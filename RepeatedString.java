/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;


import java.util.Scanner;


public class RepeatedString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        if (chkS(s)) {
            if (chkI(n)) {
                System.out.println(getV(s,n));
            }
        }
    }
    
    public static long getV(String str, long n){
        long charCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='a') {
                charCount++;
            }
        }
        long d = n / str.length();
        long r = n % str.length();
        long sol = charCount * d;
        
        for (int i = 0; i < r; i++) {
            if (str.charAt(i)=='a') {
                sol++;
            }
        }
        return sol;
    }
    
    public static boolean chkS(String str){
        boolean chk = false;
        if ((str.length()>=1)&&(str.length()<=100)) {
            //System.out.println(str + " within a range");
            chk = true;
        }
        else{
            //System.out.println(str + " too large or too small");
        }
        return chk;
    }
    
    public static boolean chkI(long n){
        boolean chk = false;
        if ((n>=1)&&(n<=1000000000000L)) {
            //System.out.println(n + " within a range");
            chk = true;
        }
        else{
            //System.out.println(n + " too large or too small");
        }
        return chk;
    }
    
}
