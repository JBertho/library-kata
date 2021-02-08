package fr.esgi.library.user;

import fr.esgi.library.Library;
import fr.esgi.library.model.Book;

public class Librarian extends Guest {

    public Librarian(Library library) {
        super(library);
    }

    public void addBookToLibrary(Book book) {
        library.addBook(book);
    }

}
