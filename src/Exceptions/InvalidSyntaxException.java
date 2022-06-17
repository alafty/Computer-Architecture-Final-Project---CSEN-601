package Exceptions;

public class InvalidSyntaxException extends Exception {
    public InvalidSyntaxException(String description, int line){
        super("[ERROR] Invalid syntax on line " + line + "\n" + description);
    }
}
