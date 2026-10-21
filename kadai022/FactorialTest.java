public class FactorialTest {
    public static void main(String[] args) {
        int      [] example = new int[10];
        example[0] = 1;
        example[2] = 1;
        example[3] = 1;
        
        Factorial[] factorialList = new Factorial[10];
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