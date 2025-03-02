<%-- 
    Document   : SisPanPri
    Created on : 30 nov 2023, 19:13:10
    Author     : prof_tes_b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String strNomUsr=request.getParameter("parNomUsr");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menú</h1>
        <b>Nombre de usuario:</b> <%=strNomUsr%>
        <br><a href="../UsuarioControlador">Listado de usuarios</a>
        <br><a href="../EstudianteControlador">Listado de estudiantes</a>
    </body>
</html>