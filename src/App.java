import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicios.controllers.Laberinto;
import Ejercicios.models.Celda;

public class App {
    public static void main(String[] args) {

        System.out.println("Programación Dinámica");
        long startime, endtime = 0;
        System.out.println("\nFibonacci Normal");
        startime = System.nanoTime();
        System.out.println(fibonacci(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println(String.format("Time taken: %.9f s", (endtime - startime) / 1_000_000_000.0));

        System.out.println("\nFibonacci using a Map");
        startime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println(String.format("Time taken: %.9f s", (endtime - startime) / 1_000_000_000.0));

        System.out.println("\nFibonacci using an array");
        startime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println(String.format("Time taken: %.9f s", (endtime - startime) / 1_000_000_000.0));

        // Ejercicio 1
        runEjercicio1();
        // Ejercicio 2
        runEjercicio2();

    }

    // Normal recursive method
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // First caching method: Using a Map
    private static Map<Integer, Integer> cacheMap = new HashMap<>();

    public static int fibonacciWithCaching(int n) {
        if (n <= 1) {
            return n;
        }

        // Resvisar en cache si ya fue calculado
        if (cacheMap.containsKey(n)) {
            cacheMap.get(n);
        }

        int result = fibonacciWithCaching(n - 1) + fibonacciWithCaching(n - 2);
        cacheMap.put(n, result);
        return result;
    }

    // Second caching method: Using an array
    public static int fibonacciCaching(int n) {
        int[] cache = new int[n + 1];
        return fibonacciArrayR(n, cache);
    }

    private static int fibonacciArrayR(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = fibonacciArrayR(n - 1, cache) + fibonacciArrayR(n - 2, cache);
        return cache[n];
    }

    public static void runEjercicio1() {
        boolean[][] grid = {
            { true, true, true, true },
            { false, false, false, true },
            { true, true, false, true },
            { true, true, false, true }
        };

        Laberinto laberinto = new Laberinto();
        List<Celda> path = laberinto.getPath(grid);

        System.out.println();
        if (path.isEmpty()) {
            System.out.println("Ejercicio 1: No se encontró un camino.");
        } else {
            System.out.print("Ejercicio 1: Camino encontrado: ");
            for (Celda cell : path) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void runEjercicio2() {
        boolean[][] grid = {
            { true, true, true, true },
            { false, true, true, true },
            { true, true, false, false },
            { true, true, true, true }
        };

        Laberinto laberinto = new Laberinto();
        List<Celda> path = laberinto.getPath(grid);

        if (path.isEmpty()) {
            System.out.println("Ejercicio 2: No se encontró un camino.");
        } else {
            System.out.print("Ejercicio 2: Camino encontrado: ");
            for (Celda cell : path) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}