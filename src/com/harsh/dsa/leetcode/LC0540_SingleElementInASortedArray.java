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

        // Edge case 1: Array has only 1 element
        if(n == 1) return nums[0];

        // Edge case 2: The single element is at the very beginning
        if(nums[0] != nums[1]) return nums[0];

        // Edge case 3: The single element is at the very end
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int start = 1;
        int end = n - 2;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            // Check if we are on the LEFT side of the single element
            // Condition 1: mid is even, and it matches the next element
            // Condition 2: mid is odd, and it matches the previous element
            if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])){
                // The pattern is intact, single element is to the right
                start = mid + 1;
            } else {
                // The pattern is broken, single element is to the left
                end = mid - 1;
            }
        }
        return -1;
    }
}
