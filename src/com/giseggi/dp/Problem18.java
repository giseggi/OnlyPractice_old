package com.giseggi.dp;

import java.util.Scanner;

public class Problem18 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n == 1 || n == 3) {
			System.out.println(-1);
		} else if (n == 2 || n == 5) {
			System.out.println(1);
		} else if (n == 4 || n == 7) {
			System.out.println(2);
		} else if (n == 6 || n == 8) {
			System.out.println(n / 2);
		} else {
			int[] dp = new int[n + 1];

			dp[4] = 2;
			dp[5] = 1;
			dp[6] = 3;
			dp[7] = 2;
			dp[8] = 4;

			for (int i = 9; i <= n; i++) {
				dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
			}

			System.out.println(dp[n]);
		}
	}
}
