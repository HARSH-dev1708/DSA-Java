package com.harsh.dsa.leetcode;
/*
 * LeetCode 438 - Find All Anagrams in a String
 *
 * Difficulty       : Medium
 * Time Complexity  : O(n) (n + n - m) where m is the length of the pattern
 * Space Complexity : O(1)
 *
 * Approach : Sliding Window and Hashing
 *
 * Date Solved      : 16-10-2026
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC0438_FindAllAnagramsinaString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println(findAnagrams(text, pattern));
    }
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        int n = s.length(); // text length
        int m = p.length(); // pattern length

        if (n < m) {
            return l;
        }

        int[] patternFreq =  new int[26];
        int[] windowFreq = new int[26];

        for(int i = 0; i < m; i++){
            patternFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i <= n - m; i++){
            if(Arrays.equals(patternFreq, windowFreq)){
                l.add(i);
            }
            if(i < n - m){
                windowFreq[s.charAt(i) - 'a']--;
                windowFreq[s.charAt(i + m) - 'a']++;
            }
        }
        return l;

    }
}
