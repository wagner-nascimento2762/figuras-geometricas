public interface ShapeCreationStrategy {
    ShapeType supportedType();
    int expectedParameterCount();
    Shape create(double... values);
}