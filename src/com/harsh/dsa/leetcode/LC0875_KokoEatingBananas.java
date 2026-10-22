package com.harsh.dsa.leetcode;

public class LC0875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int maxBananas = 0;
        int totalBananas = 0;
        for(int bananas : piles){
            maxBananas = Math.max(maxBananas, bananas);
            totalBananas += bananas;
        }

        int start = (int) Math.ceil((double) totalBananas / piles.length);
        int end = maxBananas;
        int k = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(canEatAll(piles, mid, h)){
                k = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return k;
    }

    static boolean canEatAll(int[] piles, int k, int h){
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
                if(pilesCopy[i] >= k){
                    pilesCopy[i] -= k;
                    hCopy--;
                } else {
                    pilesCopy[i] = 0;
                    hCopy--;
                }
            }
        }
        return true;
    }
}
