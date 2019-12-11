package cipheralgorithms;

/**
 * It is a modify Caesar cipher. Shifts each letter by the specified number according 
 * to its order in the UNICODE table. Limits of use: English letters, digits, 
 * space, basic math symbols etc. from 32 to 126 (include) in UNICODE table.
 * @author Anastasiya-Belova
 */
public class UnicodeCryptographer extends Cryptographer{
    
    public UnicodeCryptographer(){
        super();
    }
    
    @Override
    /**
     * Shifts each character by the key BACK according to its order in the table.
     */
    public String decrypt(){
        char[] input = super.getInput().toCharArray();
        int key = super.getKey();
        StringBuilder newStr = new StringBuilder();
        for (char character : input){
            if((int)character >= 32 && (int)character <= 126){
                newStr.append((char)(126 - ((126 - (int)character) + key)%95));
            }
            else{
                newStr.append(character);
            }
        }
        return newStr.toString();
    }
    
    @Override
    /**
     * Shifts each character by the key FORWARD according to its order in the table.
     */
    public String encrypt(){
        char[] input = super.getInput().toCharArray();
        int key = super.getKey();
        StringBuilder newStr = new StringBuilder();
        for (char character : input){
            if ((int)character >= 32 && (int)character <= 126){
                newStr.append((char)((((int)character - 32) + key)%95 + 32));
            }
            else{
                newStr.append(character);
            }
        }
        return newStr.toString();
    }
}
