package Clase_8;

class Nodo{
    char valor;
    Nodo derecha;
    Nodo izquierda;
    public Nodo(char valor) {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }
}

class ArbolBinario{
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

    
    public boolean search(char valor) {
        return searchRecursivo(this.raiz, valor);
    }

    private boolean searchRecursivo(Nodo nodo, char valor) {
        if (nodo == null) {
            return false;
        }
        if (nodo.valor == valor) {
            return true;
        }
        return searchRecursivo(nodo.izquierda, valor) || searchRecursivo(nodo.derecha, valor);
    }

    
    public void delete(char valor) {
        this.raiz = deleteRecursivo(this.raiz, valor);
    }

    private Nodo deleteRecursivo(Nodo nodo, char valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.valor) {
            nodo.izquierda = deleteRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = deleteRecursivo(nodo.derecha, valor);
        } else {
            
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            
            nodo.valor = encontrarMinimo(nodo.derecha);

            nodo.derecha = deleteRecursivo(nodo.derecha, nodo.valor);
        }

        return nodo;
    }

    private char encontrarMinimo(Nodo nodo) {
        char minimo = nodo.valor;
        while (nodo.izquierda != null) {
            minimo = nodo.izquierda.valor;
            nodo = nodo.izquierda;
        }
        return minimo;
    }

    
    public void imprimir() {
        imprimirRecursivo(this.raiz, 0);
        System.out.println();
    }

    private void imprimirRecursivo(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirRecursivo(nodo.derecha, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.valor);
            imprimirRecursivo(nodo.izquierda, nivel + 1);
        }
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.construirArbolEspecifico();

        System.out.println("Árbol original:");
        arbol.imprimir();

        // Prueba de búsqueda
        System.out.println("Búsqueda:");
        System.out.println("Valor D encontrado: " + arbol.search('D'));
        System.out.println("Valor F encontrado: " + arbol.search('F'));
        System.out.println("Valor G encontrado: " + arbol.search('G'));

        // Prueba de eliminación
        System.out.println("\nEliminando nodo D (una hoja):");
        arbol.delete('D');
        arbol.imprimir();

        System.out.println("\nEliminando nodo B (con dos hijos):");
        arbol.delete('B');
        arbol.imprimir();

        System.out.println("\nEliminando nodo A (la raíz):");
        arbol.delete('A');
        arbol.imprimir();
    }
}