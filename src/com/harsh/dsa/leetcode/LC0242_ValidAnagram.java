package com.harsh.dsa.leetcode;

import java.util.Arrays;
/*
 * LeetCode 242 - Valid Anagram
 *
 * Difficulty       : Easy
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 *
 * Date Solved      : 15-10-2026
 */
public class LC0242_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    static boolean isAnagram(String s, String t) {
        int[] freq1 =  new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq1[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            freq2[t.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freq1, freq2)) return true;
        return false;
    }
}
