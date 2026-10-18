package com.harsh.dsa.leetcode;
/*
 * LeetCode 367 - Valid Perfect Square
 *
 * Difficulty       : Esy
 * Time Complexity  : O(logn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 18-10-2026
 */
import java.util.Scanner;

public class LC0367_ValidPerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // num is a positive number
        int num = sc.nextInt();
        if(isPerfectSquare(num)){
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }
    }
    static boolean isPerfectSquare(int num) {
        if(num <= 1) return true;
        int start = 0;
        int end = num / 2;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long square = (long)mid * mid;
            if(square == num){
                return true;
            } else if(square  > num){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
