//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.fivmember;

public class FIVMemberDTO extends FIVMemberDTOBase
{
	public FIVMemberDTO()
	{
		super();
	}

	public FIVMemberDTO(FIVMemberDTO another)
	{
		super(another);
	}

	public enum CardNumberStatus 
	{
		fiv_cn_unknown, fiv_cn_notexist, fiv_cn_exist, fiv_cn_valid, fiv_cn_expired;

		public static CardNumberStatus getValue(String s)
		{
			if (s == null)
				return CardNumberStatus.fiv_cn_unknown;

			return CardNumberStatus.valueOf(s);
		}

	};

	public CardNumberStatus getEnumeratedCardNumberStatus()
	{
		return CardNumberStatus.getValue(getCardnumberstatuscode());
	}

	public boolean isValid()
	{
		boolean rc = false;
		if (getEnumeratedCardNumberStatus() == CardNumberStatus.fiv_cn_exist)
		{
			java.sql.Timestamp now = currentTimestamp();
			if (getCardexpirationdate().after(now) && getMedexamexpirationdate().after(now))
			{
				rc = true;
			}
		}

		return rc;
	}

	public void setSystemcheckdate()
	{
		setSystemcheckdate(currentTimestamp());
	}

}
