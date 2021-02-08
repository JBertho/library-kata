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

        LibraryScenario libraryScenario = new LibraryScenario();

        libraryScenario.createLibrarianAndAddBooks(fileWriter,fileReader,logger);
        libraryScenario.watchLibraryContentAsGuest(fileWriter,fileReader,logger);
        libraryScenario.borrowBookAsMember(fileWriter,fileReader, logger);
        libraryScenario.returnBookAsMember(fileWriter,fileReader,logger);
    }
}
