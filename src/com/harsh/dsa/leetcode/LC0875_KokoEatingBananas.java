package com.harsh.dsa.leetcode;
/*
 * LeetCode 0875 - Koko Eating Bananas
 *
 * Difficulty       : Medium
 *  Time Complexity  : O(nlogn)
 * Space Complexity : O(1)
 *
 * Date Solved      : 22-10-2026
 */
public class LC0875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        int totalBananas = 0;
        for(int bananas : piles){
            maxBananas = Math.max(maxBananas, bananas);
            totalBananas += bananas;
        }
        int start = (int) Math.ceil((double) totalBananas / h);
        // int start = 1;
        int end = maxBananas;
        int k = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(canEat(piles, mid, h)){
                k = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return k;
    }
    static boolean canEat(int[] piles, int k, int h){
        int[] pilesCopy = new int[piles.length];
        int p = 0;
        int hCopy = h;
        for(int bananas : piles){
            pilesCopy[p++] = bananas;
        }
        for(int i = 0; i < piles.length; i++){
            while(pilesCopy[i]!= 0){
                if(hCopy == 0){
                    return false;
                }
                int hNeeded = (int)Math.ceil((double)piles[i] / k);
                if(hCopy < hNeeded){
                    hCopy = 0;
                } else {
                    pilesCopy[i] = 0;
                    hCopy-=hNeeded;
                }
                // if(pilesCopy[i] >= k){
                //     pilesCopy[i] -= k;
                //     hCopy--;
                // } else {
                //     pilesCopy[i] = 0;
                //     hCopy--;
                // }
            }
        }
        return true;
    }
}
