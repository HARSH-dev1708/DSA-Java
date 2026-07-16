package com.harsh.dsa.leetcode;
/*
 * LeetCode 278 - First Bad Version
 *
 * Difficulty       : Easy
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 * Algorithm        : Binary Search
 *
 * Date Solved      : 16-07-2026
 */
public class LC0278_FirstBadVersion {
    static class FirstBadVersion {
        public static int bad = 4;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("First Bad Version is : " + firstBadVersion(n));
    }
    static int firstBadVersion(int n) {
        int start = 1; // Changed from 0 to 1 since versions start at 1
        int end = n;
        int version = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if(isBad){
                version = mid;
                end = mid - 1; // Look left to see if there's an even earlier bad version
            } else {
                start = mid + 1; // Look right because all versions up to mid are good
            }
        }
        return version;
    }
    static boolean isBadVersion(int v){
        return v >= FirstBadVersion.bad;
    }
}
