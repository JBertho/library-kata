package fr.esgi.library.User;

import fr.esgi.library.Library;
import fr.esgi.library.model.Book;

import java.util.List;

public class Guest {
    public List<Book> getLibraryContent(Library library) {
        return library.getLibraryContent();
    }
}
