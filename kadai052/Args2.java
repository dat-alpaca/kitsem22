import java.util.ArrayList;
import java.util.List;

public class Args2 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();

        for (String arg : args) {
            try {
                ints.add(Integer.valueOf(arg));
            } catch (NumberFormatException _) {
                try {
                    doubles.add(Double.valueOf(arg));
                } catch (NumberFormatException _) {
                    strings.add(arg);
                }
            } 
        }

        System.err.println("Strings: " + strings);
        System.err.println("Integers: " + ints);
        System.err.println("Doubles: " + doubles);
    }
}