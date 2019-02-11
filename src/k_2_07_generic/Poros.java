package k_2_07_generic;

public class Poros<K, V> implements Pora<K, V> {

    public K key;
    public V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public V returnValueByKey(K key) {
        return value;
    }
}
