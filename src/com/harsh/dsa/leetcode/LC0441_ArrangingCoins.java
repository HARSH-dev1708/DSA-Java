package com.harsh.dsa.leetcode;
/*
 * LeetCode 441 - Arranging Coins
 *
 * Difficulty       : Easy
 * Algorithm        : Brute force
 * Time Complexity  : O(n^(1/2))
 * Space Complexity : O(1)
 *
 * Date Solved      : 19-10-2026
 *
 * Note: Alternate solution is one line which is derived from quadratic formula - return (int)((Math.sqrt(1 + 8.0 * n) - 1) / 2);
 */
import java.util.Scanner;

public class LC0441_ArrangingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(arrangeCoins(n));
    }
    static int arrangeCoins(int n) {
        int count = 0;
        while(n > 0){
            count++;
            if(count <= n){
                n -= count;
            } else {
                n = 0;
                count--;
            }
        }
        return count;
    }
}
