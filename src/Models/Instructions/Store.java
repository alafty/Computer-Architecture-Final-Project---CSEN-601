package Models.Instructions;
import java.util.ArrayList;

import Exceptions.*;
import Interfaces.Executable;
import Main.OperatingSystem;
import Utils.MemoryUtils;

public class Store implements Executable {
    private int params;
    private static boolean singleton = false;

    public Store () throws ClassInstantiatedException{
        if (singleton == true){
            throw new ClassInstantiatedException();
        }
        params = 2;
        singleton = true;
    }


    @Override
    public void run(ArrayList<String> args) throws InvalidSyntaxException {
        String register = args.get(0);
        String rawAddress = args.get(1);

        if (OperatingSystem.registers.get(register) == null) {
            throw new InvalidSyntaxException("Register " + register + " is not valid", OperatingSystem.programCounter);
        }
        
        int address = MemoryUtils.getAddressFromRawAddress(rawAddress);
        
        OperatingSystem.Memory[address] = OperatingSystem.registers.get(register);
    }

    @Override
    public int paramNumber() {
        return params;
    }

}