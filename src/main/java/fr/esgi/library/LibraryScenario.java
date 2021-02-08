package fr.esgi.library;

import fr.esgi.library.logger.ILogger;
import fr.esgi.library.model.Book;
import fr.esgi.library.model.UserBook;
import fr.esgi.library.reader.IFileReader;
import fr.esgi.library.user.Guest;
import fr.esgi.library.user.Librarian;
import fr.esgi.library.user.Member;
import fr.esgi.library.writer.IFileWriter;

import java.util.List;

public class LibraryScenario {

    public void createLibrarianAndAddBooks(IFileWriter fileWriter, IFileReader fileReader, ILogger logger) {
        Library library = new Library(fileReader, fileWriter, logger);

        Librarian librarian = new Librarian(library);
        Book book = new Book("La croisée des mondes", "Carlos");
        librarian.addBookToLibrary(book);
    }

    public void watchLibraryContentAsGuest(IFileWriter fileWriter, IFileReader fileReader, ILogger logger) {
        Library library = new Library(fileReader, fileWriter, logger);
        Guest guest = new Guest(library);
        logger.log(guest.getLibraryContent().toString());
    }

    public void borrowBookAsMember(IFileWriter fileWriter, IFileReader fileReader, ILogger logger) {
        Library library = new Library(fileReader, fileWriter, logger);
        Member james = new Member("james",library,fileReader, fileWriter, logger);
        List<Book> libraryBooks = james.getLibraryContent();
        if (libraryBooks.size() > 0) {
            james.borrowBook(libraryBooks.get(0));
        }
        logger.log(james.getBorrowedBooks().toString());
        logger.log(james.getLibraryContent().toString());
    }

    public void returnBookAsMember(IFileWriter fileWriter, IFileReader fileReader, ILogger logger) {
        Library library = new Library(fileReader, fileWriter, logger);
        Member james = new Member("james",library,fileReader, fileWriter, logger);
        List<UserBook> libraryBooks = james.getBorrowedBooks();
        logger.log(libraryBooks.toString());
        if (libraryBooks.size() > 0) {
            james.returnBorrowedBook(libraryBooks.get(0));
        }
        logger.log(james.getBorrowedBooks().toString());
        logger.log(james.getLibraryContent().toString());
    }
}
