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
public class ShiftCryptographer extends Cryptographer{
    
    public ShiftCryptographer(){
        super();
    }
    
    @Override
    public String decrypt(){
        char[] input = super.getInput().toCharArray();
        int key = super.getKey()%26;
        String newStr = new String();
        for (char character : input){
            if ((int)character >= 65 && (int)character <= 90){
                newStr += (char)(90 - ((90 - (int)character) + key)%26);
            }
            else if((int)character >= 97 && (int)character <= 122){
                newStr += (char)(122 - ((122 - (int)character) + key)%26);
            }
            else{
                newStr += character;
            }
        }
        return newStr;
    }
    
    @Override
    public String encrypt(){
        char[] input = super.getInput().toCharArray();
        int key = super.getKey()%26;
        String newStr = new String();
        for (char character : input){
            if ((int)character >= 65 && (int)character <= 90){
                newStr += (char)((((int)character - 65) + key)%26 + 65);
            }
            else if((int)character >= 97 && (int)character <= 122){
                newStr += (char)((((int)character - 97) + key)%26 + 97);
            }
            else{
                newStr += character;
            }
        }
        return newStr;
    }
}
