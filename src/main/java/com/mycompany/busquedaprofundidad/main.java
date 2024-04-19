/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busquedaprofundidad;

/**
 *
 * @author Edgar David
 */
public class main {
       public static void main(String[] args) {
        // Configuración inicial
        int[][] initial = {{1,2, 3}, {4,0, 5}, {6,7,8}};
        // Configuración objetivo
       int[][] goal = {{1,2, 3}, {4,5, 6}, {7,8,0}};
       
       //4*4
        //int[][] initial = {{0,1, 2,3}, {5, 6, 7,4}, {9,10, 11, 8}, {13,14, 15, 12}};
        // Configuración objetivo
       //int[][] goal = {{1,2, 3,4}, {5, 6, 7,8}, {9,10, 11, 12}, {13,14, 15, 0}};
        DFSSolver ac=new DFSSolver();

        // Encuentra la solución y obtiene las listas OpenSet y Visited
        ResutaldoBusqueda result = ac.dfs(initial, goal,25550);

        // Imprime la ruta y el costo mínimo
        ac.printSolution(result.solucion);

        // Imprime la lista de OpenSet y Visited
        System.out.println("OpenSet:");
        System.out.println(result.openSet);
        System.out.println("  ");
        System.out.println("  ");
      //  System.out.println("Nodos visitados:");
        //System.out.println(result.visitado);
    }
}
