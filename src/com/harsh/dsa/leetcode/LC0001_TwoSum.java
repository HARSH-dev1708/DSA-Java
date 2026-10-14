package com.harsh.dsa.leetcode;
/*
 * LeetCode 0001 - Two Sum
 *
 * Difficulty       : Easy
 *  Time Complexity  : O(n)
 * Space Complexity : O(n)
 * Hash Map
 *
 * Date Solved      : 14-10-2026
 */
import java.util.Arrays;
import java.util.HashMap;

public class LC0001_TwoSum {
    public static void main(String[] args){
        int[] nums = {11,13,7,2};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
