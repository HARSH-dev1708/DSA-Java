package com.harsh.dsa.leetcode;

public class LC1295_FindNumswithEvenNoOfDigits {
    public static void main(String[] args) {
        int[] a = {12,345,2,6,7896};
        int[] b = {555,901,482,1771};
        System.out.println(findNumbers(a));
        System.out.println(findNumbers(b));
    }
    static int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            int digits = 0;
            // floating-point arithmetic method  is using log10 - (int)Math.log10(i) + 1 also gives no. of digits
            while(i>0){
                digits++;
                i/=10;
            }
            if(digits%2==0) count++;
        }
        return count;
    }
}
