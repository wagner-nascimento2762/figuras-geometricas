public class TerminalShapeRenderer {
    public static void render(Shape shape) {
        System.out.println("=== Representação ASCII no Terminal: " + traduzirTipo(shape.getType()) + " ===");
        switch (shape.getType()) {
            case TRIANGLE:
                System.out.println("   /\\");
                System.out.println("  /  \\");
                System.out.println(" /    \\");
                System.out.println("/______\\");
                break;
            case RECTANGLE:
                System.out.println("+------------+");
                System.out.println("|            |");
                System.out.println("|            |");
                System.out.println("|            |");
                System.out.println("+------------+");
                break;
            case CIRCLE:
                System.out.println("   *****");
                System.out.println(" **     **");
                System.out.println("*         *");
                System.out.println("*         *");
                System.out.println(" **     **");
                System.out.println("   *****");
                System.out.println(" (Nó Central C, Raio: " + shape.getRadius() + ")");
                break;
        }
        System.out.println();
    }

    private static String traduzirTipo(ShapeType type) {
        switch (type) {
            case TRIANGLE: return "TRIÂNGULO";
            case RECTANGLE: return "RETÂNGULO";
            case CIRCLE: return "CÍRCULO";
            default: return type.name();
        }
    }
}