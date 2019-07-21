package com.sm.misc_4.dp;

public class ClimbingStairs {
    public int cnt(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<= n; i++) {
            for(int step = 1; step <= 2; step++) {
                dp[i] += dp[i - step];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.println(" >>>3 " + cs.cnt(3));
        System.out.println(" >>>4 " + cs.cnt(4));
        System.out.println(" >>>5 " + cs.cnt(5));

    }
}
