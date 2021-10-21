
_.mixin(
{
  namespace: function(obj, global, callback) {
    if (!_(obj).isString()) return []
    var namespace = _(obj.split(".")).reduce(function(namespace, fragment) {
      if (namespace[fragment] === undefined) namespace[fragment] = {} 
      return namespace[fragment]
    }, global || window)
    if (callback) return callback(namespace)
    return namespace
  }
})

//  ,
//  indexBy: function(obj, iterator) {
//    var result = {}
//    _.each(obj, function(value, index) {
//      result[iterator(value, index)] = value
//    })
//    return result
//  },
//  definedOr: function(obj, orDefault) {
//    if (obj !== undefined) {
//      return obj
//    }
//    return orDefault
//  },
//  mapSlice: function(obj, iterator, length, context) {
//    var mapped = []
//    _.eachSlice(obj, function(slice) {
//      mapped.push(iterator.call(context, slice, obj, length))
//    }, length)
//    return mapped
//  },
//  eachSlice: function(obj, iterator, length, context) {
//    if (!_.isFunction(obj.slice)) return iterator(obj)
//    var from = 0, to = length
//    while (from < obj.length) {
//      iterator.call(context, obj.slice(from, to), obj, length)
//      from = to, to = Math.min(to+length, obj.length)
//    }
//  },
//  curry: function(obj, implicit, context) {
//    if (!_.isFunction(obj)) return obj
//    return function() {
//      return obj.apply(context, [].concat(implicit, Array.prototype.slice.call(arguments)))
//    }
//  },
//  compareWithOrder: function(reference, compared, order) {
//    if (_.isString(reference)) {
//      reference = reference.toLowerCase()
//      compared = compared.toString().toLowerCase()
//      if (order > 0) {
//        return reference.localeCompare(compared)
//      } else {
//        return compared.localeCompare(reference)
//      }
//    }
//    if (_.isNumber(reference) && _.isNumber(compared)) {
//      if (order > 0) {
//        return reference - compared
//      } else {
//        return compared - reference
//      }
//    }
//    if (_.isDate(reference) && _.isDate(compared)) {
//      if (order > 0) {
//        return reference.getTime() - compared.getTime()
//      } else {
//        return compared.getTime() - reference.getTime()
//      }
//    }
//    throw new Error("unable to compare " + JSON.stringify(reference) + " with " + JSON.stringify(compared))
//  },
//  splat: function(obj, callback, context) {
//    return callback.apply(context, [].concat(Array.prototype.slice.call(obj)))
//  },
//  pick: function(obj) {
//    if (!_.isArray(obj)) return obj
//    return obj[Math.floor(Math.random() * obj.length)]
//  },
//  isDefined: function(obj) {
//    return obj !== undefined
//  },
//  sum: function(obj) {
//    if (!_.isArray(obj)) return 0
//    var index = obj.length, sum = 0
//    while (index--) sum += obj[index]
//    return sum
//  },
//  average: function(obj, precision) {
//    if (!_.isArray(obj)) return 0
//    var index = obj.length, sum = 0
//    while (index--) sum += obj[index]
//    return _.precision(sum/obj.length, precision)
//  },
//  variance: function(obj, precision) {
//    if (!_.isArray(obj)) return 0
//    var average = _.average(obj),
//        index = obj.length,
//        variance = 0
//    while (index--) variance += Math.pow((obj[index] - average), 2 )
//    return _.precision(variance /= obj.length, precision)
//  },
//  deviation: function(obj, precision) {
//    if (!_.isArray(obj)) return 0
//    return _.precision(Math.sqrt(_.variance(obj)), precision)
//  },
//  precision: function(obj, precision) {
//    if (!_.isNumber(obj)) return 0
//    var shift = (precision||6)*10
//    return Math.round(obj*shift)/shift
//  }
//  

/* PLUGINS */
;(function($) {
  $.disableFormSubmit = function() {
    $("form").submit(function(event) {
      event.preventDefault()
    })
  }
})(jQuery)

;(function($) {
  $.fn.handlebars = function(data) {
    if (Handlebars && data) {
      this.text(Handlebars.compile(this.text())(data))
    }
  }
})(jQuery)

;(function($) {
  $.fn.tap = function(doSomething) {
    doSomething.apply(this, Array.prototype.slice.call(arguments, 1))
    return this
  }

  $.expr[':'].parent = function(a,i,m) { return $(a).parent(m[3]).length > 0 }

  if (Function.prototype.bind && window.console && window.console.log) {
    $.log = Function.prototype.bind.call(console.log, console)
  } else if (window.console && window.console.log) {
    $.log = function() {
	    window.console.log(Array.prototype.join.call(arguments,''))
    }
  } else {
    $.log = function() {
      // do nothing
    }
  }

  $.hs = (function(hs) {
    hs.get = function(name, orDefault) {
      var pairs = decode()
      if (pairs[name] !== undefined) {
        return pairs[name]
      }
      return orDefault
    }

    hs.set = function(name, value) {
      return window.location.hash = encode(
        _(decode()).tap(function(pairs) {
          pairs[name] = value
        })
      )
    }

    hs.remove = function(name, orDefault) {
      return _(this.get(name, orDefault)).tap(function(value) {
        window.location.hash = encode(
          _(decode()).tap(function(pairs) {
            delete pairs[name]
          })
        )
      })
    }

    hs.serialize = function(pairs) {
      return encode(pairs || decode())
    }
    
    function decode() {
      var hash = decodeURIComponent(window.location.hash)
      return _(hash.replace(/^#/, "").split(/\s*&\s*/))
        .reduce(function(pairs, component) {
          return _(component.split(/\s*=\s*/)).splat(function(name, value) {
            if (name && value) {
              pairs[name] = value
            }
            return pairs
          })
        }, {})
    }

    function encode(pairs) {
      return "#" + _(pairs).map(function(value, name) {
        return [name, value].join("=")
      }).join("&")
    }

    return hs
  })({})
})(jQuery)

;(function($) {
  $.fn.swapWith = function(to) {
    return this.each(function() {
      $(to).replaceWith($(this).clone(true))
      $(this).replaceWith($(to).clone(true))
    })
  }
})(jQuery)

;(function($) {
  $.fn.ifNot = function(create) {
    if (this.length === 0) {
      this.end()
      return this.pushStack(create.call(this), "ifNot", "")
    }
    return this
  }
})(jQuery)

;(function($) {
  $.fn.notifier = function() {
    return (function($container, notifier) {  
      var $messageContainer = $container.find(".wmg_notifiche_in"),
          $messageTemplate = $("<p></p>"),
          typesOfNotification = {
            "wait": "wmg_progress",
            "message": "wmg_confirm",
            "error": "wmg_error"
          }

      notifier.timer = null
      notifier.timeToLive = 30000
      notifier.currentMessageType = null

      notifier.wait = function(message, until) {
        show(message, "wait", until === undefined ? 0 : until)
      }

      notifier.message = function(message, until) {
        show(message, "message", until)
      }

      notifier.error = function(message, until) {
        show(message, "error", until)
      }

      notifier.currentMessageTypeIs = function(type) {
        return notifier.currentMessageType === type
      }

      notifier.close = function(callback) {
        notifier.currentMessageType = null
        if (notifier.timer) {
          notifier.timer = clearTimeout(notifier.timer)
        }
        $container.fadeTo("slow", 0, function() {
          $container
            .removeClass(_(typesOfNotification).map(function(c){return c}).join(" "))
            .find("p")
              .remove()
              .end()
            .fadeTo(0, 1, function() {
              $(this).hide()
            })
          if (callback) callback()
        })
      }

      function show(message, type, until) {
        notifier.currentMessageType = type
        if (notifier.timer) {
          notifier.timer = clearTimeout(notifier.timer)
        }
        until = until === undefined || until === 0 ? notifier.timeToLive : until
        $container
          .removeClass(_(typesOfNotification).map(function(c){return c}).join(" "))
          .addClass(typesOfNotification[type])
          .find("p")
            .ifNot(function() {
              return $messageTemplate.clone(true).appendTo($messageContainer)
            })
            .html(message)
        $container.show();
        if (until !== 0) {
          notifier.timer = setTimeout(function() {
            notifier.close()
          }, until)
        }
      }

      notifier.$container = $container

      return notifier
    })($(this), {})
  }
})(jQuery)

;(function($) {
  $.fn.extend({
    disable: function() {
      return this.each(function() {
        $(this).attr({
          disabled: true
        }).addClass("wmg_disabled")
      })
    },
    enable: function() {
      return this.each(function() {
        $(this).removeAttr('disabled').removeClass("wmg_disabled")
      })
    }
  })
})(jQuery)

;(function($) {
  $.fn.extend({
    emptyButFirst: function() {
      return this.each(function() {
        $(this).children().slice(1).remove()
      })
    },
    selectOption: function(indexOrValue) {
      return this.each(function() {
        var $select = $(this)
        var $options = $select.find("option")
        var $optionToSelect = _(indexOrValue).isNumber() ?
          $options.eq(indexOrValue) :
          $options.filter(function() {
            var val = $(this).val()
            return val.toLowerCase() === indexOrValue.toLowerCase()
          })
         $optionToSelect.attr("selected", true)
         $select.trigger("change")
      })
    }
  })
})(jQuery)

;(function($) {
  $.support.pdfReader = (function() {
    if ($.browser.msie) {
      var control
      try { control = new ActiveXObject("AcroPDF.PDF") } catch (e) {}
      try { control = new ActiveXObject("PDF.PdfCtrl") } catch (e) {}
      return !!control
    }

    if (navigator.plugins) {
      for (key in navigator.plugins) {
        if (/pdf/i.test(key) || /adobe acrobat/i.test(key)) {
          return true
        }
        if (/pdf/i.test(navigator.plugins[key].name) || /adobe acrobat/i.test(navigator.plugins[key].name)) {
          return true
        }
      }
      return false
    }
  })()
})(jQuery)

;(function($) {
    $.fn.blockUntil = function(task, message, context, notifier, cont) {
      var $this = this
      if (notifier) notifier.wait(message)
      $this.block({
        message: null,
        overlayCSS: {
          "opacity": 0.4,
          "backgroundColor": "#4C4C4C",
          "padding": "0px 10px 10px 10px",
          "left": "-10px",
          "-webkit-border-radius": "5px",
          "-moz-border-radius": "5px",
          "border-radius": "5px"
        }
      })
      task.call(context, function(callback) {
        if(_(cont).isUndefined() || cont.value < 1) {
          cont = {value: 1}
        }
        cont.value = cont.value - 1
        if (notifier) {
          return notifier.close(function() {
            if(cont.value == 0) {
              $this.unblock()
            }
            if (callback) callback()
          })
        }
        if(cont.value == 0) {
          $this.unblock()
        }
        if (callback) callback()
      })
    }
})(jQuery)
