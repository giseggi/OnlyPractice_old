package com.giseggi.dp;

import java.math.BigDecimal;
import java.util.*;

public class Problem12 {

	public static void main(String[] args) {
		
		BigDecimal[] P = new BigDecimal[101];		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		P[1] = P[2] = P[3] = BigDecimal.ONE;
		P[4] = P[5] = new BigDecimal("2");
		
		for(int i = 6; i < 101; i++) {
			P[i]=P[i - 1].add(P[i - 5]);
		}
		
		for(int i = 0; i < T; i++) {
			System.out.println(P[sc.nextInt()]);
		}
	}
}
