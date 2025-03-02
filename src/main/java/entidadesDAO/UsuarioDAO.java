/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import entidades.Usuario;
import java.sql.PreparedStatement;
import librerias.SisParSis;

/**
 *
 * @author prof_tes_b
 */
public class UsuarioDAO
{
    private SisParSis objParSis;
    private Connection con;
    private Statement stm;
    private ResultSet rst;
    private String strSQL;
    
    public UsuarioDAO()
    {
        objParSis=new SisParSis();
    }
    
    public List<Usuario> getListadoUsuarios()
    {
        List<Usuario> objLisUsr=new ArrayList<Usuario>();
        try
        {
            //Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbestudiantes", "postgres", "ClavePostgreSQL2017");
            con=DriverManager.getConnection(objParSis.getStringConexion(), objParSis.getUsuarioConexion(), objParSis.getClaveConexion());
            if (con!=null)
            {
                String sql=" SELECT co_usr, tx_usr, tx_nom, st_reg, tx_cla FROM tbm_usuarios ORDER BY co_usr";
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rst= pstmt.executeQuery();                
//                stm=con.createStatement();
//                strSQL=" SELECT co_usr, tx_usr, tx_nom, st_reg, tx_cla";
//                strSQL+=" FROM tbm_usuarios";
//                //strSQL+=" WHERE st_reg='A'";
//                strSQL+=" ORDER BY co_usr";
//                rst=stm.executeQuery(strSQL);
                while (rst.next())
                {
                    Usuario objUsr=new Usuario();
                    objUsr.setCodigo(rst.getInt("co_usr"));
                    objUsr.setUsuario(rst.getString("tx_usr"));
                    objUsr.setNombre(rst.getString("tx_nom"));
                    objUsr.setEstadoRegistro(rst.getString("st_reg"));
                    objUsr.setClave(rst.getString("tx_cla"));
                    objLisUsr.add(objUsr);
                }
                rst.close();
                pstmt.close();
                con.close();
            }
        }
        catch (java.sql.SQLException e)
        {
            objLisUsr=null;
            System.out.println("Excepción: " + e.toString());
        }
        catch (Exception e)
        {
            objLisUsr=null;
            System.out.println("Excepción: " + e.toString());
        }
        return objLisUsr;
    }
    
}
