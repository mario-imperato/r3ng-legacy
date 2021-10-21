package org.regattacubed.r3ds9_fivgtw.util;

import org.apache.http.cookie.Cookie;

import java.io.*;
import java.util.Base64;

public class CookieUtil {

    public static String serializeCookie(Cookie c) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(c);
        out.close();

        byte[] b = bout.toByteArray();
        return Base64.getEncoder().encodeToString(b);
    }

    public static Cookie deserializeCookie(String s) throws IOException, ClassNotFoundException {
        byte[] b = Base64.getDecoder().decode(s);
        ByteArrayInputStream bin = new ByteArrayInputStream(b);
        ObjectInputStream oin = new ObjectInputStream(bin);
        Cookie c = (Cookie)oin.readObject();
        oin.close();

        return c;
    }
}
