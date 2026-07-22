package com.harsh.dsa.leetcode;
/*
 * LeetCode 704 - Binary Search
 *
 * Difficulty       : Easy
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 22-07-2026
 */
import java.util.Scanner;

public class LC0704_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(search(nums, target));
    }
    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]<target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
