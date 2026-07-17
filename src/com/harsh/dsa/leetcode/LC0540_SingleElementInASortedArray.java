package com.harsh.dsa.leetcode;
/*
 * LeetCode 540 - Single Element in a Sorted Array
 *
 * Difficulty       : Hard
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 17-07-2026
 */
public class LC0540_SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
    static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        int low = 1, high = n-2;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid+1]==nums[mid])){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
