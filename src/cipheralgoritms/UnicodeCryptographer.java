package cipheralgoritms;

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
        String input = super.getInput();
        int key = super.getKey();
        String newStr = new String();
        for (int i = 0; i < input.length(); i++){
            if ((int)input.charAt(i)-key < 31){
                newStr += (char)(127 - 32%((int)input.charAt(i)-key));
            }
            else{
                newStr += (char)((int)input.charAt(i)-key);
            }
        }
        return newStr;
    }
    
    @Override
    /**
     * Shifts each character by the key FORWARD according to its order in the table.
     */
    public String encrypt(){
        String input = super.getInput();
        int key = super.getKey();
        String newStr = new String();
        for (int i = 0; i < input.length(); i++){
            if ((int)input.charAt(i)+key > 127){
                newStr += (char)(((int)input.charAt(i)+key)%127 + 32);
            }
            else{
                newStr += (char)((int)input.charAt(i)+key);
            }
        }
        return newStr;
    }
}
