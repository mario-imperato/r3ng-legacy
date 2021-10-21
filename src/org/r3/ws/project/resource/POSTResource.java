package org.r3.ws.project.resource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.project.resource.ResourceDTO;
import org.r3.db.project.resource.ResourcePersistence;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamPersistence;
import org.r3.db.project.teamresource.TeamResourceDTO;
import org.r3.db.project.teamresource.TeamResourcePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTResource extends ServicePattern
{
	private ResourceActionForm actionForm;

	public POSTResource(ServletContext ctx, ServiceEnvironment serviceEnvironment, ResourceActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ResourcePersistence p = ResourcePersistence.createPersistenceObject(pcfg, aSession);
		ResourceDTO dto1 = null;

		String domain = senv.getRequestSite().getSitedomain();

		String rId = actionForm.getResourceid();
		if (rId != null)
		{
			dto1 = p.selectByResourceid(rId, pcfg.getPersistenceConfigInfo());
		}
		else
		{
			dto1 = p.selectBySitedomainSSN(domain, actionForm.getSsn(), pcfg.getPersistenceConfigInfo());
		}

		if (dto1 != null)
		{
			dto1 = actionForm.getDTO4Update(dto1);
			p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		}
		else
		{
			dto1 = actionForm.getDTO4Insert(domain);
			p.insert(dto1, pcfg.getPersistenceConfigInfo());

			// Creo la Card di sistema collegata e assegno l'id della
			// discussione
			CardPersistence cardPersistence = CardPersistence.createPersistenceObject(pcfg, aSession);
			CardDTO cardDTO = actionForm.getCMSCardDTO4Insert(domain, dto1.getResourceid());
			cardPersistence.insert(cardDTO, domain, pcfg.getPersistenceConfigInfo());

			dto1.setResourcecardid(cardDTO.getCardid());
			p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		}

		TeamPersistence tp = TeamPersistence.createPersistenceObject(pcfg, aSession);
		tp.updateTeamStatus(senv.getRequestSiteId(), actionForm.getTeamid(), TeamDTO.TeamStatus.team_building, pcfg.getPersistenceConfigInfo());
		
		TeamResourcePersistence rp = TeamResourcePersistence.createPersistenceObject(pcfg, aSession);

		TeamResourceDTO rdto = rp.selectBySiteTeamidResourceid(senv.getRequestSiteId(), actionForm.getTeamid(), dto1.getResourceid(),
				pcfg.getPersistenceConfigInfo());
		if (rdto != null)
		{
			rdto = actionForm.getDTO4SiteResourceUpdate(rdto);
			rp.updateByPrimaryKey(rdto, pcfg.getPersistenceConfigInfo());
		}
		else
		{
			rdto = actionForm.getDTO4SiteResourceInsert(senv.getRequestSiteId(), dto1.getResourceid());
			rp.insert(rdto, pcfg.getPersistenceConfigInfo());
		}

		return dto1;
	}

}
