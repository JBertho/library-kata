package fr.esgi.library.logger;

public class DefaultLogger implements ILogger{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
