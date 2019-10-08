package Control;

import Modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoDAO {

    private Producto prod;
    private ArrayList<Producto> carrito;
    private Statement st;
    private ResultSet rs;
    private String sentencia, resultado;
    
    public ProductoDAO(Statement st) {
        this.st = st;
    }
    
    public ArrayList obtenerProductos(String region){
        sentencia = "SELECT P.K_CODIGO, P.N_NOMBRE, P.V_PRECIO, I.STOCK_PRODUCTO, R.K_CODIGO, R.N_NOMBRE FROM PRODUCTO P, INVENTARIO I, REGION R WHERE I.CODIGO_PRODUCTO=P.K_CODIGO AND I.CODIGO_REGION=R.K_CODIGO AND R.N_NOMBRE='"+region+"'";
        System.out.println("Sentencia: "+sentencia);
        carrito = new ArrayList<Producto>();
        try{
            rs = st.executeQuery(sentencia);
            while(rs.next()){
                int p_cod=rs.getInt("K_CODIGO");
                String p_nom=rs.getString("N_NOMBRE");
                float p_precio=rs.getFloat("V_PRECIO");
                float p_iva=rs.getFloat("V_IVA");
                int p_cat=rs.getInt("COD_CATEGORIA");
                prod = new Producto(p_cod, p_nom, p_precio, p_iva, p_cat);
                carrito.add(prod);
            }
            System.out.println("Carga de productos exitosa");
        }catch(SQLException ex){
            resultado = "Error en la carga de productos: "+ex.getMessage();
            System.out.println("ERROR: "+resultado);
        }
        return carrito;
    }
}
