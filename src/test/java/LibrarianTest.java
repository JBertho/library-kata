import fr.esgi.library.Library;
import fr.esgi.library.logger.DefaultLogger;
import fr.esgi.library.model.Book;
import fr.esgi.library.user.Librarian;
import fr.esgi.library.user.Member;
import fr.esgi.library.writer.IFileWriter;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianTest {

    private Librarian librarian;
    private Library library;

    @Before
    public void setup() {

        librarian = new Librarian();
        library = new Library(filename -> Collections.emptyList(), new LibrarianTestWriter(), new DefaultLogger());
    }

    @Test
    public void should_add_book_to_library() {

        assertEquals(0,librarian.getLibraryContent(library).size());
        Book newBook = new Book("book of the year", "test");
        librarian.addBookToLibrary(library,newBook);
        assertEquals(1,librarian.getLibraryContent(library).size());
    }

    private static class LibrarianTestWriter implements IFileWriter {
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
