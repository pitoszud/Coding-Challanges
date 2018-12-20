/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MiniMax2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String intLine = in.nextLine();
        List<Long> longList = getIntList(intLine);
        if (doIfInRange(longList)) {
            getMinMax(longList);
        }
    }
    
    public static boolean doIfInRange(List<Long> longList){
        boolean chk = true;
        for (Long longNum : longList) {
            if ((longNum<1)&&(longNum>10*9)) {
                chk = false;
            }
        }
        return chk;
    }
    
    public static void getMinMax(List<Long> intList){
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < intList.size(); i++) {
            //System.out.println("outer: " + i);
            sum = sum + intList.get(i); // 1, 3, 6...
            if (min > intList.get(i)) {
                min = intList.get(i);
            }
            if (max < intList.get(i)) {
                max = intList.get(i);
            }
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
    
    public static List<Long> getIntList(String str){
        List<Long> longList = new ArrayList<>();
        int beg = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).equals(" ")) {
                String numStr = str.substring(beg, i);
                Long num = Long.parseLong(numStr);
                longList.add(num);
                beg = i+1;
            }
        }
        String lastStr = str.substring(beg, str.length());
        Long lastInt = Long.parseLong(lastStr);
        longList.add(lastInt);
        return longList;
    }
}
