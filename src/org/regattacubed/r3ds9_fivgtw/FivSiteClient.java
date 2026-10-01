package org.regattacubed.r3ds9_fivgtw;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.regattacubed.r3ds9_fivgtw.resources.persona.PersonaResource;
import org.regattacubed.r3ds9_fivgtw.resources.societa.SocietaResource;
import org.regattacubed.r3ds9_fivgtw.resources.tesseramento.TesseramentoResource;
import org.regattacubed.r3ds9_fivgtw.util.CookieUtil;
import org.regattacubed.r3ds9_fivgtw.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FivSiteClient {

    public static Logger logger = LoggerFactory.getLogger(FivSiteClient.class);

    private static final String USER_AGENT_MAC = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/153.0.0.0 Safari/537.36";
    private static final String USER_AGENT_WIN = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0";

    private CookieStore cookieStore;
    private HttpClient httpClient;
    private File sessionCookieFile; // non-null after successful logIn(); switches HTTP calls to curl

    private HttpHost targetHost;

    public FivSiteClient() {
        this(true);
    }

    public FivSiteClient(boolean useSSL) {
        if (useSSL)
            targetHost = new HttpHost("federvela.coninet.it", 443, "https");
        else
            targetHost = new HttpHost("federvela.coninet.it", 80, "http");
    }

    public FivSiteClient(String hostName, int port, String protocolScheme) {
        targetHost = new HttpHost(hostName, port, protocolScheme);
    }

    public void setCookie(String base64Cookie) throws IOException, ClassNotFoundException {
        Cookie c = CookieUtil.deserializeCookie(base64Cookie);
        if (cookieStore == null)
            cookieStore = new BasicCookieStore();
        cookieStore.addCookie(c);

        // Write to a curl cookie file so CurlHttpClient routes around the WAF
        if (sessionCookieFile == null)
            sessionCookieFile = File.createTempFile("fiv_session_", ".cookies");
        writeCurlCookieFile();
    }

    private void writeCurlCookieFile() throws IOException {
        StringBuilder sb = new StringBuilder("# Netscape HTTP Cookie File\n");
        for (Cookie c : cookieStore.getCookies()) {
            long expiry = c.getExpiryDate() != null ? c.getExpiryDate().getTime() / 1000L : 0L;
            sb.append(".").append(c.getDomain()).append("\t")
              .append("TRUE\t")
              .append(c.getPath() != null ? c.getPath() : "/").append("\t")
              .append(c.isSecure() ? "TRUE" : "FALSE").append("\t")
              .append(expiry).append("\t")
              .append(c.getName()).append("\t")
              .append(c.getValue()).append("\n");
        }
        Files.write(sessionCookieFile.toPath(), sb.toString().getBytes(StandardCharsets.UTF_8));
    }

    public String getCookie(String aDomain) throws IOException {

        if (aDomain == null)
             aDomain = "federvela.coninet.it";
        else aDomain = aDomain.toLowerCase();

        if (cookieStore != null) {
            List<Cookie> cookies = cookieStore.getCookies();
            if (cookies != null && cookies.size() > 0) {
                for(Cookie c : cookies) {
                    String d = c.getDomain().toLowerCase();
                    if (d != null && d.endsWith(aDomain)) {
                        return CookieUtil.serializeCookie(c);
                    }
                }
            }
        }

        return null;
    }

    private HttpClient getHttpClient() {
        if (sessionCookieFile != null) {
            return new CurlHttpClient(sessionCookieFile, USER_AGENT_MAC);
        }
        if (httpClient == null) {

            try {
                RequestConfig globalConfig = RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.DEFAULT)
                        .setRedirectsEnabled(false)
                        .build();

                if (cookieStore == null)
                    cookieStore = new BasicCookieStore();

                HttpClientBuilder httpBuilder = HttpClientBuilder.create()
                        .setUserAgent(USER_AGENT_MAC)
                        .setDefaultRequestConfig(globalConfig)
                        .setDefaultCookieStore(cookieStore);

                final SSLContext sslContext = new SSLContextBuilder()
                        .loadTrustMaterial(null, (x509CertChain, authType) -> true)
                        .build();

                httpBuilder.setSSLContext(sslContext)
                        .setConnectionManager(
                                new PoolingHttpClientConnectionManager(
                                        RegistryBuilder.<ConnectionSocketFactory>create()
                                                .register("http", PlainConnectionSocketFactory.INSTANCE)
                                                .register("https", new SSLConnectionSocketFactory(sslContext,
                                                        NoopHostnameVerifier.INSTANCE))
                                                .build()
                                ));

                httpClient = httpBuilder.build();

            /*
             * Not anymore?
            httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
             */
            }
            catch(Exception exc) {
                System.out.println("Got Error:" + exc);
            }
        }


        return httpClient;
    }

    public void close() {
        SystemUtil.close((CloseableHttpClient) httpClient);
        if (sessionCookieFile != null) {
            sessionCookieFile.delete();
            sessionCookieFile = null;
        }
    }

    public boolean logIn(String userId, String passwd) {
        try {
            // Use curl as subprocess: Java's JSSE TLS fingerprint is blocked by the
            // WAF (Google Cloud Armor) on this site; curl/OpenSSL passes through.
            File cookieFile = File.createTempFile("fiv_session_", ".cookies");
            String cookiePath = cookieFile.getAbsolutePath();
            String loginUrl = getBaseUrl() + "/user/login?destination=";

            // Step 1: GET login page to obtain a fresh form_build_id
            String html = curlGet(loginUrl, cookiePath);
            if (html == null) {
                System.out.println("logIn: curl GET failed");
                return false;
            }
            String formBuildId = parseFormBuildId(html);
            if (formBuildId == null) {
                System.out.println("logIn: form_build_id not found in login page");
                return false;
            }
            System.out.println("logIn: form_build_id=" + formBuildId);

            // Step 2: POST credentials
            String postData = "name=" + URLEncoder.encode(userId, "UTF-8")
                    + "&pass=" + URLEncoder.encode(passwd, "UTF-8")
                    + "&form_build_id=" + URLEncoder.encode(formBuildId, "UTF-8")
                    + "&form_id=user_login_form"
                    + "&privacy=on"
                    + "&op=Accedi";

            int status = curlPost(loginUrl, postData, cookiePath);
            System.out.println("logIn: POST status=" + status);
            if (status != 302) {
                System.out.println("logIn: expected 302, got " + status);
                return false;
            }

            // Step 3: import curl's cookie jar into the shared CookieStore so that
            // subsequent Apache HttpClient calls carry the session cookie
            importCurlCookies(cookieFile);

            List<Cookie> cookies = cookieStore.getCookies();
            if (cookies.isEmpty()) {
                System.out.println("logIn cookies: None");
                return false;
            }
            // Keep the cookie file alive: CurlHttpClient will use it for all subsequent requests
            this.sessionCookieFile = cookieFile;
            System.out.println("logIn cookies:");
            for (Cookie c : cookies) {
                System.out.println("- " + c.toString());
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getBaseUrl() {
        String scheme = targetHost.getSchemeName();
        String host = targetHost.getHostName();
        int port = targetHost.getPort();
        if (port <= 0
                || (port == 443 && "https".equals(scheme))
                || (port == 80  && "http".equals(scheme))) {
            return scheme + "://" + host;
        }
        return scheme + "://" + host + ":" + port;
    }

    private String curlGet(String url, String cookiePath) {
        try {
            List<String> cmd = new ArrayList<>(Arrays.asList(
                "curl", "-s",
                "-c", cookiePath, "-b", cookiePath,
                "--url", url,
                "-H", "accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
                "-H", "accept-language: en-GB,en-US;q=0.9,en;q=0.8,it;q=0.7",
                "-H", "cache-control: no-cache",
                "-H", "pragma: no-cache",
                "-H", "sec-ch-ua: \"Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153\"",
                "-H", "sec-ch-ua-mobile: ?0",
                "-H", "sec-ch-ua-platform: \"macOS\"",
                "-H", "sec-fetch-dest: document",
                "-H", "sec-fetch-mode: navigate",
                "-H", "sec-fetch-site: none",
                "-H", "sec-fetch-user: ?1",
                "-H", "upgrade-insecure-requests: 1",
                "-H", "user-agent: " + USER_AGENT_MAC
            ));
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.redirectErrorStream(true);
            Process proc = pb.start();
            String output = readStream(proc.getInputStream());
            int exit = proc.waitFor();
            if (exit != 0) {
                System.out.println("curlGet: exited " + exit + " output=" + output.substring(0, Math.min(200, output.length())));
                return null;
            }
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int curlPost(String url, String postData, String cookiePath) {
        try {
            List<String> cmd = new ArrayList<>(Arrays.asList(
                "curl", "-s",
                "-c", cookiePath, "-b", cookiePath,
                "--url", url,
                "-H", "accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
                "-H", "accept-language: en-GB,en-US;q=0.9,en;q=0.8,it;q=0.7",
                "-H", "cache-control: no-cache",
                "-H", "content-type: application/x-www-form-urlencoded",
                "-H", "origin: " + getBaseUrl(),
                "-H", "pragma: no-cache",
                "-H", "referer: " + url,
                "-H", "sec-ch-ua: \"Google Chrome\";v=\"153\", \"Not_A Brand\";v=\"8\", \"Chromium\";v=\"153\"",
                "-H", "sec-ch-ua-mobile: ?0",
                "-H", "sec-ch-ua-platform: \"macOS\"",
                "-H", "sec-fetch-dest: document",
                "-H", "sec-fetch-mode: navigate",
                "-H", "sec-fetch-site: same-origin",
                "-H", "sec-fetch-user: ?1",
                "-H", "upgrade-insecure-requests: 1",
                "-H", "user-agent: " + USER_AGENT_MAC,
                "--data-raw", postData,
                "-w", "\n%{http_code}"
            ));
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.redirectErrorStream(true);
            Process proc = pb.start();
            String output = readStream(proc.getInputStream()).trim();
            proc.waitFor();
            int lastNl = output.lastIndexOf('\n');
            String statusStr = lastNl >= 0 ? output.substring(lastNl + 1).trim() : output;
            return Integer.parseInt(statusStr);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private String parseFormBuildId(String html) {
        int nameIdx = html.indexOf("name=\"form_build_id\"");
        if (nameIdx < 0) {
            System.out.println("parseFormBuildId: not found (html length=" + html.length() + ")");
            return null;
        }
        int valueIdx = html.indexOf("value=\"", nameIdx);
        if (valueIdx < 0) return null;
        int start = valueIdx + 7;
        int end = html.indexOf("\"", start);
        if (end < 0) return null;
        return html.substring(start, end);
    }

    // Netscape cookie file: domain \t subdomains \t path \t secure \t expiry \t name \t value
    private void importCurlCookies(File cookieFile) throws IOException {
        if (cookieStore == null)
            cookieStore = new BasicCookieStore();
        List<String> allLines = Files.readAllLines(cookieFile.toPath(), StandardCharsets.UTF_8);
        for (String line : allLines) {
            if (line.trim().isEmpty()) continue;
            // curl marks HttpOnly cookies with "#HttpOnly_" prefix — strip it, don't skip
            if (line.startsWith("#HttpOnly_")) {
                line = line.substring("#HttpOnly_".length());
            } else if (line.startsWith("#")) {
                continue; // real comment
            }
            String[] p = line.split("\t");
            if (p.length < 7) continue;
            String domain = p[0].startsWith(".") ? p[0].substring(1) : p[0];
            boolean secure = "TRUE".equalsIgnoreCase(p[3]);
            long expiry = 0;
            try { expiry = Long.parseLong(p[4]); } catch (NumberFormatException ignored) {}
            BasicClientCookie cookie = new BasicClientCookie(p[5], p[6]);
            cookie.setDomain(domain);
            cookie.setPath(p[2]);
            cookie.setSecure(secure);
            if (expiry > 0)
                cookie.setExpiryDate(new Date(expiry * 1000L));
            cookieStore.addCookie(cookie);
        }
    }

    private static String readStream(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        int n;
        while ((n = is.read(buf)) != -1)
            bos.write(buf, 0, n);
        return bos.toString("UTF-8");
    }

    public boolean logout() {

        CloseableHttpResponse resp = null;
        try {

            HttpUriRequest login = RequestBuilder.get()
                    .setUri(new URI("/user/logout"))
                    .setVersion(HttpVersion.HTTP_1_1)
                    .build();

            resp = (CloseableHttpResponse) getHttpClient().execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            System.out.println("logOut: " + resp.getStatusLine());
            EntityUtils.consume(entity);

            System.out.println("Get cookies:");
            List<Cookie> cookies = cookieStore.getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (Cookie c : cookies) {
                    System.out.println("- " + c.toString());
                }
            }

            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            SystemUtil.close(resp);
        }

        return false;
    }

    /*
    public List<QueryPersonaItem> QueryPersona(Query aQuery) throws OpException {

        RestOpQueryPersona op = new RestOpQueryPersona(getHttpClient(), targetHost);
        op.setQuery(aQuery);
        List<QueryPersonaItem> p = op.query();
        return p;

    }

    public Persona GETPersona(int idK) throws OpException {

        RestOpGetDettaglioPersona op = new RestOpGetDettaglioPersona(getHttpClient(), targetHost);
        Persona p = op.Get( idK);

        return p;
    }
    */

    public PersonaResource getPersona() {
        return new PersonaResource(getHttpClient(), targetHost);
    }

    public SocietaResource getSocieta() {
        return new SocietaResource(getHttpClient(), targetHost);
    }

    public TesseramentoResource getTesseramento() {
        return new TesseramentoResource(getHttpClient(), targetHost);
    }

    /*
    public List<Tesseramento> QueryTesseramento(Query aQuery) throws OpException {
        RestOpQueryTesseramento op = new RestOpQueryTesseramento(getHttpClient(), targetHost);
        op.setQuery(aQuery);
        List<Tesseramento> p = op.query();
        return p;
    }
    */

    /*
    public List<InfoCertificatoMedico> QueryCertificati(QueryCertificati aQuery) throws OpException {
        RestOpQueryCertificati op = new RestOpQueryCertificati(getHttpClient(), targetHost);
        op.setQuery(aQuery);
        List<InfoCertificatoMedico> p = op.query();
        return p;
    }
    */

    /*
    public StatoTesserato GETStatoTesserato(int codiceTessera, String cognomeOrCodiceFiscale) throws OpException {

        RestOpGetStatoTesserato op = new RestOpGetStatoTesserato(getHttpClient(), targetHost);
        StatoTesserato s = op.Get( codiceTessera, cognomeOrCodiceFiscale);

        return s;
    }
    */

    /*
    public Societa GETSocieta(long idSocieta) throws OpException {

        GetSocieta op = new GetSocieta(getHttpClient(), targetHost);
        Societa s = op.Get( idSocieta);

        return s;
    } */
}
