package fr.esgi.library.reader;

import fr.esgi.library.reader.IFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultFileReader implements IFileReader {
    @Override
    public List<String> readLines(String filename) {
        if (fileDoNotExist(filename)) {
            return null;
        }

        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private boolean fileDoNotExist(String filename) {
        File file = new File(filename);
        return file.exists() == false;
    }
}
