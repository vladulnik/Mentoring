package problemSolvingClasses.workWithFinal;

public class Library {

    private final Book[] books;
    private int count = 0;

    public Library(int capacity) {
        this.books = new Book[capacity];
    }

    public void addBook(Book book) {
        if(count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("No more space");
        }
    }

    public void printBooks() {
        for(int i = 0; i < count; i++) {
            System.out.println(books[i].getTitle());
        }
    }
}
