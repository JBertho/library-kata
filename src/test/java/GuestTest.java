import fr.esgi.library.Library;
import fr.esgi.library.logger.DefaultLogger;
import fr.esgi.library.model.LibraryBook;
import fr.esgi.library.user.Guest;
import fr.esgi.library.model.Book;
import fr.esgi.library.writer.IFileWriter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestTest {

    private Guest guest;
    private Library library;

    @Before
    public void setup() {
        Book first = new Book("first book", "author");
        LibraryBook firstLibraryBook = new LibraryBook(first,false);
        Book second = new Book("second book", "second author");
        LibraryBook secondLibraryBook = new LibraryBook(second,false);
        ArrayList<String> stringsBooks = new ArrayList<>();
        stringsBooks.add(firstLibraryBook.toFileFormat());
        stringsBooks.add(secondLibraryBook.toFileFormat());
        library = new Library(filename -> stringsBooks, new LibraryTestWriter(), new DefaultLogger());
        guest = new Guest(library);
    }

    @Test
    public void should_return_available_books() {
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(new Book("first book", "author"));
        expectedList.add(new Book("second book", "second author"));
        List<Book> result = guest.getLibraryContent();
        assertEquals(expectedList, result);
    }

    @Test
    public void should_not_return_borrowed_books() {
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(new Book("first book", "author"));

        library.setSelectedBookToBorrowed(new Book("second book", "second author"));

        List<Book> result = guest.getLibraryContent();
        assertEquals(expectedList, result);
    }

    private static class LibraryTestWriter implements IFileWriter {
        @Override
        public void write(String content, String path) {
            return;
        }

        @Override
        public void writeList(List<String> contents, String path) {
            return;
        }
    }
}
