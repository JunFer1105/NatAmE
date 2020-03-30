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
    
    public String regCliente(String identificacion, String tipo_doc,String nombre, String apellido, String telefono, String email,String ciudad, String clave){
        ClienteDAO clienteDao=new ClienteDAO(st);
        Cliente cliente=new Cliente(identificacion, tipo_doc, nombre,apellido,telefono,email,getRepresentante().getId(),ciudad);
        String auxiliar=clienteDao.registrarCliente(cliente,clave);
        System.out.println(auxiliar);
        return auxiliar;
    } 
    
    public String regRepresentante(String id, String tipo_doc, String nombre, String apellido, String cod_region, String email, String genero, String f_nacimiento, String telefono, String direccion, String clave){
        RepresentanteDAO representanteDAO=new RepresentanteDAO(st);
        Representante representante = new Representante(id, tipo_doc, nombre, apellido, cod_region, email, genero, f_nacimiento, "00",telefono, direccion, getRepresentante().getId(), "44");
        String auxiliar=representanteDAO.registrarRepresentante(representante,clave);
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
    
    public ArrayList getClientes(){
        ClienteDAO clienteDAO = new ClienteDAO(st);
        ArrayList clientes=new ArrayList();
        String auxiliar=getRepresentante().getId();
        System.out.println(auxiliar);
        if(auxiliar.equals("0")){
            System.out.println("generando datos del cliente para la compar");
            clientes.add(clienteDAO.getCliente(user));
        }
        else {
            clientes=clienteDAO.getClientes(getRepresentante().getId());
        }
        return clientes;
    }
}
