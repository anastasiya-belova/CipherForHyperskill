/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptofabric;

import cipheralgoritms.Cryptographer;
import cipheralgoritms.ShiftCryptographer;

/**
 *
 * @author Kraz
 */
public class ShiftCryptoFabric extends CryptoFabric{
    
    @Override
    public Cryptographer createCrypto(){
        return new ShiftCryptographer();
    }
}
