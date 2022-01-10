/*
「問題」
0と1だけで成り立つ数をbinary number(二進数)という。 このようなbinary numberの中に特別な性質を持つものがあるが、これらをpinary numberという。
このpinary numberは次の性質を満足する。

1. pinary numberは0で始まらない。
2. pinary number1が2回連続で現れない。(11を部分文字列として持たない。)

例えば、1、10、100、101、1000、1001などがpinary numberとなる。 
しかし、0010101や101101はそれぞれ1、2番の規則に反するので、pinary numberではない。

N(1 ≤ N ≤ 90)が与えられたとき、N桁のpinary numberの個数を求めるプログラムを作成してください。
			
「入力」
1行目にNが与えられる。

「出力」
1行目にN桁のpinary numberの個数を出力する。

EX1)          
入力			出力 
3			2

*/
package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Problem7 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		int N = Integer.parseInt(input);
		int maxNum = 90;
		BigDecimal[] solutions = new BigDecimal[maxNum + 1];
		
		solutions[1] = BigDecimal.ONE;
		solutions[2] = BigDecimal.ONE;
		for(int i = 3; i <= N; i++) {
			solutions[i] = solutions[i - 1].add(solutions[i -2]);
		}
		
		System.out.println(solutions[N]);
	
	}

}
