public class FactorialTest {
    private static final int FACTORIAL_COUNT = 10;

    public static void main(String[] args) {
        Factorial[] factorialList = new Factorial[FACTORIAL_COUNT];

        for (int i = 0; i < factorialList.length; i++) {
            factorialList[i] = new Factorial();
            var factorial = factorialList[i];

            factorial.setNum(i);

            if (i == 0)
                factorial.setFact(1);
            else
                factorial.setFact(factorialList[i - 1].getFact() * i);
        }

        for (Factorial f : factorialList)
            System.out.println("num = " + f.getNum() + ", fact = " + f.getFact());
    }
}