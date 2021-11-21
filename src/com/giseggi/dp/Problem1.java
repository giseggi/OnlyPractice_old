/*
「問題」
Aさんは最近、砂糖工場で砂糖を配達している。 Aさんは今、飴屋に砂糖を正確にNキログラム配達しなければならない。 砂糖工場で作る砂糖は袋に入っている。 袋は3キログラムの袋と5キログラムの袋がある.
Aさんは面倒だから、極力少ない袋を持って行こうとする。 例えば、18キログラム砂糖を配達しなければならないとき、3キログラム袋6個を持ち帰ってもいいが、5キログラム3個と3キログラム1個を配達すれば、さらに少ない個数の袋を配達できる。
Aさんが砂糖を正確にNキログラム配達しなければならない時に、いくつの袋を持っていけばいいのか、その数を求めるプログラムを作成してください。

「入力」
最初の行にNが入力される。(3 ≤ N ≤ 5000)


「出力」
Aさんが配達する袋の最小個数を出力する もし、正確にNキログラムが作れないなら-1を出力する。

EX1)          EX2)  
入力 = 18)   入力 = 4
出力 = 4     出力 = -1
*/

package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {

	static final int MAX_LENGTH = 5001;
	static int solutions[] = new int[MAX_LENGTH];

	static int solution(int N) {

		if (solutions[N] != 0) {
			return solutions[N];
		} else {
			
			if(N <= 7) {
				if(N == 3 || N == 5) {
					return solutions[N] = 1;
				} else if(N == 6) {
					return solutions[N] = 2;
				} else {
					return -1;
				}
				
			} else {
				if (solution(N - 5) != -1) {
					return solutions[N] = solution(N - 5) + 1;
				} else {
					return solutions[N] = solution(N - 3) + 1;
				}

			} 
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();

		int N = Integer.parseInt(input);

		System.out.println(solution(N));

	}

}
