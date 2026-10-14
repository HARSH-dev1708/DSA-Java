package com.harsh.dsa.leetcode;
/*
 * LeetCode 0001 - Two Sum
 *
 * Difficulty       : Easy
 *  Time Complexity  : O(n*2)
 * Space Complexity : O(1)
 *
 * Date Solved      : 14-10-2026
 */
import java.util.Arrays;

public class LC0001_TwoSum {
    public static void main(String[] args){
        int[] nums = {2,15,11,7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
