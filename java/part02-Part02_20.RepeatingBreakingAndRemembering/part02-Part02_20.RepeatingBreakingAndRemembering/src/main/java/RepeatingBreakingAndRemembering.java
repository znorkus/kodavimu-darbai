
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give numbers:");

        int sum = 0;
        int ones = 0;
        int even = 0;
        int odd = 0;

        while (true) {
            int number = Integer.valueOf(scanner.nextLine());

            if (number == -1) {
                break;
            }

            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            sum = sum + number;
            ones = ones + 1;
        }
        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + ones);
        System.out.println("Average: " + 1.0 * sum / ones);
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}