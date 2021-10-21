
package org.r3.system.util;


import java.util.StringTokenizer;

public class ContentTypeUtil {

   private static final String defaultMime  = "application/octet-stream";
   private static final String unoknwonIcon = "fileUnknown.gif";
   public  static final String ZIPSITE      = "X-APPLICATION/HTMLSITE";
   public  static final String CT_JPEG      = "image/jpeg";
   public  static final String CT_GIF       = "image/gif";
   public  static final String CT_PNG      = "image/png";
   
   private static String[] IANAtypes={

        "text"                 , null,                                "fileText.gif",
        "html"                 ,"htm,html",                           "fileHTML.gif",
        "plain"                ,"txt",                                null,
        "richtext"             ,"rtx",                                null,
        "tab-separated-values" ,"tsv",                                null,
        "x-setext"             ,"etx",                                null,
        "x-speech"             ,"talk",                               null,

        "application"               , null,                           "fileApplication.gif",
        "octet-stream"              ,"bin",                           unoknwonIcon,
        "astound"                   ,"asd,asn",                       null,
        "fastman"                   ,"lcc",                           null,
        "java-archive"              ,"jar",                           null,
        "java-serialized-object"    ,"ser",                           null,
        "java-vm"                   ,"class",                         null,
        "mac-binhex40"              ,"hqx",                           null,
        "x-stuffit"                 ,"sit",                           null,
        "mbedlet"                   ,"mbd",                           null,
        "msword"                    ,"doc",                           "fileWord.gif",
        "oda"                       ,"oda",                           null,
        "pdf"                       ,"pdf",                           "filePDF.gif",
        "postscript"                ,"ai,eps,ps",                     null,
        "rtf"                       ,"rtf",                           null,
        "studiom"                   ,"smp",                           null,
        "timbuktu"                  ,"tbt",                           null,
        "vnd.ms-excel"              ,"xls,xlw,xla,xlc,xlm,xlt",       "fileExcel.gif",
        "vnd.ms-powerpoint"         ,"ppt,pps,pot",                   "filePPT.gif",
        "vnd.ms-project"            ,"mpp",                           null,
        "winhlp"                    ,"hlp",                           null,
        "x-javascript"              ,"js",                            null,
        "x-javascript;charset=UTF-8","jsu",                           null,
        "x-asap"                    ,"asp",                           null,
        "x-csh"                     ,"csh",                           null,
        "x-dot"                     ,"dot",                           null,
        "x-dvi"                     ,"dvi",                           null,
        "x-earthtime"               ,"etc",                           null,
        "x-envoy"                   ,"evy",                           null,
        "x-excel"                   ,"xls,xlc,xll,xlm,xlw",           "fileExcel.gif",
        "x-gtar"                    ,"gtar",                          null,
        "x-cpio"                    ,"cpio",                          null,
        "x-hdf"                     ,"hdf",                           null,
        "x-latex"                   ,"latex",                         null,
        "x-javascript-config"       ,"jsc",                           null,
        "x-maker"                   ,"fm",                            null,
        "x-mif"                     ,"mif,mi",                        null,
        "x-mocha"                   ,"mocha,moc",                     null,
        "x-msaccess"                ,"mdb",                           null,
        "x-mscardfile"              ,"crd",                           null,
        "x-msclip"                  ,"clp",                           null,
        "x-msmediaview"             ,"m13,m14",                       null,
        "x-msmetafile"              ,"wmf",                           null,
        "x-msmoney"                 ,"mny",                           null,
        "x-mspublisher"             ,"pub",                           null,
        "x-msschedule"              ,"scd",                           null,
        "x-msterminal"              ,"trm",                           null,
        "x-mswrite"                 ,"wri",                           "fileWord.gif",
        "x-NET-Install"             ,"ins",                           null,
        "x-netcdf"                  ,"nc,cdf",                        null,
        "x-ns-proxy-autoconfig"     ,"proxy",                         null,
        "x-pointplus"               ,"css",                           null,
        "x-salsa"                   ,"slc",                           null,
        "x-sh"                      ,"sh",                            null,
        "x-shar"                    ,"shar",                          null,
        "x-sprite"                  ,"spr,sprite",                    null,
        "x-tar"                     ,"tar",                           null,
        "x-tcl"                     ,"tcl",                           null,
        "x-perl"                    ,"pl",                            null,
        "x-tex"                     ,"tex",                           null,
        "x-texinfo"                 ,"texinfo,texi",                  null,
        "x-timbuktu"                ,"tbp",                           null,
        "x-tkined"                  ,"tki,tkined",                    null,
        "x-troff-man"               ,"man",                           null,
        "x-troff-me"                ,"me",                            null,
        "x-troff-ms"                ,"ms",                            null,
        "x-troff"                   ,"t,tr,roff",                     null,
        "x-wais-source"             ,"src",                           null,
        "zip"                       ,"zip",                           "fileZIP.gif",
        "pre-encrypted"             ,"enc",                           null,
        "x-pkcs7-crl"               ,"crl",                           null,
        "x-fortezza-ckl"            ,"ckl",                           null,
        "x-x509-ca-cert"            ,"cacert",                        null,
        "x-x509-server-cert"        ,"scert",                         null,
        "x-x509-user-cert"          ,"ucert",                         null,
        "x-x509-email-cert"         ,"ecert",                         null,

        "audio"                     , null,                           "fileAudio.gif",
        "basic"                     ,"au,snd",                        null,
        "echospeech"                ,"es,esl",                        null,
        "midi"                      ,"midi,mid",                      null,
        "x-aiff"                    ,"aif,aiff,aifc",                 null,
        "mpeg"                       ,"mp1,mp2,mp3",                  null,
        "x-midi"                    ,"midi,mid",                      null,
        "x-wav"                     ,"wav",                           null,
        "x-pn-realaudio"            ,"ra,ram",                        null,
        "x-pac"                     ,"pac",                           null,
        "x-epac"                    ,"pae",                           null,
        "x-liveaudio"               ,"lam",                           null,
                                     
        "image"                     , null,                           "fileImage.gif",
        "fif"                       ,"fif",                           null,
        "gif"                       ,"gif",                           "fileGIF.gif",
        "ief"                       ,"ief",                           null,
        "ifs"                       ,"ifs",                           null,
        "jpeg"                      ,"jpeg,jpg,jpe,jfif,pjpeg,pjp",   "fileJPEG.gif",
        "png"                       ,"png",                           null,
        "tiff"                      ,"tiff,tif",                      null,
        "vnd"                       ,"dwg,svf",                       null,
        "wavelet"                   ,"wi",                            null,
        "bmp"                       ,"bmp",                           null,
        "x-photo-cd"                ,"pcd",                           null,
        "x-cmu-raster"              ,"ras",                           null,
        "x-portable-anymap"         ,"pnm",                           null,
        "x-portable-bitmap"         ,"pbm",                           null,
        "x-portable-graymap"        ,"pgm",                           null,
        "x-portable-pixmap"         ,"ppm",                           null,
        "x-rgb"                     ,"rgb",                           null,
        "x-xbitmap"                 ,"xbm",                           null,
        "x-xpixmap"                 ,"xpm",                           null,
        "x-xwindowdump"             ,"xwd",                           null,
                                     
                                     
        "video"                     , null,                           "fileVideo.gif",
        "isivideo"                  ,"fvi",                           null,
        "mpeg"                      ,"mpeg,mpg,mpe,mpv,vbs,mpegv",    null,
        "x-mpeg2"                   ,"mpv2,mp2v",                     null,
        "msvideo"                   ,"avi",                           null,
        "quicktime"                 ,"qt,mov,moov",                   null,
        "vivo"                      ,"viv,vivo",                      null,
        "wavelet"                   ,"wv",                            null,
        "x-msvideo"                 ,"avi",                           null,
        "x-sgi-movie"               ,"movie",                         null,
                                     
        "x-world"                   , null,                           "fileXWorld.gif",
        "x-svr"                     ,"svr",                           null,
        "x-vrml"                    ,"wrl",                           null,
        "x-vrt"                     ,"vrt",                           null,
                                     
        "x-conference"              , null,                           "fileXConference.gif",
        "x-cooltalk"                ,"ice",                           null,
                                     
        "encoding"                  , null,                           "fileEncoding.gif",
        "x-gzip"                    ,"gz",                            null,
        "x-compress"                ,"z",                             null,
        "x-uuencode"                ,"uu,uue",                        null
   };

   public static boolean isInternetImage(String ct)
   {
	   if (ct == null)
		   return false;
	   
	   return ct.equalsIgnoreCase(CT_JPEG) || ct.equalsIgnoreCase(CT_PNG) || ct.equalsIgnoreCase(CT_GIF);
   }
   
   public static String findExtensionByMimeType(String ct)
    {
        int posSlash;
        posSlash = ct.lastIndexOf('/');
        if (posSlash < 0)
            return null;

        return findExtensionByMimeType(ct.substring(0, posSlash), ct.substring(posSlash + 1));
    }

    public static String findExtensionByMimeType(String ct1, String ct2)
    {

        for (int i = 0; i < IANAtypes.length; i += 3)
            if (ct1.equalsIgnoreCase(IANAtypes[i]) && IANAtypes[i + 1] == null)
            {
                for (; i < IANAtypes.length; i += 3)
                {
                    if (ct2.equalsIgnoreCase(IANAtypes[i]))
                    {
                        // System.out.println("Found: "+IANAtypes[i+1]);
                        // Return only the firts one.
                        String ext = IANAtypes[i + 1];
                        int hash = ext.indexOf(',');
                        if (hash > 0)
                            return ext.substring(0, hash);
                        return ext;
                    }
                }
                // System.out.println("Found section, not found subsection");
                return null;
            }

        // System.out.println("Didn't fine anything!");
        return null;
    }

    public static String findExtension(String fname)
    {
        int posDot = fname.lastIndexOf('.');
        if (posDot < 0) { return null; }

        return fname.substring(posDot + 1);
    }

   public static String findIconByMimeType(String ct)
    {

        int posSlash;
        posSlash = ct.lastIndexOf('/');
        if (posSlash < 0)
            return unoknwonIcon;

        return findIconByMimeType(ct.substring(0, posSlash), ct.substring(posSlash + 1));
    }

    public static String findIconByMimeType(String ct1, String ct2)
    {
        String resultIcon = unoknwonIcon;
        
        for (int i = 0; i < IANAtypes.length; i += 3)
            if (ct1.equalsIgnoreCase(IANAtypes[i]) && IANAtypes[i + 1] == null)
            {
                resultIcon = IANAtypes[i + 2];
                for (; i < IANAtypes.length; i += 3)
                {
                    if (ct2.equalsIgnoreCase(IANAtypes[i]))
                    {
                    	if (IANAtypes[i + 2] != null)  return IANAtypes[i + 2];
                    	return resultIcon;
                    }
                }
                // System.out.println("Found section, not found subsection");
                return resultIcon;
            }

        // System.out.println("Didn't find anything!");
        return unoknwonIcon;
    }

    public static String findMimeType(String fname)
    {

        if (fname == null || fname.length() == 0)
            return null;

        int hash = fname.lastIndexOf('.');
        if (hash >= 0)
        {
            fname = fname.substring(hash + 1);
            if (fname.length() == 0)
                return defaultMime;
        }

        // fname should be the extension!
        String majorType = null;
        for (int i = 0; i < IANAtypes.length; i += 3)
        {
            if (IANAtypes[i + 1] == null)
            {
                majorType = IANAtypes[i];
                // System.out.println("MajorType: "+majorType);
            }
            else
            {
                StringTokenizer stk = new StringTokenizer(IANAtypes[i + 1], ",");
                while (stk.hasMoreTokens())
                {
                    String token = stk.nextToken();
                    if (fname.equalsIgnoreCase(token))
                    {
                        // System.out.println("MinorType ext: "+token);
                        return majorType + "/" + IANAtypes[i];
                    }
                }
            }
        }

        return defaultMime;
    }

    public static String guessFileName(String url, String ct)
    {
        if (url == null || url.length() == 0)
            return null;

        String ext = null; // Try to guess extension from content type.
        int hash;

        if (ct != null)
        {
            hash = ct.indexOf('/');
            if (hash != -1)
            {
                String ct1 = ct.substring(0, hash);
                String ct2 = null;
                if (hash < (ct.length() - 1))
                {
                    ct2 = ct.substring(hash + 1);
                    hash = ct2.indexOf(';');
                    if (hash != -1)
                        ct2 = ct2.substring(0, hash);
                    ext = ContentTypeUtil.findExtensionByMimeType(ct1, ct2);
                }
            }
        }

        // System.out.println("Extension: "+ext);

        hash = url.indexOf('?');
        if (hash >= 0)
            url = url.substring(0, hash).trim();

        hash = url.lastIndexOf('/');
        if (hash >= 0)
        {
            if (hash < (url.length() - 1))
                url = url.substring(hash + 1);
            else
            {
                // found a directory!
                if (ext != null)
                    return "index." + ext;
                else
                    return "index.unk";
            }
        }

        // In here I should have the last part of the name, with or
        // without extension.

        hash = url.lastIndexOf('.');
        if (hash >= 0)
            return url;
        else
        {
            if (ext != null)
                return url + "." + ext;
            else
                return url + ".unk";
        }

    }

    public static void main(String[] args)
    {
        String file = null;
        switch (args.length)
        {
            case 1:
                file = ContentTypeUtil.guessFileName(args[0], null);
                break;
            case 2:
                file = ContentTypeUtil.guessFileName(args[0], args[1]);
                break;
            case 3:
                file = ContentTypeUtil.findMimeType(args[0]);
                System.out.println("FileUtil ctype: " + file);
                break;
            default:
                System.out.println("Usage: java com.electio.db.util.FileUtil <url> [<contentType>]");
                break;
        }
        System.out.println("FileUtil guess: " + file);
    }

    // This class is not meant to be instantiated.
    private ContentTypeUtil()
    {}
} // End Of Class
