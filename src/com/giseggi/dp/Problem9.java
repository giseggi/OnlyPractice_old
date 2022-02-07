/*
「問題」
Aはワインの試飲会に行った. そこに行くと、テーブルの上に様々なワインが入ったグラスが並んでいた。 Aはワインの試飲を予定しているが、これには次のような2つの規則がある。

1. ワインのグラスを選択すると、グラスに入っているワインはすべて飲み終え、飲んだ後は元の位置に戻さなければならない。
2. 連続で置かれている3杯を全て飲むことはできない。

Aはできるだけたくさんのワインを味わうためにどのワイングラスを選べばいいか悩んでいる。 1からnまでの番号がついているn個のワイングラスが順番にテーブルの上に置かれ、各ワイングラスに入っているワイングラスの量が与えられたとき、
Aを助けて最も大量のワインを飲めるようにするプログラムを作成してください。

例えば、6つのワイングラスがあり、それぞれのグラスに順番に6、10、13、9、8、1分のワインが入っているとき、1つ目、2つ目、4つ目、5つ目の葡萄酒グラスを選択すれば、総ワインの量が33となり、最大で飲むことができる。
			
「入力」
最初の行にワイングラス数の「n」が与えられる。 (1≤ n ≤ 10,000)2行目からn+1行目までワインのグラスに入っているワインの量が順番に与えられる。 
ワインは1,000以下の整数である.

「出力」
1行目に最大で飲めるワインの量を出力する。

EX1)          
入力			出力 
6			33
6
10
13
9
8
1


*/
package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem9 {
	static final int MAX_WINE = 10001;
	static int[] solutions = new int[MAX_WINE];
	static int[] wineArray = new int[MAX_WINE];
	
	static public int maxWine(int[] wineArray, int size) {
		
		List<Integer> tempArray = new ArrayList<Integer>();
		
		solutions[1] = wineArray[1];
		solutions[2] = wineArray[1] + wineArray[2];
		
		tempArray.add(wineArray[1] + wineArray[2]);
		tempArray.add(wineArray[1] + wineArray[3]);
		tempArray.add(wineArray[2] + wineArray[3]);
		
		solutions[3] = Collections.max(tempArray);
		tempArray.clear();
		
		for(int i = 4; i <= size; i++) {
			tempArray.add(solutions[i - 1]);
			tempArray.add(solutions[i - 2] + wineArray[i]);
			tempArray.add(solutions[i - 3] + wineArray[i - 1] + wineArray[i]);
			
			solutions[i] = Collections.max(tempArray);
			tempArray.clear();
		}
		
		return solutions[size];
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String numberOfWine = in.readLine();
		
		for(int i = 1; i <= Integer.parseInt(numberOfWine); i++) {
			String input = in.readLine();
			wineArray[i] = Integer.parseInt(input);
		}
		
		System.out.println(maxWine(wineArray, Integer.parseInt(numberOfWine)));

	}

}
