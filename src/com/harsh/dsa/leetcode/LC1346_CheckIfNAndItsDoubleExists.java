package com.harsh.dsa.leetcode;
/*
 * LeetCode 1346 - Check if N and its Double Exists
 *
 * Difficulty       : Easy
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 25-07-2026
 */
public class LC1346_CheckIfNAndItsDoubleExists {
    public static void main(String[] args) {
        int[] arr = {10,2,7,3};
        System.out.println(checkIfExist(arr));
    }
    static boolean checkIfExist(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            int target = 2 * arr[i];
            int idx = binarySearch(sorted, target);

            if (idx == -1) continue;

            if (target == arr[i]) {
                // arr[i] == 0 case: need a second zero nearby
                if (idx > 0 && sorted[idx - 1] == target) return true;
                if (idx < n - 1 && sorted[idx + 1] == target) return true;
            } else {
                return true;
            }
        }
        return false;
    }
    static int binarySearch(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
