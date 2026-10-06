public class Calc {
    static int[] numbers = { 10, 12, 8, 16, 20, 6, 24, 32 };

    public static void main(String[] args) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        float average = 0.0f;

        for (int number : numbers) {
            if (number >= maximum)
                maximum = number;

            if (number <= minimum)
                minimum = number;

            average += (float)number / numbers.length;
        }

        System.out.println();
        System.out.printf("Minimum: %d\n", minimum);
        System.out.printf("Maximum: %d\n", maximum);
        System.out.printf("Average: %f\n", average);

        // or: var stats = java.util.Arrays.stream(numbers).summaryStatistics();
    }
}
