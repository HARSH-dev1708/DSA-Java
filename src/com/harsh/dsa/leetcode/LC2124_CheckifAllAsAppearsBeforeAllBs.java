package com.harsh.dsa.leetcode;
/*
 * LeetCode 2124 - Check if All A's Appears Before All B's
 *
 * Difficulty       : Easy
 *
 * Date Solved      : 22-11-2026
 */
import java.util.Scanner;

public class LC2124_CheckifAllAsAppearsBeforeAllBs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("All a's appear before all b's: " +  checkString(s));
    }
    static boolean checkString(String s) {
        int lastPosOfA = s.lastIndexOf('a') ;
        int firstPosOfB = s.indexOf('b');
        if(firstPosOfB == -1) return true;
        if(lastPosOfA > firstPosOfB) return false;
        return true;
    }
}
