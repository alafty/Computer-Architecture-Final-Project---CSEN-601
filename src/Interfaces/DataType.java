package Interfaces;
import Constants.Type;


/**
 * {@code DataType}
 * 
 * <p>
 * Raw datatype to hold wrappers for strings, integers, etc...
 * </p>
 */
public interface DataType{
    public Type checkType();
    public String toString();
}