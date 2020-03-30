package Modelo;


public class Representante {
    private String id;
    private String tipo_doc;
    private String nombre;
    private String apellido;
    private String cod_region;
    private String email;
    private String genero;
    private String f_nacimiento;
    private String f_contrato;
    private String telefono;
    private String direccion;
    private String id_master;
    private String k_rangoRep;

    public Representante(String id, String tipo_doc, String nombre, String apellido, String cod_region, String email, String genero, String f_nacimiento, String f_contrato, String telefono, String direccion, String id_master, String k_rangoRep) {
        this.id = id;
        this.tipo_doc = tipo_doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cod_region = cod_region;
        this.email = email;
        this.genero = genero;
        this.f_nacimiento = f_nacimiento;
        this.f_contrato = f_contrato;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_master = id_master;
        this.k_rangoRep = k_rangoRep;
    }
    public Representante(String id){
        this.id=id;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCod_region() {
        return cod_region;
    }

    public void setCod_region(String cod_region) {
        this.cod_region = cod_region;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getF_contrato() {
        return f_contrato;
    }

    public void setF_contrato(String f_contrato) {
        this.f_contrato = f_contrato;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId_master() {
        return id_master;
    }

    public void setId_master(String id_master) {
        this.id_master = id_master;
    }

    public String getK_rangoRep() {
        return k_rangoRep;
    }

    public void setK_rangoRep(String k_rangoRep) {
        this.k_rangoRep = k_rangoRep;
    }

    
    
    
         
}
