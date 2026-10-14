public class TriangleCreationStrategy implements ShapeCreationStrategy {
    @Override
    public ShapeType supportedType() {
        return ShapeType.TRIANGLE;
    }

    @Override
    public int expectedParameterCount() {
        return 6; // x1, y1, x2, y2, x3, y3
    }

    @Override
    public Shape create(double... values) {
        if (values == null || values.length != 6) {
            throw new IllegalArgumentException("Triangle requires exactly 6 parameters (x1, y1, x2, y2, x3, y3).");
        }

        Node t1 = new Node("T1", values[0], values[1]);
        Node t2 = new Node("T2", values[2], values[3]);
        Node t3 = new Node("T3", values[4], values[5]);

        // Validação de colinearidade (área do triângulo por determinante deve ser > 0)
        double area = 0.5 * Math.abs(t1.getX() * (t2.getY() - t3.getY()) +
                                     t2.getX() * (t3.getY() - t1.getY()) +
                                     t3.getX() * (t1.getY() - t2.getY()));
        if (area == 0.0) {
            throw new IllegalArgumentException("Triangle points cannot be collinear.");
        }

        Shape shape = new Shape(ShapeType.TRIANGLE);
        shape.getNodes().add(t1);
        shape.getNodes().add(t2);
        shape.getNodes().add(t3);

        // Ligações fechadas: T1 -> T2 -> T3 -> T1
        Connection c1 = new Connection(t1, t2);
        Connection c2 = new Connection(t2, t3);
        Connection c3 = new Connection(t3, t1);

        shape.getConnections().add(c1);
        shape.getConnections().add(c2);
        shape.getConnections().add(c3);

        return shape;
    }
}