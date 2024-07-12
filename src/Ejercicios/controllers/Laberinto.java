package Ejercicios.controllers;

import java.util.ArrayList;
import java.util.List;
import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {
    // Método principal que encuentra un camino en el laberinto
    public List<Celda> getPath(boolean[][] grid) {
        // Lista para almacenar el camino
        List<Celda> path = new ArrayList<>();

        // Verifica si la entrada es válida (no nula y no vacía)
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return path;
        }

        // Otra matriz para llevar un registro de las celdas visitadas
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Llama a la función auxiliar para encontrar el camino
        if (findPath(grid, 0, 0, path, visited)) {
            return path; // Si se encuentra un camino, devolver la lista de caminos
        }
        return new ArrayList<>(); // Si no se encuentra un camino, devolver una lista vacía
    }

    private boolean findPath(boolean[][] grid, int row, int col, List<Celda> path, boolean[][] visited) {
        // Verifica límites del laberinto y si la celda es transitable y no ha sido visitada
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col] || visited[row][col]) {
            return false; // Si está fuera de los límites, no es transitable o ya fue visitada, retorna false
        }

        // Añade la celda actual al camino
        Celda cell = new Celda(row, col);
        path.add(cell);

        // Si llegamos a la esquina inferior derecha, hemos encontrado un camino
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }

        // Marca la celda como visitada
        visited[row][col] = true;

        // Parte recursiva
        if (findPath(grid, row, col + 1, path, visited)) { // Intenta moverse hacia la derecha
            return true;
        }

        if (findPath(grid, row + 1, col, path, visited)) { // Intenta moverse hacia abajo
            return true;
        }

        // Si no se encuentra un camino, retrocede (backtrack)
        path.remove(path.size() - 1);
        visited[row][col] = false;

        return false;
    }
}