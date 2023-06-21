/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.dos.estructura.modelo;

import java.util.Stack;

/**
 *
 * @author ACER
 */
public class Pila <T> {
    private Stack<T> pila;
    private double size;

    public Pila() {
        pila = new Stack<>();
        this.size = 0;
    }
    
    public void agregar(T elemento){
        pila.push(elemento);
        size++;
    }
    
    public T procesar(){
        return pila.pop();
    }
    
    
    public boolean estaVacia(){
        return pila.isEmpty();
    }
    
    
    public void verElementos(Stack<T> pila){
        for (T t : pila) {
            System.out.println(t);
        }
    }

    @Override
    public String toString() {
        return "Pila{" + pila + '}';
    }

    
   
}
