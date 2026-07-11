package com.harsh.dsa.leetcode;
/*
 * LeetCode 0034 - Find First and Last Position of Element in Sorted Array
 *
 * Difficulty       : Medium
 *  Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 10-07-2026
 */
public class LC_0034_Find_First_and_Last_Position_of_Element_In_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 6, 7, 9};
        int target = 4;
        int firstPos = search(nums, target, true);
        int lastPos = search(nums, target, false);
        System.out.println(firstPos + ", " + lastPos);
    }
    static int search(int[] arr, int target, boolean findStartIdx){
        int start = 0;
        int end = arr.length - 1;
        int index = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            } else if (arr[mid] > target){
                end = mid -1;
            } else {
                index = mid;
                if(findStartIdx){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return index;
    }
}
