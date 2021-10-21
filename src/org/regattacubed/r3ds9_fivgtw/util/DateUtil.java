package org.regattacubed.r3ds9_fivgtw.util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    private static final Pattern dateFormat1 = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");

    public enum DateFormat { yyyy_mm_dd }

    public static String getNowAs(DateFormat df) {
        SimpleDateFormat sdf;

        switch(df) {
            default:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
        }

        return sdf.format(new java.util.Date());
    }

    public static String getDateAs(String d, DateFormat df) {

        if (d == null)
            return null;

        Matcher m = dateFormat1.matcher(d);
        if (m.matches())
        {
            switch(df) {
                case yyyy_mm_dd:
                    StringBuilder stb = new StringBuilder().append(d.substring(6))
                            .append("-").append(d.substring(3, 5))
                            .append("-").append(d.substring(0, 2));
                    return stb.toString();
            }
        }
        return d;
    }
}
