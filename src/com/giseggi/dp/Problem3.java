/*
「問題」
次のソースはN 番目のフィボナッチ数を計算するC++関数である。
int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}

Fibonacci(3) を呼び出すと次のようなことが起こる。

・Fibonacci(3) はFibonacci(2) と Fibonacci(1) (最初の呼び出し) を呼び出す。
・Fibonacci(2)はFibonacci(1)(2番目の呼び出し)とFibonacci(0)を呼び出す。
・2番目に呼び出したFibonacci(1)は1を出力し、1をリターンする。
・Fibonacci（0）は0を出力し、0をリターンする。
・Fibonacci(2)はFibonacci(1)とFibonacci(0)の結果を得て、1をリターンする。
・最初に呼び出したFibonacci(1)は1を出力し、1をリターンする。
・Fibonacci(3)はFibonacci(2)とFibonacci(1)の結果を得て、2をリターンする。

1は2回出力され、0は1回出力される。 
Nが与えられたとき、Fibonacci(N)を呼び出したとき、0と1がそれぞれ何回出力されるかを計算するプログラムを作成してください。

「入力」
1行目にテストケースの個数Tが与えられる。

各テストケースは一行からなり、N が与えられる。(0 ≤ N ≤ 40, Nは自然数)


「出力」
各テストケースごとに0が出力される回数と1が出力される回数を空白で区切って出力する。

EX1)          
入力			出力 
3			1 0
0           0 1
1           1 2
3 

EX2)          
入力			出力 
2			5 8
6           10946 17711
22          


*/

package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {
	
	static final int MAX_NUM = 41;
	static int[] solutionsOne = new int[MAX_NUM];
	static int[] solutionsZero = new int[MAX_NUM];

	
	static int solutionsOne(int num) {
		solutionsOne[0] = 0;
		solutionsOne[1] = 1;
		
		for(int i = 2; i <= num; i++) {
			solutionsOne[i] = solutionsOne[i - 1] + solutionsOne[i - 2];
		}
		
		return solutionsOne[num];
		
	}
	
	static int solutionsZero(int num) {
		solutionsZero[0] = 1;
		solutionsZero[1] = 0;
		
		for(int i = 2; i <= num; i++) {
			solutionsZero[i] = solutionsZero[i - 1] + solutionsZero[i - 2];
		}
		
		return solutionsZero[num];
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		int numList[] = new int[Integer.parseInt(input)];
		
		for(int i = 0; i < numList.length; i++) {
			numList[i] = Integer.parseInt(in.readLine());
		}

		for(int i = 0; i < numList.length; i++) {
			System.out.println(solutionsZero(numList[i]) + " " + solutionsOne(numList[i]));
		}
	}

}
