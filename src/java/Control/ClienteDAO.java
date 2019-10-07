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
        sentencia="INSERT INTO CUSTOMER VALUES (NATAME.SEQ_CLIENTE.NEXTVAL, '"+c.getNombre()+"', '"+c.getApellido()+"', '"+c.getTelefono()+"', '"+c.getEmail()+"', "+c.getId_representante()+", '"+c.getCiudad()+"')";
        System.out.println(sentencia);
        
        String sentencia2="CREATE USER "+c.getEmail()+" IDENTIFIED BY "+contra+"";
        String sentencia3="GRANT R_CLIENTE TO "+c.getEmail();
        System.out.println(sentencia3);
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
