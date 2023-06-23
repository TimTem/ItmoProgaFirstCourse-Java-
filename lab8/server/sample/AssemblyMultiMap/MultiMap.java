package sample.AssemblyMultiMap;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MultiMap<K, V> implements Serializable {
    @Serial
    private static final long serialVersionUID = 32132321L;
    private Map<K, V> map;

    public MultiMap() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    public int size() {
        return map.size();
    }
}