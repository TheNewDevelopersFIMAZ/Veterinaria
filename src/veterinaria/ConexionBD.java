/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

/**
 *
 * @author FIMaz
 */
import java.sql.*;

public class ConexionBD {
    
    Connection conx;
    
    ConexionBD(){
        
    }
    
    public Connection conexion() throws ClassNotFoundException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conx = DriverManager.getConnection("jdbc:mysql://localhost" + ":3306/VeterinariaEs", "root", "");
            System.out.println("Conexion Exitosa...");
        }catch(SQLException e){
            
            System.out.println("Conexion Fallida..." + e.getMessage());
        }
        
        return conx;
    }
    
    public void desconectar(){
        
        conx = null;
        
        if(conx == null){
            
            System.out.println("Conexion Finalizada...");
        }
    }
    
    Statement createStatement(){
        
        throw new UnsupportedOperationException("No lo soporta...");
    }
}
