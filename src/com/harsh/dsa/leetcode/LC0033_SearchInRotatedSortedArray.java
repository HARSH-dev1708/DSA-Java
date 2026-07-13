package com.harsh.dsa.leetcode;
/*
 * LeetCode 0033 - Search in Rotated Sorted Array
 *
 * Difficulty       : Medium
 *  Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 13-07-2026
 */
public class LC0033_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int pivot = findPivot(nums);
        int ans = -1;
        int target = 1;
        if(pivot == -1){
            ans = binarySearch(nums, target, 0, nums.length-1);
        } else {
            ans = binarySearch(nums, target, 0, pivot);
            if(ans == -1){
                ans = binarySearch(nums, target, pivot + 1, nums.length - 1);
            }
        }
        System.out.println(ans);
    }
    static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid  < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if(nums[start] >= nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            } else if(target < arr[mid]){
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
