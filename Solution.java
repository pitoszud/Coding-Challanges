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
public class Solution {
    static int at = 0;
    static int bt = 0;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        compare(a0,b0);
        compare(a1,b1);
        compare(a2,b2);
        
        if (!(at == 0)&&!(bt == 0)) {
            System.out.println(at + " " + bt);
        }
    }
    
    public static void compare(int a, int b){
        if ((a>=1)&&(a<=100)) {
            if ((b>=1)&&(b<=100)) {
                if (a>b) {
                    at++;
                }
                else if(b>a){
                    bt++;
                }
            }
        }
    }
}
