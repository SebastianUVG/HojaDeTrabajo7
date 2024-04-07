package uvg.edu.gt;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    private class Node<E> {
        private E key;
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E key, E value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        this.root = null;
    }

    public void add(E key, E value) {
        this.root = addRecursive(this.root, key, value);
    }

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

    public E get(E key) {
        return getRecursive(root, key);
    }

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
