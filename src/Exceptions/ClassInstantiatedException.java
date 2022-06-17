package Exceptions;
// This exception is to be thrown when a singleton class is instantiated more than one time 
// The Instructions are singleton classes, there can only be one instance of every instruction object during the run time of the operating system
// 
public class ClassInstantiatedException extends Exception {
    public ClassInstantiatedException(){
        super("This singleton class is already instantiated ");
    }
}
