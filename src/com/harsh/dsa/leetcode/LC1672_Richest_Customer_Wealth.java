package com.harsh.dsa.leetcode;
/*
 * LeetCode 1672 - Richest Customer Wealth
 *
 * Difficulty       : Easy
 *
 * Date Solved      : 08-07-2026
 */

public class LC1672_Richest_Customer_Wealth {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {3, 6, 1}
        };
        System.out.println(maximumWealth(a));
    }

    static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int currWealth = 0;
            for (int i : account) {
                currWealth += i;
            }
            if (currWealth > maxWealth) maxWealth = currWealth;
        }
        return maxWealth;
    }
}
