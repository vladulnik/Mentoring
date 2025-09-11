import problemSolvingClasses.animals.Animal;
import problemSolvingClasses.animals.Bird;
import problemSolvingClasses.animals.Cat;
import problemSolvingClasses.animals.Dog;
import problemSolvingClasses.workWithFinal.Book;
import problemSolvingClasses.workWithFinal.Item;
import problemSolvingClasses.workWithFinal.Library;
import problemSolvingClasses.workWithFinal.ShoppingCart;
import utils.AnimalUtils;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(2);
        library.addBook(new Book("Война и мир", "Лев Толстой"));
        library.addBook(new Book("Преступление и наказание", "Ф.М. Достоевский"));
        library.printBooks();

        library.addBook(new Book("Мастер и Маргарита", "М.А. Булгаков")); // тут должно появиться сообщение, что библиотека заполнена
    }
}
