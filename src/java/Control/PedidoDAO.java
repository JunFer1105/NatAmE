package Control;

import Modelo.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {
    
    private Statement st;
    private ResultSet rs;
    private ArrayList pedidos;
    private String sentencia;
    private String resultado;
    private Pedido pedido;
    
    public PedidoDAO (Statement st){
        this.st=st;
    }
    
    public String registrarPedido(Pedido pedido){
        String sentencia1 = "SELECT NATAME.SEQ_PEDIDO.NEXTVAL FROM DUAL";
        try{
            rs=st.executeQuery(sentencia1);
            rs.next();
            resultado = rs.getString("NEXTVAL");
            sentencia = "INSERT INTO WISH VALUES("+resultado+","+pedido.getId_cliente()+", 'PSE', 0, TO_DATE(SYSDATE, 'DD/MM/YY'), 'ACTIVO', '"+pedido.getId_representante()+"')";
            st.execute(sentencia);
        }catch(SQLException ex){
            resultado = "No se pudo registrar el pedido" +ex.getMessage();
        }
        return resultado;
    }
    public ArrayList getPedidos(String id_cliente){
        String sentencia1 = "SELECT * FROM WISH WHERE K_ID_CLIENTE='"+id_cliente+"'";
        pedidos=new ArrayList();
        try{
            rs=st.executeQuery(sentencia1);
            System.out.println(sentencia1);
            while(rs.next()){
                String k_codigo=rs.getString("K_CODIGO");
                String id_cli=rs.getString("K_ID_CLIENTE");
                String id_representante=rs.getString("K_COD_REPRESENTANTE");
                String fecha=rs.getString("F_FECHA_PEDIDO");
                float valor_pedido=rs.getFloat("V_PRECIO_TOTAL");
                pedido = new Pedido(k_codigo,id_cli,id_representante,fecha,valor_pedido);
                pedidos.add(pedido);
            }
        }catch(SQLException ex){
            resultado = "No se pudo obtner los registros de pedido" +ex.getMessage();
            System.out.println(resultado);
        }
        return pedidos;
    }
    
}
