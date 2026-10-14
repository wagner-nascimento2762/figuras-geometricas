public class Connection {
    private Node from;
    private Node to;

    public Connection(Node from, Node to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Connection nodes cannot be null.");
        }
        this.from = from;
        this.to = to;
        // Atualiza obrigatoriamente os nós envolvidos
        from.setNext(to);
        to.setPrevious(from);
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    @Override
    public String toString() {
        return from.getId() + " -> " + to.getId();
    }
}