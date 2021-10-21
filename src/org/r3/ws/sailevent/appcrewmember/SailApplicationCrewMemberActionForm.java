package org.r3.ws.sailevent.appcrewmember;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO;

public class SailApplicationCrewMemberActionForm
{
	@FormParam("crewcardnumber")
	private String crewcardnumber;
	
	public String getCrewcardnumber()
	{
	     return DTOBase.nullOnEmpty(crewcardnumber);
	}
	
	@FormParam("crewmembername")
	private String crewmembername;

	public String getCrewmembername()
	{
	     return DTOBase.nullOnEmpty(crewmembername);
	}

	@FormParam("crewmemberrole")
	private String crewmemberrole;

	public String getCrewmemberrole()
	{
	     return DTOBase.nullOnEmpty(crewmemberrole);
	}

	@FormParam("memberstatus")
	private String memberstatus;

	public String getMemberstatus()
	{
	     return DTOBase.nullOnEmpty(memberstatus);
	}
	
	@FormParam("crewweight")
	private String crewweight;

	public String getCrewweight()
	{
	     return DTOBase.nullOnEmpty(crewweight);
	}
	
	public SailApplicationCrewMemberDTO getDTO4Update(SailApplicationCrewMemberDTO dto)
	{
        dto.setCrewmemberrolecode(getCrewmemberrole());
        dto.setCrewmembername(getCrewmembername());
        dto.setWeight(getCrewweight());
        dto.setMemberstatuscode(getMemberstatus());
		return dto;
	}

	public SailApplicationCrewMemberDTO getDTO4Insert(String eventId, String applicationId)
	{
		SailApplicationCrewMemberDTO dto = new SailApplicationCrewMemberDTO();
		dto.setEventid(eventId);
		dto.setApplicationid(applicationId);

		dto.setCardnumber(getCrewcardnumber());
        dto.setCrewmemberrolecode(getCrewmemberrole());
        dto.setMemberstatuscode(getMemberstatus());
        dto.setCrewmembername(getCrewmembername());
        dto.setWeight(getCrewweight());
        dto.setRecstatus(RecordStatus.sys_recact.toString());
        dto.setCreatetimestamp(DTOBase.currentTimestamp());
        
		return dto;
	}
	
}
