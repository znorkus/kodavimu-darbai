
public class NullPointerExceptionProgram {

    public static void main(String[] args) {
        // Implement a program so  that it causes 
        // the NullPointerException error


        Person Joan;
        Person joan = new Person();
        System.out.println(joan);


        joan = null;
        System.out.println(joan);
        joan.print();
    }
}
