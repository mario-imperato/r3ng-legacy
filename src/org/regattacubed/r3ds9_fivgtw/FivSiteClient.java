package org.regattacubed.r3ds9_fivgtw;

import org.apache.http.Header;
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
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.regattacubed.r3ds9_fivgtw.resources.persona.PersonaResource;
import org.regattacubed.r3ds9_fivgtw.resources.societa.SocietaResource;
import org.regattacubed.r3ds9_fivgtw.resources.tesseramento.TesseramentoResource;
import org.regattacubed.r3ds9_fivgtw.util.CookieUtil;
import org.regattacubed.r3ds9_fivgtw.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class FivSiteClient {

    public static Logger logger = LoggerFactory.getLogger(FivSiteClient.class);

    private static final String USER_AGENT_MAC = "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_1_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36";
    private static final String USER_AGENT_WIN = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0";

    private CookieStore cookieStore;
    private HttpClient httpClient;

    private HttpHost targetHost;

    public FivSiteClient() {
        this("federvela.coninet.it", 80, "http");
    }

    public FivSiteClient(String hostName, int port, String protocolScheme) {
        targetHost = new HttpHost(hostName, port, protocolScheme);
    }

    public void setCookie(String base64Cookie) throws IOException, ClassNotFoundException {
        Cookie c = CookieUtil.deserializeCookie(base64Cookie);
        if (cookieStore == null)
            cookieStore = new BasicCookieStore();

        cookieStore.addCookie(c);
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
        if (httpClient == null) {
            RequestConfig globalConfig = RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.DEFAULT)
                    .setRedirectsEnabled(false)
                    .build();

            List<Header> defaultHeaders = new ArrayList<>();
            defaultHeaders.add(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml,application/json,text/plain,*/*"));

            if (cookieStore == null)
                cookieStore = new BasicCookieStore();

            httpClient = HttpClientBuilder.create()
                    .setUserAgent(USER_AGENT_MAC)
                    .setDefaultRequestConfig(globalConfig)
                    .setDefaultCookieStore(cookieStore)
                    .setDefaultHeaders(defaultHeaders)
                    .build();

            /*
             * Not anymore?
            httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
             */
        }

        return httpClient;
    }

    public void close() {
        SystemUtil.close((CloseableHttpClient) httpClient);
    }

    public boolean logIn(String userId, String passwd) {

        CloseableHttpResponse resp = null;

        try {
            HttpUriRequest login = RequestBuilder.post()
                    .setUri(new URI("/user/login?destination="))
                    .setVersion(HttpVersion.HTTP_1_1)
                    .addParameter("name", userId)
                    .addParameter("pass", passwd)
                    .addParameter("form_id", "user_login_form")
                    .addParameter("op", "Accedi")
                    .build();

            resp = (CloseableHttpResponse) getHttpClient().execute(targetHost, login);

            HttpEntity entity = resp.getEntity();

            EntityUtils.consume(entity);

            if (resp.getStatusLine().getStatusCode() != 302) {
                System.out.println("logIn: " + resp.getStatusLine() + " expected 302");
            } else {
                System.out.println("logIn: " + resp.getStatusLine());
            }

            System.out.println("logIn cookies:");
            List<Cookie> cookies = cookieStore.getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
                return false;
            } else {
                for (Cookie c : cookies) {
                    System.out.println("- " + c.toString());
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SystemUtil.close(resp);
        }

        return false;
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
