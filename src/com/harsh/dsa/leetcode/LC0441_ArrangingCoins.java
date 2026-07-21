package com.harsh.dsa.leetcode;
/*
 * LeetCode 441 - Arranging Coins
 *
 * Difficulty       : Easy
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 21-07-2026
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
        long left = 1, right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;

            if (coinsNeeded == n) {
                return (int) mid;
            } else if (coinsNeeded < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right; // right points to the largest valid k
    }
}
