package fr.esgi.library.User;

import fr.esgi.library.Library;
import fr.esgi.library.User.Guest;
import fr.esgi.library.model.Book;

import java.util.List;

public class Member extends Guest {

    List<Book> books;
    String userName;

    public void borrowBook(Library library, Book book) {
        if (library.isBookAvailable(book) && canBorrowBooks()) {
            books.add(book);
            library.setLibraryBookToBorrowed(book);
        }
    }

    private boolean canBorrowBooks() {
        return books.size() <= 4;
    }

}
