package com.giseggi.dp;

public class FibonacciNumbers {

	static final int MAX_NUM = 101;
	static long[] fibonacciNumbers = new long[MAX_NUM];

	static long FibonacciRecursive(int num) {
		if (num == 0 || num == 1) {
			return num;
		}

		return FibonacciRecursive(num - 1) + (FibonacciRecursive(num - 2));
	}

	// Top-Down
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

	// Bottom-Up
	static long FibonacciDPBottomUp(int num) {
		
		fibonacciNumbers[0] = 0;
		fibonacciNumbers[1] = 1;
		
		for(int i = 2; i <= num; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
		}
		
		return fibonacciNumbers[num];
			
	}

	public static void main(String[] args) {

		long beforeTime = System.currentTimeMillis(); // 実行前

//		System.out.println(FibonacciRecursive(50));
//		System.out.println(FibonacciDPTopDown(100));
		System.out.println(FibonacciDPBottomUp(100));

		long afterTime = System.currentTimeMillis(); // 実行後
		long secDiffTime = afterTime - beforeTime; // 時間差
		System.out.println("Execution time(m) : " + secDiffTime);

	}
}
