public class Shape {
    private String name;

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public String whoareyou() {
        return "I am a " + name + ".";
    }

    public float calcArea() {
        return 0.0f;
    }

    public static void main(String[] args) {
        Shape shape0 = new Shape();
        shape0.setName("Shape");

        Circle circle1 = new Circle();
        circle1.setName("circle");
        circle1.setRadius(5);

        Circle circle2 = new Circle();
        circle2.setName("circle");
        circle2.setRadius(10);

        Square square1 = new Square();
        square1.setName("square");
        square1.setSide(4);

        Square square2 = new Square();
        square2.setName("square");
        square2.setSide(7);

        Shape[] shapeArray = { shape0, circle1, circle2, square1, square2 };

        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println(shapeArray[i].whoareyou());
            System.out.println("Area = " + shapeArray[i].calcArea());
        }
    }
}