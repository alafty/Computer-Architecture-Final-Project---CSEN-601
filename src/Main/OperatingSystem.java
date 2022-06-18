/* Class description 
    This is the main class for the project. It simulates the function of an operating system.
    When the program starts this class starts and it is responsible for running and scheduling process in the system.
    For every new process created "Programs that the system should run" an instance of a process class is created which contains 
    all necessary information about the process. 
    The process object is given to the executer in order to execute it. There can be multiple instance of the Executer running c
    concurrently to simulate multicore / multiprocessor programming 
    
    No objects of this class shall be instantiated 
*/
package Main;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Exceptions.ClassInstantiatedException;
import Exceptions.InvalidJumpOperation;
import Exceptions.InvalidSyntaxException;
import Interfaces.Executable;
import Models.Instructions.*;

// import necessary packages

import Models.Kernel.*;
/**
 * {@code OperatingSystem}
 * The main of the interpreter.
 * 
 * <p>
 * The operating system handles the organization to run a program. This is the main process of the interpreter
 * </p>
 * <p>
 * Till now, the OS has a number of tasks:
 * <ul>
 * <li>The creation of the process</li>
 * <li>Initializing the executor</li>
 * <li>Running the process till the end</li>
 * </ul>
 * </p>
 * 
 */
public class OperatingSystem  {

    public static HashMap<String, Executable> functions = new HashMap<String, Executable>();
    public static HashMap<String,Integer> registers = new HashMap<String, Integer>();
    public static HashMap<String,Integer> labels = new HashMap<String,Integer>();
    public static int Memory [] = new int[1000];
    public static int programCounter;
    
    public static void main (String [] args) throws Exception {
        runOs();
    }
    /**
     * {@code runOS}
     * 
     * <p>
     * The main thread that runs the OS (interpreter)
     * </p>
     * @throws IOException
     * @throws InvalidSyntaxException
     * @throws InvalidJumpOperation
     */
    public static void runOs () throws IOException, InvalidJumpOperation, InvalidSyntaxException{
        // startup procedure,runs one time only when starting the operating system
        try {
        initMap();
        }
        catch (ClassInstantiatedException e){
            System.out.println(e);
        }
        // completely super important and essential, Dont remove I repeat dont remove
        {
            System.out.println("Your System is starting");
            System.out.print("Please Wait . . ");
            for(int i = 0;i< 2; i++){
                System.out.print(". ");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Done");
            System.out.println("Welcome to MakOS");
        }
        System.out.println( "Enter Program to run");
        // Scanner sc =  new Scanner(System.in);
        String command = "test.txt";
        ArrayList<String> program = FileReader_.readFile("Programs/" + command);

        //pipelined fetch decode cycle 

        while (programCounter < program.size() +2 ){

            
            if(!Executer.instructionQueue.isEmpty())System.out.println("Executing Line: " + Executer.currentLine);
            Executer.executeLine();

            if(!Decoder.instructionsQueue.isEmpty()) System.out.println("Decoding Line: " + Decoder.currentLine);
            Decoder.decode();

            if (programCounter < program.size()){
                System.out.println("Fetching Line: " + (programCounter + 1 ));
                Decoder.instructionsQueue.add( program.get(programCounter));
                Decoder.currentLine = programCounter + 1 + "";
            }
            programCounter ++;


            System.out.println("---------------------------------------- \n");
        }
        System.out.println("Decoding Line: " + programCounter);
        System.out.println("Executing Line: " + (programCounter -1));    
        Executer.executeLine();
        Decoder.decode();
        System.out.println("---------------------------------------- \n");
        System.out.println("Executing Line: " + (programCounter));    
        Executer.executeLine();
        System.out.println("---------------------------------------- \n");

        System.out.println("Register Set: ");
        printMap(registers);
        System.out.println("\nVaried Memory : ");
        printMemory(Memory);
            

            
        
    }
  
        
        
    public static void printMap(HashMap<String,Integer> mp) {
        Iterator<Map.Entry<String,Integer>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>)it.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    public static void printMemory(int[] memory){
        boolean noChange = true;
        for (int i = 0;i<memory.length;i++){
            if (memory[i]!= -100){
                System.out.println("Index: "+ i + " = " + memory[i]);
                noChange = false;
            }
        }
        if (noChange)System.out.println("There has been no change in the memroy");
    }
        
    public static void initMap() throws ClassInstantiatedException {
        functions.put("ADD", new Add());
        functions.put("ADDI", new Addi());
        functions.put("LW", new Load());
        functions.put("BEQ",new Beq());
        functions.put("SUB",new Sub());
        functions.put("SW",new Store());


        registers.put("$zero",0);
        registers.put("$at",-100);
        registers.put("$v0",-100);
        registers.put("$v1",-100);
        registers.put("$a0",-100);
        registers.put("$a1",-100);
        registers.put("$a2",-100);
        registers.put("$a3",-100);
        registers.put("$t0",-100);
        registers.put("$t1",-100);
        registers.put("$t2",-100);
        registers.put("$t3",-100);
        registers.put("$t4",-100);
        registers.put("$t5",-100);
        registers.put("$t6",-100);
        registers.put("$t7",-100);
        registers.put("$t8",-100);
        registers.put("$t9",-100);
        registers.put("$s0",-100);
        registers.put("$s1",-100);
        registers.put("$s2",-100);
        registers.put("$s3",-100);
        registers.put("$s4",-100);
        registers.put("$s5",-100);
        registers.put("$s6",-100);
        registers.put("$s7",-100);
        registers.put("$sp",-100);
        registers.put("$ra",-100);
        registers.put("$gp",-100);
        registers.put("$k0",-100);
        registers.put("$k1",-100);

        for (int i = 0; i < Memory.length ; i++){
            Memory[i] = -100;
        }
























        



    }

    
}
