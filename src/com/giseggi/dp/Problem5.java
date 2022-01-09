/*
「問題」
2×nサイズの長方形を1×2、2×1タイルで埋める方法の数を求めるプログラムを作成してください。
			
「入力」
1行目にnが与えられる。 (1 ≤ n ≤ 1000)

「出力」
1行目に2×nの大きさの長方形の埋め方の数を10,007で割った余りを出力する。

EX1)          
入力			出力 
2			2

EX2)          
入力			出力 
9			55

*/
package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Problem5 {
	static final int MAX_NUM = 1001;
	static BigDecimal[] solutions = new BigDecimal[MAX_NUM];
	
	public static void main(String[] args) throws IOException {

		solutions[0] = BigDecimal.ZERO;
		solutions[1] = BigDecimal.ONE;
		solutions[2] = new BigDecimal("2");
		
		for(int i = 3; i < MAX_NUM; i++) {
			solutions[i] = solutions[i - 1].add(solutions[i - 2]);
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		System.out.println(solutions[Integer.parseInt(input)].remainder(new BigDecimal("10007")));
	}
}
