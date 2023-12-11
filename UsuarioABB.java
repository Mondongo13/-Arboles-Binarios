// Clase principal que utiliza la implementación de Árboles Binarios de Búsqueda (ABB)
public class UsuarioABB {
    public static void main(String[] args) {
        // Crear un objeto de la clase ArbolBinarioBusqueda
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        // Insertar nodos en el árbol 25, 8, 29, 38, 27
        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(27);

        // Mostrar el árbol horizontalmente
        System.out.println("Árbol de forma horizontal:");
        arbol.imprimirHorizontal(0, arbol.obtenerRaiz());

        // Realizar recorridos en orden, preorden y postorden
        System.out.println("\nRecorrido en orden (inorden):");
        arbol.recorrerInOrden(arbol.obtenerRaiz());
        System.out.println("\nRecorrido en preorden:");
        arbol.recorrerPreOrden(arbol.obtenerRaiz());
        System.out.println("\nRecorrido en postorden:");
        arbol.recorrerPostOrden(arbol.obtenerRaiz());

        // Buscar un valor en el árbol
        int valorBuscado = 29;
        if (arbol.buscarValor(valorBuscado, arbol.obtenerRaiz()))
            System.out.println("\nEl valor " + valorBuscado + " se encuentra en el árbol.");
        else
            System.out.println("\nEl valor " + valorBuscado + " no se encuentra en el árbol.");

        // Eliminar todos los nodos del árbol
        arbol.eliminarPredecesor(8, arbol.obtenerRaiz());
        System.out.println("Árbol después de eliminar el nodo 8:");
        arbol.imprimirHorizontal(0, arbol.obtenerRaiz());
    }
}