/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherforhyperskill;

import cipheralgoritms.*;
import cryptofabric.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kraz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArgumentParser parser = new ArgumentParser(args);
        
        CryptoFabric fabric;
        switch(parser.getNameOfAlgoritm()){
            case("shift"): fabric = new ShiftCryptoFabric();
            break;
            case("unicode"): fabric = new UnicodeCryptoFabric();
            break;
            default: fabric = null;
            System.out.println("Error");//to do: clarify the exception
            break;
        }
        Cryptographer cryptographer = fabric.
                determineCrypto(parser.getData(), parser.getEncryptMode(), parser.getKey());
        
        String output;
        if (parser.getEncryptMode()) { output = cryptographer.encrypt(); }
        else { output = cryptographer.decrypt();}
        
        OutputManager out = new OutputManager(output);
        try {
            out.go(parser.getOutPath()); //to do: clarify the exception
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
