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
    
    public ArrayList<PedidoProducto> getPedidosProductos(String carrito, String cod_pedido){
        ArrayList pedido_productos=new ArrayList();
        String items[] = carrito.split(",");
        int j=0;
        for (int i=0;i<items.length;i++){
             
            pp=new PedidoProducto(cod_pedido, items[i], 1);
            //System.out.println(carrito);
            //if (j==0){
                pedido_productos.add(pp);
            //}
//            Iterator it = pedido_productos.iterator();
//            while (it.hasNext()){
//                PedidoProducto aux=(PedidoProducto)it.next();
//                if (aux.getCod_inventario().equals(pp.getCod_inventario()) && j!=0 ){
//                    pedido_productos.remove(j);
//                    aux.setCatidad(aux.getCatidad()+1);
//                    pedido_productos.add(j, aux);
//                }else if(j!=0){
//                    pedido_productos.add(pp);
//                }
//                j=j+1;
//            }
        }
        return pedido_productos;
    }
    
    public String insertarProductosEnPedido(ArrayList pedido_productos){
        resultado="Finalizado";
        Iterator it=pedido_productos.iterator();
        while(it.hasNext()){
            pp=(PedidoProducto) it.next();
            sentencia="INSERT INTO WISH_PROD VALUES('"+pp.getCod_pedido()+"','"+pp.getCod_inventario()+"',"+pp.getCatidad()+")";
            System.out.println(sentencia);
            try {
                st.execute(sentencia);
            } catch (SQLException ex) {
                resultado="No se ha podido crear los pedido producto "+ex.getMessage();
            }
        }
        return resultado;
    }
}
