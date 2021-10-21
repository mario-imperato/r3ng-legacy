// 606765369532517 - ShakeUs
// 253135905118260 - R3

if (facebook_appid)
{
window.fbAsyncInit = function() {
	  
	fbApiInit = false;
    
	FB.init({
      appId      : facebook_appid,
      xfbml      : true,
      cookie     : true,
      version    : 'v2.8'
    });
    FB.AppEvents.logPageView();
    
    fbApiInit = true;    
  };

  function fbEnsureInit(callback) {
      if(!window.fbApiInit) {
          setTimeout(function() {fbEnsureInit(callback);}, 50);
      } else {
          if(callback) {
        	  console.log("calling callback");
              callback();
          }
      }
  }
  
  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
}
else
{
	console.error("Facebook AppId Not Configured");
}