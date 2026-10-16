package com.harsh.dsa.leetcode;

import java.util.Scanner;
/*
 * LeetCode 424 - Longest Repeating Character Replacement
 *
 * Difficulty       : Medium
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 *
 * Approach : Sliding window and Hashing
 *
 * Date Solved      : 16-10-2026
 */
public class LC0424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println("Maximum substring length of repeating characters with k replacement is : " + characterReplacement(s, k));
    }
    static int characterReplacement(String s, int k){
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;
        int[] freq = new int[26];

        for(int right = 0; right < s.length(); right++){
            int index = s.charAt(right) - 'A';
            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, (right - left + 1));
        }
        return maxLength;
    }
}
