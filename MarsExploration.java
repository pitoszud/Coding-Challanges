/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.Scanner;


public class MarsExploration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        if (checkConstr(S)) {
            System.out.println(getLetterChanges2(S));
        }
    }
    
    public static int getLetterChanges(String str){
        int sosNum = str.length()/3;
        int missLettCount = 0;
        int sBeg = 0;
        int sEnd = 3;
        char char03 = "S".charAt(0);
        char char1 = "O".charAt(0);
        for (int i = 0; i < sosNum; i++) {
            String sosStr = str.substring(sBeg,sEnd);
            //System.out.println(sosStr);
            if (sosStr.charAt(0) != char03) {
                missLettCount ++;
            }
            if (sosStr.charAt(1) != char1) {
                missLettCount ++;
            }
            if (sosStr.charAt(2) != char03) {
                missLettCount ++;
            }
            sBeg += 3;
            sEnd += 3;
        }
        return missLettCount;
    }
    
    public static int getLetterChanges2(String str){
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != sos.charAt(i%3)) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean checkConstr(String str){
        boolean chk = false;
        if ((str.length()>=1)&&(str.length()<=99)) {
            if (str.length()%3 == 0) {
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isUpperCase(str.charAt(i))) {
                        chk = true;
                    }
                    else{
                        chk = false;
                        break;
                    }
                }
            }
        }
        return chk;
    }
}
