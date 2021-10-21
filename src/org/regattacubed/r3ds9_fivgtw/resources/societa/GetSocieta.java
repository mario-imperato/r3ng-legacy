package org.regattacubed.r3ds9_fivgtw.resources.societa;

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

public class GetSocieta extends ResourceOperation {

    public GetSocieta(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public Societa Get(long idk) throws ResourceOperationException {

        CloseableHttpResponse resp = null;
        try {

            HttpUriRequest login = RequestBuilder.get()
                    .setUri(new URI("/rest/Societa/Societa/dettagli"))
                    .setVersion(HttpVersion.HTTP_1_1)
                    .addParameter("idK", String.valueOf(idk))
                    .build();

            resp = (CloseableHttpResponse) client.execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            FivSiteClient.logger.trace(String.format("Societa[idk: %d]: %s", idk, resp.getStatusLine()));
            if (resp.getStatusLine().getStatusCode() != 200) {
                    throw new ResourceOperationException(resp.getStatusLine(), "unexpected http status");
            }

            String jsonData = EntityUtils.toString(entity);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                TypeReference ref = new TypeReference<FivSiteApiResponse<Societa>>() {
                };
                FivSiteApiResponse<Societa> apiResponse = (FivSiteApiResponse<Societa>) objectMapper.readValue(jsonData, ref);
                if (apiResponse.getData() != null
                        && apiResponse.getData().getPayload() != null) {
                    return apiResponse.getData().getPayload();
                }
            } catch (Exception jsonExc) {
                jsonExc.printStackTrace();
                FivSiteClient.logger.error("unexpected  api payload: " + jsonData);
            }

            return null;
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
