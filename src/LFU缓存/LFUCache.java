package LFU缓存;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private int capacity;

    private int cur = 0;

    private Map<Integer, Node> values;

    /*
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        values = new HashMap<>(capacity, 0.75f);
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        Node n = values.get(key);
        if (n != null) {
            n.useCount++;
            n.lastGetTime = System.nanoTime();
            n.value = value;
        } else {
            Node node = new Node();
            node.value = value;
            node.useCount = 0;
            node.lastGetTime = System.nanoTime();
            if (this.capacity == 0) return;
            if (cur < this.capacity) {
                cur++;
                values.put(key, node);
            } else {
                removeLast();
                values.put(key, node);
            }
        }
    }

    private void removeLast() {
        int minCount = Integer.MAX_VALUE;
        long getTime = System.nanoTime();
        Integer t = null;

        for (Integer key : values.keySet()) {
            Node node = values.get(key);
            if (node.useCount < minCount || (node.useCount == minCount && node.lastGetTime < getTime)) {
                t = key;
                minCount = node.useCount;
                getTime = node.lastGetTime;
            }
        }
        values.remove(t);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        Node node = values.get(key);
        if (node == null) {
            return -1;
        }
        node.useCount++;
        node.lastGetTime = System.nanoTime();
        return node.value;
    }

    public class Node {
        public int value;
        public int useCount;
        public long lastGetTime;
    }
}
