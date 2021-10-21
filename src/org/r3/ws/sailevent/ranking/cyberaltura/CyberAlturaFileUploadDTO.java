package org.r3.ws.sailevent.ranking.cyberaltura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.r3.db.sailevent.rankinginstance.RankingInstanceDTO;
import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.system.rest.fileupload.FileUploadProcessingBusinessObjectConfig;
import org.r3.system.rest.fileupload.FileUploadProcessingConfig.ConfigParamClass;

public class CyberAlturaFileUploadDTO extends FileUploadDTO
{
	CyberAlturaRankInfo rank = null;

	public CyberAlturaFileUploadDTO()
	{
	}

	@Override
	public void applyUploadOptions() throws IOException
	{
		RankingInstanceDTO instanceDTO = getInstanceDTO();
		System.out.println("Instance: " + instanceDTO);

		InputStream uploadInputStream = getFileInputStream();
		uploadInputStream.reset();

		BufferedReader br = new BufferedReader(new InputStreamReader(uploadInputStream));

		if (instanceDTO != null)
		{
			try
			{
				CyberAlturaRankParser parser = null;
				if (instanceDTO.isOverallRankingInstance())
				{
					parser = new CyberAlturaOverallRankingParser();
					rank = parser.parse(br);
					super.setFileInputStream(IOUtils.toInputStream(rank.getHtmlListing()));
				}
				else
				{

					parser = new CyberAlturaRaceRankParser();
					rank = parser.parse(br);
					super.setFileInputStream(IOUtils.toInputStream(rank.getHtmlListing()));
				}
			}
			catch (ParseException e)
			{
				e.printStackTrace();
				throw new IOException(e.getMessage());
			}
		}

		// super.setFileInputStream(IOUtils.toInputStream(stb.toString()));
	}

	private RankingInstanceDTO getInstanceDTO()
	{
		Object o = getFileUploadProcessingConfig(ConfigParamClass.businessobject);
		if (o != null && o instanceof FileUploadProcessingBusinessObjectConfig)
		{
			o = ((FileUploadProcessingBusinessObjectConfig) o).getBusinessObject();
			if (o instanceof RankingInstanceDTO)
				return (RankingInstanceDTO) o;
		}

		return null;
	}

	public CyberAlturaRankInfo getRank()
	{
		return rank;
	}
}
