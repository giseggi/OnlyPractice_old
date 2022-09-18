package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17 {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        long[][] dp = new long[100001][4];

        int[] testCase = new int[T];

        for(int i = 0; i < testCase.length; i++) {
            testCase[i] = Integer.parseInt(in.readLine());
        }

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }

        for(int i = 0; i < testCase.length; i++) {
            System.out.println((dp[testCase[i]][1] + dp[testCase[i]][2] + dp[testCase[i]][3]) % 1000000009);
        }
    }
}
