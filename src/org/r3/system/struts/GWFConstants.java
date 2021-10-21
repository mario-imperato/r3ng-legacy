package org.r3.system.struts;

public class GWFConstants
{
    public static final String GWFServletMappingExtension             = ".do";

    public static final String JSPMappingExtension                    = ".jsp";
    
    public static final String YachtClubSiteHome                      = "YachtClubSiteHome";
    public static final String RegattaSiteHome                        = "RegattaSiteHome";
    public static final String DefaultSiteHome                        = "DefaultSiteHome";
    public static final String SpeedSailsHome                         = "SpeedSailsHome";
    public static final String WorkshopHome                           = "WorkshopHome";
    public static final String MasterSiteHome                         = "MasterSiteHome";
    public static final String ITILServiceSiteHome                    = "ITILServiceSiteHome";
    public static final String ShakeusHome                            = "ShakeusHome";
    public static final String ShakeusHomeGuest                       = "ShakeusHomeGuest";
    public static final String ShakeusNeighbHome                      = "ShakeusNeighbHome";
    public static final String ShakeusShopHome                        = "ShakeusShopHome";    
    
    // Forward differenziati in caso di chiamate tradizionali di pagina e invece
    // chiamate che prevedono un ritorno JSON.
    public static final String SystemFailure                  = "SystemFailure";
    public static final String AuthorizationFailure           = "AuthorizationFailure";
    public static final String SessionRequiredFailure         = "SessionRequiredFailure";
    public static final String ConsoleSessionRequiredFailure  = "ConsoleSessionRequiredFailure";
    public static final String SSLRequiredFailure             = "SSLRequiredFailure";
    
    public static final String Success                        = "Success";
    public static final String SuccessGuest                   = "SuccessGuest";
    public static final String SuccessProfile1                = "SuccessProfile1";
    public static final String Failure                        = "Failure";
    
    public static final String RequestOneTimePasswordParam    = "otp";
    public static final String RequestTimeTokenParam          = "timetoken";
    
    public static final String QUARTZ_HTTP_SERVLET_CONTEXT_KEY = "HTTPServletContext";
    
//    // GWFMappingDispatchAction Forwards.
//    public static final String GWFActionMappingFailure        = "GWFActionMappingFailure";
//
//    public static final String GWFControllerConfigFailure     = "GWFControllerConfigFailure";
//
//    public static final String GWFExceptionFailure            = "GWFExceptionFailure";
//
//    public static final String GWFTimeTokenFailure            = "GWFTimeTokenFailure";
//
//    
//
//    
//
//
//    public static final String GWFGuestLoginFailure           = "GWFGuestLoginFailure";
//
//    public static final String GWFOneTimePasswordFailure      = "GWFOneTimePasswordFailure";
//
//    public static final String GWFAllowRulesFailure           = "GWFAllowRulesFailure";
//
//    public static final String GWFDenyRulesFailure            = "GWFDenyRulesFailure";
//
//    public static final String GWFBusyFailure                 = "GWFBusyFailure";
//
//    public static final String GWFAlertFailure                = "GWFAlertFailure";
//
//    public static final String GWFNoForwardFailure            = "GWFNoForwardFailure";
//
//    // Home URL welcome
//    public static final String GWFWelcome                     = "Welcome";
//
//    // Application developer forwards.
//    
//
//    public static final String ResourceNotFound               = "ResourceNotFound";
//
//    public static final String SQLFailure                     = "SQLFailure";
//
//    public static final String SystemFailure                  = "SystemFailure";
//

//
//    
//
//    
//
//    // Parameter in the request object to carry the logging information.
//    public static final String GWF_AccessLogInfo              = "GWF_AccessLogInfo";
//
//    // Session attribute to hold a reference to the Environment object
//    public static final String environmentAttrName            = "GWF_RESERVED_ENVIRONMENT_";
//
//    // Servlet Context attribute under which the reference to the dictionary is
//    // stored.
//    public static final String jspDictionaryAttrName          = "GWF_jsp_dictionary__";
//
//    // Default locale for the framework
//    public static final Locale GWFLocale                      = new Locale("it");
//
//    // Default theme for the framework
//    public static final String GWFTheme                       = "default";
//
//    // Nome dell'attributo all'interno del ServletContext
//    // dell'oggetto velocityCache (vedi GWFVelocityPlugIn)
//    public static final String velocityPlugInAttrName         = "GWF_velocityPlugIn__";
//
//    
}