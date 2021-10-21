package org.regattacubed.r3ds9_fivgtw.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.*;
import java.security.MessageDigest;

public class SystemUtil {

    public static String computeHash(byte[] dataBuffer) {
        try {
            String s_out;
            MessageDigest md = MessageDigest.getInstance("MD5");
            s_out = SystemUtil.byteArrToString(md.digest(dataBuffer));
            return s_out;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String byteArrToString(byte[] b) {
        final String hex = "0123456789ABCDEF";

        StringBuilder buffer = new StringBuilder();
        for (byte val : b) {
            buffer.append(hex.charAt((val >> 4) & 0xF));
            buffer.append(hex.charAt(val & 0xF));
        }

        return buffer.toString();
    }

    public static char[] byteArrToCharArr(byte[] b) {
        return byteArrToString(b).toCharArray();
    }

    public static void close(InputStream is) {
        if (is != null)
            try {
                is.close();
            } catch (IOException e) {
            }
    }

    public static void close(OutputStream os) {
        if (os != null)
            try {
                os.close();
            } catch (IOException e) {
            }
    }

    public static void close(Reader rd) {
        if (rd != null)
            try {
                rd.close();
            } catch (IOException e) {
            }
    }

    public static void close(Writer wrt) {
        if (wrt != null)
            try {
                wrt.close();
            } catch (IOException e) {
            }
    }

    public static void close(CloseableHttpResponse resp) {
        if (resp != null)
            try {
                resp.close();
            } catch (IOException e) {
            }
    }

    public static void close(CloseableHttpClient httpClient) {
        if (httpClient != null)
            try {
                httpClient.close();
            } catch (IOException e) {
            }
    }
}

