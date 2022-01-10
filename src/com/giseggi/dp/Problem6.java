/*
「問題」
サングンとソンヨンが他の人たちが会話を聞くのを防ぐために対話をお互い暗号化することにした。 そこで、次のような話をした。

サングン:簡単に暗号化しよう。 Aを1で、Bは2で、そしてZは26で。
ソンヨン:それじゃだめだよ。 もし、"BEAN"を暗号化すると25114が出てくるが、これをまた文字に変える方法はいろいろある。
サングン:そうだね。 25114をもう一度英語に変えると、「BEAAD」、「YAAD」、「YAN」、「YKD」、「BEKD」、「BEAN」の6つの単語が出てくるが、BEANが正しい単語だということは簡単に分かるんじゃない？
ソンヨン:例が適切ではなかったな、もし私が500文字を暗号化したとしよう。 その時は出る可能性のある解釈がたくさんあるが、それをいつ全部やってみる?
サングン:どれだけ多いの？
ソニョン:救おう！
どのような暗号が与えられた時にその暗号の解析がいくつ出てくるかを求めるプログラムを作成してください。
			
「入力」
最初の行に5000桁以下の暗号が与えられる。 暗号は数字で成り立っている。

「出力」
解釈の可能性を求めてください。 正解が非常に大きくなることもあるので、1000000で割った余りを出力する。

暗号が解析できない場合には0を出力する。

EX1)          
入力			出力 
25114		6

EX2)          
入力			出力 
1111111111	89

*/
package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6 {
	
	static int solution(String code) {
		
		int solutions[] = new int[code.length() + 1];
		int digit[] = new int[code.length() + 1];
		solutions[0] = 1;
		
		for(int i = 1; i <= code.length(); i ++) {
			digit[i] = code.charAt(i - 1) - '0';
		}
		
		for(int i = 1; i <= code.length(); i++) {
			
			if(digit[i] >= 1 && digit[i] <= 9) {
				solutions[i] = solutions[i - 1];
			}
			
			if(i == 1) {
				continue;
			}
			
			int number = (digit[i - 1] * 10) + digit[i];
			if(number >= 10 && number <= 26) {
				solutions[i] = (solutions[i] + solutions[i - 2]) % 1000000;
			}
			
		}
		return solutions[code.length()];
	}
	
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		System.out.println(solution(input));
		

	}

}
