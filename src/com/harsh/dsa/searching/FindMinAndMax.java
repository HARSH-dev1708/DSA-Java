package com.harsh.dsa.searching;

import java.util.Arrays;

public class FindMinAndMax {
    public static void main(String[] args) {
        int[] arr = {};
        try {
            System.out.println(Arrays.toString(findMinAndMax(arr)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static int[] findMinAndMax(int[] arr){
        if(arr.length == 0){
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int max = arr[0];
        int min =  arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        return new int[] {min, max};
    }
}
