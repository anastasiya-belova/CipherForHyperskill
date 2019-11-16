/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherforhyperskill;

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
        String str = sc.nextLine();
        int key = sc.nextInt();
        System.out.println(decrypt(str, key));
    }
    
    public static String decrypt(String str, int key){
        String newStr = new String();
        char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        key = key%26;
        char letterFromStr;
        boolean belongingToTheAlphabet = false;
        for (int i = 0; i < str.length(); i++){
            letterFromStr = str.charAt(i);
            for (int j = 0; j < alphabet.length; j++){
                if (letterFromStr == alphabet[j]){
                    newStr += alphabet[(j + key)%26];
                    belongingToTheAlphabet = true;
                    break;
                }
            }
            if (!belongingToTheAlphabet){
                newStr += letterFromStr;
            }
            belongingToTheAlphabet = false;
        }
        return newStr;
    }
    
}
