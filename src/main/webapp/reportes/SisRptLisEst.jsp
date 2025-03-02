<%-- 
    Document   : SisRptLisEst
    Created on : 30 nov 2023, 19:26:16
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
        <h1>Listado de Estudiantes</h1>
        <table border='1'>
            <tr>
                <td><b>Código</b></td>
                <td><b>Nombre</b></td>
                <td><b>Dirección</b></td>
                <td><b>Teléfono</b></td>
                <td><b>Sexo</b></td>
                <td><b>Estado civil</b></td>
                <td><b>Fecha de nacimiento</b></td>
                <td><b>Estado de Registro</b></td>
                <td><b>Código de Ciudad</b></td>
            <tr>
            <c:forEach items="${listadoEstudiantes}" var="estudiante">
                <c:if test="${estudiante.estadoRegistro=='A'}">
                    <tr>
                        <td>${estudiante.codigo}</td>
                        <td><c:out value="${estudiante.nombre}"/></td>
                        <td><c:out value="${estudiante.direccion}"/></td>
                        <td><c:out value="${estudiante.telefono}"/></td>
                        <td><c:out value="${estudiante.sexo}"/></td>
                        <td><c:out value="${estudiante.estadoCivil}"/></td>
                        <td><c:out value="${estudiante.fechaNacimiento}"/></td>
                        <td><c:out value="${estudiante.estadoRegistro}"/></td>
                        <td><c:out value="${estudiante.codigoCiudad}"/></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </body>
</html>