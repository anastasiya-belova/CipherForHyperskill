/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptofabric;
import cipheralgoritms.*;
/**
 *
 * @author Kraz
 */
public abstract class CryptoFabric {
    
    abstract Cryptographer createCrypto();
    
    public Cryptographer determineCrypto(String input, boolean encryptMode, int key){
        Cryptographer cr = createCrypto();
        cr.setInput(input);
        cr.setEncryptMode(encryptMode);
        cr.setKey(key);
        return cr;
    }
}
