package com.harsh.dsa.leetcode;
/*
 * LeetCode 496 - Next Greater Element I
 *
 * Difficulty       : Medium
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 *
 * Approach : Monotonic stack and HashMap
 *
 * Date Solved      : 16-10-2026
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC0496_NextGreaterElementI {
    public static void main(String[] args) {
        int[] queries = {2, 4};
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(nextGreaterElement(queries, nums)));
    }
    static int[] nextGreaterElement(int[] queries, int[] nums){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[queries.length];

        for(int num : nums){
            while(!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        for(int i = 0; i < queries.length; i++){
            result[i] = map.get(queries[i]);
        }
        return result;
    }
}
