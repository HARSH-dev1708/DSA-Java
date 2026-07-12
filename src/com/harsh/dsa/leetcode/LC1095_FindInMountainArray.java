package com.harsh.dsa.leetcode;
/*
 * LeetCode 1095 - Find In Mountain Array
 *
 * Difficulty       : Hard
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 12-07-2026
 */
public class LC1095_FindInMountainArray {
    public static void main(String[] args) {
        int[] mountainArr = {1,2,3,4,5,3,1};
        int target = 5;
        int peak = findPeak(mountainArr);
        int index = agnosticBinarySearch(mountainArr, 0, peak, target);
        if(index == -1) index = agnosticBinarySearch(mountainArr, peak + 1, mountainArr.length - 1, target);
        System.out.println(index);
    }
    static int findPeak(int[] mountainArr){
        int start = 0;
        int end = mountainArr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mountainArr[mid] < mountainArr[mid+1]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    static int agnosticBinarySearch(int[] mountainArr, int start, int end, int target){
        boolean isAsc = mountainArr[end] > mountainArr[start];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mountainArr[mid] == target) return mid;
            if(isAsc){
                if(mountainArr[mid] > target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(mountainArr[mid] < target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
