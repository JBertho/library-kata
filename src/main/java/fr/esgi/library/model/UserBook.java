package fr.esgi.library.model;

import java.time.LocalDate;

public class UserBook {
    Book book;
    LocalDate borrowedDate;

    public UserBook(Book book, LocalDate borrowedDate) {
        this.book = book;
        this.borrowedDate = borrowedDate;
    }
}
