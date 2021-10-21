package org.regattacubed.r3ds9_fivgtw.resources.tesseramento;

import org.regattacubed.r3ds9_fivgtw.resources.Query;

import java.net.URI;
import java.net.URISyntaxException;

public class QueryTesseramentoPerSocieta extends QueryTesseramento {

    public QueryTesseramentoPerSocieta() {
        orderByCognomeTesserato(OrderDirection.ASC);
    }

    public QueryTesseramentoPerSocieta orderByCognomeTesserato(OrderDirection dir) {
        withOrder("tesserato_cognome");
        withOrderDirection(dir);
        return this;
    }

    public QueryTesseramentoPerSocieta withIdSocieta(int idSocieta) {
        withParam("idSocieta", String.valueOf(idSocieta));
        return this;
    }

    public QueryTesseramentoPerSocieta withIdPeriodo(String idPeriodo) {
        withParam("idPeriodo", idPeriodo);
        return this;
    }

    @Override
    public URI getUri() throws URISyntaxException {
        return new URI("/rest/Tesseramenti/TesseramentoSocietaHandle/elenco");
    }
}
