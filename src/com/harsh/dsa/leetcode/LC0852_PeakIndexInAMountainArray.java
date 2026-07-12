package com.harsh.dsa.leetcode;
/*
 * LeetCode 852 - Peak Index in a Mountain Array
 *
 * Difficulty       : Medium
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 11-07-2026
 */
public class LC0852_PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 11, 7, 6, 5};
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }
}
