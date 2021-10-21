package org.regattacubed.r3ds9_fivgtw.resources.tesseramento;

import org.regattacubed.r3ds9_fivgtw.resources.Query;

import java.net.URI;
import java.net.URISyntaxException;

public class QueryTesseramentoPerPersona extends QueryTesseramento {

    public QueryTesseramentoPerPersona() {
        orderByPeriodo(OrderDirection.DESC);
    }

    public QueryTesseramentoPerPersona orderByPeriodo(OrderDirection dir) {
        withOrder("periodo_des");
        withOrderDirection(dir);
        return this;
    }

    public QueryTesseramentoPerPersona withIdPersona(long idPersona) {
        this.withParam("idPersona", String.valueOf(idPersona));
        return this;
    }

    @Override
    public URI getUri() throws URISyntaxException {
        return new URI("/rest/Tesseramenti/TesseramentoHandle/elenco");
    }
}
