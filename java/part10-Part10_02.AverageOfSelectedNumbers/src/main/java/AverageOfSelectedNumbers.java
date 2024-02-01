import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }

            inputs.add(row);
        }
        System.out.println("Print the average of the negative numbers or positive numbers? (n/p)");

        String input = scanner.nextLine();

        if(input.equals("p")){
            double average = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number > 0 )
                    .average()
                    .getAsDouble();

            System.out.println("Average of the positive numbers: " + average);

        } else {
            double average = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number < 0 )
                    .average()
                    .getAsDouble();

            System.out.println("Average of the negative numbers: " + average);
        }


        scanner.close();
    }
}