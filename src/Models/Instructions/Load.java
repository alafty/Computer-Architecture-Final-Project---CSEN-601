package Models.Instructions;
import java.util.ArrayList;

import Exceptions.ClassInstantiatedException;
import Exceptions.InvalidSyntaxException;
import Interfaces.Executable;
import Main.OperatingSystem;

public class Load implements Executable{
    
    private int params; // number of parameters input for the instruction
    private static boolean singleton = false;

    public Load () throws ClassInstantiatedException{
        if (singleton == true){
            throw new ClassInstantiatedException();
        }
        params = 2;
        singleton = true;
    }

    /**
     * {@code run} method should take 2 parameters : one of type register and the other an index in
     *  in memory and loads the value of the second register from memory into the first.
     * 
     * 
     * @param args - the parameters of the instruction
     * @param process - the process that is running the instruction
     */
    @Override
    public void run(ArrayList<String> args) throws InvalidSyntaxException{
      //TODO: make a case for having an offset
      OperatingSystem.registers.replace(args.get(0), OperatingSystem.Memory[Integer.parseInt(args.get(1))]);
    }

    public void infoUpdate (String updateRegister){
        System.out.println("Value of register :  " + updateRegister + " is now :"  + OperatingSystem.registers.get(updateRegister));
        
    }

    @Override
    public int paramNumber() {
        // TODO Auto-generated method stub
        return params;
    }
}
