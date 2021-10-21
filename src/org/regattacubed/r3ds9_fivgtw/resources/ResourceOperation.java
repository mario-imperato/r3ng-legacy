package org.regattacubed.r3ds9_fivgtw.resources;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;

public class ResourceOperation {

    protected HttpClient client;
    protected HttpHost targetHost;

    public ResourceOperation(HttpClient aClient, HttpHost aTargetHost) {
        client = aClient;
        targetHost = aTargetHost;
    }
}
