package com.giseggi.dp;

import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dp = new int[41];
        int[] V = new int[M + 1];

        for(int i = 1; i <= M; i++)
            V[i] = sc.nextInt();

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= 40; i++)
            dp[i] = dp[i - 2] + dp[i - 1];

        if(M == 0) {
            System.out.println(dp[N]);
        } else {
            int ans = dp[V[1] - 1];

            for(int i = 2; i < M + 1; i++)
                ans *= dp[V[i] - V[i - 1] -1];

            ans *= dp[N - V[M]];
            System.out.println(ans);
        }
    }
}
