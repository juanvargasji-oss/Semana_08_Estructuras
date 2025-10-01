package com.example.semana_08_estructuras;

public class Semana08EstructurasApplication {
    public static void main(String[] args) {
        // Pila de enteros con ArrayDeque
        java.util.ArrayDeque<Integer> pila = new java.util.ArrayDeque<>();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Pila:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }

        // Cola de cadenas con LinkedList
        java.util.Queue<String> cola = new java.util.LinkedList<>();
        cola.add("Ana");
        cola.add("Luis");
        cola.add("Marta");
        System.out.println("\nCola:");
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }

        // Cola circular de enteros con arreglo fijo
        ColaCircular colaCircular = new ColaCircular(5);
        colaCircular.encolar(1);
        colaCircular.encolar(2);
        colaCircular.encolar(3);
        colaCircular.encolar(4);
        colaCircular.encolar(5);
        System.out.println("\nCola Circular:");
        while (!colaCircular.estaVacia()) {
            System.out.println(colaCircular.desencolar());
        }
    }

    // Clase interna para cola circular
    static class ColaCircular {
        private int[] arr;
        private int frente, fin, tamaño, capacidad;

        public ColaCircular(int capacidad) {
            this.capacidad = capacidad;
            arr = new int[capacidad];
            frente = 0;
            fin = -1;
            tamaño = 0;
        }

        public boolean estaVacia() {
            return tamaño == 0;
        }

        public boolean estaLlena() {
            return tamaño == capacidad;
        }

        public void encolar(int valor) {
            if (estaLlena()) throw new RuntimeException("Cola llena");
            fin = (fin + 1) % capacidad;
            arr[fin] = valor;
            tamaño++;
        }

        public int desencolar() {
            if (estaVacia()) throw new RuntimeException("Cola vacía");
            int valor = arr[frente];
            frente = (frente + 1) % capacidad;
            tamaño--;
            return valor;
        }
    }
}