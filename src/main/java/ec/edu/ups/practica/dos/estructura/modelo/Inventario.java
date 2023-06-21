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
    //atributos
    
    private Producto producto;
    //se usara para ver el tamaño de la vista
    private double size;
    //atributo de una clase creada llamada Pila
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
    
    //se crea un nuevo producto y se le aumenta el tamaño
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
    // se busca un producto por codigo y retornando el mismo
    public Producto buscarPorCodigo(String codigo){
        Producto actual = producto;
        while(actual != null){
            if (actual.getCodigo().equals(codigo)){
                return actual;
            }
        }
        return null;
    }
    // se busca un producto por nombre 
    public Producto buscarPorNombre(String nombre){
        Producto actual = producto;
        while(actual != null){
            if (actual.getNombre().equals(nombre)){
                return actual;
            }
        }
        return null;
    }
  
    //se elimina, buscando primero un codigo de una persona
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
    
    //metodo para devolver todos los productos de la lista
    public void listar(){
        Producto actual = producto;
        while (actual != null){
            System.out.println(actual.toString());
            actual = actual.getSiguiente();
        }
    }
    
    //obtener el tamaño de la lista
    public double getSize() {
        return size;
    }
    
    /*metodo para vender un producto 
      primero se busca un producto por su nombre, luego se agrega el elemnto a una pila
      para que se vea la venta realizada y se modifica la cantidad de los productos
    */
    public void vender(String nombre){
        Producto p = this.buscarPorNombre(nombre);
        String ventaProducto ="Venta:{ Codigo: " + p.getCodigo() + " Nombre: "+p.getNombre() + " Precio: " + p.getPrecio() + "}";
        ventas.agregar(ventaProducto);
        int cantidad = p.getCantidad();
        p.setCantidad(cantidad-1);
    }
    
    //listar las listas de ventas
    public String verVentas(){
        return ventas.toString();
    }
    @Override
    public String toString() {
        return "Inventario{" + "producto=" + producto + '}';
    }
    
    
}
