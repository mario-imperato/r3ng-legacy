package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FivSiteApiResponseList<T> {

    public static class ApiResponseListPayload<T> {

        private int count;
        private List<T> payload;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<T> getPayload() {
            return payload;
        }

        public void setPayload(List<T> payload) {
            this.payload = payload;
        }

    }

    private ApiResponseListPayload<T> data;

    public ApiResponseListPayload<T> getData() {
        return data;
    }

    public void setData(ApiResponseListPayload<T> data) {
        this.data = data;
    }
}
