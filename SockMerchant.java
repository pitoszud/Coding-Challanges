/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        if ((n>=1)&&(n<=100)) {
            List<Integer> buttonList = new ArrayList<>();
            for(Integer i=0; i < n; i++){
                Integer v = in.nextInt();
                if ((v>=1)&&(v<=100)) {
                    buttonList.add(v);
                }
                else{
                    buttonList.clear();
                    break;
                }
            }
            in.close();
            getPairs(buttonList);
        }
    }
    
    
    public static void getPairs(List<Integer> bList){
        List<Integer> pList = new ArrayList<>();
        int counter = 0;
        for (Integer i = 0; i < bList.size(); i++) {
            System.out.println(pList);
            if (pList.contains(bList.get(i))) {
                counter++;
                pList.remove(bList.get(i));
                System.out.println("counter increased to " + counter + "; " + bList.get(i) + " removed");
            }
            else{
                pList.add(bList.get(i));
                System.out.println(bList.get(i) + " added");
            }
        }
        if ((!pList.isEmpty())||(counter > 0)) {
            System.out.println(counter);
        }
        
    }
}
