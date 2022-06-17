package Interfaces;
import java.io.IOException;
import java.util.ArrayList;

import Exceptions.InvalidSyntaxException;

/**
 * {@code Executable}
 * <p>
 * An executable is an implementation of a function
 * </p>
 * 
 * <p>
 * For example, print is a class that extends executable to print something to the console. print.run(--,--) will have the implementation of the function
 * </p>
 */
public interface Executable {
    public void run(ArrayList<String> args) throws InvalidSyntaxException, IOException;
    public int paramNumber();
}
