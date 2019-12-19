package cipherforhyperskill;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Prints the string to the console or writes it to a file, 
 * depending on the received parameter.
 * @author Anastasiya Belova
 */
public class OutputManager {
    
    Logger logger = LoggerFactory.getLogger(OutputManager.class);
    
    private final String output;
    
    public OutputManager(String output){
        this.output = output;
    }
    
    public void go(String outPath){
        if (outPath == null){ 
            System.out.println("Output string: \"" + output + "\""); 
        }
        else {
            File f = new File(outPath);
            if (!f.isFile()){
                try {
                    f.createNewFile();
                    logger.info("A file was created: {}", f.getAbsolutePath());
                } catch (IOException e) {
                    logger.error("There is a problem with the specified output path({}): {}", f.getAbsolutePath(), e.getMessage());
                    return;
                }
            }
            try (FileWriter wr = new FileWriter(f, true)){
                if(f.length() == 0){ wr.write(output);}
                else{ wr.write("\n" + output); }
                logger.info("Output string: \"{}\" was written to a file {}", output, f.getAbsolutePath());
            }
            catch (AccessDeniedException e){
                logger.error("File system operation is denied. "
                        + "Check the permission of the file in which you are going to write data");
            }
            catch(IOException e){
                logger.error("There is a problem with the specified output path({}): {}", f.getAbsolutePath(), e.getMessage());
            }
            catch(RuntimeException e){
                logger.error("Unchecked exception: {}", e.getMessage());
            }
        }
    }
}
