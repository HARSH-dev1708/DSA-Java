package com.harsh.dsa.searching;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {16, 73, 22, 45},
                {2, 4},
                {3, 5, 6, 8}
        };
        int target = 7;
        System.out.println(Arrays.toString(search(arr, target)));
        // System.out.println(arr) prints the array's reference, not its contents.
        // Arrays are objects in Java; Arrays.toString() converts their contents into a readable String.
    }

    static int[] search(int[][] arr, int target){
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                if(arr[row][col] == target) return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
        // Use 'new int[]' when returning an array; '{}' shorthand is only valid during array declaration.
        // as you can see we did used the shorthand while initializing the array above because it gets it from the declaration int[][] arr
    }
}
