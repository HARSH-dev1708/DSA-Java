package com.harsh.dsa.leetcode;
/*
 * LeetCode 410 - Split Array Largest Sum
 *
 * Difficulty       : Hard
 * Time Complexity  : O(nlog(s-m)) where s = sum(nums), m = max(nums)
 * Space Complexity : O(1)
 *
 * Date Solved      : 14-07-2026
 */
public class LC0410_SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 3; // No. of sub arrays
        int start = 0;
        int end = 0;

        // 1. Takes O(N) time to find the bounds: the max element (start) and total sum (end).
        for(int num : nums){
            start = Math.max(start, num);
            end += num;
        }

        // 2. The while loop cuts the search space (sum - max) in half each time, running O(log(sum - max)) steps.
        //    Inside, the for-loop scans the array of size N. Total time for this phase: O(N * log(sum - max)).
        while(start < end){
            int mid = start + (end - start) / 2; // potential ans

            int pieces = 1;
            int sum = 0;
            for(int num : nums){
                if(num + sum > mid){
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if(pieces > k){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }
}
