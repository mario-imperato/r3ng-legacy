package org.r3.ws.system.event;

import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.model.QueueMessageProcessor;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.util.ResourcesDirectory;
import org.r3.system.util.SystemUtils;
import org.r3.system.util.TemporaryDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class QPM_QueueEventProcessor extends QueueMessageProcessor
{
	protected static Logger logger = LoggerFactory.getLogger(QPM_QueueEventProcessor.class);

	private TemporaryDirectory processorTemporaryDirectory = null;
	private ResourcesDirectory processorResourcesDirectory = null;

	public TemporaryDirectory getTemporaryDirectory()
	{
		return processorTemporaryDirectory;
	}

	public ResourcesDirectory getResourceDirectory()
	{
		return processorResourcesDirectory;
	}

	protected void initalizeSystemDirectories(PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		initTemporaryDirectory(pcfg, aSession);
		initResourceDirectory(pcfg, aSession);
	}

	protected boolean isTemporaryDirectoryManaged()
	{
		return true;
	}

	protected void initTemporaryDirectory(PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		if (processorTemporaryDirectory != null)
			return;

		SitePropertyPersistence p = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
		SitePropertyDTO dto = p.selectBySitePropertyscopePropertykey(SitePropertyDTO.SiteIdentifier.__any__.toString(),
						PropertyScope.system.toString(), SitePropertyDTO.SITEPROPERTY_TEMPDIR, pcfg.getPersistenceConfigInfo());

		if (dto != null)
			processorTemporaryDirectory = new TemporaryDirectory(dto.getPropertyvalue(), isTemporaryDirectoryManaged());
		else
			processorTemporaryDirectory = new TemporaryDirectory(null, isTemporaryDirectoryManaged());
	}

	public void initResourceDirectory(PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		if (processorResourcesDirectory != null)
			return;

		SitePropertyPersistence p = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
		SitePropertyDTO dto = p.selectBySitePropertyscopePropertykey(SitePropertyDTO.SiteIdentifier.__any__.toString(),
						PropertyScope.system.toString(), SitePropertyDTO.SITEPROPERTY_RESOURCESDIR, pcfg.getPersistenceConfigInfo());

		if (dto != null)
			processorResourcesDirectory = new ResourcesDirectory(dto.getPropertyvalue());
		else
			processorResourcesDirectory = new ResourcesDirectory(null);
	}

	public void release()
	{
		SystemUtils.close(processorTemporaryDirectory);
	}

	public void initialize(String aSiteContext, QueueProcessorContext processContext)
	{
		this.initalizeSystemDirectories(processContext.getPcfg(), processContext.getProcessSession());
	}

}
