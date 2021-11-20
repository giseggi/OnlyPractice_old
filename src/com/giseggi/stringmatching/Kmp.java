package com.giseggi.stringmatching;

/**
 * 文字列検索アルゴリズム_KMP
 *
 */
public class Kmp {
	
	// FailFunction - 接頭辞=接尾辞の桁数情報Array
	static int[] failFunction;
	
	/**
	 * FailFunctionを作成する
	 *
	 * @param pattern  検索する文字列
	 * @return なし
	 */
	static void prefixTable(String pattern) {
		
		// 1番目は0固定
		failFunction[0] = 0;
		
		int i = 1;
		int j = 0;
		while(i < pattern.length()) {
			// 一致した場合、次の文字を比較する。
			if(pattern.charAt(i) == pattern.charAt(j)) {
				failFunction[i] = j + 1;
				j++;
				i++;
			
			// 一致しない文字が出た場合、もっと小さい文字列が一致するか確認するためにindexを移動させる
			} else if(j > 0) {
				j = failFunction[j - 1];
				
			//　先頭まで戻ったら	FailFunctionを0にする。次の文字に移る
			} else {
				failFunction[j] = 0;
				i++;
			}
			
		}
		
	}
	
	/**
	 * KMP
	 *
	 * @param text  検索対象の文字列
	 * @param pattern  検索する文字列
	 * @return 一致した文字列の先頭文字のindex
	 * 　　　　　　 一致する文字列がない場合は-1
	 */
	static int KMP(String text, String pattern) {
		
		// failFunctionを作成する。
		prefixTable(pattern);
		
		int i = 0;
		int j = 0;
		
		while(i < text.length()) {
			// 文字が一致した場合
			if(text.charAt(i) == pattern.charAt(j)) {
				// patternの長さまで一致したら処理終了
				if(j == pattern.length() - 1) {
					return i - j;
				// 上記以外の場合
				} else {
					//　次の文字を比較する。
					i++;
					j++;
				}
			
			// 一致しない文字が出た場合、failFunction値の程indexを移動させる
			} else if(j > 0) {
				j = failFunction[j - 1];
				
			// 上記以外の場合、次の文字に移る、
			} else {
				i++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		
		String pattern = "ababaca";
		String text = "bacbabababacaca";
		
		failFunction = new int[pattern.length()];
		
		int index = KMP(text, pattern);
		
		System.out.println(index);

	}

}
