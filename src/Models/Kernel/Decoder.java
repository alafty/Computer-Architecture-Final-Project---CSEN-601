
package Models.Kernel;

import java.util.ArrayList;

import Interfaces.Executable;
import Main.OperatingSystem;

public class Decoder {
    public static ArrayList<String> instructionsQueue = new ArrayList<String>() ; 
    public static String currentLine = "0";
    public static void decode (){
        if(instructionsQueue.size()<=0 ) return;
        String[] InstructionParams = instructionsQueue.remove(0).split (" ");
        Executable instruction = OperatingSystem.functions.get(InstructionParams[0].trim().toUpperCase());
        String[] params = InstructionParams[1].split(",");
        ArrayList <String> args = new ArrayList<String>();
        for (int i= 0 ; i<instruction.paramNumber();i++){
            args.add(params[i]);
        }
        Executer.instructionQueue.add(instruction);
        Executer.paramsQueue.add(args);
        Executer.currentLine = currentLine;
    }
}
