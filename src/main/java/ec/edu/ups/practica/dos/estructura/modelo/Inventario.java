/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.estructura.modelo;

/**
 *
 * @author ACER
 */
public class Inventario {
    private Producto producto;
    private double size;
    private Pila<String> ventas;

    public Inventario() {
        this.ventas = new Pila<>();
    }
    

    public Inventario(Producto producto) {
        this.producto = producto;
        this.size = 0;
        this.ventas = new Pila<>();
    }
    
    public Producto obtenerUltimo(){
        Producto actual = producto;
        while(actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        return actual;
    }
    
    public void agregar(String nombre, String codigo, double precio, int cantidad){
        Producto nuevo = new Producto(nombre, codigo, precio, cantidad);
        if (producto == null){
            producto = nuevo;
        } else{
            Producto ultimo = obtenerUltimo();
            ultimo.setSiguiente(nuevo);
        }
        size++;
    }
    
    public Producto buscarPorCodigo(String codigo){
        Producto actual = producto;
        while(actual != null){
            if (actual.getCodigo().equals(codigo)){
                return actual;
            }
        }
        return null;
    }
    
    public Producto buscarPorNombre(String nombre){
        Producto actual = producto;
        while(actual != null){
            if (actual.getNombre().equals(nombre)){
                return actual;
            }
        }
        return null;
    }
  
    
    public void eliminar(String codigo){
        if (producto == null){
            return;
        }
        if (producto.getCodigo().equals(codigo)){
            producto = producto.getSiguiente();
            return;
        }
        Producto anterior = producto;
        Producto actual = producto.getSiguiente();
        while (actual != null && !actual.getCodigo().equals(codigo)){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        size--;
    }
    
    public void listar(){
        Producto actual = producto;
        while (actual != null){
            System.out.println(actual.toString());
            actual = actual.getSiguiente();
        }
    }
    
    public double getSize() {
        return size;
    }
    
    public void vender(String nombre){
        Producto p = this.buscarPorNombre(nombre);
        String ventaProducto ="Venta:{ Codigo: " + p.getCodigo() + " Nombre: "+p.getNombre() + " Precio: " + p.getPrecio() + "}";
        ventas.agregar(ventaProducto);
        int cantidad = p.getCantidad();
        p.setCantidad(cantidad-1);
    }
    
    public String verVentas(){
        return ventas.toString();
    }
    @Override
    public String toString() {
        return "Inventario{" + "producto=" + producto + '}';
    }
    
    
}
