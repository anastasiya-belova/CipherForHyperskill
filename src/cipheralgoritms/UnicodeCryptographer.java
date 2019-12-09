/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipheralgoritms;

/**
 *
 * @author Kraz
 */
public class UnicodeCryptographer extends Cryptographer{
    
    public UnicodeCryptographer(){
        super();
    }
    
    @Override
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
