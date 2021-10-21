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
import org.regattacubed.r3ds9_fivgtw.model.QueryPersonaItem;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationException;
import org.regattacubed.r3ds9_fivgtw.resources.ResourceOperationQuery;
import org.regattacubed.r3ds9_fivgtw.util.SystemUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class GetPersone extends ResourceOperationQuery {

    public GetPersone(HttpClient aClient, HttpHost aTargetHost) {
        super(aClient, aTargetHost);
    }

    public List<QueryPersonaItem> query() throws ResourceOperationException {

        CloseableHttpResponse resp = null;
        try {

            RequestBuilder rb = RequestBuilder.get()
                    .setUri(query.getUri())
                    .setVersion(HttpVersion.HTTP_1_1);

            HttpUriRequest login = addParameters(rb).build();

            resp = (CloseableHttpResponse) client.execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            FivSiteClient.logger.trace(String.format("Query-Persona[]: %s", resp.getStatusLine()));
            if (resp.getStatusLine().getStatusCode() != 200) {
                throw new ResourceOperationException(resp.getStatusLine(), "unexpected http status");
            }

            String jsonData = EntityUtils.toString(entity);

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference ref = new TypeReference<FivSiteApiResponseList<QueryPersonaItem>>() {
            };
            FivSiteApiResponseList<QueryPersonaItem> apiResponse = (FivSiteApiResponseList<QueryPersonaItem>) objectMapper.readValue(jsonData, ref);
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