/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

       
        
public class PedidoProducto {
    
    private String cod_pedido;
    private String cod_inventario;
    private int catidad;

    public PedidoProducto(String cod_pedido, String cod_inventario, int catidad) {
        this.cod_pedido = cod_pedido;
        this.cod_inventario = cod_inventario;
        this.catidad = catidad;
    }

    public String getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(String cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public String getCod_inventario() {
        return cod_inventario;
    }

    public void setCod_inventario(String cod_inventario) {
        this.cod_inventario = cod_inventario;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }
    
    
}
