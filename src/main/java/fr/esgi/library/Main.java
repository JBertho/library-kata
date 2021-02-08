package fr.esgi.library;

import fr.esgi.library.User.Librarian;
import fr.esgi.library.model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian();
        Book book = new Book("La croisée des mondes", "James");
        librarian.addBookToLibrary(library, book);
        librarian.addBookToLibrary(library, book);
        librarian.addBookToLibrary(library, book);
        List<Book> books = librarian.seeLibraryContent(library);
        System.out.println(books);

    }
}
