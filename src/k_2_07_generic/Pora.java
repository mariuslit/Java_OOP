package k_2_07_generic;

public interface Pora<K, V> {

    K getKey();

    void setKey(K key);

    V getValue();

    void setValue(V value);

    V returnValueByKey(K key);
}
