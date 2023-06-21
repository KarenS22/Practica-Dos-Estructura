/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.practica.dos.estructura;

import ec.edu.ups.practica.dos.estructura.controlador.Controlador;
import ec.edu.ups.practica.dos.estructura.vista.Vista;

/**
 *
 * @author ACER
 */
public class PracticaDosEstructura {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador con = new Controlador(vista);
        con.iniciar();
    }
}
