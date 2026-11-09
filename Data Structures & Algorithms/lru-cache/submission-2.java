class LRUCache {
    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node removed = cache.get(key);
            removed.prev.next = removed.next;
            removed.next.prev = removed.prev;

            tail.prev.next = removed;
            removed.prev = tail.prev;
            removed.next = tail;
            tail.prev = removed;
            cache.put(key, removed);
            return cache.get(key).value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value = value;
            //its been "used"
            this.get(key);
        } else {
            if(cache.size() + 1 > capacity){
                Node removed = head.next;
                removed.prev.next = removed.next;
                removed.next.prev = removed.prev;
                cache.remove(removed.key);
            }
            Node temp = new Node(key, value);
            tail.prev.next = temp;
            temp.prev = tail.prev;
            temp.next = tail;
            tail.prev = temp;
            cache.put(key, temp);
        }
    }
}

class Node {
    private int key;
    private int value;
    private Node prev;
    private Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
