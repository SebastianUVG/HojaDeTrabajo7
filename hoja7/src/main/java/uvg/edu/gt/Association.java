package uvg.edu.gt;

public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {

    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    @Override
    public int compareTo(Association<K, V> other) {
        if (other == null){
            return 1;
        }
        if (this.key == null) {
            return other.key == null ? 0 : -1;
        }
        if (other.key == null){
            return 1;
        }
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString(){
        return "(" + key + " " + value + ")";
    }

}
