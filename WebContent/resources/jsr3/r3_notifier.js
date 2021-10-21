
(function($) {
  $.fn.notifier = function() {
    return (function($container, notifier) {  
      var $messageContainer = $container.find(".wmg_notifiche_in"),
          $messageTemplate = $("<p></p>"),
          typesOfNotification = {
            "wait": "wmg_progress",
            "message": "wmg_confirm",
            "error": "wmg_error"
          };

      notifier.timer = null;
      notifier.timeToLive = 30000;
      notifier.currentMessageType = null;

      notifier.wait = function(message, until) {
        show(message, "wait", until === undefined ? 0 : until);
      };

      notifier.message = function(message, until) {
        show(message, "message", until);
      };

      notifier.error = function(message, until) {
        show(message, "error", until);
      };

      notifier.currentMessageTypeIs = function(type) {
        return notifier.currentMessageType === type;
      };

      notifier.close = function(callback) {
        notifier.currentMessageType = null;
        if (notifier.timer) {
          notifier.timer = clearTimeout(notifier.timer);
        }
        
        $container
            .removeClass(_(typesOfNotification).map(function(c){return c;}).join(" "))
            .find("p")
              .remove()
              .end();
        $container.hide();
        if (callback) callback();        
      };

      function show(message, type, until) {
        notifier.currentMessageType = type;
        if (notifier.timer) {
          notifier.timer = clearTimeout(notifier.timer);
        }
        until = until === undefined || until === 0 ? notifier.timeToLive : until;
        $container
          .find("div")
          .removeClass(_(typesOfNotification).map(function(c){return c;}).join(" "))
          .addClass(typesOfNotification[type])
          .find("p")
          .ifNot(function() {
              return $messageTemplate.clone(true).appendTo($messageContainer);
          })         
          .html(message);
        $container.show();
        if (until !== 0) {
          notifier.timer = setTimeout(function() {
            notifier.close();
          }, until);
        }
      }

      notifier.$container = $container;

      return notifier;
    })($(this), {});
  };
  
})(jQuery);
