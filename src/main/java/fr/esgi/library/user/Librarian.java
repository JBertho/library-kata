package fr.esgi.library.user;

import fr.esgi.library.Library;
import fr.esgi.library.model.Book;

public class Librarian extends Guest {
    String userName;

    public void addBookToLibrary(Library library, Book book) {
        library.addBook(book);
    }

}
