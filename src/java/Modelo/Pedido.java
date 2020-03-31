package Modelo;

public class Pedido {
    private String codigo;
    private String id_cliente;
    private String forma_pago;
    private float precio_total;
    private String fecha;
    private String estado;
    private String id_representante;

    public Pedido(String codigo, String id_cliente, String forma_pago, float precio_total, String fecha, String estado, String id_representante) {
        this.codigo = codigo;
        this.id_cliente = id_cliente;
        this.forma_pago = forma_pago;
        this.precio_total = precio_total;
        this.fecha = fecha;
        this.estado = estado;
        this.id_representante = id_representante;
    }

    public Pedido(String id_cliente, String id_representante){
        this.id_cliente = id_cliente;
        this.id_representante = id_representante;
    }
    
    public Pedido(String codigo,String id_cliente, String id_representante, String fecha, float precio_total){
        this.codigo=codigo;
        this.id_cliente = id_cliente;
        this.id_representante = id_representante;
        this.fecha=fecha;
        this.precio_total=precio_total;
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_representante() {
        return id_representante;
    }

    public void setId_representante(String id_representante) {
        this.id_representante = id_representante;
    }
    
    
    
    
}
