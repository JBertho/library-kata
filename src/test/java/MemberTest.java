import fr.esgi.library.Library;
import fr.esgi.library.logger.DefaultLogger;
import fr.esgi.library.model.Book;
import fr.esgi.library.reader.DefaultFileReader;
import fr.esgi.library.reader.IFileReader;
import fr.esgi.library.user.Guest;
import fr.esgi.library.user.Member;
import fr.esgi.library.writer.DefaultFileWriter;
import fr.esgi.library.writer.IFileWriter;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTest {

    private Member member;
    private Library library;

    @Before
    public void setup() {

        library = new Library(filename -> Collections.emptyList(), new memberTestWriter(), new DefaultLogger());
        library.addBook(new Book("first book", "author"));
        library.addBook(new Book("second book", "author"));
        library.addBook(new Book("third book", "author"));
        library.addBook(new Book("my book", "author"));
        library.addBook(new Book("too much book", "author"));

        member = new Member("sut",library, filename -> Collections.emptyList(), new memberTestWriter(), new DefaultLogger());
    }

    @Test
    public void should_borrow_book_when_have_less_than_4_current_borrowed_book() {
        Book bookToBorrow = new Book("first book", "author");
        assertEquals(0,member.getBorrowedBooks().size());
        member.borrowBook(bookToBorrow);
        assertEquals(1,member.getBorrowedBooks().size());
    }

    @Test
    public void should_not_borrow_book_when_already_have_4_current_borrowed_book() {
        member.borrowBook(new Book("first book", "author"));
        member.borrowBook(new Book("second book", "author"));
        member.borrowBook(new Book("third book", "author"));
        member.borrowBook(new Book("my book", "author"));
        assertEquals(4,member.getBorrowedBooks().size());

        member.borrowBook(new Book("too much book", "author"));
        assertEquals(4,member.getBorrowedBooks().size());
    }

    @Test
    public void should_not_borrow_book_when_book_not_exist() {

        member.borrowBook(new Book("i don't exist", "author"));
        assertEquals(0,member.getBorrowedBooks().size());
    }

    @Test
    public void should_not_borrow_book_when_book_already_borrowed() {

        member.borrowBook(new Book("my book", "author"));
        assertEquals(1,member.getBorrowedBooks().size());

        member.borrowBook(new Book("my book", "author"));
        assertEquals(1,member.getBorrowedBooks().size());
    }



    private static class memberTestWriter implements IFileWriter {
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

