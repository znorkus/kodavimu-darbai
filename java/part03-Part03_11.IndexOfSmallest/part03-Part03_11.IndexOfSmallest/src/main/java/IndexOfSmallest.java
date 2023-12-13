
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 9999) {
                break;
            }

            list.add(input);
        }

        System.out.println("");

        int smallest = list.get(0);
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (smallest > number) {
                smallest = number;
                index = i;
            }

            if (list.get(i) == index) {

            }
        }
        System.out.println("The smallest number: " + smallest);
        System.out.println("Found at Index : " + index);
    }
}


// implement here finding the indices of a number

// implement here a program that reads user input
// until the user enters 9999
// after that, the program prints the smallest number
// and its index -- the smallest number
// might appear multiple times