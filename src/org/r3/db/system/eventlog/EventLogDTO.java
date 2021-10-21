//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.eventlog;


public class EventLogDTO extends EventLogDTOBase
{
	public enum UseCase 
	{ 
		ev_boatinfo, ev_classinfo, ev_ownerinfo, ev_crewinfo, ev_adddocinfo, ev_deldocinfo, ev_upddocinfo, ev_authorinfo, ev_sevcommit,
		ev_quizstart, ev_quizenter, ev_quizend, ev_quizanswer, unknown;
		
		public static UseCase getUseCase4(String s, UseCase defaultValue)
		{
			UseCase v = defaultValue;
			if (s != null && !s.isEmpty())
			{
				try
				{
					v = UseCase.valueOf(s);
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
			
			return v;
		}
	};

	public enum UseCaseAmbit 
	{ 
		unknown, sev_application, ev_action, ev_useraction;
		
		public static UseCaseAmbit getUseCaseAmbit4(String s, UseCaseAmbit defaultValue)
		{
			UseCaseAmbit v = defaultValue;
			if (s != null && !s.isEmpty())
			{
				try
				{
					v = UseCaseAmbit.valueOf(s);
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
			
			return v;
		}
		
	};

    public EventLogDTO()
    {
        super();
    }

    public EventLogDTO(EventLogDTO another)
    {
        super(another);
    }

    public void setUsecase(UseCase ec)
    {
    	this.setUsecase(ec.toString());
    }
    
    public void setUsecaseambit(UseCaseAmbit ec)
    {
    	this.setUsecaseambit(ec.toString());
    }
    
}
