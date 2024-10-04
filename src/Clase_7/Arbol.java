package Clase_7;

class Nodo {
    char valor;
    Nodo derecha;
    Nodo izquierda;
    public Nodo(char valor) {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void construirArbolEspecifico() {
        this.raiz = new Nodo('A');
        this.raiz.izquierda = new Nodo('B');
        this.raiz.derecha = new Nodo('C');
        this.raiz.izquierda.izquierda = new Nodo('D');
        this.raiz.izquierda.derecha = new Nodo('E');
        this.raiz.derecha.derecha = new Nodo('F');
    }

    
    public void inorden() {
        inordenRecursivo(this.raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inordenRecursivo(nodo.derecha);
        }
    }

    public void postorden() {
        postordenRecursivo(this.raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierda);
            postordenRecursivo(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    public void preorden() {
        preordenRecursivo(this.raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRecursivo(nodo.izquierda);
            preordenRecursivo(nodo.derecha);
        }
    }

    // Método main para demostrar la construcción y recorrido del árbol
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        
        System.out.println("Construyendo el árbol específico...");
        arbol.construirArbolEspecifico();
        
        System.out.println("Recorrido en inorden:");
        arbol.inorden();
        
        System.out.println("Recorrido en postorden:");
        arbol.postorden();
        
        System.out.println("Recorrido en preorden:");
        arbol.preorden();
    }
}