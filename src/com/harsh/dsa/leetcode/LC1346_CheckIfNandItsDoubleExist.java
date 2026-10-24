package com.harsh.dsa.leetcode;
/*
 * LeetCode 1345 - Check If N and Its Double Exist
 *
 * Difficulty       : Easy
 *  Time Complexity  : O(n)
 * Space Complexity : O(n)
 *
 * Date Solved      : 24-10-2026
 */
import java.util.HashSet;

public class LC1346_CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = {10, 3, 7, 2};
        System.out.println(checkIfExist(arr));
    }
    static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int j : arr) {
            if (set.contains(j * 2) || (j % 2 == 0 && set.contains(j / 2))) {
                return true;
            }
            set.add(j);
        }
        return false;
    }
}
