<%-- 
    Document   : SisIniSes
    Created on : 30 nov 2023, 19:05:19
    Author     : prof_tes_b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <CENTER><h1>Inicio de Sesión (Servlets).</h1></CENTER>
        <form name="frmIniSes" action="../SisIniSesControlador" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><INPUT TYPE="Text" NAME="txtUsr" SIZE="20" value=""></td>
                </tr>
                <tr>
                    <td>Clave: </td>
                    <td><INPUT TYPE="password" NAME="txtCla" SIZE="20" value=""></td>
                </tr>
            </table>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
