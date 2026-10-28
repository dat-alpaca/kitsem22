import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Persist {
    private static final String STUDENT_FILEPATH = "student.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            PrintWriter printWriter = new PrintWriter(new FileWriter(Persist.STUDENT_FILEPATH));

            while (true) {
                System.out.print("No: ");
                String number = scanner.nextLine();

                if (number.equals("q"))
                    break;

                System.out.print("Name: ");
                String name = scanner.nextLine();

                printWriter.println(number + " " + name);
            }

            printWriter.flush();

        } catch (IOException exception) {
            System.err.print("Error: " + exception.getMessage());
        }
    }
}