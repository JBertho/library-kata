package fr.esgi.library.user;

import fr.esgi.library.Library;
import fr.esgi.library.model.Book;

import java.util.List;

public class Guest {

    Library library;

    public Guest(Library library) {
        this.library = library;
    }

    public List<Book> getLibraryContent() {
        return library.getLibraryContent();
    }
}
