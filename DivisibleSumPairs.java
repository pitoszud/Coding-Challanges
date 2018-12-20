/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.Scanner;


public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        if (inRange(n,k,a)) {
            System.out.println(getPairs(n,k,a));
        }
    }
    
    
    public static boolean inRange(int n, int k, int[] a){
        boolean chk = true;
        if (!(n >= 2)&&!(n <= 100)) {
            chk = false;
            if (!(k >= 2)&&!(k <= 100)) {
                chk = false;
                for (int i = 0; i < a.length; i++) {
                    if (!(a[i] >= 1)&&!(a[i] <= 100)) {
                        chk = false;
                    }
                }
            }
        }
        return chk;
    }
    
    public static int getPairs(int n, int k, int[] a){
        int counter = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length - 1; j++) {
                if ((a[i] + a[j + 1]) % k == 0) {
                    counter++;
                }
            }
        }
    return counter;
    }
}


