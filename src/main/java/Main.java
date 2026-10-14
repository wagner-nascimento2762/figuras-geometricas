public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        System.out.println("==================================================");
        System.out.println("   SISTEMA DE ESTRUTURAS DE DADOS - GEOMETRIA ");
        System.out.println("==================================================\n");

        // 1, 2, 3. Criar triângulo, retângulo e círculo através da ShapeFactory
        System.out.println("[1, 2, 3] A criar formas através da ShapeFactory...");
        Shape triangle = factory.create("triangle", 0.0, 0.0, 4.0, 0.0, 2.0, 3.0);
        Shape rectangle = factory.create("RECTANGLE", 10.0, 10.0, 5.0, 3.0);
        Shape circle = factory.create("Circle", 0.0, 0.0, 5.0);
        System.out.println("Formas criadas com sucesso!\n");

        // 4. Mostrar cada forma em ASCII no terminal
        System.out.println("[4] A apresentar representações ASCII:");
        TerminalShapeRenderer.render(triangle);
        TerminalShapeRenderer.render(rectangle);
        TerminalShapeRenderer.render(circle);

        // 5. Mostrar os objetos Connection existentes
        System.out.println("[5] A apresentar as Ligações (Connections):");
        printConnections(triangle);
        printConnections(rectangle);
        System.out.println("Ligações do Círculo: (Vazias, conforme requerido)\n");

        // 6 & 7. Percorrer as ligações usando next e mostrar previous, current, next
        System.out.println("[6 & 7] A percorrer nós do Triângulo (atual, anterior, seguinte):");
        traversePolygon(triangle);

        System.out.println("\nA percorrer nós do Retângulo (atual, anterior, seguinte):");
        traversePolygon(rectangle);

        // 8. Demonstrar que o círculo tem previous == null e next == null
        System.out.println("\n[8] A demonstrar propriedades do Círculo (C.previous == null && C.next == null):");
        Node centerNode = circle.getNodes().getHead().getNode();
        System.out.println("Nó Central: " + centerNode.getId());
        System.out.println("C.previous == null? " + (centerNode.getPrevious() == null));
        System.out.println("C.next == null? " + (centerNode.getNext() == null));
        System.out.println("Contagem de ligações do Círculo: " + circle.getConnections().size() + "\n");

        // 9. Demonstrar rejeição de forma inválida (ex: PENTAGON)
        System.out.println("[9] A demonstrar rejeição de forma inválida ('PENTAGON'):");
        try {
            factory.create("PENTAGON", 0, 0, 1, 1, 2, 2, 3, 3, 4, 4);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção esperada capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("   DEMONSTRAÇÃO CONCLUÍDA COM SUCESSO ");
        System.out.println("==================================================");
    }

    private static void printConnections(Shape shape) {
        System.out.println("Forma: " + shape.getType());
        LinkedConnectionList.Entry curr = shape.getConnections().getHead();
        while (curr != null) {
            System.out.println("  Ligação -> " + curr.getConnection());
            curr = curr.getNext();
        }
    }

    private static void traversePolygon(Shape shape) {
        Node start = shape.getStartNode();
        if (start == null) return;

        Node current = start;
        int nodeCount = shape.getNodes().size();
        int steps = 0;

        while (current != null && steps <= nodeCount) {
            Node prev = current.getPrevious();
            Node nxt = current.getNext();
            String prevId = (prev != null) ? prev.getId() : "null";
            String nextId = (nxt != null) ? nxt.getId() : "null";

            System.out.println("  [Atual: " + current.getId() + 
                               "] <-- Anterior: " + prevId + 
                               " | Seguinte: " + nextId + " -->");
            
            current = nxt;
            steps++;
            if (current == start) {
                System.out.println("  (Ciclo completo de regresso ao nó inicial: " + start.getId() + ")");
                break;
            }
        }
    }
}