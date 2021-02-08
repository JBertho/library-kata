package fr.esgi.library;

import fr.esgi.library.model.Book;
import fr.esgi.library.model.LibraryBook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryBook> libraryBooks;

    public Library() {
        this.libraryBooks = new ArrayList<>();
    }

    public List<Book> getLibraryContent() {
        return libraryBooks.stream()
                .filter(libraryBook -> libraryBook.isBorrowed() == false).map(LibraryBook::getBook).collect(Collectors.toList());
    }

    public boolean isBookAvailable(Book book) {
        return  libraryBooks.stream()
                .filter(libraryBook -> libraryBook.isBorrowed() == false)
                .anyMatch(libraryBook -> libraryBook.getBook().equals(book));
    }

    public void addBook(Book book) {
        LibraryBook libraryBook = new LibraryBook(book,false);
        libraryBooks.add(libraryBook);
    }

    public void setLibraryBookToBorrowed(Book book) {

        List<LibraryBook> matchingBooks = libraryBooks.stream()
                .filter(libraryBook -> libraryBook.getBook().equals(book) && libraryBook.isBorrowed() == false)
                .collect(Collectors.toList());

        if (matchingBooks.size() > 0) {
            LibraryBook bookToBorrow = matchingBooks.get(0);
            bookToBorrow.borrow();
        }
    }
}
