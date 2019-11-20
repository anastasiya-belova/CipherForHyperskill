/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherforhyperskill;

/**
 *
 * @author Kraz
 */
public class CipherForHyperskill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String data = "";
        boolean enc = true;
        int key = 0;
        int dataIndex = -1;
        int modeIndex = -1;
        int keyIndex = -1;
        //поиск ключевых слов
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-data")){
                dataIndex = i;
            }
            if (args[i].equals("-mode")){
                modeIndex = i;
            }
            if (args[i].equals("-key")){
                keyIndex = i;
            }
        }
        //добавление значений data, key, mode
        if (dataIndex != -1){
            data += args[dataIndex+1];
        }
        if (keyIndex != -1){
            key = Integer.parseInt(args[keyIndex+1]);
        }
        if (modeIndex != -1){
            if (args[modeIndex+1].equals("dec")){
                enc = false;
            }
        }
        //вызов функции
        if(enc){
            System.out.println(encrypt(data, key));
        }
        else{
            System.out.println(decrypt(data, key));
        }
    }
    
    public static String encrypt(String str, int key){
        String newStr = new String();
        for (int i = 0; i < str.length(); i++){
            if ((int)str.charAt(i)+key > 127){
                newStr += (char)(((int)str.charAt(i)+key)%127 + 32);
            }
            else{
                newStr += (char)((int)str.charAt(i)+key);
            }
        }
        return newStr;
    }
    
    public static String decrypt(String str, int key){
        String newStr = new String();
        for (int i = 0; i < str.length(); i++){
            if ((int)str.charAt(i)-key < 31){
                newStr += (char)(127 - 32%((int)str.charAt(i)-key));
            }
            else{
                newStr += (char)((int)str.charAt(i)-key);
            }
        }
        return newStr;
    }
}
