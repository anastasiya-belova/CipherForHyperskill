package cryptocreators;

import cipheralgoritms.Cryptographer;
import cipheralgoritms.ShiftCryptographer;

/**
 * 
 * @author Anastasiya-Belova
 */
public class ShiftCryptoCreator extends CryptoCreator{
    
    @Override
    /**
     * Creates a new instance of ShiftCryptographer.
     */
    Cryptographer createCrypto(){
        return new ShiftCryptographer();
    }
}
