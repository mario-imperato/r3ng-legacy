<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

    <!-- La struttura del codice non è templetizzabile... rivedere per avere la traduzione di oggetto.. {%#org.r3.db.bbs.bbsthreadnodeview.message.nodetitle%} -->
    <div class="form-group">
    <label class="col-sm-3 control-label fieldRequired">Oggetto</label>
    <div class='col-sm-9'>
    <input class="form-control" name="nodetitle" id="bbsthreadportletviewactionform_nodetitle" maxlength="80"   />
    </div>
    </div>
  
    <div class="form-group" style='margin-top: 20px'>
    <div class='col-md-12'>
      <textarea class="ckeditor" id="bbsthreadportletviewactionform_nodetext" name="nodetext" style="width: 90%;"></textarea>
    </div>
    </div>
