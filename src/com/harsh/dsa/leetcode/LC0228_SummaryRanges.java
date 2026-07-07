package com.harsh.dsa.leetcode;
/*
 * LeetCode 228 - Summary Ranges
 *
 * Difficulty       : Easy
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 *
 * Date Solved      : 07-07-2026
 */
import java.util.ArrayList;
import java.util.List;

public class LC0228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> a = new ArrayList<>();
        int usedIdx = -1;
        for(int i = 0; i < nums.length; i++){
            if(i>usedIdx){
                int end = i;
                while(end < nums.length - 1){
                    if(nums[end] + 1 == nums[end+1]){
                        end++;
                    } else {
                        break;
                    }
                }
                usedIdx =  end;
                if(i == end){
                    a.add("" + nums[i]);
                } else {
                    a.add(nums[i] + "->" + nums[end]);
                }
            }
        }

        return a;
    }
}
