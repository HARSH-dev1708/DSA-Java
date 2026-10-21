package com.harsh.dsa.leetcode;
/*
 * LeetCode 754 - Reach A Number
 *
 * Difficulty       : Medium
 * Algorithm        : Binary Search
 * Time Complexity  : O((t)^0.5)
 * Space Complexity : O(1)
 *
 * Date Solved      : 19-07-2026
 *
 * Note: Here you need to find the min no. of moves to reach the target
 *
 */
import java.util.Scanner;

public class LC0754_ReachANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("The least no. of moves to reach " + num + " is = " + reachNumber(num));
    }
    static int reachNumber(int target) {

        // The complete idea in three steps
        // 1. Keep adding consecutive move lengths until your total distance reaches or exceeds the target.
        // 2. Calculate the overshoot. If it's odd, add more move lengths until it becomes even.
        // 3. Once the overshoot is even, some subset of the moves can be reversed to reduce the total by exactly that overshoot.
        // this is because when evever we are reversing a stride we are losing n steps in right direction but also moving n steps in left direction so in total 2n moves is affected

        // for example to reach 5 (1 + 2 + 3 + 4 - 5)
        target = Math.abs(target);
        int num = 0;
        int  numMoves = 0;

        // Phase 1: Just blindly run forward until we cross the target
        while(num < target){
            numMoves++;
            num += numMoves;
        }

        // Phase 2: If the overshoot (num - target) is odd,
        // keep taking forward steps until the overshoot becomes even.
        while ((num - target) % 2 != 0) {
            numMoves++;
            num += numMoves;
        }

        // The moment it's even, we are guaranteed a perfect path exists!
        return numMoves;
    }
}
