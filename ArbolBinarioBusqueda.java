/**
 * Tarea Unidad 4 - Árboles Binarios
 * Nombre: Julio Mauricio Velázquez Monsrreal
 * Fecha: 10 de diciembre de 2023
 * Tarea: Unidad 4 - Árboles Binarios
 */

// Clase para el manejo de Árboles Binarios de Búsqueda (ABB)
public class ArbolBinarioBusqueda {
    private Nodo raiz;

    // Constructor
    public ArbolBinarioBusqueda(){
        this.raiz = null;
    } 

    // Verifica si el árbol está vacío
    public boolean estaVacio(){
        return (this.raiz == null); 
    }

    // Obtener la raíz del árbol
    public Nodo obtenerRaiz(){
        return this.raiz;
    }

    // Insertar un valor en el árbol
    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        } else {
            insertarNodo(valor, this.raiz);
        }
    }

    // Método privado para insertar un nodo en el árbol
    private void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            } else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        } else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                } else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }

    // Imprimir el árbol de forma horizontal
    public void imprimirHorizontal(int nivel, Nodo nodoRef){
        if(nodoRef == null){
            return; 
        } else {
            imprimirHorizontal(nivel + 1, nodoRef.derecho);

            for(int i=0; i < nivel; i++){
                System.out.print("   ");
            }

            System.out.println("["+ nodoRef.dato + "]");
            imprimirHorizontal(nivel + 1, nodoRef.izquierdo);
        }
    }

    // Recorrer el árbol en orden (inorden)
    public void recorrerInOrden(Nodo nodoRef){
        if(nodoRef == null)
            return; 
        recorrerInOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        recorrerInOrden(nodoRef.derecho);
    }

    // Recorrer el árbol en preorden
    public void recorrerPreOrden(Nodo nodoRef){
        if(nodoRef == null)
            return; 
        System.out.print(nodoRef.dato + " - ");
        recorrerPreOrden(nodoRef.izquierdo);
        recorrerPreOrden(nodoRef.derecho);
    }

    // Recorrer el árbol en postorden
    public void recorrerPostOrden(Nodo nodoRef){
        if(nodoRef == null)
            return; 
        recorrerPostOrden(nodoRef.izquierdo);
        recorrerPostOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }

    // Buscar un valor en el árbol
    public boolean buscarValor(int x, Nodo nodoRef){
        if (nodoRef == null)
            return false;
        else if(x < nodoRef.dato)
            return buscarValor(x, nodoRef.izquierdo);
        else if(x > nodoRef.dato)
            return buscarValor(x, nodoRef.derecho);
        else 
            return true; 
    }

    // Podar el árbol eliminando todos los nodos
    public void podarArbol(Nodo nodoRef){
        if(nodoRef == null)
            return; 

        // Eliminar el subárbol izquierdo
        podarArbol(nodoRef.izquierdo);
        // Eliminar el subárbol derecho
        podarArbol(nodoRef.derecho);
        // Eliminar el nodo actual
        nodoRef = null;
    }

    // Buscar el nodo con el valor más grande en el árbol
    public Nodo buscarMayor(Nodo nodoRef) {
        if (nodoRef == null) {
            return null;
        } else if (nodoRef.derecho == null) {
            return nodoRef;
        } else {
            return buscarMayor(nodoRef.derecho);
        }
    }

    // Eliminar el predecesor de un nodo con valor x
    public void eliminarPredecesor(int x, Nodo nodoRef) {
        if (nodoRef == null) {
            return;
        } else if (x < nodoRef.dato) {
            eliminarPredecesor(x, nodoRef.izquierdo);
        } else if (x > nodoRef.dato) {
            eliminarPredecesor(x, nodoRef.derecho);
        } else if (nodoRef.izquierdo != null && nodoRef.derecho != null) {
            Nodo mayor = buscarMayor(nodoRef.izquierdo);
            nodoRef.dato = mayor.dato;
            eliminarPredecesor(mayor.dato, nodoRef.izquierdo);
        } else {
            if (nodoRef.izquierdo == null) {
                nodoRef = nodoRef.derecho;
            } else if (nodoRef.derecho == null) {
                nodoRef = nodoRef.izquierdo;
            }
        }
    }
}

