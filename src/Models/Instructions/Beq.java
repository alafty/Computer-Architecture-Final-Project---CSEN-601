package Models.Instructions;

import java.io.IOException;
import java.util.ArrayList;

import Exceptions.ClassInstantiatedException;
import Exceptions.InvalidSyntaxException;
import Interfaces.Executable;
import Main.OperatingSystem;
import Models.Kernel.Decoder;
import Models.Kernel.Executer;

public class Beq implements Executable {
    private int params; // number of parameters input for the instruction// number of parameters input for the instruction
    private static boolean singleton = false;

    public Beq () throws ClassInstantiatedException{
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
      if(OperatingSystem.registers.get(args.get(0)) == OperatingSystem.registers.get(args.get(1))){
          
            OperatingSystem.programCounter = OperatingSystem.lables.get(args.get(2));

          Decoder.instructionsQueue.clear();
          Executer.instructionQueue.clear();
          Executer.paramsQueue.clear();
          System.out.println("Branch Taken ");
      } 
      else System.out.println("Branch not taken");
     
    }

    
    @Override
    public int paramNumber() {
        return params;
    }
}
