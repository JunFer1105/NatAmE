package Control;

import Modelo.Cliente;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elric
 */
public class ClienteDAO {
    
    private Statement st;
    private String sentencia;
    private String resultado=null;
    
    public ClienteDAO(Statement st){
        this.st=st;
    }
    
    public String registrarCliente(Cliente c,String contra){
        resultado="funciono";
        sentencia="INSERT INTO CUSTOMER VALUES ('"+c.getIdentificacion()+"', '"+c.getTipo_doc()+"', '"+c.getNombre()+"', '"+c.getApellido()+"', '"+c.getTelefono()+"', '"+c.getCiudad()+"', '"+c.getEmail()+"', '"+c.getId_representante()+"')";
        System.out.println(sentencia);
        
        String sentencia2="CREATE USER "+c.getEmail()+" IDENTIFIED BY "+contra+""+" DEFAULT TABLESPACE DEF_USUARIOS TEMPORARY TABLESPACE TMP_USUARIOS";
        String sentencia3="GRANT R_CLIENTE TO "+c.getEmail();
        System.out.println(sentencia3);
        System.out.println(sentencia2);
        try {
            
            st.execute(sentencia2);
            st.execute(sentencia3);          
            st.execute(sentencia);
            
        } catch (SQLException ex) {
            resultado = "No se pudo registrar al cliente"+ex.getMessage();
        }
        return resultado;
    }
    
}
