package org.r3.ws.sailevent.application;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.DTOCasingStyle;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.sailevent.appdata.SailApplicationDataDTO;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationDTO.CompletionStatus;

public class SailFillOutApplicationActionForm
{
	public enum SailApplicationFormFields { sailnumber, plate, yachtname, yachtclub, yachttype, racegroup, apptype,
		ownerfirstname, ownerlastname, owneremail, ownercellphone, ownerphone, owneraddress, ownertown, ownerzipcode, 
		prop_havehelmsman,
		helmsmanfirstname, helmsmanlastname, helmsmanemail, helmsmancellphone, helmsmanphone, helmsmanaddress, helmsmantown, helmsmanzipcode,
		mooringloc,
		completionstatus, verificationstatus, annotation, adminchecks, adminracegroup, adminraceclass, yachtbsf, yachtgph };
	
    private MultivaluedMap<String, String> requestData;
    
	public SailFillOutApplicationActionForm(MultivaluedMap<String, String> rawData)
	{				
		requestData = rawData;
	}

	public String getSailnumber()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.sailnumber.toString()));
	}

	public String getMooringloc()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.mooringloc.toString()));
	}
	
	public String getPlate()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.plate.toString()));
	}

	public String getYachtname()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.yachtname.toString()));
	}

	public String getYachtclub()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.yachtclub.toString()));
	}

    public String getYachttype()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.yachttype.toString()));
	}

    public String getRacegroup()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.racegroup.toString()));
	}

    public String getApptype()
	{
		return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.apptype.toString()));
	}

    public String getOwnerfirstname()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.ownerfirstname.toString()));
    }

    public String getOwnerLastname()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.ownerlastname.toString()));
    }

    public String getOwneremail()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.owneremail.toString()));
    }

    public String getOwnercellphone()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.ownercellphone.toString()));
    }

    public String getOwnerphone()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.ownerphone.toString()));
    }

    public String getOwneraddress()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.owneraddress.toString()));
    }

    public String getOwnertown()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.ownertown.toString()));
    }

    public String getOwnerzipcode()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.ownerzipcode.toString()));
    }

    // Helmsman
    private boolean haveHelmsman()
    {
        return DTOBase.getBTrueFalseAsBoolean(requestData.getFirst(SailApplicationFormFields.prop_havehelmsman.toString()));
    }
    
    public String getHelmsmanfirstname()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmanfirstname.toString()));
    }

    public String getHelmsmanLastname()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmanlastname.toString()));
    }

    public String getHelmsmanemail()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmanemail.toString()));
    }

    public String getHelmsmancellphone()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmancellphone.toString()));
    }

    public String getHelmsmanphone()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmanphone.toString()));
    }

    public String getHelmsmanaddress()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmanaddress.toString()));
    }

    public String getHelmsmantown()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmantown.toString()));
    }

    public String getHelmsmanzipcode()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.helmsmanzipcode.toString()));
    }
    
    public String getCompletionstatus()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.completionstatus.toString()));
    }

    public String getVerificationstatus()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.verificationstatus.toString()));
    }

    public String getAnnotation()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.annotation.toString()));
    }

    public String getAdminchecks()
    {
    	List<String> listOfAdminChecks = requestData.get(SailApplicationFormFields.adminchecks.toString()); 
    	return DTOBase.stringList2CSV(listOfAdminChecks);
    }

    public String getAdminracegroup()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.adminracegroup.toString()));
    }

    public String getAdminraceclass()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.adminraceclass.toString()));
    }

    public String getYachtbsf()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.yachtbsf.toString()));
    }

    public String getYachtgph()
    {
    	return DTOBase.nullOnEmpty(requestData.getFirst(SailApplicationFormFields.yachtgph.toString()));
    }

	public SailApplicationDTO getDTO4UpdateBoatInfo(SailApplicationDTO dto)
	{
		if (dto.isApplicationEmpty())
			dto.setCompletionstatus(CompletionStatus.r3ea_draft.toString());

		dto.setSailnumber(getSailnumber());
		dto.setYachtname(getYachtname());
		dto.setYachttype(getYachttype());
		dto.setYachtclub(getYachtclub());
		dto.setPlate(getPlate());
		dto.setMooringloc(getMooringloc());
		return dto;
	}

	public SailApplicationDTO getDTO4UpdateAdminChecks(SailApplicationDTO dto)
	{
		dto.setCompletionstatus(getCompletionstatus());
		dto.setVerificationstatus(getVerificationstatus());
		dto.setAnnotation(getAnnotation());
		dto.setAdminchecks(getAdminchecks());
		return dto;
	}

	public SailApplicationDTO getDTO4UpdateAdminRaceInfo(SailApplicationDTO dto)
	{
		dto.setAdminracegroup(getAdminracegroup());
		dto.setAdminraceclass(getAdminraceclass());
		dto.setYachtgph(getYachtgph());
		dto.setYachtbsf(getYachtbsf());
		return dto;
	}

	public SailApplicationDTO getDTO4UpdateClassInfo(SailApplicationDTO dto)
	{
		if (dto.isApplicationEmpty())
			dto.setCompletionstatus(CompletionStatus.r3ea_draft.toString());
		
	    dto.setRacegroup(getRacegroup());		
		dto.setApptype(getApptype());
		
		return dto;
	}

	public ActorDTO getDTO4OwnerActor(String eventId, String actorId)
	{
		ActorDTO dto = new ActorDTO();
		dto.setEventid(eventId);

		dto.setActorid(actorId);
		dto.setFirstname(getOwnerfirstname());
		dto.setLastname(getOwnerLastname());
		dto.setAddress(getOwneraddress());
		dto.setCellphone(getOwnercellphone());
		dto.setContactgroup("owner");
		dto.setEmail(getOwneremail());
		dto.setPhone(getOwnerphone());
		dto.setTown(getOwnertown());
		dto.setZipcode(getOwnerzipcode());
		dto.setRecstatus(RecordStatus.sys_recblock.toString());
		return dto;
	}

	public List<SailApplicationDataDTO> getDTO4UpdateBoatInfoProperties(String eventId, String applicationid)
	{
		return getDTO4UpdateProperties(eventId, applicationid, SailApplicationDTO.ApplicationSection.r3ea_boatinfo);
	}

	public List<SailApplicationDataDTO> getDTO4UpdateClassInfoProperties(String eventId, String applicationid)
	{
		return getDTO4UpdateProperties(eventId, applicationid, SailApplicationDTO.ApplicationSection.r3ea_classinfo);
	}

	public List<SailApplicationDataDTO> getDTO4UpdateOwnerInfoProperties(String eventId, String applicationid)
	{
		return getDTO4UpdateProperties(eventId, applicationid, SailApplicationDTO.ApplicationSection.r3ea_ownerinfo);
	}

	public List<SailApplicationDataDTO> getDTO4UpdateAuthorInfoProperties(String eventId, String applicationid)
	{
		return getDTO4UpdateProperties(eventId, applicationid, SailApplicationDTO.ApplicationSection.r3ea_authorinfo);
	}

	private List<SailApplicationDataDTO> getDTO4UpdateProperties(String eventId, String applicationid, SailApplicationDTO.ApplicationSection formSection)
	{
		List<SailApplicationDataDTO> listOfProps = null; // new ArrayList<SailApplicationDataDTO>();
		
		if (requestData != null)
		{
			String propValue = null;
		    for(String key : requestData.keySet())
		    {
		    	if (key.startsWith("prop_"))
		    	{
		    		DTOCasingStyle casingOption = DTOCasingStyle.none;
		    		
			    	List<String> items = requestData.get(key);
			    	if (items.size() > 1)
			    	{
			    		propValue = DTOBase.stringList2CSV(items);
			    	}
			    	else propValue = DTOBase.nullOnEmpty(requestData.getFirst(key));
                    if (propValue != null)
                    {
                    	if (listOfProps == null)
                    		 listOfProps = new ArrayList<SailApplicationDataDTO>();
                    	
                    	SailApplicationDataDTO dto = new SailApplicationDataDTO();
                    	dto.setEventid(eventId);
                    	dto.setApplicationid(applicationid);
                    	dto.setSectionid(formSection.toString());
                    	dto.setParamname(key.substring("prop_".length()));
                    	dto.setParamvalue(propValue, casingOption);
                    	
                    	listOfProps.add(dto);
                    }
		    	}
		    		
		    }
		}	
		
		return listOfProps;
	}

	public ActorDTO getDTO4HelmsmanActor(String requestSiteId, String helmsmanid)
	{
		if (!haveHelmsman())
			return null;
		
		ActorDTO dto = new ActorDTO();
		dto.setEventid(requestSiteId);

		dto.setActorid(helmsmanid);
		dto.setFirstname(getHelmsmanfirstname());
		dto.setLastname(getHelmsmanLastname());
		dto.setAddress(getHelmsmanaddress());
		dto.setCellphone(getHelmsmancellphone());
		dto.setContactgroup("helmsman");
		dto.setEmail(getHelmsmanemail());
		dto.setPhone(getHelmsmanphone());
		dto.setTown(getHelmsmantown());
		dto.setZipcode(getHelmsmanzipcode());
		dto.setRecstatus(RecordStatus.sys_recblock.toString());
		return dto;
	}
	
}
