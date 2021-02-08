package fr.esgi.library.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DefaultFileWriter implements IFileWriter {
    @Override
    public void write(String content, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(content);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeList(List<String> contents, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            contents.forEach(printWriter::println);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
