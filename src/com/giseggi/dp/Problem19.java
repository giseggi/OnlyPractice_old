package com.giseggi.dp;

import java.util.Scanner;

import static java.lang.Math.*;

public class Problem19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++)
        {
            dp[i] = i;
            for (int j = 1; j <= sqrt(i); j++)
            {
                dp[i] = min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);


    }
}
