package fr.esgi.library;

import fr.esgi.library.logger.ILogger;
import fr.esgi.library.model.Book;
import fr.esgi.library.model.LibraryBook;
import fr.esgi.library.reader.DefaultFileReader;
import fr.esgi.library.reader.IFileReader;
import fr.esgi.library.writer.DefaultFileWriter;
import fr.esgi.library.writer.IFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private final static String FILENAME = "libraryBooks.txt";

    private List<LibraryBook> libraryBooks;
    private IFileWriter fileWriter;
    private IFileReader fileReader;

    public Library(IFileReader reader, IFileWriter writer, ILogger logger) {
        this.libraryBooks = new ArrayList<>();
        fileWriter = writer;
        fileReader = reader;
        initLibraryBooks();


    }

    private void initLibraryBooks() {
        List<String> stringLibraryBooks = fileReader.readLines(FILENAME);
        stringLibraryBooks.forEach(stringLibraryBook -> {
            libraryBooks.add(new LibraryBook(stringLibraryBook));
        } );
    }

    public List<Book> getLibraryContent() {
        return libraryBooks.stream()
                .filter(libraryBook -> libraryBook.isBorrowed() == false).map(LibraryBook::getBook).collect(Collectors.toList());
    }

    public boolean isBookAvailable(Book book) {
        return  libraryBooks.stream()
                .filter(libraryBook -> libraryBook.isBorrowed() == false)
                .anyMatch(libraryBook -> libraryBook.getBook().equals(book));
    }

    public void addBook(Book book) {
        LibraryBook libraryBook = new LibraryBook(book,false);
        libraryBooks.add(libraryBook);
        fileWriter.write(libraryBook.toFileFormat(), FILENAME);
    }

    public void setSelectedBookToBorrowed(Book book) {

        List<LibraryBook> matchingBooks = getMatchingLibraryBookByState(book,false);

        if (matchingBooks.size() > 0) {
            LibraryBook bookToBorrow = matchingBooks.get(0);
            bookToBorrow.borrow();
            fileWriter.writeList(libraryBooks.stream().map(LibraryBook::toFileFormat).collect(Collectors.toList()),FILENAME);
        }

    }

    private List<LibraryBook> getMatchingLibraryBookByState(Book book,boolean isBorrowed) {
        return libraryBooks.stream()
                .filter(libraryBook -> libraryBook.getBook().equals(book) && libraryBook.isBorrowed() == isBorrowed)
                .collect(Collectors.toList());
    }

    public void setSelectedBookToAvailable(Book book) {
        List<LibraryBook> matchingBooks = getMatchingLibraryBookByState(book,true);
        if (matchingBooks.size() > 0) {
            LibraryBook bookToBorrow = matchingBooks.get(0);
            bookToBorrow.turnBack();
            fileWriter.writeList(libraryBooks.stream().map(LibraryBook::toFileFormat).collect(Collectors.toList()),FILENAME);
        }
    }
}
