public class Book implements Packable {

    private String author;
    private String nameOfBook;
    private double weight;

    public Book(String author, String nameOfBook, double weight) {
        this.author = author;
        this.nameOfBook = nameOfBook;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.nameOfBook;
    }
}
