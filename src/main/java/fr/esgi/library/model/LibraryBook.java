package fr.esgi.library.model;

public class LibraryBook {
    Book book;
    boolean isBorrowed;

    public LibraryBook(Book book, boolean isBorrowed) {
        this.book = book;
        this.isBorrowed = isBorrowed;
    }

    public Book getBook() {
        return book;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        isBorrowed = false;
    }

    public void turnBack(){
        isBorrowed = true;
    }
}
