package com.giseggi.dp;

import java.math.*;
import java.util.*;

public class Problem21 {
    public static void main(String[] args) {
        BigDecimal[] dp = new BigDecimal[1001];
        dp[0] = dp[1] = BigDecimal.ONE;
        for(int i = 2; i < 1001; i++)
            dp[i] = dp[i-1].multiply(new BigDecimal(i));

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(dp[N].divide(dp[K]).divide(dp[N-K]).remainder(new BigDecimal(10007)));
    }
}
