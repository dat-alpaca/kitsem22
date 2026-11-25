public class Circle extends Shape {
    private int radius;

    public void setRadius(int r) {
        this.radius = r;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public float calcArea() {
        float r;

        r = getRadius();
        return (float)(3.14f * r * r);
    }
}