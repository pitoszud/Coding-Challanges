/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.Scanner;

/**
 *
 * @author patry
 */
public class DrawingBook {
    static int n = 0;
    static int p = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        p = in.nextInt();
        
        if ((n>=1)&&(n<=100000)) {
            if ((p>=1)&&(p<=n)) {
                String totalTurns = String.valueOf(getMinTurns());
                System.out.println(totalTurns);
            }
        }
    }
    
    public static int getMinTurns(){
        int counterL = 0;
        int counterR = 0;
        
        // evaluate only even pages. 
        if (p%2 != 0) {
            p--;
        }
        
        // 1 would become 0 so...
        if (p!=0) {
           for (int i = 0; i < n; i+=2) {
                counterL++;
                //System.out.println(i);
                if (p==i) {
                    counterL--;
                    break;
                }
            } 
        }
        //System.out.println("total turns from left: " + counterL);
        
        // evaluate only even pages
        if (n%2 != 0) {
            n--;
        }
        
        if ((p!=n-1)||(p!=n)) {
           for (int i = n; i > 0; i-=2) {
               //System.out.println(i);
                counterR++;
                //System.out.println(i);
                if (p==i) {
                    counterR--;
                    break;
                }
            }
        }
        //System.out.println("total turns from right: " + counterR);
        
        if (counterL < counterR) {
            //System.out.println(counterL);
            return counterL;
        }
        else if(counterL == counterR){
            //System.out.println(counterL);
            return counterL;
        }
        else{
            //System.out.println(counterR);
            return counterR;
        }
    }
}
