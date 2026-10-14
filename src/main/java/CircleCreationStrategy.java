public class CircleCreationStrategy implements ShapeCreationStrategy {
    @Override
    public ShapeType supportedType() {
        return ShapeType.CIRCLE;
    }

    @Override
    public int expectedParameterCount() {
        return 3; // x, y, radius
    }

    @Override
    public Shape create(double... values) {
        if (values == null || values.length != 3) {
            throw new IllegalArgumentException("Circle requires exactly 3 parameters (x, y, radius).");
        }

        double x = values[0];
        double y = values[1];
        double radius = values[2];

        if (radius <= 0) {
            throw new IllegalArgumentException("Circle radius must be positive.");
        }

        // Representação coerente do Círculo: Nó de referência central C
        // C.previous = null, C.next = null, lista de Connection vazia.
        Node cNode = new Node("C", x, y);
        cNode.setPrevious(null);
        cNode.setNext(null);

        Shape shape = new Shape(ShapeType.CIRCLE);
        shape.setRadius(radius);
        shape.getNodes().add(cNode);

        return shape;
    }
}