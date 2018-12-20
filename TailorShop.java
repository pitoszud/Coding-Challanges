/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TailorShop {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        int clasterNum = in.nextInt();
        int buttonPrice = in.nextInt();
        if ((clasterNum>=1)&&(clasterNum<=100000)) {
            if ((buttonPrice>=1)&&(buttonPrice<=100000)) {
                shop(clasterNum, buttonPrice);
            }
        }
    }
    
    public static void shop(int clasterNum, int buttonPrice){
        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < clasterNum; i++) {
            priceList.add(in.nextInt());
        }
        int maxC = 0;
        int currentClasterNum = 0;
        for (Integer price : priceList) {
            if (price%buttonPrice == 0) {
                if (currentClasterNum < (price / buttonPrice)) {
                    currentClasterNum = (price / buttonPrice); // 4/2
                    maxC += currentClasterNum;
                    System.out.println(price + "/" + buttonPrice + " = " + maxC + " ClasterNum: " + currentClasterNum);
                }
                else{
                    currentClasterNum = (price / buttonPrice)+1;
                    maxC += currentClasterNum;
                    System.out.println(price + "/" + buttonPrice + " = " + maxC + " ClasterNum: " + currentClasterNum);
                }
            }
            else{
                if (currentClasterNum < (price / buttonPrice)) {
                    currentClasterNum = (price / buttonPrice)+1;
                    maxC += currentClasterNum;
                    System.out.println(price + "/" + buttonPrice + " = " + maxC + " ClasterNum: " + currentClasterNum);
                }
                else{
                    maxC += (currentClasterNum* buttonPrice) + (2*buttonPrice);
                    System.out.println(price + "/" + buttonPrice + " = " + maxC + " ClasterNum: " + currentClasterNum);
                }
                
            }
        }
        System.out.println(maxC);
    }
}
