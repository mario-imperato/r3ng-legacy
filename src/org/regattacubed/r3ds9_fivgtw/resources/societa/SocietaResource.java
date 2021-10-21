package org.regattacubed.r3ds9_fivgtw.resources.societa;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.regattacubed.r3ds9_fivgtw.model.Societa;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.Resource;

public class SocietaResource extends Resource {

    public SocietaResource(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public Societa GETSocieta(long idSocieta) throws ResourceOperationException {

        GetSocieta op = new GetSocieta(client, targetHost);
        Societa s = op.Get( idSocieta);

        return s;
    }

}
