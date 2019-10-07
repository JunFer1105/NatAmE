package Modelo;

public class Producto {
    private int k_codigo;
    private String n_nombre;
    private float v_precio;
    private float v_iva;
    private int cod_categoria;

    public Producto(int k_codigo, String n_nombre, float v_precio, float v_iva, int cod_categoria) {
        this.k_codigo = k_codigo;
        this.n_nombre = n_nombre;
        this.v_precio = v_precio;
        this.v_iva = v_iva;
        this.cod_categoria = cod_categoria;
    }

    public int getK_codigo() {
        return k_codigo;
    }

    public void setK_codigo(int k_codigo) {
        this.k_codigo = k_codigo;
    }

    public String getN_nombre() {
        return n_nombre;
    }

    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }

    public float getV_precio() {
        return v_precio;
    }

    public void setV_precio(float v_precio) {
        this.v_precio = v_precio;
    }

    public float getV_iva() {
        return v_iva;
    }

    public void setV_iva(float v_iva) {
        this.v_iva = v_iva;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }
    
    
}
