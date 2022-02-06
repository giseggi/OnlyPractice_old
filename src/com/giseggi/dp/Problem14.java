package com.giseggi.dp;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Problem14 {
	static BigDecimal[] factorial = new BigDecimal[201];
	
	static BigDecimal calFactorial(int number) {
		
		if(number == 1 || number == 0) {
			return factorial[1] = BigDecimal.ONE;
		} else {
			return factorial[number] = new BigDecimal(number).multiply(calFactorial(number - 1));
		}	
	}
	
	static BigDecimal numberOfWords(int numberOfa, int numberOfz) {
		
		return calFactorial(numberOfa + numberOfz).divide(calFactorial(numberOfa))
				.divide(calFactorial(numberOfz));
	}
	
	static String solutions(int numberOfa, int numberOfz, int index) {
		
		String answer = "";
		
		if(numberOfWords(numberOfa, numberOfz).compareTo(new BigDecimal(index)) < 0) {
			return "-1";
		} else if(numberOfWords(numberOfa, numberOfz).compareTo(new BigDecimal(index)) == 0) {
			for(int i = 0; i < numberOfz; i++) {
				answer = answer + "z";
			}
			
			for(int i = 0; i < numberOfa; i++) {
				answer = answer + "a";
			}
			
			return answer;
		}
		
		if(numberOfa == 1 && numberOfz == 1 && index == 1) {
			return "az";
		} else if(numberOfa == 1 && numberOfz == 1 && index == 2) {
			return "za";
		} else {
			if(numberOfWords(numberOfa - 1, numberOfz).compareTo(new BigDecimal(index)) >= 0) {
				
				return "a" + solutions(numberOfa - 1, numberOfz, index);								
				
			} else {
				return "z" + solutions(numberOfa, numberOfz - 1, index - numberOfWords(numberOfa - 1, numberOfz).intValue());	
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner( System.in );
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(solutions(N, M, K));
		
	}

}
