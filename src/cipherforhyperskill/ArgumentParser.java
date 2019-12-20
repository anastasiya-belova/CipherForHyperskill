package cipherforhyperskill;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Searches for keywords denoting program startup parametres in an array of strings.
 * Writes the values of these parametres to the appropriate fields.
 * @author Anastasiya Belova
 */
public class ArgumentParser {
    static Logger logger = LoggerFactory.getLogger(ArgumentParser.class);
    
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
                if (args[i+1].equals("dec")){ 
                    encryptMode = false; 
                }
                else if (!args[i+1].equals("enc")){
                    logger.error("You entered an invalid mode value {}. The mode will be set to encrypt.", args[i+1]);
                }
            }
            if (args[i].equals("-key")){
                try{
                    key = Integer.parseInt(args[i+1]);
                }
                catch(NumberFormatException e){
                    logger.error("You entered an invalid key value {}. The key value will be set to 0.", args[i+1]);
                }
            }
            if (args[i].equals("-out")){
                outPath = args[i + 1];
            }
            if (args[i].equals("-alg")){
                nameOfAlgoritm = args[i + 1];
                switch(nameOfAlgoritm){
                    case("shift"): break;
                    case("unicode"): break;
                    default: logger.error("You entered an invalid name of algoritm: \"{}\". "
                    + "The algorithm \"shift\" will be set.", nameOfAlgoritm);
                }
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
                catch(RuntimeException e){
                    logger.error("Unchecked exception: {}", e.getMessage());
                }
            }
        }
    }
    
    /**
     * Returns the first line from the file. If an invalid input parametr is 
     * specified, it throws an exception.
     * @param filePath
     * @return the first line from the file
     */
    public static String readFromFile(String filePath){
       try {
           return FileUtils.readFileToString(FileUtils.getFile(filePath), Charset.defaultCharset());
       }
       catch(FileNotFoundException e){
            logger.error("This file not found: {}. Maybe the wrong file path was entered. "
                    + "The input string will be empty.", FileUtils.getFile(filePath).getAbsolutePath());
            return "";
       }
       catch(IOException e){
            logger.error(e.getMessage());
            return "";
       }
       catch(RuntimeException e){
           logger.error("Unchecked exception: {}. Argument Parser"
                   + " will return an empty input string.", e.getMessage());
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
            logger.error("An instance of this class already exists.");
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
