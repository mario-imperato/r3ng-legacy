package org.r3.system.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Codecs
{
    public static final String[] hexTable = {
            // Table of generated Hex for numbers from 0 to 255
            "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0a", "0b", "0c",
            "0d", "0e", "0f", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1a", "1b", "1c", "1d", "1e",
            "1f", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2a", "2b", "2c", "2d", "2e", "2f", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "3a", "3b", "3c", "3d", "3e", "3f", "40", "41", "42",
            "43", "44", "45", "46", "47", "48", "49", "4a", "4b", "4c", "4d", "4e", "4f", "50", "51", "52", "53", "54",
            "55", "56", "57", "58", "59", "5a", "5b", "5c", "5d", "5e", "5f", "60", "61", "62", "63", "64", "65", "66",
            "67", "68", "69", "6a", "6b", "6c", "6d", "6e", "6f", "70", "71", "72", "73", "74", "75", "76", "77", "78",
            "79", "7a", "7b", "7c", "7d", "7e", "7f", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8a",
            "8b", "8c", "8d", "8e", "8f", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9a", "9b", "9c",
            "9d", "9e", "9f", "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "aa", "ab", "ac", "ad", "ae",
            "af", "b0", "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "ba", "bb", "bc", "bd", "be", "bf", "c0",
            "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "ca", "cb", "cc", "cd", "ce", "cf", "d0", "d1", "d2",
            "d3", "d4", "d5", "d6", "d7", "d8", "d9", "da", "db", "dc", "dd", "de", "df", "e0", "e1", "e2", "e3", "e4",
            "e5", "e6", "e7", "e8", "e9", "ea", "eb", "ec", "ed", "ee", "ef", "f0", "f1", "f2", "f3", "f4", "f5", "f6",
            "f7", "f8", "f9", "fa", "fb", "fc", "fd", "fe", "ff" 
    };

    public static String generateHexTable()
    {
        String newLine = System.getProperty("line.separator");
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < 16; i++)
        {
            stb.append(newLine);
            for (int j = 0; j < 16; j++)
            {
                stb.append(" \"").append(hexChar(i)).append(hexChar(j)).append("\"");
                if (i != 15 || j != 15)
                    stb.append(',');
            }
        }
        return stb.toString();
    }

    public static char hexChar(int d)
    {
        char resC = '0';

        switch (d)
        {
            case 0:
                resC = '0';
                break;
            case 1:
                resC = '1';
                break;
            case 2:
                resC = '2';
                break;
            case 3:
                resC = '3';
                break;
            case 4:
                resC = '4';
                break;
            case 5:
                resC = '5';
                break;
            case 6:
                resC = '6';
                break;
            case 7:
                resC = '7';
                break;
            case 8:
                resC = '8';
                break;
            case 9:
                resC = '9';
                break;
            case 10:
                resC = 'a';
                break;
            case 11:
                resC = 'b';
                break;
            case 12:
                resC = 'c';
                break;
            case 13:
                resC = 'd';
                break;
            case 14:
                resC = 'e';
                break;
            case 15:
                resC = 'f';
                break;
        }

        return resC;
    }

    public static String byteToHex(byte b)
    {
        int lookupValue = (b >= 0) ? b : (b + 256);
        // System.out.println("Converting " + lookupValue + " to Hex: " +
        // hexTable[lookupValue]);
        return hexTable[lookupValue];
    }

    public static String byteToHex(byte[] b)
    {
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            stb.append(byteToHex(b[i]));
        }
        return stb.toString();
    }

    public static int hexToInt(String s)
    {
        int res = 0;

        for (int i = 0; i < s.length(); i++)
        {
            res = res * 16 + Character.digit(s.charAt(i), 16);
        }

        return res;
    }

    public static byte hexToByte(String s)
    {
        int res = 0;

        for (int i = 0; i < s.length(); i++)
        {
            res = res * 16 + Character.digit(s.charAt(i), 16);
        }

        if (res > 255)
            res = res & 0x00ff;
        if (res > 127)
            res = res - 256;

        return (byte) res;
    }

    public static byte[] hexToByteArray(String s)
    {
        if (s == null || s.length() == 0)
            return null;

        if ((s.length() % 2) == 1)
            s = s + "0";
        byte[] resB = new byte[s.length() / 2];
        for (int i = 0; i < s.length(); i += 2)
        {
            resB[i / 2] = hexToByte(s.charAt(i), s.charAt(i + 1));
        }
        return resB;
    }

    public static byte hexToByte(char c1, char c2)
    {
        int res = 0;

        res = 16 * Character.digit(c1, 16) + Character.digit(c2, 16);

        if (res > 255)
            res = res & 0x00ff;
        if (res > 127)
            res = res - 256;

        return (byte) res;
    }

    public static String digestAsString(String s)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(s.getBytes());

            byte[] dig = md.digest();
            return Codecs.byteToHex(dig);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace(System.err);
        }

        return null;
    }

    public static String md5Digest(byte[] b)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(b);

            byte[] dig = md.digest();
            return Codecs.byteToHex(dig);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace(System.err);
        }

        return null;
    }
    
    public static void main(String[] args)
    {
        try
        {
            if (args.length > 0)
            {
                byte b = Byte.parseByte(args[0]);
                System.out.println("Hex conversion " + b + " : " + Codecs.byteToHex(b));
                System.out.println("Integer for    " + args[1] + " : " + Codecs.hexToInt(args[1]));
                System.out.println("Co-decodec for " + args[1] + " : "
                        + Codecs.byteToHex(Codecs.hexToByteArray(args[1])));
                System.out.println("Digest for     " + args[2] + " : " + Codecs.digestAsString(args[2]));
            }
            else
            {
                System.out.println("Syntax: it.gwf_struts.gwfsystem.tests.AsciiTable <byteValue> <hex byte>");
            }

            for (int i = 1; i <= 100; i++)
            {
                String pwd = "user" + String.valueOf(i);
                System.out.println(Codecs.digestAsString(pwd));
            }
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace(System.err);
        }
    }
}

