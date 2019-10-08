package Modelo;

public class Producto {
    private int codigo;
    private String nombre;
    private float precio;
    private float iva;
    private int categoria;

    public Producto(int codigo, String nombre, float precio, float iva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    

    
}
