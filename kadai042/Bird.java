public class Bird {
    private String name;
    private static int numBird = 0;

    public Bird(String name) {
        this.name = name;
        Bird.numBird++;
    }

    public Bird() {
        Bird.numBird++;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public static int getNum() { return Bird.numBird; }

    public static void main(String[] args) {
        var _ = new Bird();
        var _ = new Chicken();
        var _ = new Chicken();
        var _ = new Penguin();
        var _ = new Penguin();
        var _ = new Penguin();

        System.out.println("Birds   : " + Bird.getNum());
        System.out.println("Chickens: " + Chicken.getNum());
        System.out.println("Penguins: " + Penguin.getNum());
    }
}

class Chicken extends Bird {
    private static int numChicken = 0;

    public Chicken() {
        super("Chicken");
        Chicken.numChicken++;
    }

    public static int getNum() { return Chicken.numChicken; }
}

class Penguin extends Bird {
    private static int numPenguin = 0;

    public Penguin() {
        super("Penguin");
        Penguin.numPenguin++;
    }

    public static int getNum() { return Penguin.numPenguin; }
}