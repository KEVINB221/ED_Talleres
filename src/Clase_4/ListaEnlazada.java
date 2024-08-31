package Clase_4;

public class ListaEnlazada 
{
    private Nodo cabeza;

    // Constructor
    public ListaEnlazada() {
        this.cabeza = null;
    }
    //Ejercicio Practico #1
    // Método para insertar un nodo al inicio
    public void insertarInicio(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " -> ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println("null");
    }

    //Ejercicio Practico #2
    // Método para eliminar un nodo por valor
    public boolean eliminarNodo(int valor) {
        Nodo nodoActual = cabeza;
        Nodo nodoAnterior = null;

        while (nodoActual != null) {
            if (nodoActual.valor == valor) {
                if (nodoAnterior != null) {
                    nodoAnterior.siguiente = nodoActual.siguiente;
                } else {
                    cabeza = nodoActual.siguiente;
                }
                return true; // Nodo eliminado
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }
        return false; // Nodo no encontrado
    }

    //Ejercicio Practico #3
    // Método para buscar un nodo por valor
    public boolean buscarNodo(int valor) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.valor == valor) {
                return true; // Nodo encontrado
            }
            nodoActual = nodoActual.siguiente;
        }
        return false; // Nodo no encontrado
    }


    //Ejercicio Practico #4
    // Método para insertar un nodo en una posición específica
    public boolean insertarPosicion(int valor, int posicion) {
        if (posicion < 0) {
            return false; // Posición inválida
        }

        Nodo nuevoNodo = new Nodo(valor);

        if (posicion == 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
            return true;
        }

        Nodo nodoActual = cabeza;
        int indiceActual = 0;

        while (nodoActual != null && indiceActual < posicion - 1) {
            nodoActual = nodoActual.siguiente;
            indiceActual++;
        }

        if (nodoActual == null) {
            return false; // Posición fuera del rango
        }

        nuevoNodo.siguiente = nodoActual.siguiente;
        nodoActual.siguiente = nuevoNodo;
        return true;
    }

    // Método principal para ejecutar las pruebas
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        int[] elementos = {1, 2, 3, 4, 5};

        System.out.println("Insertar elemento al inicio:");
        // Insertar elementos al inicio
        for (int elemento : elementos) {
            lista.insertarInicio(elemento);
        }
        System.out.println("Se imprime la lista:");
        lista.imprimirLista();

        System.out.println("Se elimina el número 3:");
        // Eliminar un nodo
        lista.eliminarNodo(3);
        lista.imprimirLista();

        System.out.println("Se busca el número 3 y el 4:");
        // Buscar un nodo
        System.out.println(lista.buscarNodo(3)); // Debe imprimir false
        System.out.println(lista.buscarNodo(4)); // Debe imprimir true

        // Insertar en posiciones específicas
        System.out.println("Se inserta el número 6 al inicio:");
        lista.insertarPosicion(6, 0); // Insertar al inicio
        lista.imprimirLista();
        System.out.println("Se inserta el número 7 en la posición 3:");
        lista.insertarPosicion(7, 3); // Insertar en la posición intermedia
        lista.imprimirLista();
        System.out.println("Se inserta el número 8 al final:");
        lista.insertarPosicion(8, 10); // Intentar insertar fuera del rango actual
        lista.imprimirLista();
    }
}
