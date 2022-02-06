package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10 {
	static int[][] stairNumber = new int[10][100];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(in.readLine());
		
		stairNumber[0][0] = 0;
		for(int i = 1; i < 10; i++) {
			stairNumber[i][0] = 1;
		}
		
		for(int i = 1; i < length; i ++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					stairNumber[j][i] = stairNumber[j + 1][i - 1];
				} else if(j == 9) {
					stairNumber[j][i] = stairNumber[j - 1][i - 1];
				} else {
					stairNumber[j][i] = (stairNumber[j + 1][i - 1] + stairNumber[j - 1][i - 1]) % 1000000000;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 10; i++) {
			answer += stairNumber[i][length - 1];
			answer = answer  % 1000000000;
		}
		
		System.out.println(answer);
		
	}
}
