package Models.Kernel;

import java.io.IOException;
// import necessary packages
import java.util.*;
import Exceptions.*;
import Interfaces.*;


/**
 * {@code Executer}
 * 
 * <p>
 * The executer will be assigned a process.
 * </p>
 * <p>
 * The main function of the executer is to execute line. Each line is parsed
 * from a string and the functions are run.
 * </p>
 * 
 * <p>
 * As long as the process is assigned to the executer, executeLine will fetch
 * the line from the process and execute it
 * </p>
 */
public class Executer {

    
    static ArrayList<Executable> instructionQueue = new ArrayList<Executable>();
    static ArrayList<ArrayList<String> > paramsQueue= new ArrayList<ArrayList<String>>();

    /**
     * {@code initMap}
     * <p>
     * Initializes the functions that will stay for as long as the OS is running.
     * </p>
     * <p>
     * These are the standard library of the OS
     * </p>
     * 
     * @throws ClassInstantiatedException
     * 
     */
 
    /**
     * {@code Executer}
     * 
     * <p>
     * Creates empty constructor.
     * </p>
     * <p>
     * Executer can't run without assigning a process in
     * {@link #assignProcess(Process)}
     * </p>
     * 
     */
    

    /**
     * {@code executeLine}
     * 
     * <p>
     * Executes the current line in the process and handles parsing each word in the
     * line
     * </p>
     * <p>
     * As long as a process is assigned to the executer, execute line will fetch and
     * execute the next line in the program
     * </p>
     * 
     * @return true if executed line, false if end of line
     * @throws InvalidJumpOperation
     * @throws InvalidSyntaxException
     */
    public static void executeLine( ) throws InvalidJumpOperation, InvalidSyntaxException, IOException {
       if (instructionQueue.size() <= 0 ) return;
        instructionQueue.remove(0).run(paramsQueue.remove(0));
    }

    
    

}
