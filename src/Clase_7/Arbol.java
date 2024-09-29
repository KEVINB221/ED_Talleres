package Clase_7;

class Node{

    char letra;
    Node izquierdo;
    Node derecho;
    
    public Node(char letra){
        this.letra = letra;
        this.derecho = null;
        this.izquierdo = null;
    }
}

class ArbolBinario{
    Node raiz;

    public ArbolBinario(){
        this.raiz = null;
    }

    public void inorden(Node nodo){
        if (nodo == null) {
            return;
        }
        inorden(nodo.izquierdo);
        System.out.print(nodo.letra + " ");
        inorden(nodo.derecho);
    }

    public void preorden(Node nodo){
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.letra + " ");
        preorden(nodo.izquierdo);

        preorden(nodo.derecho);
    }

    public void postorden(Node nodo){
        if (nodo == null) {
            return;
        }
        postorden(nodo.izquierdo);
        postorden(nodo.derecho);
        System.out.print(nodo.letra + " ");
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.raiz = new Node('A');
        arbol.raiz.izquierdo = new Node('B');
        arbol.raiz.derecho = new Node('C');
        arbol.raiz.izquierdo.izquierdo = new Node('D');
        arbol.raiz.izquierdo.derecho = new Node('E');
        arbol.raiz.derecho.derecho = new Node('F');
        System.out.println("Recorrido Inorden:");
        arbol.inorden(arbol.raiz); 

        System.out.println("\nRecorrido Preorden:");
        arbol.preorden(arbol.raiz); 

        System.out.println("\nRecorrido Postorden:");
        arbol.postorden(arbol.raiz); 
    }

}