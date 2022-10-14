package leetcode.task706;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    private final static int BUCKETS_SIZE = 16;
    private final List<LinkedList<Node>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(BUCKETS_SIZE);
        for (int i = 0; i < BUCKETS_SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void put(int key, int value) {
        int bucket = key % BUCKETS_SIZE;
        LinkedList<Node> nodesInBucket = buckets.get(bucket);

        boolean valueOverwritten = false;
        for (Node nodeInBucket : nodesInBucket) {
            if (nodeInBucket.key == key) {
                nodeInBucket.value = value;
                valueOverwritten = true;
                break;
            }
        }
        if (!valueOverwritten) {
            nodesInBucket.add(new Node(key, value));
        }
    }

    public int get(int key) {
        int bucket = key % BUCKETS_SIZE;
        LinkedList<Node> nodes = buckets.get(bucket);
        for (Node node : nodes) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = key % BUCKETS_SIZE;
        LinkedList<Node> nodes = buckets.get(bucket);

        for (Node node : nodes) {
            if (node.key == key) {
                nodes.remove(node);
                return;
            }
        }
    }

    private static class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;
        int value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
