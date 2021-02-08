package fr.esgi.library;

import fr.esgi.library.user.Librarian;
import fr.esgi.library.user.Member;
import fr.esgi.library.logger.DefaultLogger;
import fr.esgi.library.logger.ILogger;
import fr.esgi.library.model.Book;
import fr.esgi.library.reader.DefaultFileReader;
import fr.esgi.library.reader.IFileReader;
import fr.esgi.library.writer.DefaultFileWriter;
import fr.esgi.library.writer.IFileWriter;

public class Main {
    public static void main(String[] args) {

        IFileWriter fileWriter = new DefaultFileWriter();
        IFileReader fileReader = new DefaultFileReader();
        ILogger logger = new DefaultLogger();


        Library library = new Library();
        Librarian librarian = new Librarian();
        Book book = new Book("La croisée des mondes", "Carlos");
//        Book book2 = new Book("1984", "Test");
        librarian.addBookToLibrary(library, book);
//        librarian.addBookToLibrary(library, book2);
//        List<Book> books = librarian.getLibraryContent(library);
//        System.out.println(books);

        Member james = new Member("james",fileReader, fileWriter, logger);
        james.borrowBook(library,book);
        System.out.println(james.getBorrowedBooks());

        System.out.println(james.getLibraryContent(library));

    }
}
