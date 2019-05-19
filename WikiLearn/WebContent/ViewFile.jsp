<%@ page language="java" import="bd.BD,bd.core.*,bd.daos.*, bd.dbos.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!--DETECTA USUARIO LOGADO-->
	<%
	
	Blob file = null;
    byte[ ] fileData = null ;
		MeuResultSet result = BD.MATERIAIS.getFile();

	if (result.next()) 
    {
        file = result.getBlob("file");
        fileData = result.getBytes((int)file.length());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline");
        response.setContentLength(fileData.length);
    }

	%>

</body>
</html>