package Generics;

public class KeyValuePairs<K, V> extends Utils {
    private K key;
    private V value;
    public KeyValuePairs(K key, V value) {
        this.key = key;
        this.value = value;
        print(key, value);
    }
}
