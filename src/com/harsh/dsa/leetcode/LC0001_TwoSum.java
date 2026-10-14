package com.harsh.dsa.leetcode;
/*
 * LeetCode 0001 - Two Sum
 *
 * Difficulty       : Easy
 *  Time Complexity  : O(nlogn)
 * Space Complexity : O(n)
 *
 * Date Solved      : 14-10-2026
 */
import java.util.Arrays;

public class LC0001_TwoSum {
    public static void main(String[] args){
        int[] nums = {2,7,11,13};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    static int[] twoSum(int[] nums, int target) {
        int[][] numsWithIndex = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }

        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int st = 0;
        int end = nums.length - 1;
        while(st < end){
            int sum = numsWithIndex[st][0] + numsWithIndex[end][0];
            if(sum == target){
                return new int[] {numsWithIndex[st][1], numsWithIndex[end][1]};
            }
            if(sum > target){
                end--;
            } else {
                st++;
            }
        }
        return new int[] {-1, -1};
    }
}
