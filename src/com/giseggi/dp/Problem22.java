package com.giseggi.dp;

import java.util.Scanner;

public class Problem22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for(int i = W[1]; i <= K; i++) dp[1][i] = V[1];

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(j < W[i]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);

    }

}
