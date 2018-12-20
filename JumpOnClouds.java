/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.Scanner;


public class JumpOnClouds {
    public static void main(String[] args) {
        //int[] cl = {0,0,1,0,0,1,0};
        int[] cl = {0,0,0,1,0,0};
        
//        Scanner in = new Scanner(System.in);
//        int cNum = in.nextInt();
//        int[] cl = new int[cNum];
//        for (int i = 0; i < cl.length; i++) {
//            cl[i] = in.nextInt();
//        }
//        
//        if (chk(cNum)) {
//            if (chkFirst(cl)) {
//                if (chkLoop(cl)) {
//                    joc(cl);
//                }
//            }
//        }
        
    joc2(cl);
        
    }
    
    public static void joc(int[] cl){
        int i = 0;
        int count = 0;
        while (i <= cl.length) { // while the pointer is not outside of the list (1,2,3,4,5,x)
            System.out.println(i + " <= " + cl.length);
            if (i < cl.length-2) { // if the pointer is less than the last -1 item in the list (1,2,3,x,5)
                System.out.println(i + " < " + (cl.length-2));
                if (cl[i+2] == 1) {
                    i++;
                    count++;
                    System.out.println("position+1: " + i + " ; counter: " + count);
                }
                else{
                    i += 2;
                    count++;
                    System.out.println("position+2: " + i + " ; counter: " + count);
                    
                }
            }
            else if (i == cl.length-2){ // if the pointer is at last -1 item in the list (1,2,3,x,5)
                System.out.println(i + " == " +(cl.length-2));
                count++;
                break;
            }
            else{ // the pointer is at the last item in the list (1,2,3,4,x)
                break;
            }
            
        }
        System.out.println(count);
    }
    
    public static void joc2(int[] cl){
        int i = 0;
        int count = 0;
        while (i < cl.length-1) { // while the pointer is less than the last item in the list (1,2,3,4,x)
            if (((i + 2) > cl.length-1) || (cl[i + 2] == 1)) { // if the pointer +2 is outside the list or equlas 1
                i++;
                count++;
            }
            else{
                i += 2;
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean chk(int n){
        boolean chk = false;
        if ((n>=2)&&(n<=100)) {
            //System.out.println(n + " within a range");
            chk = true;
        }
        else{
            //System.out.println(n + " too large or too small");
        }
        return chk;
    }
    
    public static boolean chkLoop(int[] zeroOnes){
        boolean chk = true;
        for (int i = 0; i < zeroOnes.length; i++) {
            if (!(zeroOnes[i]==0)&&!(zeroOnes[i]==1)) {
                //System.out.println(zeroOnes[i] + " is too large or too small");
                chk = false;
                break;
            }
            else{
                //System.out.println(zeroOnes[i] + " within a range");
            }
        }
        return chk;
    }
    
    public static boolean chkFirst(int[] zeroOnes){
        boolean chk = true;
        if (zeroOnes[0]==1) {
            chk = false;
        }
        return chk;
    }
}   
