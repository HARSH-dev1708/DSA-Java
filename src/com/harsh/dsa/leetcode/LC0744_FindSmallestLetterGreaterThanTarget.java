package com.harsh.dsa.leetcode;
/*
 * LeetCode 744 - Find Smallest Letter Greater Than Target
 *
 * Difficulty       : Easy
 * Algorithm        : Binary Search
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 09-07-2026
 */
public class LC0744_FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'f';
        char ceil = nextGreatestLetter(letters, target);
        System.out.println(ceil);
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(letters[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
