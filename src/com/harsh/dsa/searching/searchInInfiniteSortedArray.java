package com.harsh.dsa.searching;
// This is an amazon interview question the array is of infinity size basically means that we just cant use arr.length
// Since it is sorted array binary search is the right approach but we will go bottom up and the search space will increase exponetially
/*
 * 💡 INTERVIEW NOTE: The "Infinite Array" Illusion
 *
 * In a real Amazon interview or on platforms like LeetCode, you are NOT
 * given a standard `int[] arr`. If you were, this exponential expansion
 * would throw an IndexOutOfBoundsException.
 *
 * Instead, you are given an API object, typically called `ArrayReader`.
 * You access elements using a method like `reader.get(index)`.
 *
 * THE TRICK:
 * The problem states that if you query an index that is out of bounds,
 * the API safely returns `Integer.MAX_VALUE` (or some max limit) instead
 * of crashing.
 *
 * Since `Integer.MAX_VALUE` is strictly greater than any `target`,
 * the condition `while (target > reader.get(end))` naturally turns false.
 * The loop breaks safely, and we proceed to binary search. We can blindly
 * double our search space because the API protects us from bounds errors!
 */
public class searchInInfiniteSortedArray {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7, 8, 10, 11, 15, 20, 27, 28, 30, 32, 36, 38};
        int target = 36;
        System.out.println("Target is found at index " + ans(arr, target));
    }
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int temp = end + 1;

            end  += (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
