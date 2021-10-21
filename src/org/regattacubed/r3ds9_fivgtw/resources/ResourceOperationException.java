package org.regattacubed.r3ds9_fivgtw.resources;

import org.apache.http.StatusLine;

public class ResourceOperationException extends Exception {

    private StatusLine httpStatusLine;

    public ResourceOperationException(StatusLine aStatus, String message) {
        super(message);
        httpStatusLine = aStatus;
    }

    public ResourceOperationException(String message) {
        super(message);
    }

    public StatusLine getHttpStatusLine() {
        return httpStatusLine;
    }
}
