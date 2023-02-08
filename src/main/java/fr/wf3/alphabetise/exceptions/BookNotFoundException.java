package fr.wf3.alphabetise.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String bookNotFound) {
        super(bookNotFound);
    }
}
