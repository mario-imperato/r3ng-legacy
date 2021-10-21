package org.r3.ws.bbs.topic;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.bbs.bbstopic.BBSTopicPersistence;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTBBSTopic extends ServicePattern
{
    private BBSTopicActionForm actionForm;
    
	public POSTBBSTopic(ServletContext ctx,  ServiceEnvironment serviceEnvironment, BBSTopicActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSTopicPersistence p = BBSTopicPersistence.createPersistenceObject(pcfg, aSession);
		BBSTopicDTO dto1 = null;
		
		String topicId = actionForm.getTopicid();
		if (topicId != null)
		{
		   dto1 = p.selectBySiteTopicid(getServiceEnvironment().getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());
		}
		
		if (dto1 != null)
			return new RestServiceDTO(Status.fail, "RESTDTO_ERROR_ID_DUP", "Codice Topic gia' presenta a sistema");
		
		dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());

	    // Creo la Card di sistema collegata e assegno l'id della discussione
	    CardPersistence cardPersistence = CardPersistence.createPersistenceObject(pcfg, aSession);
	    CardDTO cardDTO = actionForm.getCMSCardDTO4Insert(getServiceEnvironment().getRequestSiteId(), dto1.getTopicid());
	    cardPersistence.insert(cardDTO, pcfg.getPersistenceConfigInfo());
	    			    
	    dto1.setCardid(cardDTO.getCardid());
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
	    
		return dto1;
	}

}
