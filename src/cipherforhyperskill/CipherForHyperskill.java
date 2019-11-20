/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherforhyperskill;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 * @author Kraz
 */
public class CipherForHyperskill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String flag = sc.nextLine();
        String str = sc.nextLine();
        int key = sc.nextInt();
        if (flag.equals("dec")){
            System.out.println(decrypt(str, key));
        }
        if (flag.equals("enc")){
            System.out.println(encrypt(str, key));
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
