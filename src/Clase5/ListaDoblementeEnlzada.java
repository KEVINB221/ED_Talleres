package Clase5;

public class ListaDoblementeEnlzada 
{
    private Node cabeza;
    private Node cola;

    public ListaDoblementeEnlzada()
    {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar un valor al final 
   public void agregar (int valor) 
   {
        Node nuevoNodo = new Node(valor);
        if (cabeza == null)
        {
            cabeza = cola = nuevoNodo;
        }
        else 
        {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;

        }
   }

   //Primera función: Eliminar un dodo que ingresa por parámetro

   public void eliminarNodo (Node nodo)
   {
    if (nodo == null) return;

    if (nodo == cabeza) 
    {
        cabeza = nodo.siguiente;
        if (cabeza != null) 
        {
            cabeza.anterior = null;
        }
    } else if (nodo == cola) 
    {
        cola = nodo.anterior;
        if (cola != null) 
        {
            cola.siguiente = null;
        }
    } else 
    {
        nodo.anterior.siguiente = nodo.siguiente;
        nodo.siguiente.anterior = nodo.anterior;
    }
   }

   //Funcion 2: Mostrar la lista hacia atrás
   public void mostrarHaciaAtras() {
        Node actual = cola;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    //Se tiene que crear este método porque si se ingresa el valor de una vezz aparece error, entonces primero tiene que
    //buscar si el nodo está en la lista, si está le asigna ese valor a un nodo "temporal", que es el que se va a eliminar
    private Node buscarNodo(int valor) {
        Node actual = cabeza;
        while (actual != null) {
            if (actual.valor == valor) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }
    

    public static void main(String[] args) {
        ListaDoblementeEnlzada lista = new ListaDoblementeEnlzada();
        
        // Agregar elementos a la lista
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        System.out.println("Lista original (hacia atrás):");
        lista.mostrarHaciaAtras();

        Node nodoAEliminar = lista.buscarNodo(3);
        if (nodoAEliminar != null) {
            lista.eliminarNodo(nodoAEliminar);
            System.out.println("Lista después de eliminar el nodo con valor 3 (hacia atrás):");
            lista.mostrarHaciaAtras();
        } else {
            System.out.println("No se encontró el nodo con valor 3");
        }
        
    }
}
