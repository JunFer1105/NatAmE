package Modelo;


public class Cliente {
    
    private String identificacion;
    private String tipo_doc;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String id_representante;
    private String ciudad;

    public Cliente(String identificacion, String tipo_doc, String nombre, String apellido, String telefono, String email, String id_representante, String ciudad) {
        this.identificacion = identificacion;
        this.tipo_doc = tipo_doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.id_representante = id_representante;
        this.ciudad = ciudad;
    }
    
    public Cliente(String identificacion, String tipo_doc, String nombre, String apellido, String id_representante){
        this.identificacion = identificacion;
        this.tipo_doc = tipo_doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_representante=id_representante;
    }
    

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }
    
    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_representante() {
        return id_representante;
    }

    public void setId_representante(String id_representante) {
        this.id_representante = id_representante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
   
    
    
    
}
