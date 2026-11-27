class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private HashMap<Integer, Node> cache;
    private int capacity;

    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        cache = new HashMap<>();

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node node = new Node(key, value);

        cache.put(key, node);
        insert(node);

        if (capacity < cache.size()) {
            Node lru = right.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(Node node) {
        Node prev = left;
        Node next = left.next;

        prev.next = node;
        node.prev = prev;

        next.prev = node;
        node.next = next;
    }
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        next.prev = prev;
        prev.next = next;
    }
}
