public class LinkedNodeList {
    public static class Entry {
        private Node node;
        private Entry next;

        public Entry(Node node) {
            this.node = node;
            this.next = null;
        }

        public Node getNode() {
            return node;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }

    private Entry head;
    private Entry tail;
    private int size;

    public LinkedNodeList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Node node) {
        Entry newEntry = new Entry(node);
        if (head == null) {
            head = newEntry;
            tail = newEntry;
        } else {
            tail.setNext(newEntry);
            tail = newEntry;
        }
        size++;
    }

    public Entry getHead() {
        return head;
    }

    public int size() {
        return size;
    }
}