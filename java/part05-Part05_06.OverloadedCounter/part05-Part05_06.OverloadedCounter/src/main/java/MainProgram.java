
public class MainProgram {

    public static void main(String[] args) {
        // Test your counter here
        Counter counter = new Counter();
        System.out.println(counter.value());

        counter.increase(9);
        System.out.println(counter.value());
    }

}
