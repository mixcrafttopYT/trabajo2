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
public class SisUtilidades
{
    public SisUtilidades()
    {
        
    }
    
    /**
     * Esta función determina si la cadena recibida es un número entero.
     * @param strNum La cadena a evaluar.
     * @return true: Si la cadena es un número.
     * <BR>false: En el caso contrario. 
     */
    public boolean isNumero(String strNum)
    {
        boolean blnRes=true;
        try
        {
            Integer.parseInt(strNum);
        }
        catch (Exception e)
        {
            blnRes=false;
        }
        return blnRes;
    }
    
    /**
     * Esta función obtiene la ruta donde se encuentra el Sistema.
     * @return La ruta del Sistema.
     */
    public String getRutaSistema()
    {
        String strRes="";
        try
        {
            //java.net.URL urlArc=this.getClass().getResource("/librerias/SisParSis.class");
            java.net.URL urlArc=this.getClass().getResource("");
            //strRes=urlArc.getPath();
            strRes=java.net.URLDecoder.decode(urlArc.getPath(), "UTF-8");
            //La ruta contiene directorios que están de más.
            ///C:/Eddye/SI2019_SistemaAcademico%20v0.3/build/classes/librerias/
            //Hay que quitarle "build/classes/librerias/". Es decir, 24 caracteres.
            strRes=strRes.substring(0, strRes.length()-24);
        }
        catch (Exception e)
        {
            strRes="ERROR: No se puede determinar la ruta del proyecto...";
        }
        return strRes;
    }

}
