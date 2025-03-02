<%-- 
    Document   : SisRptLisUsr
    Created on : 30 nov 2023, 19:18:15
    Author     : prof_tes_b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Académico</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <table border='1'>
            <tr>
                <td><b>Código</b></td>
                <td><b>Usuario</b></td>
                <td><b>Nombre</b></td>
                <td><b>Estado de Registro</b></td>
            <tr>
            <c:forEach items="${listadoUsuarios}" var="usuario">
                <c:if test="${usuario.estadoRegistro=='A'}">
                    <tr>
                        <td>${usuario.codigo}</td>
                        <td><c:out value="${usuario.usuario}"/></td>
                        <td><c:out value="${usuario.nombre}"/></td>
                        <td><c:out value="${usuario.estadoRegistro}"/></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </body>
</html>