package cipheralgorithms;

/**
 * It is a classic Caesar cipher. Shifts each letter by the specified number according 
 * to its order in the alphabet. Doesn't modify non-letter character.
 * Encrypts or decrypts only English letters, in upper case and lower case.
 * @author Anastasiya Belova
 */
public class ShiftCryptographer extends Cryptographer{
    
    public ShiftCryptographer(){
        super();
    }
    
    @Override
    /**
     * Shifts each letter by the key BACK according to its order in the alphabet.
     */
    public String decrypt(){
        char[] input = super.getInput().toCharArray();
        int key = super.getKey()%26;
        StringBuilder newStr = new StringBuilder();
        for (char character : input){
            if ((int)character >= 65 && (int)character <= 90){
                newStr.append((char)(90 - ((90 - (int)character) + key)%26));
            }
            else if((int)character >= 97 && (int)character <= 122){
                newStr.append((char)(122 - ((122 - (int)character) + key)%26));
            }
            else{
                newStr.append(character);
            }
        }
        return newStr.toString();
    }
    
    @Override
    /**
     * Shifts each letter by the key FORWARD according to its order in the alphabet.
     */
    public String encrypt(){
        char[] input = super.getInput().toCharArray();
        int key = super.getKey()%26;
        StringBuilder newStr = new StringBuilder();
        for (char character : input){
            if ((int)character >= 65 && (int)character <= 90){
                newStr.append((char)((((int)character - 65) + key)%26 + 65));
            }
            else if((int)character >= 97 && (int)character <= 122){
                newStr.append((char)((((int)character - 97) + key)%26 + 97));
            }
            else{
                newStr.append(character);
            }
        }
        return newStr.toString();
    }
}
