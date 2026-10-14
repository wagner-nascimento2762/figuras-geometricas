public class Shape {
    private ShapeType type;
    private LinkedNodeList nodes;
    private LinkedConnectionList connections;
    private double radius; // Utilizado apenas para CIRCLE

    public Shape(ShapeType type) {
        this.type = type;
        this.nodes = new LinkedNodeList();
        this.connections = new LinkedConnectionList();
        this.radius = 0.0;
    }

    public ShapeType getType() {
        return type;
    }

    public LinkedNodeList getNodes() {
        return nodes;
    }

    public LinkedConnectionList getConnections() {
        return connections;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Node getStartNode() {
        if (nodes.getHead() != null) {
            return nodes.getHead().getNode();
        }
        return null;
    }
}