package cryptocreators;

import cipheralgorithms.Cryptographer;
import cipheralgorithms.UnicodeCryptographer;

/**
 * 
 * @author Anastasiya-Belova
 */
public class UnicodeCryptoCreator extends CryptoCreator{
    
    @Override
    /**
     * Creates a new instance of UnicodeCryptographer.
     */
    Cryptographer createCrypto(){
        return new UnicodeCryptographer();
    }
}
