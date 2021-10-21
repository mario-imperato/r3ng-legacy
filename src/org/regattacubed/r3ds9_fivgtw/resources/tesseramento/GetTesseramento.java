package org.regattacubed.r3ds9_fivgtw.resources.tesseramento;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.util.EntityUtils;
import org.regattacubed.r3ds9_fivgtw.FivSiteClient;
import org.regattacubed.r3ds9_fivgtw.model.*;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperation;
import org.regattacubed.r3ds9_fivgtw.util.SystemUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GetTesseramento extends ResourceOperation {

    public GetTesseramento(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public StatoTesserato Get(int codiceTessera /*, String cognomeOrCodiceFiscale */) throws ResourceOperationException {

        CloseableHttpResponse resp = null;
        try {

            HttpUriRequest login = RequestBuilder.get()
                    .setUri(new URI("/rest/Persone/PersonaHandle/ricercaStatoTesserato"))
                    .setVersion(HttpVersion.HTTP_1_1)
                    .addParameter("matricola", String.valueOf(codiceTessera))
                    // .addParameter("valoreRicerca", String.valueOf(cognomeOrCodiceFiscale))
                    .build();

            resp = (CloseableHttpResponse) client.execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            FivSiteClient.logger.trace(String.format("Tesserato[fiv: %d]: %s", codiceTessera, resp.getStatusLine()));
            if (resp.getStatusLine().getStatusCode() != 200) {
                throw new ResourceOperationException(resp.getStatusLine(), "unexpected http status");
            }

            String jsonData = EntityUtils.toString(entity);

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference ref = new TypeReference<FivSiteApiResponse<StatoTesserato>>() { };
            FivSiteApiResponse<StatoTesserato> apiResponse = (FivSiteApiResponse<StatoTesserato>)objectMapper.readValue(jsonData, ref);
            if (apiResponse.getData() != null
                    && apiResponse.getData().getPayload() != null) {

                return apiResponse.getData().getPayload();
            }

            throw new ResourceOperationException("unexpected  api payload: " + jsonData);
        }
        catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
            throw new ResourceOperationException(ioe.getMessage());
        }
        finally {
            SystemUtil.close(resp);
        }

    }
}

