package fr.esgi.library.writer;

import java.util.List;

public interface IFileWriter {

    public void write(String content, String path);

    void writeList(List<String> contents, String path);
}
