package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FivSiteApiResponse<T> {

    public static class ApiResponsePayload<T> {

        private int count;
        private T   payload;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public T getPayload() {
            return payload;
        }

        public void setPayload(T payload) {
            this.payload = payload;
        }

    }

    private ApiResponsePayload<T> data;

    public ApiResponsePayload<T> getData() {
        return data;
    }

    public void setData(ApiResponsePayload<T> data) {
        this.data = data;
    }
}
