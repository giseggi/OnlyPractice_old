package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Problem16 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        BigDecimal[][] dp = new BigDecimal[n + 1][11];

        for(int i = 1; i < 11; i++) {
            dp[1][i] = BigDecimal.ONE;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < 11; j++) {
                BigDecimal temp = BigDecimal.ZERO;
                for(int k = j; k < 11; k++) {
                    temp = temp.add(dp[i - 1][k]);
                }
                dp[i][j] = temp;
            }
        }
        BigDecimal answer = BigDecimal.ZERO;
        for(int i = 1; i < 11; i++) {
            answer = answer.add(dp[n][i]) ;
        }
        System.out.println(answer.remainder(new BigDecimal(10007)));

	}

}
