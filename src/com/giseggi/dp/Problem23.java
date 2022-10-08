package com.giseggi.dp;

import java.math.BigDecimal;
import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        if(K == 0) {
            System.out.println(route(N, M));
        } else {
            int CX;
            int CY;
            if(K % M == 0) {
                CX = M;
                CY = K / M;
            } else {
                CX = K % M;
                CY = (K / M) + 1;
            }
            System.out.println(route(CX, CY).multiply(route(M - CX + 1, N - CY + 1)));
        }


    }
    static BigDecimal factorial(int n) {
        BigDecimal f = BigDecimal.ONE;

        for(int i = 1; i <= n; i++)
            f = f.multiply(new BigDecimal(i));

        return f;
    }

    static BigDecimal route(int n, int m) {
        return  factorial(n + m - 2).divide(factorial(n - 1)).divide(factorial(m - 1));
    }
}