package com.harsh.dsa.searching;
// order agnostic binary search works for both, ascending and descending sorted array
public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3 ,4, 5, 9};
        int[] arr1 = {8, 7, 5, 4, 3, 1};
        int target = 3;
        int res = orderAgnosticBS(arr1, target);
        if(res == -1){
            System.out.println("Element not found");
        } else {
            System.out.println(target + " found at index " + res);
        }
    }
    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[end] > arr[start];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            if(isAsc){
                if(arr[mid] > target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(arr[mid] < target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
