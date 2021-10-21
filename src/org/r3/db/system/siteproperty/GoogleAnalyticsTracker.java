package org.r3.db.system.siteproperty;

public class GoogleAnalyticsTracker
{
    private String trackerId;
    private String trackerDomain;
    
	public GoogleAnalyticsTracker(String aTrackerId, String aTrackerDomain)
	{
		trackerId = aTrackerId;
		trackerDomain = aTrackerDomain;
	}

	public String getTrackerId()
	{
		return trackerId;
	}

	public void setTrackerId(String trackerId)
	{
		this.trackerId = trackerId;
	}

	public String getTrackerDomain()
	{
		return trackerDomain;
	}

	public void setTrackerDomain(String trackerDomain)
	{
		this.trackerDomain = trackerDomain;
	}
	
}
