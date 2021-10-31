package com.giseggi.dp;

import java.math.BigDecimal;

public class FibonacciNumbers {

	static final int MAX_NUM = 101;
	static long[] fibonacciNumbers = new long[MAX_NUM];

	static long FibonacciRecursive(int num) {
		if (num == 0 || num == 1) {
			return num;
		}

		return FibonacciRecursive(num - 1) + (FibonacciRecursive(num - 2));
	}

	static long FibonacciDPTopDown(int num) {
		if (num == 0 || num == 1) {
			return num;
		}

		if (fibonacciNumbers[num] != 0) {
			return fibonacciNumbers[num];
		} else {
			return fibonacciNumbers[num] = FibonacciDPTopDown(num - 1) + FibonacciDPTopDown(num - 2);
		}

	}

	static long FibonacciDPBottomUp(int num) {
		
		fibonacciNumbers[0] = 0;
		fibonacciNumbers[1] = 1;
		
		for(int i = 2; i <= num; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
		}
		
		return fibonacciNumbers[num];
			
	}

	public static void main(String[] args) {

		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

//		System.out.println(FibonacciRecursive(50));
//		System.out.println(FibonacciDPTopDown(100));
		System.out.println(FibonacciDPBottomUp(100));

		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = afterTime - beforeTime; // 두 시간에 차 계산
		System.out.println("시간차이(m) : " + secDiffTime);

	}
}
