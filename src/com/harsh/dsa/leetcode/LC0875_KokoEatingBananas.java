package com.harsh.dsa.leetcode;
/*
 * LeetCode 0875 - Koko Eating Bananas
 *
 * Difficulty       : Medium
 *  Time Complexity  : O(nlogm) n = number of piles, and m = maximum number of bananas in any pile
 * Space Complexity : O(1)
 *
 * Date Solved      : 22-10-2026
 */
public class LC0875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canEatAll(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;
        }

        return hours <= h;
    }
}
