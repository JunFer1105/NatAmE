package Control;

import Modelo.Cliente;
import Modelo.Representante;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorPrincipal {
    Connection conector;
    public ArrayList<Producto> carrito;
    private Statement st;
    private ResultSet rs;
    public boolean funciono=false;
    public String excepcion="";
    public String user;
    
    public GestorPrincipal(String usuario,String clave){
        user=usuario;
        ConexionBD con=new ConexionBD(usuario,clave);
        conector=con.conexion();
        try {           
            if(conector!=null){
                st=conector.createStatement();
                funciono=true;
            }
            this.excepcion=con.excepcion;
        } catch (SQLException ex) {
            System.out.println("No se pudo establecer coneccion");
        }
    }
    
    public void cerrarConexion() throws SQLException{
        conector.close();
    }
    
    public String regCliente(String nombre, String apellido, String telefono, String email,String ciudad, String clave){
        ClienteDAO clienteDao=new ClienteDAO(st);
        Cliente cliente=new Cliente(nombre,apellido,telefono,email,getRepresentante().getId(),ciudad);
        String auxiliar=clienteDao.registrarCliente(cliente,clave);
        System.out.println(auxiliar);
        return auxiliar;
    } 
    
    public Representante getRepresentante(){
        RepresentanteDAO representanteDAO=new RepresentanteDAO(st);
        return representanteDAO.cargarRepresentante(user);
    }
    
    public ArrayList getProductos(String region){
        ProductoDAO prodDAO = new ProductoDAO(st);
        return prodDAO.obtenerProductos(region);
    }
    
    public ArrayList getRegionales(){
        RegionDAO regDAO = new RegionDAO(st);
        return regDAO.getRegionales();
    }
   
}
