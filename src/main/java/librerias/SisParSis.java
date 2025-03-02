/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias;

/**
 *
 * @author Eddye
 */
public class SisParSis
{
    private String strDriCon, strStrCon, strUsrCon, strClaCon;

    public SisParSis()
    {
        if (!cargarParSis())
            javax.swing.JOptionPane.showMessageDialog(null, "Error al leer el archivo de configuración.");
    }

    private boolean cargarParSis()
    {
        boolean blnRes=true;
        try
        {
//            System.out.println("Ruta 1: " + System.getProperty ("user.dir"));
//            System.out.println("Ruta 2: " + this.getClass().getResource("/").getPath());
            /*
            //Leer archivo de configuración "SisUsrSis.properties".
            java.util.Properties proArc=new java.util.Properties();
            //java.io.FileInputStream fis=new java.io.FileInputStream("c:\\archivosConfiguracion\\SisParSis.properties");
            //java.io.FileInputStream fis=new java.io.FileInputStream("E:\\Eddye\\S2M12021_Programación Web\\S2M12021_Ej06_SistemaAcademico_Servlets\\config\\SisParSis.properties");
            java.io.FileInputStream fis=new java.io.FileInputStream("/config/SisParSis.properties");
            proArc.load(fis);
            fis.close();
            //Leer las propiedades.
            strDriCon=proArc.getProperty("DriverConexion");
            strStrCon=proArc.getProperty("StringConexion");
            strUsrCon=proArc.getProperty("UsuarioConexion");
            strClaCon=proArc.getProperty("ClaveConexion");
            proArc=null;
            */
            
            strDriCon="org.postgresql.Driver";
            strStrCon="jdbc:postgresql://localhost:5432/dbestudiantes";
            strUsrCon="postgres";
            strClaCon="2354";
            
        }
//        catch (java.io.IOException e)
//        {
//            blnRes=false;
//            System.out.println("Excepción: " + e.toString());
//        }
        catch (Exception e)
        {
            blnRes=false;
            System.out.println("Excepción: " + e.toString());
        }
        return blnRes;
    }
    
    /**
     * Esta función devuelve el driver de conexión.
     * @return El driver de conexión.
     */
    public String getDriverConexion()
    {
        return strDriCon;
    }
    
    /**
     * Esta función devuelve la cadena de conexión.
     * @return La cadena de conexión.
     */
    public String getStringConexion()
    {
        return strStrCon;
    }
    
    /**
     * Esta función devuelve el usuario de conexión.
     * @return El usuario de conexión.
     */
    public String getUsuarioConexion()
    {
        return strUsrCon;
    }
    
    /**
     * Esta función devuelve la clave de conexión.
     * @return La clave de conexión.
     */
    public String getClaveConexion()
    {
        return strClaCon;
    }
    
}