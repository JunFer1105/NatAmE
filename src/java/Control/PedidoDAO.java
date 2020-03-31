package Control;

import Modelo.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {
    
    private Statement st;
    private ResultSet rs;
    private ArrayList regiones;
    private String sentencia;
    private String resultado;
    
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
    
}
