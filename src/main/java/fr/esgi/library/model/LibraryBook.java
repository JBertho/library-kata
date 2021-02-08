package fr.esgi.library.model;

public class LibraryBook {
    Book book;
    boolean isBorrowed;

    public LibraryBook(Book book, boolean isBorrowed) {
        this.book = book;
        this.isBorrowed = isBorrowed;
    }

    public LibraryBook(String stringLibraryBook) {
        String[] libraryBooksAttributes = stringLibraryBook.split(",");
        this.book = new Book(libraryBooksAttributes[0],libraryBooksAttributes[1]);
        this.isBorrowed = Boolean.parseBoolean(libraryBooksAttributes[2]);
    }

    public Book getBook() {
        return book;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        isBorrowed = true;
    }

    public void turnBack(){
        isBorrowed = false;
    }

    public String toFileFormat() {
        return book.toFileFormat() + "," + isBorrowed;
    }
}
