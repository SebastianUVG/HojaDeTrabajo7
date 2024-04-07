package uvg.edu.gt;

/**
 * Codigo inspirado en los documentos que brindo el profesor
 * Implementación de un par clave-valor.
 * <p>
 * En esta implementación se pueden almacenar pares de valores clave-valor de
 * cualquier tipo, siempre y cuando el tipo de la clave implemente la interfaz
 * {@link Comparable}.
 * <p>
 * Los métodos {@link #compareTo(Association) compareTo} y
 * {@link #toString() toString} se han sobreescrito para que los objetos
 * {@code Association} puedan compararse y mostrarse de manera más
 * legible.
 *
 * @param <K> tipo de la clave
 * @param <V> tipo del valor
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {

    /**
     * Clave de la clase.
     */
    private final K key;

    /**
     * Valor del valor.
     */
    private final V value;

    /**
     * Crea un nuevo par clave-valor.
     *
     * @param key clave
     * @param value valor
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Devuelve la clave del par.
     *
     * @return clave
     */
    public K getKey() {
        return this.key;
    }

    /**
     * Devuelve el valor del par.
     *
     * @return valor
     */
    public V getValue() {
        return this.value;
    }

  
    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Association<K, V> other) {
        /*
         * Si el objeto other es nulo, devuelve 1, ya que este objeto
         * Association es mayor que null.
         */
        if (other == null) {
            return 1;
        }

        /*
         * Si el campo key de este objeto Association es nulo, entonces
         * devuelve 0 si el campo key de other es nulo también, o -1
         * si el campo key de other no es nulo.
         */
        if (this.key == null) {
            return other.key == null ? 0 : -1;
        }

        /*
         * Si el campo key de other es nulo, devuelve 1, ya que este objeto
         * Association es mayor que null.
         */
        if (other.key == null) {
            return 1;
        }

        /*
         * Si los campos key de ambos objetos no son nulos, entonces
         * se llama al método compareTo del tipo de la clave para comparar
         * las claves de ambos objetos.
         */
        return this.key.compareTo(other.key);
    }



    /**
     * 
     * Devuelve una representación de cadena del par clave-valor.
     *
     * @return cadena con la representación del par
     */
    @Override
    public String toString() {
        // Formato de la cadena: (clave valor)
        return String.format("(%s %s)", this.key, this.value);
    }

}

