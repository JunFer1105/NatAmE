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
        sentencia="INSERT INTO SALESMAN VALUES ('"+c.getId()+"','"+c.getTipo_doc()+"','"+c.getNombre()+"', '"+c.getApellido()+"','"+c.getCod_region()+"', '"+c.getEmail()+"', '"+c.getGenero()+"',TO_DATE('"+c.getF_nacimiento() +"','DD/MM/YYYY'), TO_DATE(SYSDATE,'DD/MM/YYYY'),'"+c.getTelefono()+"','"+c.getDireccion()+"','"+c.getK_rangoRep()+"','"+c.getId_master()+"')";
        System.out.println(sentencia);
        
        String sentencia2="CREATE USER "+c.getEmail()+" IDENTIFIED BY "+contra+" DEFAULT TABLESPACE DEF_USUARIOS TEMPORARY TABLESPACE TMP_USUARIOS";;
        String sentencia3="GRANT R_REPRESENTANTE TO "+c.getEmail();
        
        System.out.println(sentencia2);
        System.out.println(sentencia3);
        try {
            
            st.execute(sentencia2);
            st.execute(sentencia3);          
            st.execute(sentencia);
            st.execute("COMMIT");
            
        } catch (SQLException ex) {
            resultado = "No se pudo registrar al representante "+ex.getMessage();
            
        }
        return resultado;
    } 
    
    public Representante cargarRepresentante(String user){
        String id="0";
        Representante representante = null;
        System.out.println(user);
        sentencia="SELECT * FROM SALESMAN WHERE O_EMAIL='"+user+"'"; 
        System.out.println(sentencia);
        representante = new Representante(id);
        try {
            rs=st.executeQuery(sentencia);
            System.out.println("consulta sobre representantes realizada CON EXITO");
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
