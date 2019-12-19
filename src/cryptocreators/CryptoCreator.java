package cryptocreators;
import cipheralgorithms.Cryptographer;
/**
 * Creates a new instance of Cryptographer and specified all necessary fields for this instance.
 * @author Anastasiya Belova
 */
public abstract class CryptoCreator {
    
    abstract Cryptographer createCrypto();
    
    /**
     * Specified all necessary fields for instance of "Cryptographer".
     * @param input
     * @param encryptMode
     * @param key
     * @return 
     */
    public Cryptographer determineCrypto(String input, boolean encryptMode, int key){
        Cryptographer cr = createCrypto();
        cr.setInput(input);
        cr.setEncryptMode(encryptMode);
        cr.setKey(key);
        return cr;
    }
}
