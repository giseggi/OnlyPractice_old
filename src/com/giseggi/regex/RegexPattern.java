package com.giseggi.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {

	public static void main(String[] args) throws IOException {
		
		// 整数のみ可
		Pattern integerOnly = Pattern.compile("^[0-9]*$");
		// 英文字のみ可
		Pattern englishCharactersOnly = Pattern.compile("^[a-zA-Z]*$");
		// メールアドレス
		Pattern mailAddr = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$");
		// 携帯番号
		Pattern cellPhoneNumber = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$");
		// IPアドレス
		Pattern ipAddr = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		Matcher matcher = integerOnly.matcher(input);
		
		if(matcher.find()) {
			System.out.println("\"" + input + "\"" + "matches the pattern");
		} else {
			System.out.println("\"" + input + "\"" + "does not match the pattern");
		}
	
		

	}

}
