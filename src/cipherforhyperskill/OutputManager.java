package cipherforhyperskill;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import org.apache.commons.io.FileUtils;
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
            if (!FileUtils.getFile(outPath).isFile()){
                try {
                    FileUtils.getFile(outPath).createNewFile();
                    logger.info("A file was created: {}", FileUtils.getFile(outPath).getAbsolutePath());
                } catch (IOException e) {
                    logger.error("There is a problem with the specified output path({}): {}",
                            FileUtils.getFile(outPath).getAbsolutePath(), e.getMessage());
                    return;
                }
            }
            try {
                FileUtils.writeStringToFile(FileUtils.getFile(outPath), output, Charset.defaultCharset(), false);
                logger.info("Output string: \"{}\" was written to a file {}",
                        output, FileUtils.getFile(outPath).getAbsolutePath());
            }
            catch (AccessDeniedException e){
                logger.error("File system operation is denied. "
                        + "Check the permission of the file in which you are going to write data");
            }
            catch(IOException e){
                logger.error("There is a problem with the specified output path({}): {}",
                        FileUtils.getFile(outPath).getAbsolutePath(), e.getMessage());
            }
            catch(RuntimeException e){
                logger.error("Unchecked exception: {}", e.getMessage());
            }
        }
    }
}
