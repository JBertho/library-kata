package fr.esgi.library.model;

import java.time.LocalDate;

public class UserBook {
    Book book;
    LocalDate borrowedDate;

    public UserBook(Book book, LocalDate borrowedDate) {
        this.book = book;
        this.borrowedDate = borrowedDate;
    }

    public UserBook(String stringBook) {
        String[] libraryBooksAttributes = stringBook.split(",");
        this.book = new Book(libraryBooksAttributes[0],libraryBooksAttributes[1]);
        this.borrowedDate = LocalDate.parse(libraryBooksAttributes[2]);
    }

    public String toFileFormat() {
        return book.toFileFormat() + "," + borrowedDate;
    }

    @Override
    public String toString() {
        return book.toString() + " emprunté le " + borrowedDate;
    }
}
