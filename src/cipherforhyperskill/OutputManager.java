/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherforhyperskill;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kraz
 */
public class OutputManager {
    
    private final String output;
    
    public OutputManager(String output){
        this.output = output;
    }
    
    public void go(String outPath) throws IOException{ //to do: clarify the exception
        if (outPath == null){ System.out.println(output); }
        else {
            File f = new File(outPath);
            if (!f.isFile()){ f.createNewFile(); }
            try (FileWriter wr = new FileWriter(f)){ wr.write(output); }
            catch(RuntimeException e){ System.out.println("Error: " + e.getMessage()); } //to do: clarify the exception
        }
    }
}
