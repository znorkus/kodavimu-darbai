
public class FromParameterToOne {

    public static void main(String[] args) {
        printFromNumberToOne(5);
    }

    public static void printFromNumberToOne(int numOfTimes) {

        for (int i = numOfTimes; i > 0; i--) {
            System.out.println(i);
        }
    }
}
