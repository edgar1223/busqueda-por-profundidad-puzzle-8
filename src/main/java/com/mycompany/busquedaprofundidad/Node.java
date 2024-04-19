/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busquedaprofundidad;


/**
 *
 * @author Edgar David
 */
public class Node {
    int[][] estado;
        int costo;
        Node padre;

        public Node(int[][] estado, int costo, Node padre) {
            this.estado = estado;
            this.costo = costo;
            this.padre = padre;
        }

    public Node() {
    }

    

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] row : estado) {
                sb.append(MyArrays.toString(row)).append("\n");
            }
            return sb.toString();
        }

    public static boolean deepEquals(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (!MyArrays.arraysEquals(matrix1[i], matrix2[i])) {
                return false;
            }
        }
        return true;
    }
    
      public static void AgregaNodoVecino(Node actual, MyStack<Node> openSet, MyHashSet<String> visited, int[][] goal) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Direcciones: arriba, abajo, izquierda, derecha

        // Encuentra la posición del cero en el estado actual
        int zeroRow = -1, zeroCol = -1;
        outerloop:
        for (int i = 0; i < actual.estado.length; i++) {
            for (int j = 0; j < actual.estado[0].length; j++) {
                if (actual.estado[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break outerloop;
                }
            }
        }

        // Genera nuevos estados moviendo el cero en todas las direcciones posibles
        for (int[] dir : directions) {
            int newRow = zeroRow + dir[0];
            int newCol = zeroCol + dir[1];

            // Verifica si la nueva posición es válida
            if (newRow >= 0 && newRow < actual.estado.length && newCol >= 0 && newCol < actual.estado[0].length) {
                // Copia el estado actual para modificarlo
                int[][] newState = copiarestado(actual.estado);

                // Intercambia el valor del cero con el valor en la nueva posición
                int temp = newState[zeroRow][zeroCol];
                newState[zeroRow][zeroCol] = newState[newRow][newCol];
                newState[newRow][newCol] = temp;

                // Verifica si el nuevo estado no ha sido visitado ni está en OpenSet
                if (!visited.contains(MyArrays.deepToString(newState))&& !contienoEstado(openSet, newState)) {
                    // Calcula el costo para llegar al nuevo estado (en este caso, distancia recorrida)
                    
                    int newCost = actual.costo + 1;

                    // Agrega el nuevo estado a OpenSet
                    openSet.push(new Node(newState, newCost, actual));
                }
                
            }
        }
    }
       private static boolean contienoEstado(MyStack<Node> queue, int[][] estado) {
        for (Node node : queue) {
            if (Node.deepEquals(node.estado, estado)) {
                return true;
            }
        }
        return false;
    }
    public static int[][] copiarestado(int[][] state) {
        int[][] newState = new int[state.length][];
        for (int i = 0; i < state.length; i++) {
            newState[i] = MyArrays.copyOf(state[i], state[i].length);
        }
        return newState;
    }
        
}
