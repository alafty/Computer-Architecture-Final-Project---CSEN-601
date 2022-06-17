package Models.Instructions;
import Exceptions.*;
import Interfaces.*;
import Main.OperatingSystem;

import java.util.ArrayList;


/**
 * The instruction should take 2 parameters of type integer and return the value of their sum
 */
public class Add implements Executable {
    private int params; // number of parameters input for the instruction// number of parameters input for the instruction
    private static boolean singleton = false;

    public Add () throws ClassInstantiatedException{
        if (singleton == true){
            throw new ClassInstantiatedException();
        }
        params = 3;
        singleton = true;
    }
    /**
     * {@code run} method should take 2 parameters of type integer and return the value of their sum
     * 
     * @param args - the parameters of the instruction
     * @param process - the process that is running the instruction
     */
    @Override
    public void run(ArrayList<String> args) throws InvalidSyntaxException{
      int result = OperatingSystem.registers.get(args.get(1)) + OperatingSystem.registers.get(args.get(2)); 
        OperatingSystem.registers.replace(args.get(0),result);
        infoUpdate(args.get(0));
    }

    public void infoUpdate (String updateRegister){
        System.out.println("Value of register :  " + updateRegister + " is now :"  + OperatingSystem.registers.get(updateRegister));
        
    }
    @Override
    public int paramNumber() {
        return params;
    }
}
