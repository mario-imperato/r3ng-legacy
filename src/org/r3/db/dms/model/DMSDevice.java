package org.r3.db.dms.model;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.dms.device.DMSDeviceDTO;
import org.r3.db.dms.device.DMSDevicePersistence;
import org.r3.db.dms.devicealias.DMSDeviceAliasDTO;
import org.r3.db.dms.devicealias.DMSDeviceAliasPersistence;
import org.r3.db.dms.folder.DMSFolderPersistence;

public abstract class DMSDevice extends DMSDeviceDTO
{

	DMSDevice() throws DMSException
	{
		super();
	}

	public abstract DMSStorageBucket getStorageBucket(String aPhysicalName) throws DMSException;

	public DMSDeviceAlias getAlias(DMSContext aDmsContext) throws DMSException
	{
		return getAliasFor(aDmsContext, DMSEnvironment.getClientIdentifier());
	}

	public DMSDeviceAlias getAliasFor(DMSContext aDmsContext, String aClientId) throws DMSException
	{
		DMSDeviceAlias defaultAlias = null;

		List<DMSDeviceAlias> listOfAliases = getListOfAliases(aDmsContext, getDeviceid());
		if (listOfAliases != null && listOfAliases.size() > 0)
		{
			for (DMSDeviceAlias dto : listOfAliases)
			{
				if (dto.getClientid().equalsIgnoreCase(aClientId))
					return dto;
				else if (dto.isDefaultAlias())
					defaultAlias = dto;
			}
		}

		return defaultAlias;
	}

	public List<DMSDeviceAlias> getListOfAliases(DMSContext aDmsContext, String deviceId) throws DMSException
	{
		List<DMSDeviceAlias> listOfAliases = null;

		try
		{
			DMSDeviceAliasPersistence p = DMSDeviceAliasPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());

			List<DMSDeviceAliasDTO> listOfAliasDataBean = p.selectByDeviceid(deviceId, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
			if (listOfAliasDataBean != null && listOfAliasDataBean.size() > 0)
			{
				listOfAliases = new ArrayList<DMSDeviceAlias>(listOfAliasDataBean.size());
				for (DMSDeviceAliasDTO dto : listOfAliasDataBean)
				{
					DMSDeviceAlias alias = new DMSDeviceAlias(dto);
					listOfAliases.add(alias);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
			throw new DMSException(e);
		}
		finally
		{
		}

		return listOfAliases;

	}

	public void addAlias(DMSContext aDmsContext, DMSDeviceAlias anAlias) throws DMSException
	{
		try
		{
			DMSDeviceAliasPersistence p = DMSDeviceAliasPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
			DMSDeviceAliasDTO aliasDto = p.selectByDeviceidClientid(anAlias.getDeviceid(), anAlias.getClientid(),
							aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
			if (aliasDto != null)
			{
				aliasDto.setDevicephysicalname(anAlias.getDevphysicalnameAsUrl().toString());
				p.updateByPrimaryKey(aliasDto, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
			}
			else
			{
				aliasDto = new DMSDeviceAliasDTO();
				aliasDto.setClientid(anAlias.getClientid());
				aliasDto.setDeviceid(getDeviceid());
				aliasDto.setDevicephysicalname(anAlias.getDevphysicalnameAsUrl().toString());
				p.insert(aliasDto, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
			throw new DMSException(e);
		}
		finally
		{
		}
	}

	// Funzione che verifica se vi sono fascicoli collegati al device. Questo
	// per permettere o meno la cancellazione del device.
	//
	public int numberOfBoundFolders(DMSContext aDmsContext) throws DMSException
	{

		try
		{
			DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
			int rc = p.numberOfFoldersBoundToDevice(getDeviceid(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());

			return rc;
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
			throw new DMSException(e);
		}
		finally
		{
		}

	}

	void setDevType(DMSDeviceType devType)
	{
		this.devicetype = devType.getTypeCode().toString();
	}

	public DMSDeviceType getDevType()
	{
		return new DMSDeviceType(devicetype);
	}

	public void commit(DMSContext aDmsContext)
	{
		DMSDevicePersistence p = DMSDevicePersistence
						.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
		if (this.getDeviceid() != null)
			p.updateByPrimaryKey(this, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
		else
			p.insert(this, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
	}

}
