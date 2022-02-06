package com.giseggi.dp;

import java.math.BigDecimal;
import java.util.Scanner;

public class Problem13 {
	static BigDecimal[] factorial = new BigDecimal[31];
	
	static BigDecimal calFactorial(int number) {
		
		if(number == 1 || number == 0) {
			return factorial[1] = BigDecimal.ONE;
		} else {
			return factorial[number] = new BigDecimal(number).multiply(calFactorial(number - 1));
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner( System.in );
		
		int numberOfTestCase = sc.nextInt();
				
		for(int i = 0; i < numberOfTestCase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(calFactorial(M).divide(calFactorial(N).multiply(calFactorial(M - N))));
		}

	}

}
