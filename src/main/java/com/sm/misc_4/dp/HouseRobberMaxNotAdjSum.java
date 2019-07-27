package com.sm.misc_4.dp;

public class HouseRobberMaxNotAdjSum {

    public int rob_noArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }

        int prevMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);

        for(int i = 2; i < size; i++) {
            int tmp = curMax;
            curMax = Math.max(curMax, prevMax + nums[i]);
            prevMax = tmp;

        }
        return curMax;
    }


    public int rob_withArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < size; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i-1]);
        }
        return dp[size - 1];
    }

    public static void main(String[] args) {
        HouseRobberMaxNotAdjSum maxNotAdjSum = new HouseRobberMaxNotAdjSum();

        System.out.println(">>> expected 4 :  " + maxNotAdjSum.rob_withArray(new int[]{1,2,3,1}));
        System.out.println(">>> expected 4 :  " + maxNotAdjSum.rob_withArray(new int[]{2,1,1,2}));
        System.out.println(">>> expected 12 :  " + maxNotAdjSum.rob_withArray(new int[]{2,7,9,3,1}));

        System.out.println(">>> expected 4 :  " + maxNotAdjSum.rob_noArray(new int[]{1,2,3,1}));
        System.out.println(">>> expected 4 :  " + maxNotAdjSum.rob_noArray(new int[]{2,1,1,2}));
        System.out.println(">>> expected 12 :  " + maxNotAdjSum.rob_noArray(new int[]{2,7,9,3,1}));
    }
}
