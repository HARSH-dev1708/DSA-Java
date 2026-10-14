package com.harsh.dsa.leetcode;
/*
 * LeetCode 2965 - Find Missing and Repeated Values
 *
 * Difficulty       : Easy
 * Space Complexity : O(n * 2)
 *  Time Complexity : O(n*2)
 *
 * Date Solved      : 14-10-2026
 */
import java.util.Arrays;
import java.util.HashSet;

public class LC2965_FindMissingandRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 3}, {1, 8, 4}, {5, 6, 7}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
    static int[] findMissingAndRepeatedValues(int[][] grid){
        int n = grid.length;
        int totalSum = ((n*n)*((n*n)+1)) / 2; // Sum of no.s from 1 to n*n
        int actualSum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                actualSum += grid[i][j];
            }
        }
        HashSet<Integer> set = new HashSet<>(); // Hash set used to store single no.s
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(set.contains(grid[i][j])){
                    // missing value = totalSum - (actualSum - repeatedValue)
                    return new int[] {grid[i][j], totalSum - actualSum + grid[i][j]};
                }
                set.add(grid[i][j]);
            }
        }
        return new int[] {-1, -1};
    }
}
