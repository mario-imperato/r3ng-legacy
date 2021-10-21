
(function($){$.r3Utils={namespace:function(obj,global,callback)
{if(!_(obj).isString())return[];var namespace=_(obj.split(".")).reduce(function(namespace,fragment){if(namespace[fragment]===undefined)namespace[fragment]={};return namespace[fragment];},global||window);if(callback)return callback(namespace);return namespace;},ie:function()
{return r3_IE||navigator.userAgent.indexOf('Trident')>=0;},getCookie:function(c_name)
{var i,x,y,ARRcookies=document.cookie.split(";");for(i=0;i<ARRcookies.length;i++)
{x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);x=x.replace(/^\s+|\s+$/g,"");if(x==c_name)
{return unescape(y);}}
return null;},logElapsedTime:function(start)
{if(start)
{var end=new Date().getTime();var time=end-start;console.error('logElapsedTime::Execution time: '+time);}
start=new Date().getTime();return start;},hitch:function(o,f)
{if(!o||!f||(typeof f=="undefined"))
console.error("r3_utils::hitch is: ",o,f);return function(){return f.apply(o,arguments);};},stringFormat:function(str)
{if(!str||str=="undefined")return str;switch(arguments.length)
{case 1:break;case 2:str=this._stringFormatFromArrayOfParameters(str,arguments[1]);break;case 3:if(_.isNumber(arguments[1]))
{str=this._stringFormatFromIndexedParameter(str,arguments[1],arguments[2]);}
else if(_.isString(arguments[1]))
str=this._stringFormatFromNamedParameter(str,arguments[1],arguments[2]);break;}
return str;},stringContains:function(s1,s2)
{if(s1!=null&&s2!=null)
{if(s1.indexOf(s2)>=0)
return true;}
return false;},stringDistance:function(s1,s2)
{if(s1!=null&&s2!=null)
{if(s1==s2)
return 0;if(s1.indexOf(s2)>=0)
return 1;if(s2.indexOf(s1)>=0)
return 1;}
return-1;},_stringFormatFromArrayOfParameters:function(str,params)
{if(params!=null&&params.constructor.toString().indexOf("Array")>0)
{for(var i=0;i<params.length;i++)
{str=str.replace("{"+i+"}",params[i]);}
var j=params.length;var k=0;var placeHolder="{"+j+"}";var shiftedPlaceHolder="{"+k+"}";while(j<9)
{if(str.indexOf(placeHolder)>=0)
{str=str.replace(placeHolder,shiftedPlaceHolder);}
j++;k++;placeHolder="{"+j+"}";shiftedPlaceHolder="{"+k+"}";}}
return str;},_stringFormatFromIndexedParameter:function(str,paramIndex,paramValue)
{if(paramIndex>=0)
{str=str.replace("{"+paramIndex+"}",paramValue);}
return str;},_stringFormatFromNamedParameter:function(str,paramName,paramValue)
{str=str.replace("{"+paramName+"}",paramValue);return str;},addParameterToUrl:function(aUrl,fieldName,fieldValue)
{var retUrl=aUrl;if(aUrl.indexOf('?')>=0)
retUrl+="&";else retUrl+="?";return retUrl+fieldName+'='+fieldValue;},addQueryStringToUrl:function(aUrl,aQueryString)
{var retUrl=aUrl;if(aUrl.indexOf('?')>=0)
retUrl+="&";else retUrl+="?";return retUrl+aQueryString;},getQueryStringParamFromPageUrl:function(paramName)
{var regExpResult=(new RegExp('[?&]'+encodeURIComponent(paramName)+'=([^&]*)')).exec(location.search);if(regExpResult)
return decodeURIComponent(regExpResult[1]);},stripParameterFromUrl:function(aUrl,aParamName)
{if(!aUrl)
return aUrl;var paramPosition=aUrl.indexOf(aParamName+"=");if(paramPosition<0)
return aUrl;var arrayOfItems=aUrl.split(/&|\?/);console.log("ArrayOfItems: ",arrayOfItems);var retUrl=null;if(arrayOfItems&&arrayOfItems.length>0)
{retUrl=arrayOfItems[0];var numberOfParams=0;for(var i=1;i<arrayOfItems.length;i++)
{if(arrayOfItems[i].indexOf(aParamName+"=")==0)
continue;if(numberOfParams==0)
retUrl+='?';else retUrl+='&';retUrl+=arrayOfItems[i];numberOfParams++;}}
else
{console.error("it.unep.PageManager::_stripParameterToUrl - Failed on ",aUrl,aParamName);}
return retUrl;},adjustDateFormat:function(aStringDate,aInFormat,anOutFormat)
{var theDate=this.parseDate(aStringDate,aInFormat);if(theDate)
{var d=(theDate.getDate()<10)?'0'+theDate.getDate():theDate.getDate();var m=((theDate.getMonth()+1)<10)?('0'+(theDate.getMonth()+1)):(theDate.getMonth()+1);return d+'/'+m+'/'+theDate.getFullYear();}
return null;},parseDate:function(aStringDate,aFormat)
{if(!aFormat)
aFormat="dd/MM/yyyy";return Date.parseExact(aStringDate,aFormat);},getToday:function()
{var aDate=Date.today();var m=('0'+(aDate.getMonth()+1)).slice(-2);var d=('0'+aDate.getDate()).slice(-2);return d+'/'+m+'/'+aDate.getFullYear();},getTodayAsyyyyMMdd:function()
{var aDate=Date.today();var m=('0'+(aDate.getMonth()+1)).slice(-2);var d=('0'+aDate.getDate()).slice(-2);return''+aDate.getFullYear()+m+d;},getDateAsR3TimestampStringFormat:function(aDate,useShortFormat)
{var m=('0'+(aDate.getMonth()+1)).slice(-2);var d=('0'+aDate.getDate()).slice(-2);var hh=('0'+aDate.getHours()).slice(-2);var mm=('0'+aDate.getMinutes()).slice(-2);var ss=('0'+aDate.getSeconds()).slice(-2);if(useShortFormat)
return''+d+'/'+m+'/'+aDate.getFullYear();return''+d+'/'+m+'/'+aDate.getFullYear()+' '+hh+':'+mm+':'+ss;},isAfter:function(aFirstDate,aSecondDate)
{return aFirstDate.compareTo(aSecondDate)>0;},isBefore:function(aFirstDate,aSecondDate)
{return aFirstDate.compareTo(aSecondDate)<0;},layoutClassicErrorPlacement:function(error,element)
{var parentCell=element.parents("div.validation-error-anchor:first");if(parentCell)
parentCell=parentCell.parents("div:first");else parentCell=element.parents("div:first");error[parentCell.length?'appendTo':'insertAfter'](parentCell.length?parentCell:element);},onEnter:function(elementId,functionContext,processFuntion,unbindFlag)
{var el=$(elementId);if(unbindFlag)
el.unbind();el.bind("keypress",function(event)
{if(event.keyCode==13)
{event.preventDefault();processFuntion.apply(functionContext,arguments);return false;}});},padString:function(value,padCharacter,maxLength)
{var pattern="";for(var i=0;i<maxLength;i++)
pattern+=padCharacter;var newValue=(pattern+value).slice(-maxLength);return newValue;},formatDataDataBeanField:function(aSystemDateDataBeanField)
{if(aSystemDateDataBeanField)
{return $.r3Utils.adjustDateFormat(aSystemDateDataBeanField,'yyyy-MM-dd','dd/MM/yyyy');}
return null;},formatDataDataBeanFieldAsYearMonth:function(aSystemDateDataBeanField)
{if(aSystemDateDataBeanField)
{var d=$.r3Utils.adjustDateFormat(aSystemDateDataBeanField,'yyyy-MM-dd','dd/MM/yyyy');return d.slice(3);}
return null;},formatLUTDataBeanField:function(lutName,aCodedDataBeanField)
{if(aCodedDataBeanField)
{var descr=org.r3.PageManager.getLUTItemDescription(lutName,aCodedDataBeanField);return descr;}
return null;},formatTimestampDataBeanField:function(aSystemTimestampDataBeanField,useShortFormat)
{if(aSystemTimestampDataBeanField)
{var aDate=new Date(aSystemTimestampDataBeanField);return this.getDateAsR3TimestampStringFormat(aDate,useShortFormat);}
return null;},formatTimestampDataBeanFieldAsTime:function(aSystemTimestampDataBeanField)
{if(aSystemTimestampDataBeanField)
{var aDate=new Date(aSystemTimestampDataBeanField);var s=this.getDateAsR3TimestampStringFormat(aDate,false);return s.substring(11);}
return null;},formatSecondsToElapsedTime:function(secs)
{if(secs==0)
return"00:00:00";if(secs)
{var res='';var h=Math.floor(secs/3600);if(h<10)
res='0'+h;else
res=''+h;secs=secs%3600;var m=Math.floor(secs/60);if(m<10)
res+=(':0'+m);else
res+=(':'+m);secs=secs%60;if(secs<10)
res+=(':0'+secs);else
res+=(':'+secs);return res;}
return null;},formatTimeDifferenceFromNow:function(aDateValue)
{var msPerMinute=60*1000;var msPerHour=msPerMinute*60;var msPerDay=msPerHour*24;var msPerMonth=msPerDay*30;var msPerYear=msPerDay*365;var elapsed=(new Date())-aDateValue;var c=0;if(elapsed<msPerMinute)
{c=Math.round(elapsed/1000);if(c==0)
return org.r3.message.no_second_ago;else if(c==1)
return org.r3.message.a_second_ago;return c+' '+org.r3.message.seconds_ago;}
else if(elapsed<msPerHour)
{c=Math.round(elapsed/msPerMinute);if(c==1)
return org.r3.message.a_minute_ago;return c+' '+org.r3.message.minutes_ago;}
else if(elapsed<msPerDay)
{c=Math.round(elapsed/msPerHour);if(c==1)
return org.r3.message.an_hour_ago;return c+' '+org.r3.message.hours_ago;}
else if(elapsed<msPerMonth)
{c=Math.round(elapsed/msPerDay);if(c==1)
return org.r3.message.a_day_ago;return org.r3.message.approximately+' '+c+' '+org.r3.message.days_ago;}
else if(elapsed<msPerYear)
{c=Math.round(elapsed/msPerMonth);if(c==1)
return org.r3.message.a_month_ago;return org.r3.message.approximately+' '+c+' '+org.r3.message.months_ago;}
else
{c=Math.round(elapsed/msPerYear);if(c==1)
return org.r3.message.an_year_ago;return org.r3.message.approximately+' '+c+' '+org.r3.message.years_ago;}},formatDateAsBadge:function(aTimeValue)
{var d=(aTimeValue)?new Date(aTimeValue):new Date();var m=org.r3.message.get3LettersMonthNames(d.getMonth());return'<i>'+('0'+d.getDate()).slice(-2)+'</i> <span class="text-uppercase">'+m+'</span>';},formatDMSUrl4ClientAccess:function(aDMSUrl,saveAsModifier)
{if(aDMSUrl)
{if(aDMSUrl.indexOf("mfs:///")>=0)
{aDMSUrl=aDMSUrl.slice("mfs://".length);clientUrl=org.r3.Constants.getMongoDMSServiceContext()+aDMSUrl;if(saveAsModifier)
clientUrl=org.r3.Constants.getMongoDMSServiceContext()+saveAsModifier+"/"+aDMSUrl;return clientUrl;}
if(aDMSUrl.indexOf("DMS_FILE:///")>=0)
{aDMSUrl=aDMSUrl.slice("DMS_FILE:///".length);var clientUrl=null;if(aDMSUrl.indexOf("PUB")>=0)
{clientUrl=org.r3.Constants.getDMSPublicMountPoint()+aDMSUrl.substring(3);}
else
{clientUrl=org.r3.Constants.getDMSServicesContext()+"/document/"+aDMSUrl;if(saveAsModifier)
clientUrl=org.r3.Constants.getDMSServicesContext()+"/document"+saveAsModifier+"/"+aDMSUrl;}
return clientUrl;}}
return aDMSUrl;},formatMoneyDataBeanField:function(aMoneyValue)
{if(aMoneyValue)
{return aMoneyValue;}
return"0.00&euro;";},formatBooleanAsCheckboxIcon:function(aBooleanValue,padding)
{var checkName="/resources/img/icons/checkbox_off.png";if(aBooleanValue)
checkName="/resources/img/icons/checkbox_on.png";if(!padding)
padding='0';var imageRef="<img style='padding: "+padding+"px' src=\""+org.r3.Constants.applicationContext+checkName+"\" />";return imageRef;},formatSemaphore:function(aSemaphoreColor)
{var s='<i class="fa fa-circle text-'+aSemaphoreColor+'" style="margin: 5px 5px 0 0"></i>';return s;},deprecatedFormatSemaphore:function(aSemaphoreValue)
{var semaphoreName="/resources/img/icons/unknown_semaphore.png";switch(aSemaphoreValue)
{case'ajaxload':semaphoreName="/resources/img/icons/datatable_ajaxload_dot.gif";break;case'red':semaphoreName="/resources/img/icons/datatable_red_dot.png";break;case'green':semaphoreName="/resources/img/icons/datatable_green_dot.png";break;case'orange':semaphoreName="/resources/img/icons/datatable_orange_dot.png";break;case'yellow':semaphoreName="/resources/img/icons/datatable_yellow_dot.png";break;case'gray':semaphoreName="/resources/img/icons/datatable_gray_dot.png";break;case'redo':semaphoreName="/resources/img/icons/redo-icon.png";break;default:semaphoreName="/resources/img/icons/datatable_gray_dot.png";}
var imageRef="<img src=\""+org.r3.Constants.applicationContext+semaphoreName+"\" />";return imageRef;},format4HtmlConsumption:function(s)
{if(s)
{return s;}
return'';},getURLPageQueryParam:function(aParamName)
{var paramValue=null;var qs=this.getURLQueryString(aParamName);if(!qs)
return paramValue;var ndxStart=qs.indexOf(aParamName+"=");if(ndxStart>=0)
{var ndxEnd=qs.indexOf("&",ndxStart);if(ndxEnd>=0)
paramValue=qs.substring(ndxStart+1+aParamName.length,ndxEnd);else
paramValue=qs.substring(ndxStart+1+aParamName.length);}
return paramValue;},getURLQueryString:function()
{var documentUrl=document.URL;if(!documentUrl)
documentUrl=window.location.href;var ndx=documentUrl.indexOf('?');if(ndx>=0)
{return documentUrl.substring(ndx+1);}
return null;},jquery_ui_hoverIn:function(e)
{var element=$(e.currentTarget);element.addClass("ui-state-hover");},jquery_ui_hoverOut:function(e)
{var element=$(e.currentTarget);element.removeClass("ui-state-hover");},isFieldEmpty:function(jQueryObject)
{var s=jQueryObject.val();var isEmpty=!jQueryObject||!s||s.length==0||s.trim().length==0;return isEmpty;},getArrayAsJSONObject:function(anArray)
{var res={};$.map(anArray,function(n,i){res[n['name']]=n['value'];});return res;}};$.codecUtils={computeCheckDigit:function(value)
{if(!value||value.length<11)
return-1;var sumOdd=0;var sumEven=0;for(var i=0;i<11;i++)
{if(i%2)
{sumOdd+=parseInt(value.charAt(i));}
else
{sumEven+=parseInt(value.charAt(i));}}
var totale=0;var sumTotalAsString=""+(sumEven+sumOdd*11);for(var i=0;i<sumTotalAsString.length;i++)
{totale+=parseInt(sumTotalAsString.charAt(i));}
var digit=totale%10;return digit;},checkCheckDigit:function(aCodiceRaccomandata)
{var digit=this.computeCheckDigit(aCodiceRaccomandata);if(digit!=-1&&aCodiceRaccomandata.length==12)
{return digit==parseInt(aCodiceRaccomandata.charAt(11));}
return false;},shiftCodiceRaccomandata:function(aCodiceRaccomandata,shiftValue)
{if(!aCodiceRaccomandata||aCodiceRaccomandata.length!=12)
{return null;}
var s="9"+aCodiceRaccomandata.substring(0,11);var l=parseInt(s)+shiftValue;var nuovoCodice=''+l;if(nuovoCodice.length>11)
nuovoCodice=nuovoCodice.substring(nuovoCodice.length-11);var checkDigit=this.computeCheckDigit(nuovoCodice);return nuovoCodice+checkDigit;},getCodiceARCadFromCodiceRaccomandata:function(aCodiceRaccomandata)
{var nuovoCodice=this.shiftCodiceRaccomandata(aCodiceRaccomandata,10000000);return nuovoCodice;}};})(jQuery);(function($)
{$.fn.ifNot=function(create)
{if(this.length===0)
{this.end();return this.pushStack(create.call(this),"ifNot","");}
return this;};})(jQuery);if(window.console==null)
{window.console={log:function(aMessage)
{},info:function(aMessage)
{},error:function(aMessage)
{}};}
(function($)
{$.fn.cascadingSelect=function(anOptionHash)
{var defaults={withNullOption:false,groupId:'cascadingSelect',widgetConfig:[],lutManager:null,ajaxUrlMode:'x-www-form-urlencoded'};var options=$.extend({},defaults,anOptionHash);if(this.length>0)
{if(_cascadingSelect_getWidgetDataOfItem($(this[0])))
{_cascadingSelect_unbindOnChange($(this[0]));console.info("Unbinding Change On Cascading Select",$(this[0]),_cascadingSelect_getWidgetDataOfItem($(this[0])));}
var cascadingInfo={eventsBound:false,lutManager:options.lutManager,selectInfo:[]};for(var i=0;i<this.length;i++)
{var item=$(this[i]);var itemId=item.attr('id');if(!itemId)
{itemId=options.groupId+'_'+i;item.attr('id',itemId);}
var widgetConfig=_cascadingSelect_getWidgetConfig(itemId,options);var itemInfo={'widgetId':itemId,'ajaxSource':widgetConfig.ajaxSource,'ajaxUrlMode':widgetConfig.ajaxUrlMode,'value':widgetConfig.value,'withNullOption':options.withNullOption,'onChange':widgetConfig.onChange,'onChangePropagate':options.onChangePropagate};cascadingInfo.selectInfo[i]=itemInfo;item.data('cascadingSelect',{widgetIndex:i,'cascadingInfo':cascadingInfo});item.prop('options').length=0;}
_cascadingSelect_populateSelect($(this[0]));}
function _cascadingSelect_populateSelect(currentSelect)
{var cascadingSelectInfo=_cascadingSelect_getCascadingSelectInfoOfItem(currentSelect);var ajaxEndPoint=_cascadingSelect_getAjaxSource(currentSelect);var selectOptions=currentSelect.prop('options');if(cascadingSelectInfo.withNullOption)
{selectOptions[selectOptions.length]=new Option('','');}
var currentSelectValue=cascadingSelectInfo.value;var aLutManager=_cascadingSelect_getWidgetDataOfItem(currentSelect).cascadingInfo.lutManager;var onLutSuccess=function(jsonData)
{var firstItemKey=null;var itemSelectedKey=null;var itemSelected=false;$.each(jsonData.aaData,function(index,item)
{if(index==0)
firstItemKey=item.dtokey;if(currentSelectValue&&item.dtokey==currentSelectValue)
{itemSelected=true;itemSelectedKey=item.dtokey;}
else
itemSelected=false;selectOptions[selectOptions.length]=new Option(item.dtodescr,item.dtokey,itemSelected,itemSelected);});if(!cascadingSelectInfo.withNullOption&&!itemSelectedKey)
itemSelectedKey=firstItemKey;var doBindOnChange=!_cascadingSelect_getWidgetDataOfItem(currentSelect).cascadingInfo.eventsBound;if(!itemSelectedKey)
{cascadingSelectInfo.value=null;}
else
{cascadingSelectInfo.value=itemSelectedKey;var nextItem=_cascadingSelect_getCascadingSelectInfoOfNextItem(currentSelect);if(nextItem)
{_cascadingSelect_populateSelect($('#'+nextItem.widgetId));doBindOnChange=false;}}
if(doBindOnChange)
_cascadingSelect_bindOnChange(currentSelect);};if(aLutManager==null)
$.getJSON(ajaxEndPoint,onLutSuccess);else
{aLutManager.getLUT(ajaxEndPoint,onLutSuccess);}}
function _cascadingSelect_unbindOnChange(item)
{var widgetData=item.data('cascadingSelect');var cascadingInfo=widgetData.cascadingInfo;$.each(cascadingInfo.selectInfo,function(index,item)
{$('#'+item.widgetId).unbind('change.cascadingSelect');});}
function _cascadingSelect_bindOnChange(item)
{var widgetData=item.data('cascadingSelect');var cascadingInfo=widgetData.cascadingInfo;$.each(cascadingInfo.selectInfo,function(index,item)
{$('#'+item.widgetId).bind('change.cascadingSelect',function(e)
{var item=$(this);var widgetData=item.data('cascadingSelect');var cascadingInfo=widgetData.cascadingInfo;cascadingInfo.selectInfo[widgetData.widgetIndex].value=item.val();if(cascadingInfo.selectInfo[widgetData.widgetIndex].onChange)
cascadingInfo.selectInfo[widgetData.widgetIndex].onChange(item.val());for(var i=widgetData.widgetIndex+1;i<cascadingInfo.selectInfo.length;i++)
{cascadingInfo.selectInfo[i].value=null;$('#'+cascadingInfo.selectInfo[i].widgetId).prop('options').length=0;if(cascadingInfo.selectInfo[i].onChange&&cascadingInfo.selectInfo[i].onChangePropagate)
cascadingInfo.selectInfo[i].onChange();}
if(item.val()&&item.val().length>0&&widgetData.widgetIndex<(widgetData.cascadingInfo.selectInfo.length-1))
{_cascadingSelect_populateSelect($('#'+cascadingInfo.selectInfo[widgetData.widgetIndex+1].widgetId));}});});cascadingInfo.eventsBound=true;}
function _cascadingSelect_getIndexOfItem(item)
{var widgetData=item.data('cascadingSelect');return widgetData.widgetIndex;}
function _cascadingSelect_getCascadingSelectInfoOfNextItem(item)
{var widgetData=item.data('cascadingSelect');if(widgetData.widgetIndex<(widgetData.cascadingInfo.selectInfo.length-1))
return widgetData.cascadingInfo.selectInfo[widgetData.widgetIndex+1];return null;}
function _cascadingSelect_getWidgetDataOfItem(item)
{var widgetData=item.data('cascadingSelect');return widgetData;}
function _cascadingSelect_getCascadingSelectInfoOfItem(item)
{var widgetData=item.data('cascadingSelect');return widgetData.cascadingInfo.selectInfo[widgetData.widgetIndex];}
function _cascadingSelect_getAjaxSource(item)
{var widgetData=item.data('cascadingSelect');var cascadingSelectInfo=_cascadingSelect_getCascadingSelectInfoOfItem(item);var ajaxSourceUrl=cascadingSelectInfo.ajaxSource;for(var i=0;i<widgetData.widgetIndex;i++)
{var theSelect=$('#'+widgetData.cascadingInfo.selectInfo[i].widgetId);if(cascadingSelectInfo.ajaxUrlMode=='restful')
ajaxSourceUrl=_cascadingSelect_restUrlEncode(ajaxSourceUrl,i,theSelect.val());else
ajaxSourceUrl=_cascadingSelect_formUrlEncode(ajaxSourceUrl,i,theSelect.attr('name'),theSelect.val());}
cascadingSelectInfo.resolvedAjaxSource=ajaxSourceUrl;return ajaxSourceUrl;}
function _cascadingSelect_formUrlEncode(anAjaxSource,fieldIndex,fieldName,fieldValue)
{if(fieldIndex==0)
anAjaxSource=anAjaxSource+"?";else
anAjaxSource=anAjaxSource+"&";anAjaxSource=anAjaxSource+(fieldName||'NONE')+"="+fieldValue;return anAjaxSource;}
function _cascadingSelect_restUrlEncode(anAjaxSource,fieldIndex,fieldValue)
{anAjaxSource=$.r3Utils.stringFormat(anAjaxSource,fieldIndex,fieldValue);return anAjaxSource;}
function _cascadingSelect_getWidgetConfig(widgetId,anOptionHash)
{for(var i=0;i<anOptionHash.widgetConfig.length;i++)
{if(anOptionHash.widgetConfig[i].widgetId==widgetId)
{return $.extend({},{'ajaxSource':anOptionHash.ajaxSource,'ajaxUrlMode':anOptionHash.ajaxUrlMode},anOptionHash.widgetConfig[i]);}}
console.error("CascadingSelect::_cascadingSelect_getWidgetConfig - Could not find widgetId");return{'ajaxSource':anOptionHash.ajaxSource,'ajaxUrlMode':'x-www-form- urlencoded','value':null};}
return this;};})(jQuery);(function($)
{$.widget('r3.formmessage',{options:{},_create:function()
{this._message={category:'info'};this._currentCategory="info";this._infoLineDiv=$('<div></div>').addClass('formmessageCanvas info');this._setMessage(this.options);this._renderMessage();this.element.html(this._infoLineDiv);},_setMessage:function(anHash)
{if(anHash.text&&anHash.text.length>0)
{this._message={'text':anHash.text,'category':((!anHash.category)?'info':anHash.category)};}
else
{this._message={category:'info'};}},setText:function(anHash)
{this._setMessage(anHash);this._renderMessage();},clear:function()
{this._message={category:'info'};this._renderMessage();},_renderMessage:function()
{this._infoLineDiv.empty();if(this._currentCategory!=this._message.category)
{this._infoLineDiv.removeClass(this._currentCategory);this._infoLineDiv.addClass(this._message.category);this._currentCategory=this._message.category;}
if(this._message.text)
{this._infoLineDiv.append(this._message.text);this._infoLineDiv.show();}
else this._infoLineDiv.hide();},destroy:function()
{this._infoLineDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);}});})(jQuery);(function($)
{$.widget('r3.infoLine',{options:{},_create:function()
{this._itemsMap={};this._infoLineDiv=$('<div></div>').addClass('infoLineCanvas');if(this.options.items)
{if(!this.options.groupId)
this.options.groupId='default';this._itemsMap[this.options.groupId]=this.options.items;this._renderItems();}
this.element.html(this._infoLineDiv);},update:function(anHash)
{if(anHash&&anHash.items)
{if(!anHash.groupId)
anHash.groupId='default';this._itemsMap[anHash.groupId]=anHash.items;this._renderItems();}},clear:function()
{this._itemsMap={};this._renderItems();},removeGroup:function(aGroupId)
{if(aGroupId)
{this._itemsMap[aGroupId]=[];this._renderItems();}},_renderItems:function()
{this._infoLineDiv.empty();var itemCounter=0;for(pname in this._itemsMap)
{var groupItems=this._itemsMap[pname];if(groupItems&&groupItems.length>0)
{for(var i=0;i<groupItems.length;i++,itemCounter++)
{var separator=" ";if(itemCounter>0&&!groupItems[i].newLine)
{separator=' - ';}
var item="";if($.isFunction(groupItems[i].value))
{console.info("Is Function");var itemHtml='<label>'+separator+groupItems[i].label+': </label><label class="itemInfo" id="'
+groupItems[i].id+'">...Waiting...</label>';if(groupItems[i].newLine)
itemHtml='<br />'+itemHtml;item=$(itemHtml);}
else
{var gval=groupItems[i].value;var brender=true;if(!gval)
{if(this.options.defaultOnEmptyValues&&this.options.defaultOnEmptyValues=='skip')
brender=false;else gval=this.options.defaultOnEmptyValues||".";}
if(brender)
{var itemHtml='<label>'+separator+groupItems[i].label+': </label><label class="itemInfo" id="'
+groupItems[i].id+'">'+gval+'</label>';if(groupItems[i].newLine)
itemHtml='<br />'+itemHtml;item=$(itemHtml);}}
this._infoLineDiv.append(item);if($.isFunction(groupItems[i].value))
{groupItems[i].value();}}}}},destroy:function()
{this._infoLineDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);}});})(jQuery);(function($){$.fn.notifier=function(){return(function($container,notifier){var $messageContainer=$container.find(".wmg_notifiche_in"),$messageTemplate=$("<p></p>"),typesOfNotification={"wait":"wmg_progress","message":"wmg_confirm","error":"wmg_error"};notifier.timer=null;notifier.timeToLive=30000;notifier.currentMessageType=null;notifier.wait=function(message,until){show(message,"wait",until===undefined?0:until);};notifier.message=function(message,until){show(message,"message",until);};notifier.error=function(message,until){show(message,"error",until);};notifier.currentMessageTypeIs=function(type){return notifier.currentMessageType===type;};notifier.close=function(callback){notifier.currentMessageType=null;if(notifier.timer){notifier.timer=clearTimeout(notifier.timer);}
$container.removeClass(_(typesOfNotification).map(function(c){return c;}).join(" ")).find("p").remove().end();$container.hide();if(callback)callback();};function show(message,type,until){notifier.currentMessageType=type;if(notifier.timer){notifier.timer=clearTimeout(notifier.timer);}
until=until===undefined||until===0?notifier.timeToLive:until;$container.find("div").removeClass(_(typesOfNotification).map(function(c){return c;}).join(" ")).addClass(typesOfNotification[type]).find("p").ifNot(function(){return $messageTemplate.clone(true).appendTo($messageContainer);}).html(message);$container.show();if(until!==0){notifier.timer=setTimeout(function(){notifier.close();},until);}}
notifier.$container=$container;return notifier;})($(this),{});};})(jQuery);(function($)
{$.widget('r3.wizardnavigator',{options:{},_create:function()
{this._wizardNavigator=$('<div></div>').addClass('wizardNavigator');this._initializeWizard(this.options);this.element.html(this._wizardNavigator);this._bindEvents(this.options);},getSelected:function()
{var selectedItem=this._getSelectedItem(this.options);return selectedItem;},find:function(aStepId)
{var foundItem=this._findItemById(this.options,aStepId);return foundItem;},next:function()
{var selectedItem=this._getSelectedItem(this.options);var nextItem=this._getNextItem(this.options);this._clearSelectionHint(this.options,selectedItem);this._selectItem(this.options,nextItem);return nextItem;},prev:function()
{var selectedItem=this._getSelectedItem(this.options);var prevItem=this._getPrevItem(this.options);this._clearSelectionHint(this.options,selectedItem);this._selectItem(this.options,prevItem);return prevItem;},_clearSelectionHint:function(anHash,selectedItem)
{if(selectedItem)
{var removeCSSClassName=anHash.stepSelectedCSSClass;if(!removeCSSClassName)
removeCSSClassName='wizardSelectedStep';var addCSSClassName=anHash.stepCSSClass;if(!addCSSClassName)
addCSSClassName='wizardStep';$('#'+selectedItem.id).removeClass(removeCSSClassName).addClass(addCSSClassName);selectedItem.selected=false;if(selectedItem.active&&selectedItem.onClick)
{this._bindEvent(selectedItem);$('#'+selectedItem.id).addClass('wizardActiveStep');}}},_selectItem:function(anHash,selectedItem)
{if(selectedItem)
{var addCSSClassName=this.options.stepSelectedCSSClass;if(!addCSSClassName)
addCSSClassName='wizardSelectedStep';var removeCSSClassName=this.options.stepCSSClass;if(!removeCSSClassName)
removeCSSClassName='wizardStep';$('#'+selectedItem.id).removeClass(removeCSSClassName).addClass(addCSSClassName);$('#'+selectedItem.id).removeClass('wizardActiveStep');this._unbindEvent(selectedItem);selectedItem.selected=true;this._setWizardTitle(selectedItem);}},_setWizardTitle:function(anItem)
{var widgetId=this.element.attr("id");$('#'+widgetId+" .wizardNavigatorTitle").html(anItem.title);$('#'+widgetId+" .wizardNavigatorStepNumber").html(anItem.stepNumber);if(anItem.legend)
{$('#'+widgetId+" .wizardNavigatorLegend").html(anItem.legend);}
else
{$('#'+widgetId+" .wizardNavigatorLegend").html("");}},_getSelectedItem:function(anHash)
{for(var i=0;i<anHash.steps.length;i++)
{var stepItem=anHash.steps[i];if(stepItem.selected)
{return stepItem;}}
return null;},_findItemById:function(anHash,aStepId)
{for(var i=0;i<anHash.steps.length;i++)
{var stepItem=anHash.steps[i];if(stepItem.id==aStepId)
{return stepItem;}}
return null;},_getNextItem:function(anHash)
{var selectedFound=false;for(var i=0;i<anHash.steps.length;i++)
{var stepItem=anHash.steps[i];if(stepItem.selected)
{selectedFound=true;}
else
{if(selectedFound)
return stepItem;}}
return null;},_getPrevItem:function(anHash)
{var prevItem=null;for(var i=0;i<anHash.steps.length;i++)
{var stepItem=anHash.steps[i];if(stepItem.selected)
{return prevItem;}
prevItem=stepItem;}
return null;},_bindEvents:function(anHash)
{for(var i=0;i<anHash.steps.length;i++)
{var stepItem=anHash.steps[i];if(!stepItem.selected&&stepItem.active&&stepItem.onClick)
{this._bindEvent(stepItem);}}},_bindEvent:function(aStepInfo)
{var _self=this;$('#'+aStepInfo.id).unbind(".wizardnavigator").bind('click.wizardnavigator',function(e){_self._onActiveClick(aStepInfo.id);});},_unbindEvent:function(aStepInfo)
{var _self=this;$('#'+aStepInfo.id).unbind(".wizardnavigator");},_onActiveClick:function(aStepId)
{var selectedItem=this._getSelectedItem(this.options);this._clearSelectionHint(this.options,selectedItem);var newSelectedItem=this._findItemById(this.options,aStepId);this._selectItem(this.options,newSelectedItem);selectedItem.onClick(selectedItem,false);newSelectedItem.onClick(newSelectedItem,true);},_initializeWizard:function(anHash)
{var wizardHtml="";wizardHtml+="<div style='clear: both'> </div>"+"<ul class='wizardNavigatorSteps hidden-sm hidden-xs'>"+"  <li><div class='wizardStepStart'>&nbsp;</div></li>";for(var i=0;i<anHash.steps.length;i++)
{var stepItem=anHash.steps[i];stepItem.stepNumber=i+1;if(stepItem.selected)
{wizardHtml=this._buildHtmlTitle(stepItem)+wizardHtml;wizardHtml+=this._buildHtmlSelectedStep(stepItem,anHash.stepSelectedCSSClass);}
else if(stepItem.active&&stepItem.onClick)
{wizardHtml+=this._buildHtmlActiveStep(stepItem,anHash.stepCSSClass);}
else wizardHtml+=this._buildHtmlStep(stepItem,anHash.stepCSSClass);}
wizardHtml+="<li><div class='wizardStepEnd'>&nbsp;</div></li></ul>";this._wizardNavigator.html(wizardHtml);},_buildHtmlTitle:function(aStepInfo)
{var generatedHtml="";generatedHtml="<div class='wizardNavigatorStepNumber'>"+aStepInfo.stepNumber+"</div>"+"<div class='wizardNavigatorTitle'>"+aStepInfo.title;if(aStepInfo.legend)
{generatedHtml+="<br /><span class='wizardNavigatorLegend'>"+aStepInfo.legend+"</span>";}
generatedHtml+="</div>";return generatedHtml;},_buildHtmlSelectedStep:function(aStepInfo,aStepClass)
{var generatedHtml="";var sClass='wizardSelectedStep';if(aStepClass)
sClass=aStepClass;generatedHtml="<li><div id='"+aStepInfo.id+"' class='"+sClass+"'><br />"+aStepInfo.briefTitle+"</div></li>";return generatedHtml;},_buildHtmlActiveStep:function(aStepInfo,aStepClass)
{var generatedHtml="";var sClass='wizardStep';if(aStepClass)
sClass=aStepClass;generatedHtml="<li><div id='"+aStepInfo.id+"' class='"+sClass+" wizardActiveStep'><br />"+aStepInfo.briefTitle+"</div></li>";return generatedHtml;},_buildHtmlStep:function(aStepInfo,aStepClass)
{var generatedHtml="";var sClass='wizardStep';if(aStepClass)
sClass=aStepClass;generatedHtml="<li><div id='"+aStepInfo.id+"' class='"+sClass+"'><br />"+aStepInfo.briefTitle+"</div></li>";return generatedHtml;},destroy:function()
{this._wizardNavigator.remove();$.Widget.prototype.destroy.apply(this,arguments);}});})(jQuery);(function($)
{$.fn.cmsCard=function(anOptionHash)
{var defaults={card_tmpl:'cms_tpl_simple',fetchmode:'full',url_bycardid:'GET_CardView_Detail_Info',url_bycardquery:'GET_CardView_Query_Info',adapterFactory:function(aRowDataBean)
{return new org.r3.db.cms.cardview.CardViewDTOAdapter(aRowDataBean);}};var cmscard_options=$.extend({},defaults,anOptionHash);if(!cmscard_options.site)
{cmscard_options.site=org.r3.Constants.site;}
cmscard_options.language=org.r3.Constants.language;if(this.length>0)
{var listOfDivInfo=[];var mapOfDivInfo={};for(var i=0;i<this.length;i++)
{var item=$(this[i]);var itemId=item.attr('id');var tpl=cmscard_options.card_tmpl||item.attr('card_tmpl');var divInfo={canvasObj:item,canvasId:itemId,cardTemplate:tpl};listOfDivInfo.push(divInfo);mapOfDivInfo[itemId]=divInfo;}
var restUrl=null;if(cmscard_options.cardid)
{restUrl=org.r3.PageManager.getRESTUrl(cmscard_options.url_bycardid,[cmscard_options.site,cmscard_options.language,cmscard_options.cardid,cmscard_options.fetchmode]);}
else
{if(cmscard_options.cardquery)
{var actualQuery=cmscard_options.cardquery;if(cmscard_options.iDisplayLength&&cmscard_options.iDisplayLength>0)
{actualQuery=actualQuery+"&iDisplayStart="+(cmscard_options.iDisplayStart||'0')+"&iDisplayLength="+cmscard_options.iDisplayLength;}
else
actualQuery=actualQuery+"&iDisplayStart=0&iDisplayLength=-1";restUrl=org.r3.PageManager.getRESTUrl(cmscard_options.url_bycardquery,[cmscard_options.site,cmscard_options.language,cmscard_options.fetchmode,actualQuery]);}
else
{console.error("CardQuery has not been set.... Why?");cmscard_options.cardid='__NO_CARD__';restUrl=org.r3.PageManager.getRESTUrl(cmscard_options.url_bycardid,[cmscard_options.site,cmscard_options.language,cmscard_options.cardid,cmscard_options.fetchmode]);}}
_cmsCard_retrieveCardData(restUrl,mapOfDivInfo,listOfDivInfo,cmscard_options);}
function _cmsCard_retrieveCardData(anAjaxSource,mapOfDivs,listOfDivs,pluginOptions)
{var networkRequestsQueue=[];networkRequestsQueue.push({id:"card_data",type:"Get",url:anAjaxSource,dataType:"json"});org.r3.PageManager.multiAjax(networkRequestsQueue,$.r3Utils.hitch(this,function(responseData)
{_cmsCard_processCardData(mapOfDivs,listOfDivs,responseData["card_data"],pluginOptions);}),function(d)
{console.error("...> error");});}
function _cmsCard_applyTemplates(cardInfo,listOfDivs,pluginOptions)
{for(var i=0;i<listOfDivs.length;i++)
{var renderedCard=tmpl(listOfDivs[i].cardTemplate,{"object":cardInfo,"options":_cmsCard_getRenderingOptions(pluginOptions,{})});var canvas=listOfDivs[i].canvasObj;canvas.html(renderedCard);canvas.show();}}
function _cmsCard_retrieveExecutableHtmlFragments(listOfPropertyDTOAdapter,onComplete)
{var networkRequestsQueue=[];for(var j=0;j<listOfPropertyDTOAdapter.length;j++)
{networkRequestsQueue.push({id:listOfPropertyDTOAdapter[j].dataBean.propertyid,type:"Get",url:listOfPropertyDTOAdapter[j].getDocumenturl(),dataType:"html"});}
org.r3.PageManager.multiAjax(networkRequestsQueue,$.r3Utils.hitch(this,function(responseData)
{for(var j=0;j<listOfPropertyDTOAdapter.length;j++)
{listOfPropertyDTOAdapter[j].dataBean.propertyvalue=responseData[listOfPropertyDTOAdapter[j].dataBean.propertyid];}
if(onComplete)
onComplete();}),function(d)
{console.error("...> error");});}
function _cmsCard_getRenderingOptions(pluginOptions,moreInfo)
{var renderingOptions=$.extend({},pluginOptions,moreInfo);return renderingOptions;}
function _cmsCard_processCardData(mapOfDivs,listOfDivs,responseData,pluginOptions)
{if(responseData&&!(typeof responseData.aaData==="undefined"))
{if(responseData.aaData&&responseData.aaData.length>0&&responseData.iTotalRecords)
{var adapter=new org.r3.db.DTOTableAdapter(responseData,function(aRowDataBean){return cmscard_options.adapterFactory(aRowDataBean);});if(listOfDivs.length>1)
{}
else
{var renderedCard=tmpl(listOfDivs[0].cardTemplate,{"object":adapter,"options":_cmsCard_getRenderingOptions(pluginOptions,{"totalrecords":responseData.iTotalRecords})});var canvas=listOfDivs[0].canvasObj;canvas.html(renderedCard);canvas.show();}
if(pluginOptions&&pluginOptions.onComplete)
pluginOptions.onComplete(adapter,responseData.iTotalRecords);}
else
{if(pluginOptions&&pluginOptions.onComplete)
pluginOptions.onComplete(null,0);}}
else
{if(responseData)
{var cardInfo=cmscard_options.adapterFactory(responseData);if(cardInfo.hasExecutableHtmlFragments())
{_cmsCard_retrieveExecutableHtmlFragments(cardInfo.dataBean.listof_executablehtmlfragments,function(){_cmsCard_applyTemplates(cardInfo,listOfDivs,pluginOptions);if(pluginOptions&&pluginOptions.onComplete)
pluginOptions.onComplete(cardInfo,1);});}
else
{_cmsCard_applyTemplates(cardInfo,listOfDivs,pluginOptions);if(pluginOptions&&pluginOptions.onComplete)
pluginOptions.onComplete(cardInfo,1);}}
else
{var cardInfo={cardid:pluginOptions.cardid};for(var i=0;i<listOfDivs.length;i++)
{var renderedCard=tmpl("cms_tpl_notfound",{"object":cardInfo,"options":_cmsCard_getRenderingOptions(pluginOptions,{})});var canvas=listOfDivs[i].canvasObj;canvas.html(renderedCard);canvas.show();}
if(pluginOptions&&pluginOptions.onComplete)
pluginOptions.onComplete(null,0);}}}
return this;};})(jQuery);(function($)
{$.widget('r3.gmenubar',{options:{},_create:function()
{this._itemsMap={};this._canvasDiv=$('<div></div>').addClass('canvas');var renderedHtml="";if(this.options.mainaction)
{renderedHtml=this._renderMainAction(this.options.mainaction);}
if(this.options.sections&&this.options.sections.length)
{for(var i=0;i<this.options.sections.length;i++)
{renderedHtml=renderedHtml+this._renderSection(this.options.sections[i]);}}
this._canvasDiv.html(renderedHtml);this.element.addClass('gmenubar');this.element.html(this._canvasDiv);this._bindEvents(this.options);},addItems2Section:function(aSectionId,anItemsArray)
{if(!anItemsArray||!anItemsArray.length)
return;var sect=this._findItem(aSectionId);if(!sect)
{console.error("gmenubar NO SECTION FOUND");return;}
else
{var renderedHtml=this._generateHtml4SectionItems(anItemsArray);$('#'+sect.id).append(renderedHtml);for(var j=0;j<anItemsArray.length;j++)
{var item=anItemsArray[j];if(!sect.items)
sect.items=[];sect.items.push(item);if(item.onClick)
this._bindItemEvent(item);}}},updateItemTitle:function(anItemId,anItemTitle)
{$('#'+anItemId+" span a").html(anItemTitle);},find:function(anItemId)
{var theItem=this._findItem(anItemId);return theItem;},select:function(anItemId)
{$('#'+this.element.attr('id')+' .canvasItem').removeClass('selected');this._deselectAll();var theItem=this._findItem(anItemId);if(theItem)
{theItem.selected=true;$("#"+this.element.attr("id")+" .canvasItem div[id='"+theItem.id+"']").parent().addClass('selected');}},remove:function(anItemId)
{$('#'+anItemId).parent().remove();this._removeItem(anItemId);},destroy:function()
{this._canvasDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);},_renderMainAction:function(cfgHash)
{var html="<div class='canvas-section'>"+"<div class='main-action'>"+"<button id='"+cfgHash.id+"' class='btn btn-primary start' type='button' >"+"<span>"+cfgHash.title+"</span>"+"</button>"+"</div>"+"</div>";return html;},_renderSection:function(cfgHash)
{var renderHtml="";renderHtml="<div class='canvas-section' id='"+cfgHash.id+"'>";renderHtml=renderHtml+this._generateHtml4SectionItems(cfgHash.items);renderHtml+="</div>";if(cfgHash.bottom_border)
renderHtml+="<hr />";return renderHtml;},_generateHtml4SectionItems:function(items2Add)
{var theHtml="";if(items2Add&&items2Add.length)
{for(var j=0;j<items2Add.length;j++)
{var itemClassName="";if(items2Add[j].selected)
itemClassName="selected";if(items2Add[j].customCSSClassName)
itemClassName=itemClassName+" "+items2Add[j].customCSSClassName;theHtml+="<div class='canvasItem "+itemClassName+" cf'><div class='item' id="+items2Add[j].id+"><span><a href='javascript:void(0)'>"+items2Add[j].title+"</a></span></div>";if(items2Add[j].deletable)
{theHtml+="<div class='item-action' id='item_action_"+items2Add[j].id+"'>&nbsp;</div>";}
theHtml+="</div>";}}
return theHtml;},_bindEvents:function(anHash)
{if(this.options.mainaction&&this.options.mainaction.onClick)
{this._bindMainActionEvent(this.options.mainaction);}
if(this.options.sections&&this.options.sections.length)
{for(var i=0;i<this.options.sections.length;i++)
{var curSection=this.options.sections[i];if(curSection.items&&curSection.items.length)
{for(var j=0;j<curSection.items.length;j++)
{var item=curSection.items[j];if(item.onClick)
this._bindItemEvent(item);}}}}},_bindMainActionEvent:function(cfgItem)
{var _self=this;$('#'+cfgItem.id).unbind(".gmenubar").bind('click.gmenubar',function(e){_self._onMainActionClick(cfgItem.id);});},_bindItemEvent:function(cfgItem)
{var _self=this;$('#'+cfgItem.id).unbind(".gmenubar").bind('click.gmenubar',function(e){_self._onItemClick(cfgItem.id);});if(cfgItem.deletable)
{console.info("Action: ",$('#item_action_'+cfgItem.id));$('#item_action_'+cfgItem.id).unbind(".gmenubar").bind('click.gmenubar',function(e){_self._onDeleteItemClick(cfgItem.id);});}},_onMainActionClick:function(aMainActionId)
{console.info("_onMainActionClick "+aMainActionId);var eventItem=this._findItem(aMainActionId);if(eventItem.onClick)
eventItem.onClick(eventItem);},_onItemClick:function(anItemId)
{console.info("_onItemClick "+anItemId);var eventItem=this._findItem(anItemId);if(eventItem.onClick)
eventItem.onClick(eventItem);},_onDeleteItemClick:function(anItemId)
{console.info("r3_gmenubar _onItemClick "+anItemId);var eventItem=this._findItem(anItemId);if(eventItem.onClick)
eventItem.onClick(eventItem,'delete');},_deselectAll:function()
{var visitor={processMainAction:function(aMainAction)
{aMainAction.selected=false;return true;},processItem:function(anItem)
{anItem.selected=false;return true;},processSection:function(anItem)
{return true;}};this._visit(visitor);},_removeItem:function(anItemId)
{var foundItem=null;var foundItemNdx=-1;var section=null;var visitor={processMainAction:function(aMainAction)
{if(aMainAction.id==anItemId)
{foundItem=aMainAction;return false;}
return true;},processItem:function(anItem,ndxOfItem)
{if(anItem.id==anItemId)
{foundItem=anItem;foundItemNdx=ndxOfItem;return false;}
return true;},processSection:function(anItem)
{section=anItem;return true;}};this._visit(visitor);if(foundItem)
{if(section&&section.items.length)
{var res=section.items.splice(foundItemNdx,foundItemNdx+1);console.info("gmenubar::removing element from items at "+foundItemNdx,section.items,res);}}
return foundItem;},_findItem:function(anItemId)
{var foundItem=null;var visitor={processMainAction:function(aMainAction)
{if(aMainAction.id==anItemId)
{foundItem=aMainAction;return false;}
return true;},processSection:function(anItem)
{if(anItem.id==anItemId)
{foundItem=anItem;return false;}
return true;},processItem:function(anItem)
{if(anItem.id==anItemId)
{foundItem=anItem;return false;}
return true;}};this._visit(visitor);return foundItem;},_visit:function(aVisitor)
{var keepOn=true;if(this.options.mainaction)
{keepOn=aVisitor.processMainAction(this.options.mainaction);if(!keepOn)
return keepOn;}
if(this.options.sections&&this.options.sections.length)
{for(var i=0;i<this.options.sections.length;i++)
{var curSection=this.options.sections[i];keepOn=aVisitor.processSection(curSection);if(!keepOn)
return keepOn;if(curSection.items&&curSection.items.length)
{for(var j=0;j<curSection.items.length;j++)
{var item=curSection.items[j];keepOn=aVisitor.processItem(item,j);if(!keepOn)
return keepOn;}}}}
return true;}});})(jQuery);(function($)
{$.widget('r3.gsidebar',{options:{},_create:function()
{this._itemsMap={};this._canvasDiv=$('<section></section>').addClass('sidebar');if(this.options.csshoverenabled)
this._canvasDiv.addClass('csshoverenabled');var renderedHtml="<ul class='sidebar-menu' id='gsidebar-menu'>";if(this.options.sections&&this.options.sections.length)
{for(var i=0;i<this.options.sections.length;i++)
{if(this.options.sections[i].grouped)
renderedHtml=renderedHtml+this._renderGroupedSection(this.options.sections[i]);else renderedHtml=renderedHtml+this._renderLinearSection(this.options.sections[i]);}}
renderedHtml=renderedHtml+"</ul>";this._canvasDiv.html(renderedHtml);this.element.html(this._canvasDiv);this._bindEvents(this.options);},addItems2Section:function(aSectionId,anItemsArray)
{if(!anItemsArray||!anItemsArray.length)
return;var sect=this._findItem(aSectionId);if(!sect)
{console.error("gsidebar NO SECTION FOUND");return;}
else
{var renderedHtml=this._generateHtml4NestedSectionItems(anItemsArray);$('#'+sect.id+" ul").append(renderedHtml);for(var j=0;j<anItemsArray.length;j++)
{var item=anItemsArray[j];if(!sect.items)
sect.items=[];sect.items.push(item);if(item.onClick)
this._bindItemEvent(item);}
$('#'+sect.id).removeClass('empty');}},updateItemTitle:function(anItemId,anItemTitle)
{$('#'+anItemId+" span").html(anItemTitle);},find:function(anItemId)
{var theItem=this._findItem(anItemId);return theItem;},select:function(anItemId)
{$('#'+this.element.attr('id')+' li').removeClass('active');this._deselectAll();var theItem=this._findItem(anItemId);if(theItem)
{theItem.selected=true;$("#"+this.element.attr("id")+" li[id='"+theItem.id+"']").addClass('active');}},remove:function(anItemId)
{$('#'+anItemId).remove();this._removeItem(anItemId);},destroy:function()
{this._canvasDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);},_renderLinearSection:function(cfgHash)
{var html="";if(cfgHash.items&&cfgHash.items.length)
{for(var j=0;j<cfgHash.items.length;j++)
{var item=cfgHash.items[j];html=html+"<li style='overflow: hidden;' id='"+item.id+"'>"+"<a href='javascript:void(0)'>";var theIcon='';if(item.icon)
{theIcon='fa-'+item.icon;}
html=html+"<i class='fa "+theIcon+"'></i>";html=html+"<span>"+item.title+"</span>";html=html+"</a>"+"</li>";}}
return html;},_renderGroupedSection:function(cfgHash)
{var renderHtml="";renderHtml=renderHtml+"<li id='"+cfgHash.id+"'";var sectionStyle='treeview';if(!cfgHash.items||!cfgHash.items.length)
{sectionStyle=sectionStyle+" empty";}
renderHtml=renderHtml+" class='"+sectionStyle+"' ";renderHtml=renderHtml+">";renderHtml=renderHtml+"<a href='javascript:void(0)'>";var theIcon='';if(cfgHash.icon)
{theIcon='fa-'+cfgHash.icon;}
renderHtml=renderHtml+"<i class='fa "+theIcon+" '></i>";renderHtml=renderHtml+"<span >"+cfgHash.title+"</span>";renderHtml=renderHtml+"<i class='fa fa-angle-left pull-right'></i>";renderHtml=renderHtml+"</a>";renderHtml=renderHtml+"<ul class='treeview-menu'>";renderHtml=renderHtml+this._generateHtml4NestedSectionItems(cfgHash.items);renderHtml=renderHtml+"</ul>";renderHtml=renderHtml+"</li>";return renderHtml;},_generateHtml4NestedSectionItems:function(items2Add)
{var theHtml="";if(items2Add&&items2Add.length)
{for(var j=0;j<items2Add.length;j++)
{theHtml+="<li style='overflow: hidden;' id='"+items2Add[j].id+"'><a href='javascript:void(0)'><i class='fa fa-chevron-right  '></i><span>"+items2Add[j].title+"</span></a></li>";}}
return theHtml;},_bindEvents:function(anHash)
{if(this.options.sections&&this.options.sections.length)
{for(var i=0;i<this.options.sections.length;i++)
{var curSection=this.options.sections[i];if(curSection.items&&curSection.items.length)
{for(var j=0;j<curSection.items.length;j++)
{var item=curSection.items[j];if(item.onClick)
this._bindItemEvent(item);}}}}},_bindItemEvent:function(cfgItem)
{var _self=this;$('#'+cfgItem.id).unbind(".gsidebar").bind('click.gsidebar',function(e){_self._onItemClick(cfgItem.id);});},_onMainActionClick:function(aMainActionId)
{console.info("_onMainActionClick "+aMainActionId);var eventItem=this._findItem(aMainActionId);if(eventItem.onClick)
eventItem.onClick(eventItem);},_onItemClick:function(anItemId)
{console.info("_onItemClick "+anItemId);var eventItem=this._findItem(anItemId);if(eventItem.onClick)
eventItem.onClick(eventItem);},_onDeleteItemClick:function(anItemId)
{console.info("r3_gsidebar _onItemClick "+anItemId);var eventItem=this._findItem(anItemId);if(eventItem.onClick)
eventItem.onClick(eventItem,'delete');},_deselectAll:function()
{var visitor={processMainAction:function(aMainAction)
{aMainAction.selected=false;return true;},processItem:function(anItem)
{anItem.selected=false;return true;},processSection:function(anItem)
{return true;}};this._visit(visitor);},_removeItem:function(anItemId)
{var foundItem=null;var foundItemNdx=-1;var section=null;var visitor={processMainAction:function(aMainAction)
{if(aMainAction.id==anItemId)
{foundItem=aMainAction;return false;}
return true;},processItem:function(anItem,ndxOfItem)
{if(anItem.id==anItemId)
{foundItem=anItem;foundItemNdx=ndxOfItem;return false;}
return true;},processSection:function(anItem)
{section=anItem;return true;}};this._visit(visitor);if(foundItem)
{if(section&&section.items.length)
{var res=section.items.splice(foundItemNdx,foundItemNdx+1);console.info("gsidebar::removing element from items at "+foundItemNdx,section.items,res);}}
return foundItem;},_findItem:function(anItemId)
{var foundItem=null;var visitor={processMainAction:function(aMainAction)
{if(aMainAction.id==anItemId)
{foundItem=aMainAction;return false;}
return true;},processSection:function(anItem)
{if(anItem.id==anItemId)
{foundItem=anItem;return false;}
return true;},processItem:function(anItem)
{if(anItem.id==anItemId)
{foundItem=anItem;return false;}
return true;}};this._visit(visitor);return foundItem;},_visit:function(aVisitor)
{var keepOn=true;if(this.options.mainaction)
{keepOn=aVisitor.processMainAction(this.options.mainaction);if(!keepOn)
return keepOn;}
if(this.options.sections&&this.options.sections.length)
{for(var i=0;i<this.options.sections.length;i++)
{var curSection=this.options.sections[i];keepOn=aVisitor.processSection(curSection);if(!keepOn)
return keepOn;if(curSection.items&&curSection.items.length)
{for(var j=0;j<curSection.items.length;j++)
{var item=curSection.items[j];keepOn=aVisitor.processItem(item,j);if(!keepOn)
return keepOn;}}}}
return true;}});})(jQuery);(function($)
{$.widget('r3.gmultiselect',{options:{},_create:function()
{this._itemsMap={};this._canvasDiv=$('<div></div>');var renderedHtml=this._renderHtml(this.options);this._canvasDiv.html(renderedHtml);this.element.addClass('gmultiselect');this.element.html(this._canvasDiv);this._initializeMultiSelectWidget(this.options.lutUrl,this.options.selectedValue);this._bindEvents(this.options);},destroy:function()
{this._canvasDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);},clear:function()
{this._deselectAll();},disabled:function(aDisabledFlag)
{if(arguments.length==0)
return this.disabledFlag;this.disabledFlag=aDisabledFlag;if(aDisabledFlag)
{this._deselectAll();}
this._getButton('add').prop('disabled',aDisabledFlag);this._getButton('add_all').prop('disabled',aDisabledFlag);this._getButton('remove').prop('disabled',aDisabledFlag);this._getButton('remove_all').prop('disabled',aDisabledFlag);this._getAvailableSelect().prop('disabled',aDisabledFlag);this._getSelectedSelect().prop('disabled',aDisabledFlag);},_renderHtml:function(cfgHash)
{var buttonBarWidth='';if(cfgHash.buttonBarWidth)
{buttonBarWidth="width: "+cfgHash.buttonBarWidth;}
var idPrefix=this.element.attr('id');var html="<input type='hidden' name='"+cfgHash.fieldName+"' id='"+idPrefix+"_"+cfgHash.fieldName+"' />";html=html+"<div class='form-inline'>";html=html+"<select multiple='multiple' class='form-control' name='available_"+cfgHash.fieldName+"' size='7' id='"+idPrefix+"_available_"+cfgHash.fieldName+"' ></select>"+"";html=html+"<div class='actions'>"+"<div>"+"<button id='"+idPrefix+"_action_add_all'    class='btn btn-default'><span class='glyphicon glyphicon-fast-forward' aria-hidden='true'></span></button>"+"<button id='"+idPrefix+"_action_add'        class='btn btn-default'><span class='glyphicon glyphicon-forward' aria-hidden='true'></span></button>"+"<button id='"+idPrefix+"_action_remove'     class='btn btn-default'><span class='glyphicon glyphicon-backward' aria-hidden='true'></span></button>"+"<button id='"+idPrefix+"_action_remove_all' class='btn btn-default'><span class='glyphicon glyphicon-fast-backward' aria-hidden='true'></span></button>"+"</div>"+"</div>";html=html+"<select multiple='multiple' class='form-control' name='selected_"+cfgHash.fieldName+"' size='7' id='"+idPrefix+"_selected_"+cfgHash.fieldName+"'></select>"+"";html=html+"</div>";return html;},_bindEvents:function(anHash)
{this._getButton('add').unbind().click($.r3Utils.hitch(this,this._onAddClick));this._getButton('add_all').unbind().click($.r3Utils.hitch(this,this._onAddAllClick));this._getButton('remove').unbind().click($.r3Utils.hitch(this,this._onRemoveClick));this._getButton('remove_all').unbind().click($.r3Utils.hitch(this,this._onRemoveAllClick));this._getAvailableSelect().unbind().dblclick($.r3Utils.hitch(this,function(e){this._select($(e.currentTarget).val());}));this._getSelectedSelect().unbind().dblclick($.r3Utils.hitch(this,function(e){this._deselect($(e.currentTarget).val());}));},_initializeMultiSelectWidget:function(lutUrl,selectedValue)
{$.ajax({"type":'GET',"url":lutUrl,"dataType":"json","success":$.r3Utils.hitch(this,function(theLUT)
{var theModel=[];var selectedValueArray=selectedValue&&selectedValue.length>0&&selectedValue.split(',');if(theLUT.aaData&&theLUT.aaData.length>0)
{$.each(theLUT.aaData,function(index,item)
{var selected=false;if(selectedValueArray&&selectedValueArray.length>0&&selectedValueArray.indexOf(item.dtokey)>=0)
{selected=true;}
theModel.push({"dtokey":item.dtokey,"dtodescr":item.dtodescr,"selected":selected});});}
this.multiSelectWidgetModel=theModel;this._updateUI(theModel);}),"error":function(jqXHR,timeout,message)
{console.error("gmultiselect: ",message);}});},_updateUI:function(theModel)
{var available_select=this._getAvailableSelect();var selected_select=this._getSelectedSelect();var available_select_options=available_select.prop('options');var selected_select_options=selected_select.prop('options');available_select_options.length=0;selected_select_options.length=0;for(var i=0;i<theModel.length;i++)
{var opt=new Option(theModel[i].dtodescr,theModel[i].dtokey,false,false);if(theModel[i].selected)
{selected_select_options[selected_select_options.length]=opt;}
else
available_select_options[available_select_options.length]=opt;}
this._getField().val(this._getSelectedItemsAsCSV());},_getSelectedItems:function()
{var opts=this._getSelectedSelect().prop('options');if(!opts||opts.length==0)
return null;var returningItems=[];for(var i=0;i<opts.length;i++)
{returningItems.push(opts[i].value);}
return returningItems;},_getSelectedItemsAsCSV:function()
{var opts=this._getSelectedSelect().prop('options');if(!opts||opts.length==0)
return'';var returningItems='';for(var i=0;i<opts.length;i++)
{if(i>0)
returningItems=returningItems+',';returningItems=returningItems+opts[i].value;}
return returningItems;},_selectAll:function()
{for(var i=0;i<this.multiSelectWidgetModel.length;i++)
{var selected=true;this.multiSelectWidgetModel[i].selected=selected;}
this._updateUI(this.multiSelectWidgetModel);},_select:function(currentSelection)
{if(currentSelection)
{for(var i=0;i<this.multiSelectWidgetModel.length;i++)
{var selected=true;if(currentSelection.indexOf(this.multiSelectWidgetModel[i].dtokey)>=0)
this.multiSelectWidgetModel[i].selected=selected;}}
this._updateUI(this.multiSelectWidgetModel);},_deselectAll:function()
{for(var i=0;i<this.multiSelectWidgetModel.length;i++)
{var selected=false;this.multiSelectWidgetModel[i].selected=selected;this._updateUI(this.multiSelectWidgetModel);}},_deselect:function(currentSelection)
{if(currentSelection)
{for(var i=0;i<this.multiSelectWidgetModel.length;i++)
{var selected=false;if(currentSelection.indexOf(this.multiSelectWidgetModel[i].dtokey)>=0)
this.multiSelectWidgetModel[i].selected=selected;}
this._updateUI(this.multiSelectWidgetModel);}},_getField:function()
{var idPrefix=this.element.attr('id');var bt=$('#'+idPrefix+"_"+this.options.fieldName);return bt;},_getButton:function(buttonName)
{var idPrefix=this.element.attr('id');var bt=$('#'+idPrefix+'_action_'+buttonName);return bt;},_getAvailableSelect:function()
{var idPrefix=this.element.attr('id');var bt=$('#'+idPrefix+"_available_"+this.options.fieldName);return bt;},_getSelectedSelect:function()
{var idPrefix=this.element.attr('id');var bt=$('#'+idPrefix+"_selected_"+this.options.fieldName);return bt;},_onAddClick:function(e)
{console.info("onAddClick");this._select(this._getAvailableSelect().val());e.preventDefault();},_onAddAllClick:function(e)
{console.info("onAddAllClick");this._selectAll();e.preventDefault();},_onRemoveClick:function(e)
{console.info("onRemoveClick");this._deselect(this._getSelectedSelect().val());e.preventDefault();},_onRemoveAllClick:function(e)
{console.info("onRemoveAllClick");this._deselectAll();e.preventDefault();}});})(jQuery);(function($)
{$.widget('r3.gdatetime',{options:{},_create:function()
{this._itemsMap={};this._canvasDiv=$('<div></div>');this._canvasDiv.addClass('input-group').addClass('validation-error-anchor').addClass("bootstrap-timepicker");var renderedHtml=this._renderHtml(this.options);this._canvasDiv.html(renderedHtml);this.element.addClass('gdatetime');this.element.html(this._canvasDiv);var idPrefix=this.element.attr('id');$('#'+this._getDateFieldId(idPrefix)).datepicker({format:"dd/mm/yyyy"});$('#'+this._getTimeFieldId(idPrefix)).timepicker({showMeridian:false});},destroy:function()
{this._canvasDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);},clear:function()
{},getDateTime:function()
{var idPrefix=this.element.attr('id');var s=$('#'+this._getDateFieldId(idPrefix)).val();var s1='00:00';if(s&&s.length>0)
{if(this._isTimeFieldVisible(idPrefix))
s1=$('#'+this._getTimeFieldId(idPrefix)).val();}
else return null;return s+' '+s1;},_isTimeFieldVisible:function(idPrefix)
{return $('#'+this._getTimeFieldId(idPrefix)).is(":visible");},showtime:function()
{var idPrefix=this.element.attr('id');$('#'+this._getTimeFieldId(idPrefix)).show();$('#'+this._getTimeFieldId(idPrefix)).next().show();},hidetime:function()
{var idPrefix=this.element.attr('id');$('#'+this._getTimeFieldId(idPrefix)).hide();$('#'+this._getTimeFieldId(idPrefix)).next().hide();},_getDateFieldId:function(idPrefix)
{return idPrefix+'_date';},_getTimeFieldId:function(idPrefix)
{return idPrefix+'_time';},_renderHtml:function(cfgHash)
{var idPrefix=this.element.attr('id');var htmlDate="<input type='text' class='input-sm form-control r3_datepicker' name='"+cfgHash.name+"_date' id='"+this._getDateFieldId(idPrefix)+"'  />"+"<span class='input-group-addon'><i class='glyphicon glyphicon-calendar'></i></span>";var htmlTime="<input  type='text' class='input-sm form-control r3_timepicker' name='"+cfgHash.name+"_time' id='"+this._getTimeFieldId(idPrefix)+"'>"+"<span class='input-group-addon timepicker-addon'><i class='glyphicon glyphicon-time'></i></span>";return htmlDate+htmlTime;}});})(jQuery);(function($)
{$.widget('r3.picker',{options:{},_create:function()
{this.options=$.extend({multiple:true,fieldHeight:131,fieldWidth:'100%',fieldSize:5,disabled:false},this.options);var widgetHtml=this._buildHtml(this.options);this._picker=$(widgetHtml);this.element.html(this._picker);this._bindEvents(this.options);this.setVal(this.options.pickerValue);},addVal:function(pickerValue)
{if(this._isMultiSelection())
{this._addMultiSelectionValue(pickerValue);}
else
{this._setSingleSelectionValue(pickerValue);}},_addMultiSelectionValue:function(pickerValue)
{var valueField=this._getValueField();var currentVal=valueField.val();if(currentVal&&currentVal.indexOf(pickerValue.dtokey)>=0)
{console.info("Widget(Picker) - Item Already Present!");return;}
var displayField=this._getDisplayField();var displayFieldOptions=displayField.prop('options');if(pickerValue)
{var opt=new Option(pickerValue.dtodescr,pickerValue.dtokey,false,false);displayFieldOptions[displayFieldOptions.length]=opt;this._computeMultiSelectionValue();}},setVal:function(pickerValue)
{if(this._isMultiSelection())
{this._setMultiSelectionValue(pickerValue);}
else
{this._setSingleSelectionValue(pickerValue);}},_setMultiSelectionValue:function(pickerValue)
{var valueField=this._getValueField();var displayField=this._getDisplayField();var displayFieldOptions=displayField.prop('options');displayFieldOptions.length=0;if(pickerValue&&pickerValue.iTotalRecords&&pickerValue.aaData.length)
{for(var i=0;i<pickerValue.aaData.length;i++)
{var opt=new Option(pickerValue.aaData[i].dtodescr,pickerValue.aaData[i].dtokey,false,false);displayFieldOptions[displayFieldOptions.length]=opt;}
this._computeMultiSelectionValue();}
else
{valueField.val(null);}},_computeMultiSelectionValue:function()
{var v="";var displayFieldOptions=this._getDisplayField().prop('options');for(var j=0;j<displayFieldOptions.length;j++)
{if(j>0)
v=v+";";v=v+displayFieldOptions[j].value;}
this._getValueField().val(v);},_setSingleSelectionValue:function(pickerValue)
{var dtokey=null;var dtodescr=null;if(pickerValue)
{dtokey=pickerValue.dtokey;dtodescr=pickerValue.dtodescr;}
this._getValueField().val(dtokey);this._getDisplayField().val(dtodescr);},_isMultiSelection:function()
{return this.options.multiple;},_buildHtml:function(anHash)
{var html="<div>";html+="<input type='hidden' name='"+anHash.fieldName+"' id='"+anHash.fieldId+"' />";if(anHash.multiple)
{html+="<div class='form-inline'><div class='form-group' style='margin-left: 0px'>"+"<select name='"+anHash.fieldName+"_display' size='"+anHash.fieldSize+"' id='"+anHash.fieldId+"_display' style='height: "+anHash.fieldHeight+"px'></select></div>";html+="<div class='picker_actions' style='height: "+anHash.fieldHeight+"px'>"+"<button id='"+anHash.fieldId+"_action_set'    class='btn btn-default' ><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></button>"+"<button id='"+anHash.fieldId+"_action_clear'  class='btn btn-default' ><span class='glyphicon glyphicon-minus' aria-hidden='true'></span></button>"+"</div>"+"</div></div>";}
else
{html+="<div class='form-group row'>"+"<div class='col-md-9 col-sm-10' style='padding-right: 0'>"+"<input type='text' class='form-control ' style='display: inline-block; width: "+anHash.fieldWidth+"' name='"+anHash.fieldName+"_display' id='"+anHash.fieldId+"_display' readonly='readonly'  />"+"</div>";html+="<div class='col-md-3 col-sm-2' style='padding: 0'>"+"<button id='"+anHash.fieldId+"_action_set'   class='btn btn-default' style='margin-left: 5px' ><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></button>"+"<button id='"+anHash.fieldId+"_action_clear' class='btn btn-default' style='margin-left: 5px' ><span class='glyphicon glyphicon-minus' aria-hidden='true'></span></button>"+"</div></div>";}
html+="</div>";return html;},_getValueField:function()
{var f=null;f=$('#'+this.options.fieldId);return f;},_getDisplayField:function()
{var f=$('#'+this.options.fieldId+'_display');return f;},_getSetButton:function()
{var bt=$('#'+this.options.fieldId+'_action_set');console.info("Bt...",bt);return bt;},_getClearButton:function()
{return $('#'+this.options.fieldId+'_action_clear');},_bindEvents:function(anHash)
{var b=this._getSetButton();b.unbind().click($.r3Utils.hitch(this,this._openPicker));b.prop("disabled",(typeof anHash.disabled==="undefined")?false:anHash.disabled);var b=this._getClearButton();b.unbind().click($.r3Utils.hitch(this,this._clearSelection));b.prop("disabled",(typeof anHash.disabled==="undefined")?false:anHash.disabled);},_openPicker:function(event)
{console.info("Open Picker Called");if(this.options.openPicker)
this.options.openPicker(this);event.preventDefault();},_clearSelection:function(event)
{console.info("Clear Selection Called");if(this._isMultiSelection())
{this._clearMultiSelectionValue(event);}
else this.setVal();event.preventDefault();},_clearMultiSelectionValue:function(event)
{var displayField=this._getDisplayField();var selectedIndex=displayField.prop('selectedIndex');if(selectedIndex<0)
console.info("Select an item please");else
{displayField.find('option:selected').remove();}
this._computeMultiSelectionValue();},destroy:function()
{this._widgetContainer.remove();$.Widget.prototype.destroy.apply(this,arguments);}});})(jQuery);(function($)
{$.fn.loadImage1=function(anOptionHash)
{if(this.length==0)
return this;var _self=this;var defaults={canvas:true};var r3LoadImageOptions=$.extend({},defaults,anOptionHash);var result=this.find('#result'),actionsNode=this.find('#actions'),coordinates=null,exifInfo=null;$('#r3_img_cropcanvas_commit').on('click',function(event){event.preventDefault();var img=result.find('img, canvas')[0];if(img&&coordinates){var img_or_canvas=loadImage.scale(img,{left:coordinates.x,top:coordinates.y,sourceWidth:coordinates.w,sourceHeight:coordinates.h,maxWidth:r3LoadImageOptions.maxSize[0],maxHeight:r3LoadImageOptions.maxSize[1]});coordinates=null;_self.modal('hide');if(r3LoadImageOptions.processImage)
{r3LoadImageOptions.processImage(img_or_canvas,exifInfo&&exifInfo.getAll());}}});var startEditing=function()
{var imgNode=result.find('img, canvas'),img=imgNode[0];var imgAspectRatio=img.width/img.height;var percentage=0.85;var startSelection,x=0,y=0;if(r3LoadImageOptions.aspectRatio)
{if(imgAspectRatio>=r3LoadImageOptions.aspectRatio)
{y=img.height;x=img.height*r3LoadImageOptions.aspectRatio;x=Math.floor(x*percentage);y=Math.floor(y*percentage);}
else
{x=img.width;y=img.width/r3LoadImageOptions.aspectRatio;x=Math.floor(x*percentage);y=Math.floor(y*percentage);}
var sx=Math.floor((img.width-x)/2);var sy=Math.floor((img.height-y)/2);startSelection=[sx,sy,sx+x,sy+y];}
else
{startSelection=[40,40,img.width-40,img.height-40];}
imgNode.Jcrop({aspectRatio:r3LoadImageOptions.aspectRatio,boxWidth:result.width(),boxHeight:result.width(),setSelect:startSelection,onSelect:function(coords){coordinates=coords;},onRelease:function(){coordinates=null;}});};var replaceResults=function(img)
{if(!(img.src||img instanceof HTMLCanvasElement)){content=$('<span>Loading image file failed</span>');}else{content=$('<a  target="_blank">').append(img).attr('download',currentFile.name).attr('href',img.src||img.toDataURL());}
result.html(img);if(img.getContext){actionsNode.show();}
setTimeout(startEditing,500);};var displayImage=function(file,options1){currentFile=file;if(!loadImage(file,replaceResults,options1)){}};this.modal('show');loadImage.parseMetaData(r3LoadImageOptions.file,function(data){var anOptionHash={canvas:true};if(data.exif){anOptionHash.orientation=data.exif.get('Orientation');exifInfo=data.exif;}
displayImage(r3LoadImageOptions.file,anOptionHash);});return this;};})(jQuery);$.r3Utils.namespace("org.r3.widget.miller");org.r3.widget.miller.message={"nodeCaption":"Node","noMoreLevels":"You have reached the maximum depth configured","moveNotAllowed":"Operation not allowed: a node cannot be made child of a child or dropped in invalid context"};org.r3.widget.miller.TreeNode=Class.extend({init:function(aNodeId,aNodeText,aNodeUserData)
{this.nodeId=aNodeId;this.nodeText=aNodeText;this.nodeUserData=aNodeUserData;this.hasBeenFetched=false;this.children=[];},addChild:function(aNode,atPosition)
{if(!atPosition||atPosition<0||atPosition>=this.children.length)
this.children.push(aNode);else this.children.splice(atPosition,0,aNode);},getNumberOfChildren:function()
{return this.children.length;},removeChild:function(aNodeId)
{var ndxOfItem=this.indexOfById(aNodeId);if(ndxOfItem>=0)
{this.children.splice(ndxOfItem,1);return true;}
return false;},moveChild:function(aNodeId,toPosition)
{var ndxOfItem=this.indexOfById(aNodeId);if(ndxOfItem>=0&&toPosition!=ndxOfItem)
{this.children.splice(toPosition,0,this.children.splice(ndxOfItem,1)[0]);return true;}
return false;},indexOfById:function(aNodeId)
{var ndx=-1;var visitor={visit:function(aNode,parentNode,indexOfNode)
{if(aNode.nodeId==aNodeId)
{ndx=indexOfNode;return false;}
return true;}};this.visit(visitor,null,0,false);return ndx;},findNode:function(aNodeId)
{console.log("I'm Looking for node: "+aNodeId);var theNodeInfo=null;var visitor={visit:function(aNode,parentNode,indexOfNode)
{if(aNode.nodeId==aNodeId)
{console.log("Visitor Visit Result: ["+indexOfNode+"] "+aNode.nodeId+" under parent: "+((parentNode)?parentNode.nodeId:" ND "));theNodeInfo={"node":aNode,"parent":parentNode,"pos":indexOfNode};return false;}
return true;}};this.visit(visitor,null,0,true);console.log("Returning node: "+theNodeInfo.node);return theNodeInfo;},visit:function(aVisitor,parentNode,positionOfNode,recurseFlag)
{if(!aVisitor.visit(this,parentNode,positionOfNode))
return false;for(var i=0;i<this.getNumberOfChildren();i++)
{if(recurseFlag)
{if(!this.children[i].visit(aVisitor,this,i,recurseFlag))
return false;}
else
{if(!aVisitor.visit(this.children[i],this,i))
return false;}}
return true;}});(function($)
{$.widget('r3.gmiller',{options:{},defaults:{numberOfColumns:3,maxNumberOfLevels:5,rootNodeId:'MILLER_ID',rootNodeName:'MILLER_NAME',nodeMove:true},_create:function()
{var widgetOptions=this.options=$.extend({},this.defaults,this.options);this._rootNode=new org.r3.widget.miller.TreeNode(widgetOptions.rootNodeId,widgetOptions.rootNodeName,{});this._treeConfig=[];this._uiInfo=[];this._sequenceCounter=200;this._dragStep='none';this._dragTarget=null;var widgetId=this.element.attr('id');this._adjustOptions(widgetOptions);for(var i=0;i<widgetOptions.maxNumberOfLevels;i++)
{var treeConfigItem=null;if(widgetOptions.treeConfig&&widgetOptions.treeConfig.length)
{if(widgetOptions.treeConfig.length>i)
treeConfigItem=widgetOptions.treeConfig[i];else treeConfigItem=widgetOptions.treeConfig[widgetOptions.treeConfig.length-1];}
else
{treeConfigItem={};}
if(i==0)
treeConfigItem.refNodeId=this._rootNode.nodeId;this._treeConfig.push(treeConfigItem);}
this._uiSlidingWindowOffset=0;for(var i=0;i<widgetOptions.numberOfColumns;i++)
{var columnConfig={containerId:this._getContainerIdByIndex(widgetId,i),containerObj:null,selectedItem:null,buttons:[]};this._uiInfo.push(columnConfig);}
this._initializeCanvas(widgetId,widgetOptions);this._bindEvents(widgetId);this._populateCanvas(0);},_adjustOptions:function(cfgHash)
{if(cfgHash.numberOfColumns>cfgHash.maxNumberOfLevels)
{cfgHash.numberOfColumns=cfgHash.maxNumberOfLevels;}},add:function(sortableContainerId,aParentNodeId,anItem)
{console.log("An Item in add is: ",anItem);var newNode=new org.r3.widget.miller.TreeNode(anItem.getNodeId(),anItem.getNodeLabel(),anItem);var sortableContainerIndex=this._getContainerIndexById(sortableContainerId);var refTreeNode=this._getReferenceTreeNode(sortableContainerIndex);refTreeNode.addChild(newNode);var htmlItem=this.options.renderHtml4NewNode(anItem);var cnt=this._getContainerObjByIndex(sortableContainerIndex);cnt.append(htmlItem);},remove:function(sortableContainerId,aParentNodeId,anItemId)
{console.log("An Item in add is: ",anItemId);var sortableContainerIndex=this._getContainerIndexById(sortableContainerId);var refTreeNode=this._getReferenceTreeNode(sortableContainerIndex);refTreeNode.removeChild(anItemId);var treeNodeConfigIndex=sortableContainerIndex+this._uiSlidingWindowOffset+1;this._clearConfigTreeNodeReferenceTreeNode(treeNodeConfigIndex);this._populateCanvas(sortableContainerIndex);},refresh:function(sortableContainerId,aNode)
{var treeNode=this._rootNode.findNode(aNode.getNodeId());if(treeNode)
{treeNode.node.nodeText=aNode.getNodeLabel();treeNode.node.nodeUserData=aNode;}
var sortableContainerIndex=this._getContainerIndexById(sortableContainerId);this._populateCanvas(sortableContainerIndex);},destroy:function()
{this._canvasDiv.remove();$.Widget.prototype.destroy.apply(this,arguments);},_bindEvents:function(widgetId)
{var ulSelector="#"+widgetId+" .gmiller_column ul";var liSelector=ulSelector+" li";var sortableConfig={change:$.r3Utils.hitch(this,this._onSortableChange),over:$.r3Utils.hitch(this,this._onSortableOver),out:$.r3Utils.hitch(this,this._onSortableOut),stop:$.r3Utils.hitch(this,this._onSortableStop),receive:$.r3Utils.hitch(this,this._onSortableReceive),beforeStop:$.r3Utils.hitch(this,this._onSortableBeforeStop),start:$.r3Utils.hitch(this,this._onSortableStart)};if(this.options.nodeMove)
sortableConfig.connectWith=ulSelector;this.element.find("ul").sortable(sortableConfig);$(document).off('click',liSelector).on("click",liSelector,$.r3Utils.hitch(this,function(e)
{var currentTarget=$(e.currentTarget);var containerNodeId=currentTarget.parent().attr('id');var sortableContainerIndex=this._getContainerIndexById(containerNodeId);var currentTreeNodeConfigIndex=this._getConfigTreeNodeIndexBySortableContainerIndex(sortableContainerIndex);var selectedContainerIndex=sortableContainerIndex;var selectedNodeId=currentTarget.attr('id');var selectedNodePosition=currentTarget.index();var parentNodeId=this._treeConfig[currentTreeNodeConfigIndex].refNodeId;if(currentTreeNodeConfigIndex==(this._treeConfig.length-1))
{console.error("Terminati i livelli di selezione");this._updateSelectionHint(currentTarget);this._enableDisableButtons_onSelection(sortableContainerIndex,true);alert(org.r3.widget.miller.message.noMoreLevels);}
else
{var firstSortableContainer2Populate=sortableContainerIndex+1;if(sortableContainerIndex==(this._uiInfo.length-1))
{this._shiftRightSortableContainerView();firstSortableContainer2Populate=0;selectedContainerIndex--;containerNodeId=this._getContainerIdByIndex(this.element.attr('id'),selectedContainerIndex);$("#"+widgetId+" .gmiller_backseparator > div").show();}
else
{this._updateSelectionHint(currentTarget);this._enableDisableButtons_onSelection(sortableContainerIndex,true);}
var treeNodeConfigIndex=currentTreeNodeConfigIndex+1;this._clearConfigTreeNodeReferenceTreeNode(treeNodeConfigIndex);var treeNodeConfig=this._treeConfig[treeNodeConfigIndex];treeNodeConfig.refNodeId=currentTarget.attr('id');this._populateCanvas(firstSortableContainer2Populate);}
this._markContainerAsActiveByContainerId(containerNodeId);if(this.options.onSelect)
{this.options.onSelect(this._getContainerIdByIndex(this.element.attr('id'),selectedContainerIndex),parentNodeId,selectedNodeId,selectedNodePosition,this._rootNode.findNode(selectedNodeId));}}));var backButtonSelector="#"+widgetId+" .gmiller_backseparator > div";$(document).off('click',backButtonSelector).on("click",backButtonSelector,$.r3Utils.hitch(this,function(e)
{var sortableContainerIndex=-1;var aContainer=$('.gmiller_container.active')
if(aContainer)
{sortableContainerIndex=this._getContainerIndexById(aContainer.attr('id'));if(sortableContainerIndex<(this._uiInfo.length-1))
{sortableContainerIndex++;var containerNodeId=this._getContainerIdByIndex(this.element.attr('id'),sortableContainerIndex);this._markContainerAsActiveByContainerId(containerNodeId);}
else
{aContainer=$(aContainer[0]).removeClass('active');if(this.options.onClearActiveContainer)
{this.options.onClearActiveContainer();}}}
this._shiftLeftSortableContainerView();if(this._uiSlidingWindowOffset==0)
$(backButtonSelector).hide();this._populateCanvas(0);}));if(this.options.buttons)
{for(var k=0;k<this._uiInfo.length;k++)
{for(var j=0;j<this.options.buttons.length;j++)
{if(this.options.buttons[j].showOn=='all'||(this.options.buttons[j].showOn=='first'&&k==0))
{var buttonId=this._getRenderedButtonId(this.element.attr('id'),this.options.buttons[j].id,k);var buttonObj=$('#'+buttonId).button();buttonObj.click($.r3Utils.hitch(this,this._onClickActionBarButton));if(this.options.buttons[j].enabled!='always')
buttonObj.hide();var buttonConfig={"enabled":this.options.buttons[j].enabled,"id":buttonId,"buttonObj":buttonObj,onClick:this.options.buttons[j].onClick};this._uiInfo[k].buttons.push(buttonConfig);}}}}},_onClickActionBarButton:function(e)
{e.preventDefault();var currentTarget=$(e.currentTarget);var buttonId=currentTarget.attr('id');var sortableContainerIndex=this._getSortableContainerIndexByButtonId(buttonId);var bc=this._getButtonConfigByButtonId(this._uiInfo[sortableContainerIndex].buttons,buttonId);if(bc.onClick)
{var sortableContainerId=this._getContainerIdByIndex(this.element.attr("id"),sortableContainerIndex);var treeConfig=this._getConfigTreeNodeBySortableContainerIndex(sortableContainerIndex);var selectedNodeId=null;var selectdNodeQuery=$('#'+sortableContainerId+" li.selected");if(selectdNodeQuery.length>0)
{selectedNodeId=$(selectdNodeQuery[0]).attr("id");}
bc.onClick(sortableContainerId,treeConfig.refNodeId,selectedNodeId);this._markContainerAsActiveByContainerId(sortableContainerId);}},_markContainerAsActiveByContainerId:function(aSortableContainerId)
{$('.gmiller_container').removeClass('active');if(aSortableContainerId)
$('#'+aSortableContainerId).addClass('active');},_initializeCanvas:function(widgetId,cfgHash)
{var html="";var divWidth=Math.floor(12/cfgHash.numberOfColumns);for(var i=0;i<cfgHash.numberOfColumns;i++)
{html+="<div class='col-md-"+divWidth+"'>";if(i>0)
{html+="<div class='gmiller_separator' >";html+="<div class='gmiller_separator_symbol' ></div>";html+="</div>";}
else
{html+="<div class='gmiller_separator gmiller_backseparator' >";html+="<div style='display: none'><span></span></div>";html+="</div>";}
html+="<div class='gmiller_column' >";html+="<div class='gmiller_column_header clearfix'>";html+="<div class='gmiller_actionbar_caption gmiller_actionbar_caption_"+i+"'>";html+="<span class='nodelabel'>"+org.r3.widget.miller.message.nodeCaption+"</span>";html+="<span class='nodeid'></span>";html+="<span class='nodetext'></span>";html+="</div>";if(cfgHash.buttons)
{html+="<div class='gmiller_buttonbar'>";for(var j=0;j<cfgHash.buttons.length;j++)
{if(cfgHash.buttons[j].showOn=='all'||(cfgHash.buttons[j].showOn=='first'&&i==0))
{html+="<button class='btn btn-default' id='"+this._getRenderedButtonId(widgetId,cfgHash.buttons[j].id,i)+"'  >"+cfgHash.buttons[j].caption+"</button>";}}
html+="</div>";}
html+="</div>";html+="<ul class='gmiller_container' id='"+this._getContainerIdByIndex(widgetId,i)+"'></ul>";html+="</div>";html+="</div>";}
this.element.addClass('gmiller');this.element.html(html);for(var i=0;i<cfgHash.numberOfColumns;i++)
{this._uiInfo[i].nodeIdCaption=$(this._getNodeIdCaptionSelector(widgetId,i));this._uiInfo[i].nodeTextCaption=$(this._getNodeLabelCaptionSelector(widgetId,i));}},_clearConfigTreeNodeReferenceTreeNode:function(startingIndex)
{for(var i=startingIndex;i<this._treeConfig.length;i++)
{this._treeConfig[i].refNodeId=null;this._treeConfig[i].refNode=null;}},_getRenderedButtonId:function(aWidgetId,buttonOptionId,sortableContainerIndex)
{return aWidgetId+"_"+buttonOptionId+"_"+sortableContainerIndex;},_getSortableContainerIndexByButtonId:function(buttonId)
{var sortableContainerIndex=-1;if(buttonId)
{var ndx=buttonId.lastIndexOf("_");if(ndx>=0)
{sortableContainerIndex=parseInt(buttonId.substring(ndx+1));}}
return sortableContainerIndex;},_getButtonConfigByButtonId:function(sortableContainerButtonsArray,buttonId)
{for(var i=0;i<sortableContainerButtonsArray.length;i++)
{if(sortableContainerButtonsArray[i].id==buttonId)
{return sortableContainerButtonsArray[i];}}
return null;},_getNodeIdCaptionSelector:function(aWidgetId,sortableContainerIndex)
{return"#"+aWidgetId+" .gmiller_actionbar_caption_"+sortableContainerIndex+" .nodeid";},_getNodeLabelCaptionSelector:function(aWidgetId,sortableContainerIndex)
{return"#"+aWidgetId+" .gmiller_actionbar_caption_"+sortableContainerIndex+" .nodetext";},_getReferenceTreeNode:function(sortableContainerIndex)
{var configTreeNode=this._getConfigTreeNodeBySortableContainerIndex(sortableContainerIndex);var refTreeNode=configTreeNode.refNode;if(!refTreeNode)
{var nodeId=configTreeNode.refNodeId;if(nodeId)
{var nInfo=this._rootNode.findNode(nodeId);refTreeNode=(nInfo)?nInfo.node:null;configTreeNode.refNode=refTreeNode;}}
return refTreeNode;},_shiftRightSortableContainerView:function()
{this._uiSlidingWindowOffset++;},_shiftLeftSortableContainerView:function()
{if(this._uiSlidingWindowOffset>0)
this._uiSlidingWindowOffset--;},_getConfigTreeNodeIndexBySortableContainerIndex:function(sortableContainerIndex)
{var refPathIndex=this._uiSlidingWindowOffset+sortableContainerIndex;return refPathIndex;},_getConfigTreeNodeBySortableContainerIndex:function(sortableContainerIndex)
{var refPathIndex=this._uiSlidingWindowOffset+sortableContainerIndex;return this._treeConfig[refPathIndex];},_enableDisableButtons_onSettingRefTreeNode:function(aSortableContainerIndex,refTreeNodeFlag)
{for(var i=0;i<this._uiInfo[aSortableContainerIndex].buttons.length;i++)
{var b=this._uiInfo[aSortableContainerIndex].buttons[i].buttonObj;switch(this._uiInfo[aSortableContainerIndex].buttons[i].enabled)
{case'onRefNode':if(refTreeNodeFlag)
b.show();else b.hide();break;}}},_enableDisableButtons_onSelection:function(aSortableContainerIndex,selectionFlag)
{for(var i=0;i<this._uiInfo[aSortableContainerIndex].buttons.length;i++)
{var b=this._uiInfo[aSortableContainerIndex].buttons[i].buttonObj;switch(this._uiInfo[aSortableContainerIndex].buttons[i].enabled)
{case'onSelection':if(selectionFlag)
b.show();else b.hide();break;}}},_setSortableContainerCaption:function(aSortableContainerIndex,aNodeId,aNodeText)
{this._uiInfo[aSortableContainerIndex].nodeIdCaption.html(aNodeId);this._uiInfo[aSortableContainerIndex].nodeTextCaption.html(aNodeText);},_populateCanvas:function(startingIndex)
{if(startingIndex>(this._uiInfo.length-1))
return;var cnt=this._getContainerObjByIndex(startingIndex);cnt.empty();var configTreeNodeIndex=this._getConfigTreeNodeIndexBySortableContainerIndex(startingIndex);var configTreeNode=this._treeConfig[configTreeNodeIndex];var refTreeNode=this._getReferenceTreeNode(startingIndex);if(!refTreeNode)
{console.log("gmiller::_populateCanvas Node not specified on Index: "+startingIndex);this._enableDisableButtons_onSettingRefTreeNode(startingIndex,false);this._enableDisableButtons_onSelection(startingIndex,false);this._setSortableContainerCaption(startingIndex,"","");this._populateCanvas(startingIndex+1);return;}
this._enableDisableButtons_onSettingRefTreeNode(startingIndex,true);this._setSortableContainerCaption(startingIndex,refTreeNode.nodeId,refTreeNode.nodeText);var selectedNodeId=null;if(configTreeNodeIndex<(this._treeConfig.length-1))
{var nextConfigTreeNode=this._treeConfig[configTreeNodeIndex+1];if(nextConfigTreeNode.refNodeId)
{selectedNodeId=nextConfigTreeNode.refNodeId;}}
var _self=this;if(refTreeNode.hasBeenFetched)
{var foundSelectedHtmlNode=null;for(var i=0;i<refTreeNode.getNumberOfChildren();i++)
{var newNode=refTreeNode.children[i];var htmlItem=_self.options.renderHtml4NewNode(newNode.nodeUserData);cnt.append(htmlItem);if(selectedNodeId&&selectedNodeId==newNode.nodeId)
{foundSelectedHtmlNode=htmlItem;}}
if(foundSelectedHtmlNode)
{_self._updateSelectionHint(foundSelectedHtmlNode);_self._enableDisableButtons_onSelection(startingIndex,true);}
else _self._enableDisableButtons_onSelection(startingIndex,false);_self._populateCanvas(startingIndex+1);}
else
{this.options.onFetch(refTreeNode.nodeId,configTreeNodeIndex,function(jsonDataArray,iTotalRecords)
{refTreeNode.hasBeenFetched=true;var foundSelectedHtmlNode=null;if(iTotalRecords>0)
{for(var i=0;i<iTotalRecords;i++)
{var newNode=new org.r3.widget.miller.TreeNode(jsonDataArray[i].getNodeId(),jsonDataArray[i].getNodeLabel(),jsonDataArray[i]);refTreeNode.addChild(newNode);var htmlItem=_self.options.renderHtml4NewNode(newNode.nodeUserData);cnt.append(htmlItem);if(selectedNodeId&&selectedNodeId==newNode.nodeId)
{foundSelectedHtmlNode=htmlItem;_self._enableDisableButtons_onSelection(startingIndex,true);}
else _self._enableDisableButtons_onSelection(startingIndex,false);}}
if(foundSelectedHtmlNode)
{_self._updateSelectionHint(foundSelectedHtmlNode);}
_self._populateCanvas(startingIndex+1);});}},_getContainerObjByIndex:function(anIndex)
{if(!this._uiInfo[anIndex].containerObj)
{this._uiInfo[anIndex].containerObj=this.element.find('#'+this._getContainerIdByIndex(this.element.attr('id'),anIndex));}
return this._uiInfo[anIndex].containerObj;},_getContainerIdByIndex:function(aWidgetId,anIndex)
{return aWidgetId+"_gmiller_container_"+anIndex;},_getContainerIndexById:function(aContainerId)
{for(var i=0;i<this._uiInfo.length;i++)
{if(this._uiInfo[i].containerId==aContainerId)
return i;}
return-1;},_isContainerLinked2Node:function(aContainerId)
{var ndx=this._getContainerIndexById(aContainerId);if(ndx>=0)
{var c=this._getConfigTreeNodeBySortableContainerIndex(ndx);if(c&&c.refNodeId)
return true;}
return false;},_onSortableChange:function(event,ui)
{console.log("gmiller::_onSortableChange ",event,ui);},_onSortableStart:function(event,ui)
{console.log("gmiller::_onSortableStart ",event,ui);this._dragStep='start';this._dragTarget=event.target;},_onSortableCreate:function(event,ui)
{console.log("gmiller::_onSortableCreate ",event,ui);},_onSortableOver:function(event,ui)
{console.log("gmiller::_onSortableOver ",event.target,ui.item,ui.sender);},_onSortableOut:function(event,ui)
{console.log("gmiller::_onSortableOut ",event.target,ui.item,ui.sender);},_onSortableStop:function(event,ui)
{if(this._dragStep=='receiving')
{var dt=$(this._dragTarget);var st=$(event.target);console.log("gmiller::_onSortableStop RECEIVING FROM "+st.attr('id')+" --> "+dt.attr('id')+" Of item at index "+ui.item.index()+" With value ",ui.item);if(!this._moveCanBeApplied(dt,st,ui.item))
{console.log("gmiller::_onSortableStop RECEIVING FROM But Is Not ALlowed");st.sortable('cancel');alert(org.r3.widget.miller.message.moveNotAllowed);}
else
{this._applyMove(dt,st,ui.item,ui.item.index());}}
else
{var st=$(event.target);console.log("gmiller::_onSortableStop SORTING ",st,ui.item);this._applySort(st,ui.item,ui.item.index());}
this._dragStep='none';this._dragTarget=null;},_applySort:function(sourceContainer,anItem,anItemPosition)
{var stId=this._getContainerIndexById(sourceContainer.attr("id"));var refTreeNode=this._getReferenceTreeNode(stId);if(refTreeNode)
{refTreeNode.moveChild(anItem.attr("id"),anItemPosition);}
if(!anItem.hasClass("selected"))
{this._updateSelectionHint(anItem);}
if(this.options.onSort)
{this.options.onSort(sourceContainer.attr('id'),refTreeNode.nodeId,anItem.attr("id"),anItemPosition,(anItemPosition==0)?null:refTreeNode.children[anItemPosition-1].nodeId);}},_applyMove:function(dropContainer,sourceContainer,anItem,anItemPosition)
{var ndxd=this._getContainerIndexById(dropContainer.attr('id'));var ndxs=this._getContainerIndexById(sourceContainer.attr('id'));var updateUiFromIndex=(ndxd<ndxs)?ndxd:ndxs;var itemId=anItem.attr("id");var dropContainerReferenceTreeNode=this._getReferenceTreeNode(ndxd);var sourceContainerReferenceTreeNode=this._getReferenceTreeNode(ndxs);var targetTreeNodeInfo=sourceContainerReferenceTreeNode.findNode(itemId);targetTreeNodeInfo.parent.removeChild(itemId);dropContainerReferenceTreeNode.addChild(targetTreeNodeInfo.node,anItemPosition);var dropContainerTreeConfigIndex=ndxd+this._uiSlidingWindowOffset;if((dropContainerTreeConfigIndex+1)<this._treeConfig.length)
{this._clearConfigTreeNodeReferenceTreeNode(dropContainerTreeConfigIndex+1);this._treeConfig[dropContainerTreeConfigIndex+1].refNodeId=itemId;}
this._populateCanvas(updateUiFromIndex);if(this.options.onMove)
{this.options.onMove(dropContainer.attr('id'),sourceContainer.attr('id'),dropContainerReferenceTreeNode.nodeId,anItem.attr("id"),anItemPosition,(anItemPosition==0)?null:dropContainerReferenceTreeNode.children[anItemPosition-1].nodeId);}},_moveCanBeApplied:function(dropContainer,sourceContainer,anItem)
{console.log("Source Container length: ",sourceContainer.find("li").length);if(!this._isContainerLinked2Node(dropContainer.attr('id')))
return false;if(!this._isNodePromotion(dropContainer.attr('id'),sourceContainer.attr('id')))
{if(!(sourceContainer.find("li").length)||anItem.hasClass('selected'))
return false;}
return true;},_updateSelectionHint:function(anItem)
{anItem.siblings().removeClass('selected');anItem.addClass('selected');},_isNodePromotion:function(dropContainerId,sourceContainerId)
{var ndxd=this._getContainerIndexById(dropContainerId);var ndxs=this._getContainerIndexById(sourceContainerId);return ndxd<ndxs;},_onSortableReceive:function(event,ui)
{console.log("gmiller::_onSortableReceive ",event.target,ui.item,ui.sender);this._dragStep='receiving';this._dragTarget=event.target;},_onSortableBeforeStop:function(event,ui)
{console.log("gmiller::_onSortableBeforeStop ",event.target,ui.item,ui.sender);}});})(jQuery);