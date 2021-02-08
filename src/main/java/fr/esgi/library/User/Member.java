package fr.esgi.library.User;

import fr.esgi.library.Library;
import fr.esgi.library.model.Book;
import fr.esgi.library.model.UserBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member extends Guest {

    List<UserBook> books;
    String userName;

    public Member(String userName) {
        this.userName = userName;
        books = new ArrayList<>();
    }

    public void borrowBook(Library library, Book book) {
        if (library.isBookAvailable(book) && canBorrowBooks()) {
            UserBook userBook = new UserBook(book, LocalDate.now());
            books.add(userBook);
            library.setSelectedBookToBorrowed(book);
        }
    }

    private boolean canBorrowBooks() {
        return books.size() <= 4;
    }

}
