package org.regattacubed.r3ds9_fivgtw.resources.persona;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.regattacubed.r3ds9_fivgtw.model.InfoCertificatoMedico;
import org.regattacubed.r3ds9_fivgtw.model.QueryPersonaItem;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.Resource;
import org.regattacubed.r3ds9_fivgtw.resources.persona.certificati.QueryCertificati;
import org.regattacubed.r3ds9_fivgtw.resources.persona.certificati.GetCertificati;

import java.util.List;

public class PersonaResource extends Resource {

    public PersonaResource(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public List<QueryPersonaItem> GETPersone(QueryPersona aQuery) throws ResourceOperationException {

        GetPersone op = new GetPersone(client, targetHost);
        op.setQuery(aQuery);
        List<QueryPersonaItem> p = op.query();
        return p;
    }

    public org.regattacubed.r3ds9_fivgtw.model.Persona GETPersona(int idK) throws ResourceOperationException {

        GetPersona op = new GetPersona(client, targetHost);
        org.regattacubed.r3ds9_fivgtw.model.Persona p = op.Get( idK);
        return p;
    }

    public List<org.regattacubed.r3ds9_fivgtw.model.InfoCertificatoMedico> GETCertificati(QueryCertificati q) throws ResourceOperationException {

        GetCertificati op = new GetCertificati(client, targetHost);
        op.setQuery(q);
        List<InfoCertificatoMedico> p = op.query();
        return p;
    }

}
