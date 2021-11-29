/*
「問題」
整数X に使用できる演算は以下の3つである。

1. Xが3で割り切れると、3で割る。
2. Xが2で割り切れると、2で割る。
3. 1を引く。

整数N が与えられたとき、上のような演算三つを適切に使って1 を作ろうとする。 演算を使用する回数の最小値を出力してください。

「入力」
最初の行に整数Nが入力される。(1≦N≦1000000)


「出力」
最初の行に演算をする回数の最小値を出力する。

EX1)
入力 = 10
出力 = 3

10→9→3→1なので3回

EX2)  
入力 = 17
出力 = 5

17→16→8→4→2→1なので5回 
*/

package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	static final int MAX_LENGTH = 1000001;
	static final int HALF_MAX_LENGTH = 500000;
	static final int ONE_THIRD_MAX_LENGTH = 333333;
	static int solutions[] = new int[MAX_LENGTH];
	
	static void solution() {
		solutions[1] = 0;
		solutions[2] = 1;
		solutions[3] = 1;
		
		for(int i = 2; i < MAX_LENGTH; i++) {
			
			if(i != MAX_LENGTH -1) {
				if(solutions[i + 1] == 0 || (solutions[i + 1] > solutions[i] + 1)) {
					solutions[i + 1] = solutions[i] + 1;
				} 		
			}
			
			if(i <= HALF_MAX_LENGTH) {
				if(solutions[i * 2] == 0 || (solutions[i * 2] > solutions[i] + 1)) {
					solutions[i * 2] = solutions[i] + 1;
				} 		
			}
			
			if(i <= ONE_THIRD_MAX_LENGTH) {
				if(solutions[i * 3] == 0 || (solutions[i * 3] > solutions[i] + 1)) {
					solutions[i * 3] = solutions[i] + 1;
				} 		
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();

		int N = Integer.parseInt(input);
		
		solution();

		System.out.println(solutions[N]);
	}

}
