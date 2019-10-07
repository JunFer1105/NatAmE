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
    
    public Representante cargarRepresentante(String user){
        int id=0;
        
        System.out.println(user);
        sentencia="SELECT * FROM SALESMAN WHERE O_CORREO_ELECTRONICO='"+user+"'"; 
        System.out.println(sentencia);
        try {
            rs=st.executeQuery(sentencia);
            System.out.println("consulta sobre representantes realizada CON EXITO");
            representante = new Representante(id);
            while (rs.next()){
                System.out.println("OBTENIENDO DATOS DE LA CONSULTA");
                id =rs.getInt("K_ID");
                String nombre=rs.getString("N_NOMBRES");
                String apellido=rs.getString("N_APELLIDOS");
                String email =rs.getString("O_CORREO_ELECTRONICO");
                String genero=rs.getString("O_GENERO");
                String f_nacimiento=rs.getString("F_NACIMIENTO");
                String f_contrato=rs.getString("F_CONTRATO");
                String telefono =rs.getString("O_TELEFONO");
                String direccion=rs.getString("O_DIRECCION");
                int cod_region=rs.getInt("COD_REGION");
                int id_master=rs.getInt("ID_MASTER");
                String rango=rs.getString("I_RANGO");
                
                representante=new Representante(id,nombre,apellido,email,genero,f_nacimiento,f_contrato,telefono,direccion,cod_region,id_master,rango);
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
