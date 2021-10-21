package org.r3.ws.sailevent.ranking;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.sailevent.ranking.RankingDTO;
import org.r3.db.sailevent.ranking.RankingPersistence;
import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO;
import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO.InstanceType;
import org.r3.db.sailevent.rankinginstance.RankingInstancePersistence;
import org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO;
import org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.system.rest.fileupload.FileUploadPattern;
import org.r3.system.rest.fileupload.FileUploadProcessingBusinessObjectConfig;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAlturaFileUploadDTO;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAlturaFileUploadDTOFactory;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAlturaRankEntry;
import org.r3.ws.sailevent.ranking.cyberaltura.CyberAlturaRankInfo;

public class POSTFileUpload extends FileUploadPattern
{
	public POSTFileUpload(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String fileDataPart, boolean isIEFlag)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new CyberAlturaFileUploadDTOFactory(), true, isIEFlag);
	}

//	@Override
//	protected FileUploadActionForm newFileUploadActionFormInstance()
//	{
//		return new CyberAlturaFileUploadActionForm();
//	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		List<FileUploadDTO> files = getFileUploadActionForm().getFiles();

		DMSContext dmsContext = new DMSContext(pcfg, aSession);

		DMSFileSystemUrl url;
		try
		{
			RankingPersistence rankingPersistence = RankingPersistence.createPersistenceObject(pcfg, aSession);			
			List<RankingDTO> listOfRankings = rankingPersistence.selectByEventid(senv.getRequestSiteId(), pcfg);

			DMSFolder docFolder = DMSFolderHelper.getCyberAlturaRankingUploadFolder(dmsContext, senv.getRequestSiteId());

			FileUploadDTO uploadedFile = getFileUploadActionForm().getUploadedFile();
			if (docFolder != null && uploadedFile != null)
			{
				RankingInstanceDTO instanceDTO = processIncomingFile(pcfg, aSession, uploadedFile, listOfRankings);

				if (instanceDTO != null)
				{
					uploadedFile.setValid(true);
					uploadedFile.addFileUploadProcessingConfig(new FileUploadProcessingBusinessObjectConfig(instanceDTO));
					storeFile(dmsContext, docFolder, uploadedFile, true);
					
					// A questo punto dovrei trovare valorizzata l'istanza.
                    persistRankingInstance(pcfg, aSession, instanceDTO, uploadedFile);                    	
				}
				else
				{
					uploadedFile.setValid(false);
					uploadedFile.setError("File Non Valido - Nome File Non Riconosciuto");
				}

			}
		}
		catch (DMSException e)
		{
			e.printStackTrace();
			if (isIE())
				return serializeFiles(files);
			else
				throw new ServicePatternException(e.getMessage());
		}

		if (isIE())
			return serializeFiles(files);

		return new ArrayOfFileUploadDTO(files);
	}

	private void persistRankingInstance(PersistenceContext pcfg, SqlSession aSession, RankingInstanceDTO instanceDTO, FileUploadDTO uploadedFile)
	{
		CyberAlturaFileUploadDTO cyberAlturaDTO = (CyberAlturaFileUploadDTO)uploadedFile;
		
		RankingInstancePersistence rankingInstancePersistence = RankingInstancePersistence.createPersistenceObject(pcfg, aSession);
		RankingInstanceDetailPersistence rankingInstanceDetailPersistence = RankingInstanceDetailPersistence.createPersistenceObject(pcfg, aSession);
		
		instanceDTO.setRacefiledmsurl(cyberAlturaDTO.getFileurl());
		
		cyberAlturaDTO.getRank().populateFromRankInfo(instanceDTO);
		if (instanceDTO.getInstanceid() != null)
		{
			instanceDTO.setRectimestamp(DTOBase.currentTimestamp());
			rankingInstancePersistence.updateByPrimaryKey(instanceDTO, pcfg.getPersistenceConfigInfo());
			rankingInstanceDetailPersistence.deleteByEventidInstanceid(instanceDTO.getEventid(), instanceDTO.getInstanceid(), pcfg.getPersistenceConfigInfo());
		}
		else rankingInstancePersistence.insert(instanceDTO, pcfg.getPersistenceConfigInfo());
		
		persistRankEntries(pcfg, aSession,
				instanceDTO.getEventid(), 
				instanceDTO.getInstanceid(),
				instanceDTO.getRacedate(),
				cyberAlturaDTO.getRank());		
	}

	private RankingInstanceDTO processIncomingFile(PersistenceContext pcfg, SqlSession aSession, FileUploadDTO f, List<RankingDTO> listOfRankings)
	{		
		RankingInstancePersistence rankingInstancePersistence = RankingInstancePersistence.createPersistenceObject(pcfg, aSession);

		String fName = f.getUploadFileName();
		if (listOfRankings != null && listOfRankings.size() > 0)
		{
			for (RankingDTO rDto : listOfRankings)
			{
				String guessFileName = rDto.getOverallfilepattern();
				if (fName.equalsIgnoreCase(guessFileName))
				{
					return rankingInstancePersistence.newRankingDetailInstance(pcfg.getPersistenceConfigInfo(), rDto, InstanceType.rank_overall, RankingInstanceDTO.GENERAL_RACENUMBER);
				}

				for (int i = 0; i < RankingInstanceDTO.GENERAL_MAXRACENUMBER; i++)
				{
					guessFileName = String.format(rDto.getRacefilepattern(), i);
					if (fName.equalsIgnoreCase(guessFileName))
					{
						return rankingInstancePersistence.newRankingDetailInstance(pcfg.getPersistenceConfigInfo(), rDto, InstanceType.rank_race, i);
					}
				}
			}
		}

		return null;
	}



	public void persistRankEntries(PersistenceContext pcfg, SqlSession aSession, String eventId, String instanceId, java.sql.Date rankDate, CyberAlturaRankInfo rank)
	{
		RankingInstanceDetailPersistence rankingInstanceDetailPersistence = RankingInstanceDetailPersistence.createPersistenceObject(pcfg, aSession);

		SailApplicationPersistence applicationPersistence = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
		Map<String, SailApplicationDTO> mapOfApps = applicationPersistence.selectDTOsAsMapOfSailNumber(eventId, pcfg.getPersistenceConfigInfo());
						
		List<CyberAlturaRankEntry> entries = rank.getListOfRankEntry();
		if (entries != null)
		{
			RankingInstanceDetailDTO dto = new RankingInstanceDetailDTO();
			dto.setEventid(eventId);
			dto.setInstanceid(instanceId);			
			for(CyberAlturaRankEntry e : entries)
			{
				SailApplicationDTO appDTO = null;
				if (mapOfApps != null)
					appDTO = mapOfApps.get(e.getSailNumber());
				
				if (appDTO != null)
					dto.setApplicationid(appDTO.getApplicationid());
				
				e.populate(rankDate, dto);
				rankingInstanceDetailPersistence.insert(dto, pcfg.getPersistenceConfigInfo());
			}
		}
	}


}
