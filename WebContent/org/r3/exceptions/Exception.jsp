<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%
	String serverName = request.getServerName().toUpperCase();
	String homelink = "/";
	String splashImage = "/r3ng/resources/sites/shakeus/shakeus_splash.png";
	String actualPage = "localhost.html";
	if (serverName.indexOf("SHAKEUS") >= 0)
	{
		// homelink = "/r3ng/shakeus/it/org/r3/home.do";
		// splashImage = "/r3ng/resources/sites/shakeus/shakeus_splash.png";
		actualPage = "shakeus.html";
	}
	
	if (serverName.indexOf("CVFIUMICINO") >= 0)
	{
		// homelink = "http://www.cvfiumicino.org/r3ng/cvfonline/it/org/r3/home.do";
		// splashImage = "/r3ng/resources/sites/shakeus/shakeus_splash.png";
		actualPage = "localhost.html";	
	}
%>

<jsp:include page="<%=actualPage%>" flush="true" />

