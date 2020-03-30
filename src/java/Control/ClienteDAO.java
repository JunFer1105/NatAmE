package Control;

import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    private ResultSet rs;
    private Cliente cliente;
    
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
    
    public Cliente getCliente(String user){
        sentencia = "SELECT * FROM CUSTOMER WHERE O_EMAIL='"+user+"'";
        System.out.println(sentencia);
        try{
            rs=st.executeQuery(sentencia);
            System.out.println("consulta sobre el cliente realizada CON EXITO");
            while (rs.next()){
                System.out.println("OBTENIENDO DATOS DE LA CONSULTA");
                String identificacion =rs.getString("K_ID");
                String nombre=rs.getString("N_NOMBRE");
                String apellido=rs.getString("N_APELLIDO");
                String tipo_doc = rs.getString("I_TIPO_ID");
                String id_representante=rs.getString("K_ID_REPRESENTANTE");
                cliente=new Cliente(identificacion, tipo_doc, nombre,apellido, id_representante);               
                
             }
        } catch (SQLException ex) {
            resultado = "No se pudo leer el cliente al cliente"+ex.getMessage();
            System.out.println(resultado);
        }
        return cliente;
    }
    
    public ArrayList getClientes(String id_representante){
        ArrayList clientes=null;
        String consulta="SELECT * from CUSTOMER WHERE K_ID_REPRESENTANTE='"+id_representante+"'";
        System.out.println(consulta);
        try {
            rs=st.executeQuery(consulta);
            clientes=new ArrayList();
            System.out.println("consulta sobre los clientes realizada CON EXITO");
            while (rs.next()){
                String identificacion =rs.getString("K_ID");
                String nombre=rs.getString("N_NOMBRE");
                String apellido=rs.getString("N_APELLIDO");
                String tipo_doc = rs.getString("I_TIPO_ID");
                cliente=new Cliente(identificacion, tipo_doc, nombre,apellido, id_representante);          
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            resultado = "No se pudo cargar a los clientes del representante, "+ex.getMessage();
            System.out.println(resultado);
        }
        return clientes;
    }
    
}
