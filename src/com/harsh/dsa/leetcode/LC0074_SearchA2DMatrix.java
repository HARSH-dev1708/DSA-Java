package com.harsh.dsa.leetcode;
/*
 * LeetCode 74 - Search a 2D Matrix
 *
 * Difficulty       : Medium
 * Time Complexity  : O(m*n) where m = no. of rows and n = no. of columns
 * Space Complexity : O(1)
 *
 * Date Solved      : 18-07-2026
 */
public class LC0074_SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        System.out.println(target + " found = " + searchMatrix(matrix, target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= matrix.length - 1 && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] < target){
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
