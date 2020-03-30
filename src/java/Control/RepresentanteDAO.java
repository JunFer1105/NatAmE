package Control;

import Modelo.Representante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepresentanteDAO {
    private Statement st;
    private Representante representante;
    private String sentencia;
    private ResultSet rs;
    private String resultado;
    
    public RepresentanteDAO(Statement st){
        this.st=st;
    }
    
    public String registrarRepresentante(Representante c,String contra){
        resultado="funciono";
        //sentencia="INSERT INTO CUSTOMER VALUES (NATAME.SEQ_REPRESENTANTE.NEXTVAL, '"+c.getNombre()+"', '"+c.getApellido()+"', '"+c.getTelefono()+"', '"+c.getEmail()+"', "+c.getId_representante()+", '"+c.getCiudad()+"')";
        System.out.println("sentencia");
        
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
    
    public Representante cargarRepresentante(String user){
        String id="0";
        Representante representante = null;
        System.out.println(user);
        sentencia="SELECT * FROM SALESMAN WHERE O_EMAIL='"+user+"'"; 
        System.out.println(sentencia);
        try {
            rs=st.executeQuery(sentencia);
            System.out.println("consulta sobre representantes realizada CON EXITO");
            representante = new Representante(id);
            System.out.println("Se creo que representante");
            while (rs.next()){
                System.out.println("OBTENIENDO DATOS DE LA CONSULTA");
                id =rs.getString("K_ID");
                String tipo_doc =rs.getString("I_TIPO_ID");
                String nombre=rs.getString("N_NOMBRE");
                String apellido=rs.getString("N_APELLIDO");
                String cod_region=rs.getString("K_COD_REGION");
                String email =rs.getString("O_EMAIL");
                String genero=rs.getString("O_GENERO");
                String f_nacimiento=rs.getString("F_NACIMIENTO");
                String f_contrato=rs.getString("F_CONTRATO");
                String telefono =rs.getString("O_TELEFONO");
                String direccion=rs.getString("O_DIRECCION");
                String rango=rs.getString("K_COD_TIPO");
                String id_master=rs.getString("K_ID_MASTER");
                
                representante=new Representante(id,tipo_doc,nombre,apellido,cod_region,email,genero,f_nacimiento,f_contrato,telefono,direccion,id_master,rango);
                System.out.println("El representante se creo");
            }
        } catch (SQLException ex) {
            resultado = "No se pudo cargar el representante,"+ex.getMessage();
            System.out.println(resultado);
        }
        return representante;
        
    }
    
    public String getResultado(){
        return this.resultado;
    }
}
