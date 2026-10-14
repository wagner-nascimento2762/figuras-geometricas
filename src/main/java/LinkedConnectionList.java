public class LinkedConnectionList {
    public static class Entry {
        private Connection connection;
        private Entry next;

        public Entry(Connection connection) {
            this.connection = connection;
            this.next = null;
        }

        public Connection getConnection() {
            return connection;
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

    public LinkedConnectionList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Connection connection) {
        Entry newEntry = new Entry(connection);
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