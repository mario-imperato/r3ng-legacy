package org.regattacubed.r3ds9_fivgtw.resources;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.RequestBuilder;

public abstract class ResourceOperationQuery extends ResourceOperation {

    protected Query query;

    public ResourceOperationQuery(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public RequestBuilder addParameters(RequestBuilder request) {
        return query.addParameters(request);
    }


}
