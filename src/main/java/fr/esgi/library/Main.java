package fr.esgi.library;

import fr.esgi.library.User.Librarian;
import fr.esgi.library.User.Member;
import fr.esgi.library.model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Librarian librarian = new Librarian();
        Book book = new Book("La croisée des mondes", "Carlos");
        Book book2 = new Book("1984", "Test");
        librarian.addBookToLibrary(library, book);
        librarian.addBookToLibrary(library, book2);
        List<Book> books = librarian.getLibraryContent(library);
        System.out.println(books);

        Member james = new Member("james");
        james.borrowBook(library,book);

        System.out.println(james.getLibraryContent(library));

    }
}
