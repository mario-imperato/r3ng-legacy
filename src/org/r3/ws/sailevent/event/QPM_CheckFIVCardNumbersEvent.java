package org.r3.ws.sailevent.event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberPersistence;
import org.r3.db.sailevent.fivmember.FIVMemberDTO;
import org.r3.db.sailevent.fivmember.FIVMemberPersistence;
import org.r3.db.sailevent.fivmember.FIVMemberDTO.CardNumberStatus;
import org.r3.db.system.queues.model.QueueMessage;
import org.r3.db.system.queues.model.QueueMessageProcessorException;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.r3.ws.sailevent.event.fivmemberverificationclient.FIVMemberClient;
import org.r3.ws.sailevent.event.fivmemberverificationclient.RegattaCubedClient.HTTPRequestResult;
import org.regattacubed.r3ds9_fivgtw.FivSiteClient;
import org.regattacubed.r3ds9_fivgtw.model.SailEventFivMemberInfo;
import org.regattacubed.r3ds9_fivgtw.model.StatoTesserato;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.tesseramento.TesseramentoResource;

public class QPM_CheckFIVCardNumbersEvent extends QPM_SEVQueueEventProcessor {
	private static final int FIVCREWCECKBATCHSIZE = 1000;

	@Override
	public boolean process(QueueProcessorContext processContext, QueueMessage aQueueMessage)
			throws QueueMessageProcessorException {
		boolean logHttpResponsesFlag = true;

		QM_CheckFIVCardNumbersEvent qm = (QM_CheckFIVCardNumbersEvent) aQueueMessage;
		String idPacco = qm.getRefentita();
		sevQueueLogger.info(String.format("Process Event: %s for %s with %s, %s", qm.getEvent().toString(),
				qm.getSiteContext(), qm.getYachtClubFivCode(), qm.getYachtClubFivPwd()));

		/*
		 * 2021-03-10 11:13:31 FIVMemberClient verificationHttpClient =
		 * FIVMemberClient.newClientInstance(qm.getYachtClubFivCode(),
		 * qm.getYachtClubFivPwd());
		 * verificationHttpClient.setWorkDirectory(this.getTemporaryDirectory());
		 * verificationHttpClient.setLogHTTPResponses(logHttpResponsesFlag);
		 */

		FivSiteClient fivClient = null;

		SqlSession session = processContext.getProcessSession();
		PersistenceContext pctx = processContext.getPcfg();

		boolean processingComplete = true;

		try {
			fivClient = new FivSiteClient();
			boolean b = fivClient.logIn(qm.getYachtClubFivCode(), qm.getYachtClubFivPwd());
			if (!b) {
				sevQueueLogger.error(String.format("Log-in to fivSIte site failed with credentials %s, %s",
						qm.getYachtClubFivCode(), qm.getYachtClubFivPwd()));
			} else {

				SailApplicationCrewMemberPersistence crewPersistence = SailApplicationCrewMemberPersistence.createPersistenceObject(pctx, session);
				List<SailApplicationCrewMemberDTO> listOfDTOS = crewPersistence.selectCrewMember4FIVCardNumberCheckingByEventid(
						qm.getSiteContext(), FIVCREWCECKBATCHSIZE, pctx.getPersistenceConfigInfo());

				if (listOfDTOS != null) {
					if (listOfDTOS.size() == FIVCREWCECKBATCHSIZE)
						processingComplete = false;

					sevQueueLogger.info(String.format("Retrieved: %d cards to check - will complete? %b",
							listOfDTOS.size(), processingComplete));

					FIVMemberPersistence fivPersistence = FIVMemberPersistence.createPersistenceObject(pctx, session);
					for (SailApplicationCrewMemberDTO crewDTO : listOfDTOS) {
						
						FIVMemberDTO fivMemberDTO = fivPersistence.selectByCardnumber(crewDTO.getCardnumber(), pctx.getPersistenceConfigInfo());
						sevQueueLogger.info(String.format("[%s] - Supposed Holder: %s - Is Member Present? %b",
								crewDTO.getCardnumber(), crewDTO.getCrewmembername(), fivMemberDTO != null));
						
						if (fivMemberDTO == null) {
							/*
							 * 2021-03-10 11:13:31 FIVMemberDTO fivMemberDTO2 =
							 * retrieveFIVMemberInfoFromFIVSite(verificationHttpClient,
							 * crewDTO.getCardnumber());
							 */
							FIVMemberDTO fivMemberDTO2 = retrieveFIVMemberInfoFromFIVSite(fivClient, crewDTO.getCardnumber());

							// Ad una verifica potrebbe in effetti non esistere...
							if (fivMemberDTO2 != null) {
								sevQueueLogger.info(String.format("[%s] - Returning FIV Info from Site For Holder: %s", crewDTO.getCardnumber(), fivMemberDTO2.getCardholderlastname()));
								fivPersistence.insert(fivMemberDTO2, pctx.getPersistenceConfigInfo());
							} else
								sevQueueLogger.info(String.format("[%s] - Unable to Return FIV Info from Site",	crewDTO.getCardnumber()));
						} else {
							if (!fivMemberDTO.isValid()) {
								sevQueueLogger.info(String.format("[%s] - Member is not valid - Checking FIV Site",	crewDTO.getCardnumber()));
								/*
								 * 2021-03-10 11:13:31 FIVMemberDTO fivMemberDTO2 =
								 * retrieveFIVMemberInfoFromFIVSite(verificationHttpClient,
								 * crewDTO.getCardnumber());
								 */
								FIVMemberDTO fivMemberDTO2 = retrieveFIVMemberInfoFromFIVSite(fivClient, crewDTO.getCardnumber());

								// Ad una verifica potrebbe in effetti non
								// esistere...
								if (fivMemberDTO2 != null) {
									sevQueueLogger.info(String.format("[%s] - Returning FIV Info from Site For Holder: %s", crewDTO.getCardnumber(), fivMemberDTO2.getCardholderlastname()));
									fivPersistence.updateByPrimaryKey(fivMemberDTO2, pctx.getPersistenceConfigInfo());
								} else
									sevQueueLogger.error(String.format("Unable to Return FIV Info from Site"));
							} else {
								sevQueueLogger.info(String.format("[%s] - Member is valid", crewDTO.getCardnumber()));
								// fivMemberDTO.setSystemcheckdate();
								// fivPersistence.updateByPrimaryKey(fivMemberDTO,
								// pctx.getPersistenceConfigInfo());
							}

						}

						crewDTO.setCheckcardnumber("bfalse");
						crewDTO.setCheckcardnumber_ts(DTOBase.currentTimestamp());
						crewPersistence.updateByPrimaryKey(crewDTO, pctx.getPersistenceConfigInfo());
						sevQueueLogger.info(String.format("[%s] - End Of Processing", crewDTO.getCardnumber()));
					}
				}

				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new QueueMessageProcessorException(e.getMessage());
		} finally {
			/*
			 * 2021-03-10 11:13:31 verificationHttpClient.close();
			 */
			fivClient.close();
		}

		return processingComplete;
	}

	/*
	 * 2021-03-10 11:13:31 Vecchio codice.
	 */
	public FIVMemberDTO retrieveFIVMemberInfoFromFIVSite(FIVMemberClient verificationHttpClient, String aCardNumber) {
		return verificationHttpClient.retrieveFIVMemberInfoFromFIVSite(aCardNumber);
	}

	public FIVMemberDTO retrieveFIVMemberInfoFromFIVSite(FivSiteClient fivClient, String codiceTessera) {

		try {
			TesseramentoResource r = fivClient.getTesseramento();

			StatoTesserato p;
			p = r.GETTesseramento(Integer.parseInt(codiceTessera) /* , cognome */);
			if (p != null && p.isFound()) {
				sevQueueLogger.info(String.format("Tesseramento[fiv: %s]: %s", codiceTessera, p.toJsonString()));
				SailEventFivMemberInfo finfo = new SailEventFivMemberInfo(p);
				FivSiteClient.logger.info(String.format("FivMemberInfo[fiv: %s]: %s", finfo.getCodiceTessera(),	finfo.toJsonString()));
				
				return getDataBeanFromFivMemberInfo(finfo);
			} else {
				sevQueueLogger.info(String.format("Tesseramento[fiv: %s]: NOT FOUND", codiceTessera));
			}


			
		} catch (ResourceOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	private FIVMemberDTO getDataBeanFromFivMemberInfo(SailEventFivMemberInfo finfo)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		FIVMemberDTO fivMemberDataBean = new FIVMemberDTO();				
		
		fivMemberDataBean.setCardnumber(String.valueOf(finfo.getCodiceTessera()));

		java.util.Calendar calNow = java.util.Calendar.getInstance();
		fivMemberDataBean.setSystemcheckdate(new java.sql.Timestamp(finfo.getSystemcheckdate().getTimeInMillis()));
		
		try {
		java.sql.Timestamp renewalDate = new java.sql.Timestamp(df.parse(finfo.getDataEmissione()).getTime());
		java.sql.Timestamp medicalExamExpirationDate = new java.sql.Timestamp(df.parse(finfo.getCertificatoScadenza()).getTime());
		java.sql.Timestamp cardExpirationDate = new java.sql.Timestamp(df.parse(finfo.getDataScadenzaValidita()).getTime());
		fivMemberDataBean.setCardexpirationdate(cardExpirationDate);
		fivMemberDataBean.setRenewaldate(renewalDate);
		fivMemberDataBean.setMedexamexpirationdate(medicalExamExpirationDate);
		} catch (Exception exc) {
			sevQueueLogger.error("error in parsing dates.", exc);
		}
		
		fivMemberDataBean.setCardholdername(finfo.getNome());		
		fivMemberDataBean.setCardholderlastname(finfo.getCognome());
		fivMemberDataBean.setSex(finfo.getSesso());
		
		fivMemberDataBean.setYachtclub(finfo.getYachtclub());		
		fivMemberDataBean.setBirthdate(finfo.getDataNascita());
		fivMemberDataBean.setPhone(finfo.getPhone());
		
		fivMemberDataBean.setCardnumberstatuscode(finfo.getCardnumberstatuscode());
		
		return fivMemberDataBean;
	}
}
