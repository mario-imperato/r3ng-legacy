<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
%>
 
<div class="box box-solid box-grade1">
  <div class="box-header with-border">
    <h3 class="box-title"><a href='sev/cmspage.do?pageid=comunicati'>Albo Ufficiale Virtuale</a></h3>
    <div class="box-tools pull-right">
       <a href='sev/cmspage.do?pageid=comunicati' class="btn btn-box-tool" title="Vai alla Pagina">
            <i class="fa fa-chevron-circle-right"></i>
       </a>            
    </div>
  </div>
  <div class="box-body">
<div style="padding-left: 110px; min-height: 100px; background: url('/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/iconicmenu/icon_013.jpg') no-repeat">
<div class="cmsCard">
<p>
In questa sezione sono disponibili i Comunicati e i documenti emessi alla data dal Comitato Organizzatore (Organizing Committee), la Giuria (Jury), 
il Comitato di Regata (Race Committee) e la Commissione di Stazza (Measurement Committeee).
<a href='sev/cmspage.do?pageid=comunicati'>Vai alla pagina &hellip;</a>
</p>
</div>
</div>  
  </div>
</div>

</r3_lang:environment>
 