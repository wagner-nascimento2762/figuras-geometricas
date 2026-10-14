public class RectangleCreationStrategy implements ShapeCreationStrategy {
    @Override
    public ShapeType supportedType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public int expectedParameterCount() {
        return 4; // x, y, width, height
    }

    @Override
    public Shape create(double... values) {
        if (values == null || values.length != 4) {
            throw new IllegalArgumentException("Rectangle requires exactly 4 parameters (x, y, width, height).");
        }

        double x = values[0];
        double y = values[1];
        double width = values[2];
        double height = values[3];

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Rectangle width and height must be positive.");
        }

        Node r1 = new Node("R1", x, y);
        Node r2 = new Node("R2", x + width, y);
        Node r3 = new Node("R3", x + width, y + height);
        Node r4 = new Node("R4", x, y + height);

        Shape shape = new Shape(ShapeType.RECTANGLE);
        shape.getNodes().add(r1);
        shape.getNodes().add(r2);
        shape.getNodes().add(r3);
        shape.getNodes().add(r4);

        // Ligações fechadas: R1 -> R2 -> R3 -> R4 -> R1
        Connection c1 = new Connection(r1, r2);
        Connection c2 = new Connection(r2, r3);
        Connection c3 = new Connection(r3, r4);
        Connection c4 = new Connection(r4, r1);

        shape.getConnections().add(c1);
        shape.getConnections().add(c2);
        shape.getConnections().add(c3);
        shape.getConnections().add(c4);

        return shape;
    }
}