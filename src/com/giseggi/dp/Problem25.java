package com.giseggi.dp;

import java.util.Scanner;
/**
 * Problem description
 * https://www.acmicpc.net/problem/2502
 */
problem description
public class Problem25 {
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int K = sc.nextInt();
        int dp[] = new int[D + 1];

        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= D; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int A = 1;
        int B = 0;
        boolean flg = true;

        while(flg) {
           if((K - (dp[D - 2] * A)) % dp[D - 1] == 0) {
               B = (K - (dp[D - 2] * A)) / dp[D - 1];
               flg = false;
           } else {
               A++;
           }
        }

        System.out.println(A);
        System.out.println(B);
    }
}
