import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        numbers.add(-4);
        numbers.add(5);
        numbers.add(-6);

        List<Integer> positiveNumbers = positive(numbers);
        System.out.println("Positive Numbers: " + positiveNumbers);

    }

    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> positiveNumbers = numbers.stream()
                .filter(value -> value > 0)
                .collect(Collectors.toCollection(ArrayList::new));

        return positiveNumbers;
    }
}