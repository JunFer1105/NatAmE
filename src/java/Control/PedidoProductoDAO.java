package Control;

import Modelo.PedidoProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoProductoDAO {
    
    private PedidoProducto pp;
    private Statement st;
    private ResultSet rs;
    private String sentencia, resultado;
    
    public PedidoProductoDAO(Statement st){
        this.st=st;
    }
    
    public String insertarProductosEnPedido(ArrayList pedido_productos){
        resultado="Finalizado";
        Iterator it=pedido_productos.iterator();
        while(it.hasNext()){
            pp=(PedidoProducto) it.next();
            sentencia="INSERT INTO WISH_PROD VALUES('"+pp.getCod_pedido()+"','"+pp.getCod_pedido()+"',"+pp.getCatidad()+")";
            try {
                st.execute(sentencia);
            } catch (SQLException ex) {
                resultado="No se ha podido crear los pedido producto "+ex.getMessage();
            }
        }
        return resultado;
    }
}
