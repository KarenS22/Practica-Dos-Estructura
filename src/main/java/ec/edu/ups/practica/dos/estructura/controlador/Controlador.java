/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.estructura.controlador;

import ec.edu.ups.practica.dos.estructura.modelo.Inventario;
import ec.edu.ups.practica.dos.estructura.modelo.Producto;
import ec.edu.ups.practica.dos.estructura.vista.Vista;

/**
 *
 * @author ACER
 */
public class Controlador {
    private Vista vista;
    private Inventario inventario;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.inventario = new Inventario();
    }
    
    public void iniciar() {
        int opcionPrincipal = -1;

        while (opcionPrincipal != 0) {
            opcionPrincipal = vista.mostrarMenuPrincipal();

            // Instancia de [dato] segun la opcion escogida
            switch (opcionPrincipal) {
                case 1:
                    String nombre = vista.pedirNombre();
                    String codigo = vista.pedirCodigo();
                    double precio = vista.pedirPrecio();
                    int cantidad = vista.pedirCantidad();
                    inventario.agregar(nombre, codigo, precio, cantidad);
                    break;
                case 2:
                    String codigoBuscar = vista.pedirCodigo();
                    Producto pB = inventario.buscarPorCodigo(codigoBuscar);
                    vista.mostrarMensaje(pB.toString());
                    break;
                case 3: 
                    inventario.listar();
                    break;
                case 4:
                    String codigoB = vista.pedirCodigo();
                    inventario.vender(codigoB);
                    
                    break;
                case 5:
                    String ventas = inventario.verVentas();
                    vista.mostrarMensaje(ventas);
                case 0:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        }
    }


    
    
}
