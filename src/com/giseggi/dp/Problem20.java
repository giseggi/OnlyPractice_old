package com.giseggi.dp;

import java.util.Scanner;

public class Problem20 {
    public static void main(String[] args) {
        int[][] dp = new int[15][15];

        for(int i = 1; i < 15; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for(int i = 1; i < 15; i++)
            for(int j = 1; j < 15; j++)
                dp[i][j] = dp[i][j-1] + dp[i-1][j];

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(sc.hasNext()) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(dp[k][n]);
        }

    }
}
