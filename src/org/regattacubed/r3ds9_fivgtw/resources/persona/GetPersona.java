package org.regattacubed.r3ds9_fivgtw.resources.persona;

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
import org.regattacubed.r3ds9_fivgtw.model.FivSiteApiResponseList;
import org.regattacubed.r3ds9_fivgtw.model.Persona;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperation;
import org.regattacubed.r3ds9_fivgtw.util.SystemUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class GetPersona extends ResourceOperation {

    public GetPersona(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public Persona Get(int idk) throws ResourceOperationException {

        CloseableHttpResponse resp = null;
        try {

            HttpUriRequest login = RequestBuilder.get()
                    .setUri(new URI("/rest/Persone/Persona/dettagli"))
                    .setVersion(HttpVersion.HTTP_1_1)
                    .addParameter("idK", String.valueOf(idk))
                    .build();

            resp = (CloseableHttpResponse) client.execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            FivSiteClient.logger.trace(String.format("Persona[idk: %d]: %s", idk, resp.getStatusLine()));
            if (resp.getStatusLine().getStatusCode() != 200) {
                    throw new ResourceOperationException(resp.getStatusLine(), "unexpected http status");
            }

            String jsonData = EntityUtils.toString(entity);

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference ref = new TypeReference<FivSiteApiResponseList<Persona>>() { };
            FivSiteApiResponseList<Persona> apiResponse = (FivSiteApiResponseList<Persona>)objectMapper.readValue(jsonData, ref);
            if (apiResponse.getData() != null
                    && apiResponse.getData().getPayload() != null
                    && apiResponse.getData().getPayload().size() > 0
                    && apiResponse.getData().getCount() == 1) {

                /*
                 * In this form I get an error in IDEA at least.
                 * Persona p1 = apiResponse.getData().getPayload().get(0);
                 */
                List<Persona> lp = apiResponse.getData().getPayload();
                Persona p = lp.get(0);

                return p;
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
