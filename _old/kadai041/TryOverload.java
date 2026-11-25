public class TryOverload {
    private int valInt;
    private String valString;
    private double valDouble;

    public int getValInt()       { return valInt; }
    public String getValString() { return valString; }
    public double getValDouble() { return valDouble; }

    public void setValInt(int data)       { valInt    = data; }
    public void setValString(String data) { valString = data; }
    public void setValDouble(double data) { valDouble = data; }

    public void setValue(int data)    { valInt    = data; }
    public void setValue(String data) { valString = data; }
    public void setValue(double data) { valDouble = data; }

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