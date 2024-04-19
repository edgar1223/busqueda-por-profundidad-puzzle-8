/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busquedaprofundidad;

/**
 *
 * @author Edgar David
 */

public class DFSSolver {
  

    

 

    public static ResutaldoBusqueda dfs(int[][] initial, int[][] goal,int depthLimit) {
        MyStack<Node> openSet = new MyStack<>();
        MyHashSet<String> visited = new MyHashSet<>();
            Node ac=new Node();

        // Agrega el estado inicial a OpenSet
        openSet.push(new Node(initial, 0, null));

        // Mientras OpenSet no esté vacío
        while (!openSet.isEmpty()) {
            // Remueve un nodo de OpenSet (el último agregado)
            Node actual = openSet.pop();

            // Si el nodo contiene el estado objetivo, retorna la solución
            if (Node.deepEquals(actual.estado, goal)) {
                return new ResutaldoBusqueda(actual, openSet, visited);
            }
// Verifica el límite de profundidad
            if (actual.costo >= depthLimit) {
                continue; // Si la profundidad excede el límite, salta este nodo
            }
            // Agrega el estado actual a la lista de visitados
            visited.add(MyArrays.deepToString(actual.estado));
            // Agrega nodos resultantes
            ac.AgregaNodoVecino(actual, openSet, visited, goal);
        }

        // Si no se encuentra una solución, retorna null
        return new ResutaldoBusqueda(null, openSet, visited);
    }

  

    public static void printSolution(Node solution) {
        if (solution == null) {
            System.out.println("No se encontró solución.");
            return;
        }

        // Recorre la ruta desde el estado final hasta el estado inicial
        MyStack<Node> path = new MyStack<>();
        Node current = solution;
        while (current != null) {
            path.push(current);
            current = current.padre;
        }

        // Imprime la ruta y el costo mínimo
        System.out.println("Ruta hacia la solución:");
        int step = 0;
        while (!path.isEmpty()) {
            Node node = path.pop();
            System.out.println("Paso " + step + ":");
            printState(node.estado);
            System.out.println("Costo acumulado: " + node.costo);
            step++;
        }
    }

    public static void printState(int[][] state) {
        for (int[] row : state) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
