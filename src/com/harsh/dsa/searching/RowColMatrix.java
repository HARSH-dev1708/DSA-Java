package com.harsh.dsa.searching;
/*
* Searching in a matrix that is sorted across each row and each column
* Time complexity: O(n + m) or O(n)
*/
import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {12, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = 12;
        System.out.println(Arrays.toString(search(matrix, target)));
    }
    static int[] search(int[][]  matrix, int target){
        int row = 0;
        int col = matrix[0].length - 1;

        while(row <= matrix.length - 1 && col >= 0){
            if(matrix[row][col] == target){
                return new int[] {row, col};
            }
            if(matrix[row][col] > target){
                col --;
            } else {
                row ++;
            }
        }
        return new int[] {-1, -1};
    }
}
