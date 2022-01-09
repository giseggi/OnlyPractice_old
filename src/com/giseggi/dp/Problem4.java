/*
「問題」
整数4を1、2、3の和で表す方法は全部で7通りある。 和を表す時は数を1個以上使わなければならない
・1+1+1+1
・1+1+2
・1+2+1
・2+1+1
・2+2
・1+3
・3+1

整数nが与えられたとき、nを1、2、3の和で表す方法の数を求めるプログラムを作成してください。

「入力」
1行目にテストケースの個数Tが与えられる。

各テストケースは一行からなり、N が与えられる。(0 ≤ N ≤ 11, Nは整数)


「出力」
各テストケースごとにnを1、2、3の和で表す方法の数を出力する。

EX1)          
入力			出力 
3			7
4           44
7           274
10 
    
*/
package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
	static final int MAX_NUM = 12;
	static int[] solutions = new int[MAX_NUM];

	public static void main(String[] args) throws IOException {
		
		solutions[0] = 0;
		solutions[1] = 1;
		solutions[2] = 2;
		solutions[3] = 4;
		
		for(int i = 4; i < MAX_NUM; i++) {
			solutions[i] = solutions[i - 1] + solutions[i - 2] + solutions[i - 3];
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String numberOfTestCases = in.readLine();
		
		int testCase[] = new int[Integer.parseInt(numberOfTestCases)];
		
		for(int i = 0; i < testCase.length; i++) {
			String input = in.readLine();
			testCase[i] = Integer.parseInt(input);
		}

		for(int i = 0; i < testCase.length; i++) {
			System.out.println(solutions[testCase[i]]);
		}

	}

}
