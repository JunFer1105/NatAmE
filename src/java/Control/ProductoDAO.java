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
        sentencia = "SELECT I.K_INVENTARIO, P.N_NOMBRE, I.O_PRECIO_PROD , I.O_STOCK_PROD FROM PRODUCT P, ZONA R, STOCK I WHERE I.K_COD_REGION=R.K_CODIGO AND I.K_COD_PRODUCTO=P.K_CODIGO AND R.K_CODIGO='"+region+"'";
        System.out.println("Sentencia: "+sentencia);
        carrito = new ArrayList<Producto>();
        try{
            rs = st.executeQuery(sentencia);
            System.out.println("Consulta sobre productos realizada con exito");
            while(rs.next()){
                int p_cod=rs.getInt("K_INVENTARIO");
                String p_nom=rs.getString("N_NOMBRE");
                float p_precio=rs.getFloat("O_PRECIO_PROD");
                int cantidad=rs.getInt("O_STOCK_PROD");
                prod = new Producto(p_cod, p_nom, p_precio, cantidad);
                System.out.println("producto agregado a la consulta "+p_nom);
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
