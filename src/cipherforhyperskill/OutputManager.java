package cipherforhyperskill;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Prints the string to the console or writes it to a file, 
 * depending on the received parameter.
 * @author Anastasiya-Belova
 */
public class OutputManager {
    
    private final String output;
    
    public OutputManager(String output){
        this.output = output;
    }
    
    public void go(String outPath) throws IOException{
        if (outPath == null){ System.out.println("Output string: " + output); }
        else {
            File f = new File(outPath);
            if (!f.isFile()){
                f.createNewFile();
            }
            try (FileWriter wr = new FileWriter(f)){
                wr.write(output);
                System.out.println("Output string: " + output + 
                        " Was written to a file " + f.getAbsolutePath());
            }
            //to do: output exception to log
            catch(RuntimeException e){
                System.out.println("Unchecked exception: " + e.getMessage());
            }
        }
    }
}
