package Models.Kernel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Main.OperatingSystem;

/**
 * {@code FileReader}
 * 
 * <p>
 * FileReader is the library responsible for reading files from disk and returning the program as
 * a list of strings. Each string represents a line in the file
 * </p>
 */
public class FileReader_ {
    //TODO: Implement file reader
    // goal: implement function readFile() which returns a list of strings

    

    /**
    * {@code readFile}
    * 
    * <p>
    * Static method
    * parameters String filepath
    * returns the file as a list of string for each line in the file
    * throws exception of creating file reader (file not found )
    * throws exception of read next line (io exception)
    * </p>
    * @return ArrayList - String
    * @throws IOException
    * 
    */ 
    public static ArrayList<String> readFile (String filepath) throws IOException{
        ArrayList<String> fileString =  new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader("User directory/" + filepath));
        String nextLine;
        int i =0;
        while ((nextLine= reader.readLine())!= null){
            String labelSplit [] = nextLine.split(":");
            if (labelSplit.length > 1){
                OperatingSystem.labels.put(labelSplit[0].trim(), i);
                nextLine = labelSplit[1];
            }
            fileString.add(nextLine.trim());


        }
        reader.close();

        return fileString;
    }
}
