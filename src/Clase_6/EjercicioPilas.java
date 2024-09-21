package Clase_6;

import java.util.Scanner;

class Node {
    String palabra;
    Node next;

    public Node(String palabra) {
        this.palabra = palabra;
        this.next = null;
    }
}

class Pila {
    Node top;
    Node bottom;
    int length;

    public Pila() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public Node peek() {
        if (this.length == 0) {
            return null;
        }
        return this.top;
    }

    public void push(String value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.length++;
    }

    public Node pop() {
        if (this.length == 0) {
            return null;
        }
        Node poppedNode = this.top;
        if (this.length == 1) {
            this.top = null;
            this.bottom = null;
        } else {
            this.top = this.top.next;
        }
        this.length--;
        return poppedNode;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public static void invertirOracion(String oracion) {
        Pila pila = new Pila();
        String[] palabras = oracion.trim().split("\\s+");

        for (String palabra : palabras) {
            pila.push(palabra);
        }
        Node topNode = pila.peek();
        if (topNode != null) {
            System.out.println("La palabra en la parte superior de la pila es: " + topNode.palabra);
        } else {
            System.out.println("La pila está vacía.");
        }

        System.out.println("Oración invertida:");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop().palabra + " ");
        }
        System.out.println();
    }

    public static boolean verificarParentesis(String expresion) {
        Pila pila = new Pila();

        for (char c : expresion.toCharArray()) {
            if (c == '(') {
                pila.push("(");
            } else if (c == ')') {
                if (pila.length == 0) {
                    return false; 
                }
                pila.pop();
            }
        }

        return pila.length == 0; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario que ingrese una oración
        System.out.println("Por favor, ingrese una oración:");
        String oracion = scanner.nextLine();

        // Invierte la oración
        invertirOracion(oracion);

        String[] expresiones = {
            "((2+3)*(4-1))",
            "(3+4))(()",
            "((2+3)*(4-1)",
            "(()()())",
            ")("
        };

        for (String expr : expresiones) {
            boolean balanceado = verificarParentesis(expr);
            System.out.println("Expresión: " + expr);
            System.out.println("¿Está balanceada? " + balanceado);
            System.out.println();
        }

        scanner.close();
    }
}
