package uvg.edu.gt;

/**
 * Esta clase implementa un árbol binario para almacenar pares clave-valor
 * de cualquier tipo, siempre y cuando el tipo de la clave implemente la
 * interfaz {@link Comparable}.
 *
 * Cada nodo del árbol almacena una clave y un valor, y puede tener dos
 * subárboles descendientes: uno izquierdo (left) y otro derecho (right).
 *
 * Las operaciones {@link #add(Comparable, Object) add},
 * {@link #get(Comparable) get} y {@link #size() size} tienen complejidad
 * O(log n) en el peor de los casos.
 *
 * @param <E> tipo de la clave
 */
public class BinaryTree<E extends Comparable<E>> {

    /**
     * Raíz del árbol. Si es {@code null}, el árbol está vacío.
     */
    private Node<E> root;

    /**
     * Nodo del árbol binario. Almacena una clave y un valor, y puede tener dos
     * subárboles descendientes: uno izquierdo (left) y otro derecho (right).
     *
     * @param <E> tipo de la clave
     */
    private class Node<E> {

        /**
         * Clave del nodo.
         */
        private E key;

        /**
         * Valor asociado a la clave en el nodo.
         */
        private E value;

        /**
         * Subárbol izquierdo.
         */
        private Node<E> left;

        /**
         * Subárbol derecho.
         */
        private Node<E> right;

        /**
         * Crea un nuevo nodo con la clave y el valor especificados.
         *
         * @param key   clave del nodo
         * @param value valor asociado a la clave en el nodo
         */
        public Node(E key, E value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Crea un nuevo árbol binario vacío.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Agrega un nuevo par clave-valor al árbol. Si la clave ya existe en el
     * árbol, su valor es actualizado con el valor especificado.
     *
     * @param key   clave del par clave-valor a agregar
     * @param value valor asociado a la clave
     */
    public void add(E key, E value) {
        this.root = addRecursive(this.root, key, value);
    }

    /**
     * Agrega un nuevo par clave-valor al árbol de manera recursiva.
     *
     * @param current nodo actual
     * @param key     clave del par clave-valor a agregar
     * @param value   valor asociado a la clave
     * @return nodo actualizado
     */
    private Node<E> addRecursive(Node<E> current, E key, E value) {
        if (current == null) {
            return new Node<>(key, value);
        }

        int comparison = key.compareTo(current.key);
        if (comparison < 0) {
            current.left = addRecursive(current.left, key, value);
        } else if (comparison > 0) {
            current.right = addRecursive(current.right, key, value);
        } else {
            // Key already exists, update value
            current.value = value;
        }

        return current;
    }

    /**
     * Devuelve el valor asociado a la clave especificada en el árbol.
     *
     * @param key clave de la que se desea obtener el valor
     * @return valor asociado a la clave, o {@code null} si la clave no existe
     */
    public E get(E key) {
        return getRecursive(root, key);
    }

    /**
     * Devuelve el valor asociado a la clave especificada en el árbol de manera
     * recursiva.
     *
     * @param current nodo actual
     * @param key     clave de la que se desea obtener el valor
     * @return valor asociado a la clave, o {@code null} si la clave no existe
     */
    private E getRecursive(Node<E> current, E key) {
        if (current == null) {
            return null; // Key not found
        }

        int comparison = key.compareTo(current.key);
        if (comparison == 0) {
            return current.value;
        } else if (comparison < 0) {
            return getRecursive(current.left, key);
        } else {
            return getRecursive(current.right, key);
        }
    }
}
