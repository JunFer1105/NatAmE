package Control;

import Modelo.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author elric
 */
public class RegionDAO { 
    private Statement st;
    private ResultSet rs;
    private String resultado;
    private Region reg;
    private ArrayList regiones;
    
    public RegionDAO (Statement st){
        this.st=st;
    }
    
    
    public ArrayList getRegionales(){
        String consulta="SELECT k_codigo,n_nombre from ZONE";
        System.out.println(consulta);
        try {
            rs=st.executeQuery(consulta);
            regiones=new ArrayList();
            System.out.println("consulta sobre los representantes CON EXITO");
            while (rs.next()){
                System.out.println("OBTENIENDO DATOS DE LA CONSULTA");
                int id =rs.getInt("K_CODIGO");
                String nombre=rs.getString("N_NOMBRE");
                reg=new Region(id,nombre);               
                regiones.add(reg);
             }
        } catch (SQLException ex) {
            resultado = "No se pudo cargar el representante,"+ex.getMessage();
            System.out.println(resultado);
        }
        return regiones;
    }
}
