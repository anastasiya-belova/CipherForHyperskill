package cipherforhyperskill;

import cipheralgorithms.Cryptographer;
import cryptocreators.UnicodeCryptoCreator;
import cryptocreators.ShiftCryptoCreator;
import cryptocreators.CryptoCreator;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.security.AccessControlException;

/**
 *
 * @author Anastasiya-Belova
 */
public class Main {

    /**
     * @param args the command line arguments. Read the README to learn about 
     * the operating modes of this program.
     */
    public static void main(String[] args) {
        
        ArgumentParser parser = ArgumentParser.getInstance(args);
        //to do: add the Scanner for reading data if args is empty
        
        CryptoCreator creator;
        switch(parser.getNameOfAlgoritm()){
            case("shift"): creator = new ShiftCryptoCreator();
            break;
            case("unicode"): creator = new UnicodeCryptoCreator();
            break;
            default: creator = null;
            System.out.println("Error, you entered an invalid name of algoritm: \"" 
                    + parser.getNameOfAlgoritm() + 
                    "\". Valid name of algs is \"shift\" and \"unicode\" (without the quotes).");//to do: clarify the logger
            break;
        }
        if (creator == null){ return; }
        Cryptographer cryptographer = creator.
                determineCrypto(parser.getData(), parser.getEncryptMode(), parser.getKey());
        
        String output;
        if (parser.getEncryptMode()) { output = cryptographer.encrypt(); }
        else { output = cryptographer.decrypt();}
        
        //Prints an information about the program operation mode
        System.out.println("You have chosen:");
        System.out.println("  algorithm of encryption: " + parser.getNameOfAlgoritm());
        System.out.print("  mode: ");
        if (parser.getEncryptMode()) {System.out.println("encryption");}
        else {System.out.println("decryption");}
        System.out.println("  key: " + parser.getKey());
        System.out.println("  input string: " + parser.getData());
        
        //to do: all exceptions to log
        OutputManager out = new OutputManager(output);
        try {
            out.go(parser.getOutPath());
        } catch (FileAlreadyExistsException e) {
            System.out.println("File with this name already exists. "
                    + "It's very strange that you saw this message.");
        }
        catch (NoSuchFileException e){
            System.out.println("File with this name does not exists. "
                    + "It's very strange that you saw this message.");
        }
        catch (AccessDeniedException e){
            System.out.println("File system operation is denied. "
                    + "Check the permission of the file in which you are going to write data");
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch (AccessControlException e){
            System.out.println("Access is denied: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unchecked exception: " + e.getMessage());
        }
    }
}
