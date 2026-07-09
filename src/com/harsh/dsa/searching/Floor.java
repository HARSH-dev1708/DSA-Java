package com.harsh.dsa.searching;
// Floor = Largest element in the array that is smaller or equal to the target
// Algorithm : Binary Search - obviously array need to be sorted
public class Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 0;
        int res = floor(arr, target);
        System.out.println(res);
    }
    static int floor(int[] arr, int target){
        if(target < arr[0]) {
            System.out.println("Floor doesn't exists");
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            } else if(target < arr[mid]){
                end = mid - 1;
            } else{
                return arr[mid];
            }
        }
        return arr[end];
    }
}
