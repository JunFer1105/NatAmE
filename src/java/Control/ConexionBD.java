package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private String Driver,Database,User,Clave;
    private Connection con = null;
    public String excepcion;
    
    public ConexionBD(String usuario, String clave){
        recibirConexion("oracle.jdbc.OracleDriver","jdbc:oracle:thin:@localhost:1521:XE",usuario,clave);
    }
      
    public void recibirConexion (String driver, String database,String user,String clave){
          
        this.Driver= driver;
        this.Database = database;
        this.User = user;
        this.Clave = clave;
       }
       
       
    public Connection conexion() {
    try {
        Class.forName(Driver);
        con= DriverManager.getConnection(Database,User,Clave);
 
         System.out.println("conexion exitosa");
        
    }catch(ClassNotFoundException | SQLException e){
        
        System.out.println(e.getMessage()+"No se realizo la conexion");
        excepcion=e.getMessage();
        
    }
        return con;
    }
}
