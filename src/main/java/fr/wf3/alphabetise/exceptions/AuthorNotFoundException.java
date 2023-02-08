package fr.wf3.alphabetise.exceptions;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String bookNotFound) {
        super(bookNotFound);
    }
    public void printStackTrace() {
    }
}
