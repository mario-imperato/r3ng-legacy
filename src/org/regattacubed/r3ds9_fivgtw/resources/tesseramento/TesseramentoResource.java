package org.regattacubed.r3ds9_fivgtw.resources.tesseramento;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.regattacubed.r3ds9_fivgtw.model.StatoTesserato;
import org.regattacubed.r3ds9_fivgtw.model.Tesseramento;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.Resource;

import java.util.List;

public class TesseramentoResource extends Resource {

    public TesseramentoResource(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public StatoTesserato GETTesseramento(int codiceTessera /*, String cognomeOrCodiceFiscale */) throws ResourceOperationException {

        GetTesseramento op = new GetTesseramento(client, targetHost);
        StatoTesserato s = op.Get( codiceTessera /*, cognomeOrCodiceFiscale */);

        return s;
    }

    public List<Tesseramento> GETTesseramenti(QueryTesseramento aQuery) throws ResourceOperationException {
        GetTesseramenti op = new GetTesseramenti(client, targetHost);
        op.setQuery(aQuery);
        List<Tesseramento> p = op.query();
        return p;
    }

}
