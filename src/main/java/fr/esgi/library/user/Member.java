package fr.esgi.library.user;

import fr.esgi.library.*;
import fr.esgi.library.logger.ILogger;
import fr.esgi.library.model.Book;
import fr.esgi.library.model.UserBook;
import fr.esgi.library.reader.IFileReader;
import fr.esgi.library.writer.IFileWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Member extends Guest {

    private static final String PATH = "members/";
    private static final String EXTENSION = ".txt";
    private static final String NO_MORE_BORROW_POSSIBLE = "Vous ne pouvez pas emprunté de livre actuellement";

    List<UserBook> userBooks;
    String userName;
    private final IFileWriter fileWriter;
    private final IFileReader fileReader;
    private final ILogger logger;

    public Member(String userName,Library library, IFileReader fileReader, IFileWriter fileWriter, ILogger logger) {
        super(library);
        this.userName = userName;
        userBooks = new ArrayList<>();
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
        this.logger = logger;
        initMemberBooks();
    }

    private void initMemberBooks() {
        List<String> userBooksRow = fileReader.readLines(PATH + userName + EXTENSION);
        if (userBooksRow != null) {
            userBooksRow.forEach(stringBook -> this.userBooks.add(new UserBook(stringBook)));
        }
    }

    public void borrowBook(Book book) {
        if (library.isBookAvailable(book) && canBorrowBooks()) {
            UserBook newUserBook = new UserBook(book, LocalDate.now());
            userBooks.add(newUserBook);
            library.setSelectedBookToBorrowed(book);
            fileWriter.writeList(userBooks.stream().map(UserBook::toFileFormat).collect(Collectors.toList()),PATH + userName + EXTENSION);
        } else {
            logger.log(NO_MORE_BORROW_POSSIBLE);
        }
    }

    private boolean canBorrowBooks() {
        return userBooks.size() < 4;
    }

    public List<UserBook> getBorrowedBooks() {
        return userBooks;
    }

}
