/*
「問題」
階段上がりゲームは、階段下のスタート地点(S)から階段の頂上にある到着点(G)まで行くのゲームだ。 
<図1>のようにそれぞれの階段には点数が書かれていて、階段を踏むとその階段に書かれている点数が得られる。

                                   
                                ___                                     
                            ___│20 │
                        ___│10 │ G │
                    ___│25 │   │   │    
                ___│15 │   │   │   │
            ___│20 │   │   │   │   │
           │10 │   │   │   │   │   │
        ___│___│___│___│___│___│___│
         S
                   <図1>

例えば<図2>のようにスタート地点(S)から1番目、2番目、4番目、6番目の階段を踏んで到着点に着くと、
総点数は10 + 20 + 25 + 20 = 75点となる。

                               ↓
                              ___                                     
                       ↓  ___│20 │
                      ___│10 │ G │
               ↓  ___│25 │   │   │    
           ↓  ___│15 │   │   │   │
          ___│20 │   │   │   │   │
         │10 │   │   │   │   │   │
      ___│___│___│___│___│___│___│
      S
                <図2>
                         
階段を上がるには、次のようなルールがある

・ 階段は一度に一段階ずつ、または二段階ずつ上がることができる。
・ 連続した3つの階段をすべて踏んではならない。 ただし、スタート地点は階段に含まれない。
・ 到着の階段は必ず踏まなければならない。

つまり、1番目の階段を踏んで、続いて2番目または3番目の階段で上がることができる。 
しかし、1番目の階段を踏んで4番目の階段を上がったり、1番目、2番目、3番目の階段を連続して全て踏むことはできない。

各階段に書かれた点数が与えられた時、このゲームで得られる点数の最大値を求めるプログラムを作成してください。

「入力」
1行目に階段の個数が与えられる。

2行目から1行ずつ、一番下に置かれた階段から順に各階段に書かれている点数が与えられる。 
階段の個数は300以下の自然数であり、階段に書かれている点数は10,000以下の自然数である。

「出力」
1行目に階段上がりゲームで得られる総点数の最大値を出力する。。

EX1)          
入力			出力 
6			75
10          
20           
15
25
10
20 
    
*/
package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8 {

	static final int MAX_NUM = 301;
	static int[] solutions = new int[MAX_NUM];
	static int[] stairScoreArray = new int[MAX_NUM];
	
	static int maxStairScore(int[] stairScoreArray, int size) {
		
		solutions[1] = stairScoreArray[1];
		solutions[2] = stairScoreArray[1] + stairScoreArray[2];
		solutions[3] = Math.max(stairScoreArray[1] + stairScoreArray[3], stairScoreArray[2] + stairScoreArray[3]); 
		
		for(int i = 4; i <= size; i++) {
			solutions[i] = Math.max(solutions[i - 2] + stairScoreArray[i], solutions[i - 3] + stairScoreArray[i - 1] + stairScoreArray[i]);
		}
		
		return solutions[size];
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String numberOfStair = in.readLine();
		
		for(int i = 1; i <= Integer.parseInt(numberOfStair); i++) {
			String input = in.readLine();
			stairScoreArray[i] = Integer.parseInt(input);
		}
		
		System.out.println(maxStairScore(stairScoreArray, Integer.parseInt(numberOfStair)));
	}

}
