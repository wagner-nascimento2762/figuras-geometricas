import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private final Map<ShapeType, ShapeCreationStrategy> strategies;

    public ShapeFactory() {
        strategies = new HashMap<>();
        registerStrategy(new TriangleCreationStrategy());
        registerStrategy(new RectangleCreationStrategy());
        registerStrategy(new CircleCreationStrategy());
    }

    public void registerStrategy(ShapeCreationStrategy strategy) {
        strategies.put(strategy.supportedType(), strategy);
    }

    public Shape create(String typeStr, double... values) {
        if (typeStr == null) {
            throw new IllegalArgumentException("Shape type cannot be null.");
        }

        ShapeType type;
        try {
            type = ShapeType.valueOf(typeStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid shape type: '" + typeStr + "'. Allowed types are TRIANGLE, RECTANGLE, CIRCLE.");
        }

        ShapeCreationStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy registered for shape type: " + type);
        }

        return strategy.create(values);
    }
}