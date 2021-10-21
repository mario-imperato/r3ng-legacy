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
import org.regattacubed.r3ds9_fivgtw.model.FivSiteApiResponseList;
import org.regattacubed.r3ds9_fivgtw.model.Tesseramento;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationQuery;
import org.regattacubed.r3ds9_fivgtw.util.SystemUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class GetTesseramenti extends ResourceOperationQuery {

    public GetTesseramenti(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public List<Tesseramento> query() throws ResourceOperationException {

        CloseableHttpResponse resp = null;
        try {

            RequestBuilder rb = RequestBuilder.get()
                    .setUri(query.getUri())
                    .setVersion(HttpVersion.HTTP_1_1);

            HttpUriRequest login = addParameters(rb).build();

            resp = (CloseableHttpResponse) client.execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            FivSiteClient.logger.trace(String.format("Query-Tesseramento[]: %s", resp.getStatusLine()));
            if (resp.getStatusLine().getStatusCode() != 200) {
                throw new ResourceOperationException(resp.getStatusLine(), "unexpected http status");
            }

            String jsonData = EntityUtils.toString(entity);

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference ref = new TypeReference<FivSiteApiResponseList<Tesseramento>>() {
            };
            FivSiteApiResponseList<Tesseramento> apiResponse = (FivSiteApiResponseList<Tesseramento>) objectMapper.readValue(jsonData, ref);
            if (apiResponse.getData() != null) {
                this.query.setQueryCount(apiResponse.getData().getCount());
                return apiResponse.getData().getPayload();
            }

            throw new ResourceOperationException("unexpected  api payload: " + jsonData);
        } catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
            throw new ResourceOperationException(ioe.getMessage());
        } finally {
            SystemUtil.close(resp);
        }

    }

}