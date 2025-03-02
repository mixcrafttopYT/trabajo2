/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Statement;
import librerias.SisParSis;

/**
 *
 * @author prof_tes_b
 */
@WebServlet(name = "SisIniSesControlador", urlPatterns = {"/SisIniSesControlador"})
public class SisIniSesControlador extends HttpServlet
{
    private SisParSis objParSis;
    private String strUsr, strCla, strNomUsr;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            objParSis=new SisParSis();
            if (cargarDriver())
            {
                strUsr=request.getParameter("txtUsr")==null?"":request.getParameter("txtUsr");
                strCla=request.getParameter("txtCla")==null?"":request.getParameter("txtCla");
                if (isUsuarioValido())
                {
                    response.sendRedirect("seguridades/SisPanPri.jsp?parNomUsr=" + strNomUsr);
                }
                else
                {
                    response.sendRedirect("seguridades/SisPanErr.jsp");
                }
            }
            else
            {
                System.out.println("Error consola: No se pudo cargar el Driver.");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>SisIniSesControlador</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("Error: No se pudo cargar el Driver.");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean cargarDriver()
    {
        boolean blnRes=true;
        try
        {
            //Class.forName("org.postgresql.Driver");
            Class.forName(objParSis.getDriverConexion());
        }
        catch (ClassNotFoundException e)
        {
            blnRes=false;
//            JOptionPane.showMessageDialog(this, "Excepción: " + e.toString());
        }
        return blnRes;
    }
    
    public boolean isUsuarioValido()
    {
        String strSQL;
        boolean blnRes=true;
        try
        {
            //Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbestudiantes", "postgres", "ClavePostgreSQL2017");
            Connection con=DriverManager.getConnection(objParSis.getStringConexion(), objParSis.getUsuarioConexion(), objParSis.getClaveConexion());
            if (con!=null)
            {
                String sql=" SELECT tx_usr, tx_nom FROM tbm_usuarios WHERE tx_usr = ? AND tx_cla=MD5(?) AND st_reg = 'A'";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, strUsr);
                pstmt.setString(2, strCla);
//                Statement stm=con.createStatement();
//                strSQL=" SELECT tx_usr, tx_nom";
//                strSQL+=" FROM tbm_usuarios";
//                strSQL+=" WHERE tx_usr='" + strUsr + "'";
//                strSQL+=" AND tx_cla=MD5('" + strCla + "')";
//                strSQL+=" AND st_reg='A'";
                ResultSet rst=pstmt.executeQuery();
                if (rst.next())
                {
                    strNomUsr=rst.getString("tx_nom");
                }
                else
                {
                    blnRes=false;
                }
                rst.close();
                pstmt.close();
                con.close();
            }
        }
        catch (java.sql.SQLException e)
        {
            blnRes=false;
//            JOptionPane.showMessageDialog(this, "Excepción: " + e.toString());
        }
        catch (Exception e)
        {
            blnRes=false;
//            JOptionPane.showMessageDialog(this, "Excepción: " + e.toString());
        }
        return blnRes;
    }
    
}
