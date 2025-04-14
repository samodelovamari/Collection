package collection.hashmap.realization;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private ArrayList<LinkedList<Entry<K, V>>> buckets;

    public HashMap() {
        buckets = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    /**
     * Метод put().
     * Добавляет значение в HashMap с указанным ключом.
     * @param key ключ, по которому необходимо добавить значение
     * @param value значение для добавления
     */

    public void put(K key, V value) {
        int index = key.hashCode() % DEFAULT_CAPACITY;
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    /**
     * Метод get().
     * Получает значение из HashMap по указанному ключу.
     * @param key ключ, по которому необходимо получить значение
     * @return значение, соответствующее указанному ключу, или null, если ключ не найден
     */

    public V get(K key) {
        int index = key.hashCode() % DEFAULT_CAPACITY;
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }


    /**
     * Метод size().
     * Возвращает количество элементов в HashMap.
     * @return количество элементов в HashMap
     */

    public int size() {
        int size = 0;
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            size += bucket.size();
        }
        return size;
    }

    /**
     * Метод remove().
     * Удаляет значение из HashMap по указанному ключу.
     * @param key ключ, по которому необходимо удалить значение
     */

    public void remove(K key) {
        int index = key.hashCode() % DEFAULT_CAPACITY;
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Value for key 'Two': " + map.get("Two"));

    }
}