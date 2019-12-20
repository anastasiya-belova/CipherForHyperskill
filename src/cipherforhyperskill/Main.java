package cipherforhyperskill;

import ch.qos.logback.classic.util.ContextInitializer;
import cipheralgorithms.Cryptographer;
import cryptocreators.UnicodeCryptoCreator;
import cryptocreators.ShiftCryptoCreator;
import cryptocreators.CryptoCreator;
import java.security.AccessControlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Anastasiya Belova
 */
public class Main {
    /**
     * @param args the command line arguments. Read the README to learn about 
     * the operating modes of this program.
     */
    public static void main(String[] args) {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "logback.xml");

        Logger logger = LoggerFactory.getLogger(Main.class);
        ArgumentParser parser = ArgumentParser.getInstance(args);
        //to do: add the Scanner for reading data if args is empty
        
        logger.info("Input string: \"{}\"", parser.getData());
        CryptoCreator creator;
        switch(parser.getNameOfAlgoritm()){
            case("shift"): creator = new ShiftCryptoCreator();
            logger.info("Algorithm of encryption: \"shift\"");
            break;
            case("unicode"): creator = new UnicodeCryptoCreator();
            logger.info("Algorithm of encryption: \"unicode\"");
            break;
            default: creator = new ShiftCryptoCreator();
            logger.info("Algorithm of encryption: \"shift\"");
        }
        Cryptographer cryptographer = creator.
                determineCrypto(parser.getData(), parser.getEncryptMode(), parser.getKey());
        
        logger.info("The key is {}", parser.getKey());
        
        String output;
        if (parser.getEncryptMode()) { 
            output = cryptographer.encrypt();
            logger.info("Mode: encrypt");
            logger.info("Result is \"{}\"", output);
        }
        else { 
            output = cryptographer.decrypt();
            logger.info("Mode: decrypt");
            logger.info("Result is \"{}\"", output);
        }
        
        OutputManager out = new OutputManager(output);
        try {
            out.go(parser.getOutPath());
        }
        
        catch (AccessControlException e){
            logger.error("Access is denied: {}", parser.getOutPath());
        }
        catch(RuntimeException e){
            logger.error("Unchecked exception: {}", e.getMessage());
        }
    }
}
