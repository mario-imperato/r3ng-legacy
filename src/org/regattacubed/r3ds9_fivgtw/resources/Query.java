package org.regattacubed.r3ds9_fivgtw.resources;

import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class Query {

    public enum OrderDirection { ASC, DESC }

    public static class RowBounds {

        private int QRY_limit;
        private int QRY_offset;

        public RowBounds() {
            QRY_limit = 10;
            QRY_offset = 0;
        }

        public RowBounds withLimit(int aLimit) {
            QRY_limit = aLimit;
            return this;
        }

        BasicNameValuePair getLimitQueryParam() {
            return new BasicNameValuePair("QRY_limit", String.valueOf(QRY_limit));
        }

        public RowBounds withOffset(int anOffset) {
            QRY_offset = anOffset;
            return this;
        }

        BasicNameValuePair getOffsetQueryParam() {
            return new BasicNameValuePair("QRY_offset", String.valueOf(QRY_offset));
        }

        public void next() {
            QRY_offset += QRY_limit;
        }

        public String toString() {
            return String.format("offset: %d, limit: %d", QRY_offset, QRY_limit);
        }
    }

    /*
     * Variabile che mantiene il running count.
     */
    private int queryCount;

    private String QRY_order;
    private OrderDirection QRY_orderDir;
    private RowBounds rowBounds;
    private List<BasicNameValuePair> params;

    public Query() {

        QRY_order = "";
        QRY_orderDir = OrderDirection.ASC;
        rowBounds = new RowBounds();
    }

    public abstract URI getUri() throws URISyntaxException;

    public Query withOrder(String anOrdering) {
        QRY_order = anOrdering;
        return this;
    }

    public Query withOrderDirection(OrderDirection anOrderingDirection) {
        QRY_orderDir = anOrderingDirection;
        return this;
    }

    public Query withRowBounds(RowBounds rb) {
        rowBounds = rb;
        return this;
    }

    public Query withParam(String name, String value) {

        if (params == null)
            params = new ArrayList<>();

        params.add(new BasicNameValuePair(name, value));
        return this;
    }

    public RequestBuilder addParameters(RequestBuilder request) {

        if (rowBounds != null) {
            request.addParameter(rowBounds.getLimitQueryParam());
            request.addParameter(rowBounds.getOffsetQueryParam());
        }

        if (QRY_order != null)
            request.addParameter(new BasicNameValuePair("QRY_order", QRY_order));

        if (QRY_orderDir != null)
            request.addParameter(new BasicNameValuePair("QRY_orderDir", QRY_orderDir.toString()));

        if (params != null)
        {
            for(BasicNameValuePair p : params) {
                request.addParameter(p);
            }
        }

        return request;
    }

    public boolean hasMorePages(int queryCount) {
        return queryCount > 0 && rowBounds != null && (rowBounds.QRY_offset + rowBounds.QRY_limit) < queryCount;
    }

    public void setQueryCount(int aNumberOfRows) {
        queryCount = aNumberOfRows;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public boolean hasMorePages() {
        return queryCount > 0 && hasMorePages(queryCount);
    }

    public boolean next() {
        if (rowBounds == null || queryCount <= 0 || !hasMorePages(queryCount)) {
            return false;
        }

        rowBounds.next();
        return true;
    }
}
