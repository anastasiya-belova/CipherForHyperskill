package cipherforhyperskill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Searches for keywords denoting program startup parametres in an array of strings.
 * Writes the values of these parametres to the appropriate fields.
 * @author Anastasiya-Belova
 */
public class ArgumentParser {
    
    private static ArgumentParser instance = null;
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
                catch(FileNotFoundException e){
                    System.out.println("This file not found: " + inPath + 
                            ". Maybe the wrong file path was entered"); 
                }
                catch(RuntimeException e){
                    System.out.println("Unchecked exception: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Returns the first line from the file. If an invalid input parametr is 
     * specified, it throws an exception.
     * @param filePath
     * @return the first line from the file
     * @throws FileNotFoundException 
     */
    public static String readFromFile(String filePath) throws FileNotFoundException{
        //to do: add the multiline input
       File f = new File(filePath);
       try (Scanner sc = new Scanner(f)){
           return sc.nextLine();
       }
       catch(RuntimeException e){
           System.out.println("Unchecked exception: " + e.getMessage() + 
                   ". In method \"readFromeFile\" an empty string will be returned");
           return "";
       }
    }
    
    private ArgumentParser(String[] args){
        this.args = args;
        this.work();
    }
    
    public static ArgumentParser getInstance(String[] args){
        if (instance == null){ 
            instance = new ArgumentParser(args);
            return instance;
        }
        else {
            //to do: log - error
            return null;
        }
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
