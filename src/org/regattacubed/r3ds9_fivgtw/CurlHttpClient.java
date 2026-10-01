package org.regattacubed.r3ds9_fivgtw;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HttpClient implementation that routes every request through a curl subprocess.
 * Used after login because Java's JSSE TLS fingerprint is blocked by the WAF
 * (Google Cloud Armor) on this site; curl/OpenSSL passes through.
 */
@SuppressWarnings("deprecation")
class CurlHttpClient extends CloseableHttpClient {

    private final File cookieFile;
    private final String userAgent;

    CurlHttpClient(File cookieFile, String userAgent) {
        this.cookieFile = cookieFile;
        this.userAgent = userAgent;
    }

    @Override
    protected CloseableHttpResponse doExecute(HttpHost target, HttpRequest request, HttpContext context)
            throws IOException, ClientProtocolException {

        String fullUrl = buildBaseUrl(target) + request.getRequestLine().getUri();

        List<String> cmd = new ArrayList<>(Arrays.asList(
            "curl", "-s",
            "-c", cookieFile.getAbsolutePath(),
            "-b", cookieFile.getAbsolutePath(),
            "--url", fullUrl,
            "-H", "accept: application/json, text/plain, */*",
            "-H", "user-agent: " + userAgent,
            "-w", "\n%{http_code}"
        ));

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process proc = pb.start();
        String output = readStream(proc.getInputStream()).trim();
        try { proc.waitFor(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        int lastNl = output.lastIndexOf('\n');
        int statusCode;
        String body;
        if (lastNl >= 0) {
            statusCode = Integer.parseInt(output.substring(lastNl + 1).trim());
            body = output.substring(0, lastNl);
        } else {
            try {
                statusCode = Integer.parseInt(output.trim());
                body = "";
            } catch (NumberFormatException e) {
                throw new IOException("Unexpected curl output: " + output.substring(0, Math.min(200, output.length())));
            }
        }

        return new CurlHttpResponse(statusCode, body);
    }

    private static String buildBaseUrl(HttpHost host) {
        String scheme = host.getSchemeName();
        int port = host.getPort();
        if (port <= 0
                || (port == 443 && "https".equals(scheme))
                || (port == 80  && "http".equals(scheme))) {
            return scheme + "://" + host.getHostName();
        }
        return scheme + "://" + host.getHostName() + ":" + port;
    }

    private static String readStream(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        int n;
        while ((n = is.read(buf)) != -1) bos.write(buf, 0, n);
        return bos.toString("UTF-8");
    }

    @Override public void close() {}
    @Override public HttpParams getParams() { return null; }
    @Override public ClientConnectionManager getConnectionManager() { return null; }

    // CloseableHttpResponse backed by curl's response body and status code
    static class CurlHttpResponse extends BasicHttpResponse implements CloseableHttpResponse {

        CurlHttpResponse(int statusCode, String body) {
            super(new BasicStatusLine(HttpVersion.HTTP_1_1, statusCode, ""));
            setEntity(new StringEntity(body, "UTF-8"));
        }

        @Override public void close() {}
    }
}
