package Clase5;

public class ListaCircular 
{
    private Node cabeza;

    public ListaCircular()
    {
        this.cabeza = null;
    }

     // 1. Función para insertar un nodo en cualquier posición
    public void insertar(int dato, int posicion) {
        Node nuevoNodo = new Node(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.anterior = cabeza;
            cabeza.siguiente = cabeza;
        } else if (posicion == 0) {
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cabeza.anterior;
            cabeza.anterior.siguiente = nuevoNodo;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        } else {
            Node actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
                if (actual == cabeza) break; 
            }
            nuevoNodo.siguiente = actual.siguiente;
            nuevoNodo.anterior = actual;
            actual.siguiente.anterior = nuevoNodo;
            actual.siguiente = nuevoNodo;
        }
    }

    // 2. Función para eliminar un nodo
    public void eliminar(int dato) {
        if (cabeza == null) return;

        Node actual = cabeza;
        do {
            if (actual.valor == dato) {
                if (actual == cabeza && actual.siguiente == cabeza) {
                    cabeza = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    if (actual == cabeza) {
                        cabeza = actual.siguiente;
                    }
                }
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    // 3. Función para recorrer la lista circular 
    public void recorrerTresVueltas() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Node actual = cabeza;
        int vueltas = 0;

        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
            if (actual == cabeza) {
                vueltas++;
            }
        } while (vueltas < 3);
    }

    
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        
        lista.insertar(1, 0);
        lista.insertar(2, 1);
        lista.insertar(3, 2);
        lista.insertar(4, 3);
        lista.insertar(5, 4); 

        System.out.println("Lista original (3 vueltas):");
        lista.recorrerTresVueltas();

       
        lista.eliminar(3);

        System.out.println("\nLista después de eliminar el 3 (3 vueltas):");
        lista.recorrerTresVueltas();
    }
}
