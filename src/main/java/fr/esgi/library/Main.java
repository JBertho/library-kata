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


        Library library = new Library(fileReader, fileWriter, logger);

        Librarian librarian = new Librarian(library);
        Book book = new Book("La croisée des mondes", "Carlos");
        librarian.addBookToLibrary(book);
//        librarian.addBookToLibrary(library, book2);
//        List<Book> books = librarian.getLibraryContent();
//        System.out.println(books);

        Member james = new Member("james",library,fileReader, fileWriter, logger);
        james.borrowBook(book);
        System.out.println(james.getBorrowedBooks());

        System.out.println(james.getLibraryContent());

    }
}
