package org.r3.system.rest;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.sequence.SequencePersistence;
import org.r3.system.ServicePatternException;

public class CreateSequenceServicePattern extends ServicePattern
{
    private String sequencePrefix;
    
	public CreateSequenceServicePattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSequencePrefix)
	{
		super(ctx, serviceEnvironment);
		sequencePrefix = aSequencePrefix;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO dto = RestServiceDTO.SuccessDTO;		
		String sid = getSequence(pcfg, aSession, sequencePrefix);
		dto.setCorrelationid(sid);
		return dto;
	}

	protected String getSequence(PersistenceContext pcfg, SqlSession aSession, String aSequencePrefix)
	{
		SequencePersistence p = pcfg.getSequencePersistence();
		String sid = p.getSequence(aSequencePrefix);		
		return sid;
	}
}
