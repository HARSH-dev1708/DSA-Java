package com.harsh.dsa.stacks;
// GFG Question- https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElementGFG {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println(nextSmallerEle(arr));
    }
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result =
                new ArrayList<>(Collections.nCopies(n, -1));

        Stack<Integer> stack =  new Stack<>();


        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                result.set(stack.pop(), arr[i]);
            }
            stack.push(i);
        }

        return result;
    }
}
