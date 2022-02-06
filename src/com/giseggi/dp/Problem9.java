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
