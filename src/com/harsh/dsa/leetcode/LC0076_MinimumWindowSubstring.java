package com.harsh.dsa.leetcode;
/*
 * LeetCode 76 - Minimum Window Substring
 *
 * Difficulty       : Hard
 * Algorithm        : Binary Search
 * Time Complexity  : O(n + m)
 * Space Complexity : O(1)
 *
 * Date Solved      : 20-10-2026
 */
import java.util.Scanner;

public class LC0076_MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println("Min window with all the characters of t string(including duplicates) = " + minWindowSubstring(s, t));
    }
    static String minWindowSubstring(String s, String t){
        if(s.length() < t.length()){
            return "";
        }
        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int required = t.length();

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(freq[c] > 0){
                required--;
            }
            freq[c]--;

            while(required == 0){
                int windowLength = right - left + 1;
                if(windowLength < minLength){
                    minLength = windowLength;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if(freq[leftChar] > 0){
                    required++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}
