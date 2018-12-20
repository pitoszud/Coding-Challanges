/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRank17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class EqualizeArray {

    public static void main(String[] args) {
//        List<Integer> intList = new ArrayList<>();
//        Scanner in = new Scanner(System.in);
//        Integer n = in.nextInt();
//        if (checkInput(n)) {
//            for (int i = 0; i < n; i++) {
//                intList.add(in.nextInt());
//            }
//        }
//        else{
//            in.close();
//        }
//        if (checkList(intList)) {
//            System.out.println(getMaxOccur(intList));
//        }
//        else{
//            in.close();
//        }

        //List<Integer> intList = Arrays.asList(3,3,2,7,2,1,6,7,8,3);
        List<Integer> intList0 = Arrays.asList(41, 22, 80, 80, 41, 41, 41, 80, 22, 80, 22, 41, 41, 41, 80, 80, 22, 22, 22, 22, 41, 80, 80, 41, 22, 80, 80, 80, 80, 41, 22, 80, 22, 22, 22, 80, 22, 80, 80, 41, 22, 41, 41, 22, 22, 41, 22, 22, 80, 22, 22, 80, 41);

        getMaxOccur2(intList0);
        //getMaxOccur(intList0);

    }

    public static int getMaxOccur(List<Integer> intList) {
        long startTime = System.nanoTime();
        int maxCount = 0;
        int currentCount = 1;
        List<Integer> sil = intList;
        Collections.sort(sil);
        for (int i = 0; i < sil.size() - 1; i++) {
            if (Objects.equals(sil.get(i + 1), sil.get(i))) {
                currentCount++;
                //System.out.println(sil.get(i+1) +" == "+ sil.get(i) + " increasing currentCount to " + currentCount);
                maxCount = currentCount;
            } else {
                if (currentCount > maxCount) {
                    //System.out.println(currentCount + " > " + maxCount);
                    maxCount = currentCount;
                    currentCount = 1;
                    //System.out.println(" maxCount increased to " + maxCount + ". Reset currentCount to 1");
                } else {
                    currentCount = 1;
                    //System.out.println(currentCount + " <= " + maxCount);
                    //System.out.println("Reset currentCount to 1");
                }
            }
        }
        System.out.println(intList.size() + " - " + maxCount);
        int sol = intList.size() - maxCount;

        long endTime = System.nanoTime();
        System.out.println("Sorting method: " + (endTime - startTime));
        return sol;
    }

    public static int getMaxOccur2(List<Integer> intList) {
        long startTime = System.nanoTime();
        int maxCount = 1;
        List<Integer> sil = intList;
        Map<Integer, Integer> ml = new HashMap<>();
        for (Integer i : sil) {
            if (!ml.containsKey(i)) {
                ml.put(i, 1);
            } else {
                int gi = ml.get(i) + 1;
                ml.replace(i, gi);
                if (gi > maxCount) {
                    maxCount = gi;
                }
            }
        }
        int sol = intList.size() - maxCount;
        System.out.println(sol);

        long endTime = System.nanoTime();
        System.out.println("HashMap method: " + (endTime - startTime));
        return sol;
    }

    public static List<Integer> getList(int inputNum) {
        List<Integer> intL = new ArrayList<>();
        for (int i = 0; i < inputNum; i++) {

        }

        return intL;
    }

    public static boolean checkInput(int n) {
        boolean chk = false;
        if ((n >= 1) && (n <= 100)) {
            chk = true;
        } else {
            //System.out.println(n + " is too large or too small");
        }
        return chk;
    }

    public static boolean checkList(List<Integer> intList) {
        boolean chk = true;
        for (Integer i : intList) {
            if (!(i >= 1) || !(i <= 100)) {
                //System.out.println(i + " is too large or too small");
                chk = false;
                break;
            }
        }
        return chk;
    }
}
