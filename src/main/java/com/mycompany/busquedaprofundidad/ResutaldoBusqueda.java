/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busquedaprofundidad;

/**
 *
 * @author Edgar David
 */
public class ResutaldoBusqueda {
      Node solucion;
        MyStack<Node> openSet;
        MyHashSet<String> visitado;

        public ResutaldoBusqueda(Node solucion, MyStack<Node> openSet, MyHashSet<String> visitado) {
            this.solucion = solucion;
            this.openSet = openSet;
            this.visitado = visitado;
        }

}
