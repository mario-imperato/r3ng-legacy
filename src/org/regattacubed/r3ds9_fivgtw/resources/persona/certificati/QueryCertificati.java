package org.regattacubed.r3ds9_fivgtw.resources.persona.certificati;

import org.regattacubed.r3ds9_fivgtw.resources.Query;

import java.net.URI;
import java.net.URISyntaxException;

public class QueryCertificati extends Query {

    public QueryCertificati withIdPersona(long idPersona) {
        this.withParam("idPersona", String.valueOf(idPersona));
        return this;
    }

    @Override
    public URI getUri() throws URISyntaxException {
        return new URI("/rest/Certificati/CertificatoHandle/elenco");
    }
}
