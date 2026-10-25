package com.harsh.dsa.leetcode;
/*
 * LeetCode 888 Fair Candy Swap
 *
 * Difficulty       : Easy
 * Time Complexity: O((N + M) log M)
 * Reason: Sorting Bob's array takes O(M log M) time. Then, we iterate through Alice's array
 * of size N, and for each element, we perform a binary search on Bob's array which takes
 * O(log M) time. This results in O(M log M + N log M) = O((N + M) log M).
 *
 * Space Complexity: O(log M)
 * Reason: The algorithm itself uses only a few integer variables, which is O(1) space.
 * However, Java's Arrays.sort() for primitives uses a Dual-Pivot Quicksort under the hood,
 * which requires O(log M) auxiliary space for the recursion stack.
 *
 * ------------------------------------
 * Optimized Solution
 * Time Complexity: O(N + M)
 * Reason: We iterate through Alice's array (size N) and Bob's array (size M) to calculate
 * the sums and populate the HashSet, which takes O(N + M). The final loop iterates through
 * Alice's array up to N times, performing an O(1) HashSet lookup each time.
 *
 * Space Complexity: O(M)
 * Reason: We are storing all the elements of Bob's array inside the HashSet. In the worst-case
 * scenario (where all of Bob's candies are unique sizes), the set will grow to size M.
 *
 * Date Solved      : 25-10-2026
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC0888_FairCandySwap {
    public static void main(String[] args) {
        int[] aliceSizes = {1, 2, 5};
        int[] bobSizes = {2, 4};
        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
        System.out.println(Arrays.toString(fairCandySwapOptimized(aliceSizes, bobSizes)));

    }
    static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int a = 0;
        int b = 0;
        for(int c : aliceSizes){
            a+=c;
        }
        for(int c : bobSizes){
            b+=c;
        }
        // if x = candy given by alice and y is candy given by bob, a = total candies of alice and b = total candies of bob
        // then a - x + y = b - y + x => y = x + (b - a) / 2;

        // Binary search requires the array to be sorted
        Arrays.sort(bobSizes);

        for(int x : aliceSizes){
            int y = x + (b - a) / 2;
            // Skip this iteration, don't break the whole loop
            if(y <= 0) continue;
            int start = 0;
            int end = bobSizes.length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(bobSizes[mid] == y){
                    return new int[] {x, y};
                } else if (bobSizes[mid] < y){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
    static int[] fairCandySwapOptimized(int[] aliceSizes, int[] bobSizes) {
        int a = 0;
        int b = 0;

        for (int c : aliceSizes) {
            a += c;
        }

        // Load Bob's array into a HashSet for O(1) lookups
        Set<Integer> bobSet = new HashSet<>();
        for (int c : bobSizes) {
            b += c;
            bobSet.add(c);
        }

        int diff = (b - a) / 2;

        for (int x : aliceSizes) {
            int y = x + diff;

            // If Bob has the candy 'y', we found our answer
            if (bobSet.contains(y)) {
                return new int[] {x, y};
            }
        }

        return new int[]{-1, -1};
    }
}
