package com.harsh.dsa.leetcode;
/*
 * LeetCode 374 - Guess Number Higher or Lower
 *
 * Difficulty       : Easy
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 * Algorithm        : Binary Search
 *
 * Date Solved      : 15-07-2026
 */
public class LC0374_GuessNumberHigherOrLower {
    static class Guess {
        // Globally accessible variable
        public static int pick = 6;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }
    static int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);

            if (result == -1) {
                end = mid - 1;
            } else if (result == 1) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }
    static int guess(int guessedNo){
        return Integer.compare(Guess.pick, guessedNo);
//        Integer.compare(int a, int b) returns 0 if a==b, -1 if a>b and 1 if a<b
    }
}
