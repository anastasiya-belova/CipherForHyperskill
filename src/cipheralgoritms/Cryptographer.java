package cipheralgoritms;

/**
 * Provides a common interface fo working with an entity "Cryptographer".
 * 
 * @author Anastasiya-Belova
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
