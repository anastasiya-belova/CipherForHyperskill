/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cipherforhyperskill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kraz
 */
public class ArgumentParser {
    
    private final String[] args;
    private String data = "";
    private boolean encryptMode = true;
    private int key = 0;
    private String inPath;
    private String outPath;
    private String nameOfAlgoritm = "shift";
        
    private void work(){
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-data")){
                data = args[i+1];
            }
            if (args[i].equals("-mode")){
                if (args[i+1].equals("dec")){ encryptMode = false; }
            }
            if (args[i].equals("-key")){
                key = Integer.parseInt(args[i+1]);
            }
            if (args[i].equals("-out")){
                outPath = args[i + 1];
            }
            if (args[i].equals("-alg")){
                nameOfAlgoritm = args[i + 1];
            }
        }
        
        /*второй цикл сделан из-за условия получения исходного текста 
        для шифровки/дешифровки: если во входной строке есть и "-data", и "-in", 
        то следует выбрать ввод текста из консоли ("-data")*/
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-in") && data.length() == 0){
                inPath = args[i+1];
                try{ 
                    data = readFromFile(inPath); 
                }
                catch(IOException e){ //to do: clarify the exception
                    System.out.println("Error: " + e.getMessage()); 
                }
            }
        }
    }
    
    public static String readFromFile(String filePath) throws FileNotFoundException{
       File f = new File(filePath);
       try (Scanner sc = new Scanner(f)){
           return sc.nextLine();
       }
       catch(RuntimeException e){ //to do: clarify the exception
           System.out.println("Error: " + e.getMessage());
           return "";
       }
    }
    
    public ArgumentParser(String[] args){
        this.args = args;
        this.work();
    }
    
    public String getData(){
        return data;
    }
    
    public boolean getEncryptMode(){
        return encryptMode;
    }
    
    public int getKey(){
        return key;
    }
    
    public String getInPath(){
        return inPath;
    }
    
    public String getOutPath(){
        return outPath;
    }
    
    public String getNameOfAlgoritm(){
        return nameOfAlgoritm;
    }
}
