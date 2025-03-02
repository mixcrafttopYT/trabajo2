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
import entidades.Estudiante;
import java.sql.PreparedStatement;
import librerias.SisParSis;

/**
 *
 * @author prof_tes_b
 */
public class EstudianteDAO
{
    private SisParSis objParSis;
    private Connection con;
    private Statement stm;
    private ResultSet rst;
    private String strSQL;
    
    public EstudianteDAO()
    {
        objParSis=new SisParSis();
    }
    
    public List<Estudiante> getListadoEstudiantes()
    {
        List<Estudiante> objLisEst=new ArrayList<Estudiante>();
        try
        {
            //Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbestudiantes", "postgres", "ClavePostgreSQL2017");
            con=DriverManager.getConnection(objParSis.getStringConexion(), objParSis.getUsuarioConexion(), objParSis.getClaveConexion());
            if (con!=null)
            {
                String sql="SELECT co_est, tx_nom, tx_dir, tx_tel, st_sex, st_estciv, fe_nac, st_reg, co_ciu FROM tbm_estudiantes ORDER BY co_est";
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rst= pstmt.executeQuery();
                
//                stm=con.createStatement();
//                strSQL=" SELECT co_est, tx_nom, tx_dir, tx_tel, st_sex, st_estciv, fe_nac, st_reg, co_ciu";
//                strSQL+=" FROM tbm_estudiantes";
//                strSQL+=" WHERE st_reg='A'";
//                strSQL+=" ORDER BY co_est";
//                rst=stm.executeQuery(strSQL);
                while (rst.next())
                {
                    Estudiante objEst=new Estudiante();
                    objEst.setCodigo(rst.getInt("co_est"));
                    objEst.setNombre(rst.getString("tx_nom"));
                    objEst.setDireccion(rst.getString("tx_dir"));
                    objEst.setTelefono(rst.getString("tx_tel"));
                    objEst.setSexo(rst.getString("st_sex"));
                    objEst.setEstadoCivil(rst.getString("st_estciv"));
                    objEst.setFechaNacimiento(rst.getString("fe_nac"));
                    objEst.setEstadoRegistro(rst.getString("st_reg"));
                    objEst.setCodigoCiudad(rst.getInt("co_ciu"));
                    objLisEst.add(objEst);
                }
                rst.close();
                pstmt.close();
                con.close();
            }
        }
        catch (java.sql.SQLException e)
        {
            objLisEst=null;
            System.out.println("Excepción: " + e.toString());
        }
        catch (Exception e)
        {
            objLisEst=null;
            System.out.println("Excepción: " + e.toString());
        }
        return objLisEst;
    }
    
}
