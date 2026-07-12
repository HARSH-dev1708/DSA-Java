package com.harsh.dsa.leetcode;
/*
 * LeetCode 162 - Find Peak Element
 *
 * Difficulty       : Medium
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 12-07-2026
 */
public class LC0162_FindPeakElement {
    public static void main(String[] args) {
        int[] nums ={1, 3, 5, 4, 2, 0};
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}
