package com.harsh.dsa.searching;

public class linearsearchkk {
    public static void main(String[] args) {
//        int[] arr = {};
        int[] arr = {1, 2, 4, 7, 18, 3};
        int target = 3;
//        int target = 16;
        System.out.println(linearSearch(arr, target));


        String s = "Harsh";
        char targetChar = 'k';
        System.out.println(linearSearchInString(s, targetChar));
    }

    static int linearSearch(int[] arr, int target){
        for(int index = 0; index < arr.length; index++){
            if(arr[index] == target) return index;
        }
        return -1;
    }

    static boolean linearSearchInString(String s, char targetChar){
        for(char ch : s.toCharArray()){
            if(ch == targetChar) return true;
        }
        return false;
    }
}
