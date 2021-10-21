package org.r3.db.dms.model;

import java.io.OutputStream;

public interface DMSContentStreamer
{
	public int getStreamSize(DMSContext aDmsContext);

	public String getStreamName(DMSContext aDmsContext);

	public String getStreamMimeType();

	public long streamContent(DMSContext aDmsContext, OutputStream os) throws Exception;

	public long getStreamLastModified(DMSContext aDmsContext);
}