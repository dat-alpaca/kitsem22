public class TryOverload {
    private int valInt;
    private String valString;
    private double valDouble;

    public int getValInt()       { return this.valInt; }
    public String getValString() { return this.valString; }
    public double getValDouble() { return this.valDouble; }

    public void setValue(int number)    { this.valInt = number; }
    public void setValue(String string) { this.valString = string; }
    public void setValue(double number) { this.valDouble = number; }

    public static int times(int value1, int value2) { return value1 * value2; }
    public static String times(String string, int number)
    {
        String result = "";
        for (int i = 0; i < number; i++)
            result += string;

        return result;
    }
    public static String times(int number, String string)
    {
        String result = "";
        for (int i = 0; i < number; i++)
            result += string;

        return result;
    }
    public static String times(String str1, String str2)
    {
        return str1 + str2;
    }

    public static void main(String[] args) {
        TryOverload overload = new TryOverload();

        // Testing set int
        {
            overload.setValue(1020);
            System.out.printf("valInt: %d\n", overload.getValInt());
        }

        // Testing set string
        {
            overload.setValue("Hello");
            System.out.printf("valString: %s\n", overload.getValString());
        }

        // Testing set double
        {
            overload.setValue(312.14324);
            System.out.println("valDouble = " + overload.getValDouble());
        }

        // Testing times
        {
            System.out.printf("%d x %d = %d \n", 3, 4, TryOverload.times(3, 4));
            System.out.printf("%s * %d = %s \n", "Happy", 3, TryOverload.times("Happy ", 3));
            System.out.printf("%d * %s = %s \n", 4, "Birthday", TryOverload.times(4, "Birthday "));
            System.out.printf("%s + %s = %s \n", "Happy ", "Birthday!", TryOverload.times("Happy ", "Birthday!"));
        }
    }
}