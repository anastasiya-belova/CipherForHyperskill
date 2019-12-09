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
public abstract class Cryptographer {
    
    private String input;
    private boolean encryptMode;
    private String result;
    private int key;
    
    public abstract String decrypt();
    public abstract String encrypt();
    
    public String getResult(){
        return result;
    }
    
    public void setInput(String input){
        this.input = input;
    }
    
    public String getInput(){
        return input;
    }
    
    public void setKey(int key){
        this.key = key;
    }
    
    public int getKey(){
        return key;
    }
    
    public void setEncryptMode(boolean encryptMode){
        this.encryptMode = encryptMode;
    }
    
    public boolean isEncryptMode(){
        return encryptMode;
    }
}
