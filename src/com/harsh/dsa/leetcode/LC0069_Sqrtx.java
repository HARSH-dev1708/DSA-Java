package com.harsh.dsa.leetcode;
/*
 * LeetCode 69 - Sqrt(x)
 *
 * Difficulty       : Easy
 * Time Complexity  : O(logn) (actually log(n/20 but constant is ignored so yeah)
 * Space Complexity : O(1)
 * Algorithm        : Binary Search
 *
 * Date Solved      : 15-07-2026
 */
import java.util.Scanner;

public class LC0069_Sqrtx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Square root(round down) of " + x + " is " + sqrt(x));
    }
    static int sqrt(int x){
        if (x < 2) {
            return x;
        }
        int start = 0;
        int end = x / 2;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long square =(long) mid * mid;
            // Cast to long to prevent integer overflow when calculating mid * mid.
            if(square > x){
                end = mid - 1;
            } else if (square < x){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
