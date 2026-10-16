package com.harsh.dsa.leetcode;
/*
 * LeetCode 3 - Longest Substring Without Repeating Characters
 *
 * Difficulty       : Medium
 * Time Complexity  : O(n) n is the length of the input  string
 * Space Complexity : O(1)
 *
 * Approach : Sliding Window and Hashing
 *
 * Date Solved      : 16-10-2026
 */
import java.util.Arrays;
import java.util.Scanner;

public class LC0003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Length Longest Substring without Repeating Characters is : " + lengthOfLongestSubstring(s));
    }
    static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        int[] lastSeen = new int[265];
        Arrays.fill(lastSeen, -1);
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(lastSeen[ch] >= left){
                left = lastSeen[ch] + 1;
            }
            lastSeen[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
