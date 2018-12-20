/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author patry
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if ((s.length()>=1)&&(s.length()<=100000)) {
            getWords(s);
        }
    }
    
    public static void getWords(String s){
        String str = "";
        //List<String> wordList = new ArrayList<>();
        int wordBeg = 0;
        int counter = 1;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                String word = s.substring(wordBeg, i);
                //wordList.add(word);
                wordBeg = i;
                counter++;
            }
        }
        //String lastWord = s.substring(wordBeg, s.length());
        //wordList.add(lastWord);
        //System.out.println(wordList);
        System.out.println(counter);
    }
}
