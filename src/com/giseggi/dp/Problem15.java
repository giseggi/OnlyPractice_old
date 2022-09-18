package com.giseggi.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem15 {
	
    static BigDecimal[] factorial = new BigDecimal[100001];
    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] lines = getStdin();

        // 商品の数
        int N = Integer.parseInt(lines[0]);

        // 目立ちやすさの配列
        String[] C = lines[1].split(" ");

        // 目立ちやすさのリスト
        List<BigDecimal> CList = new ArrayList<BigDecimal>();

        for (int i = 0; i < C.length; i++) {
            CList.add(new BigDecimal(C[i]));
        }

        // 重複を除いたリスト
        List<BigDecimal> CListWithoutDuplication= CList.stream().distinct().collect(Collectors.toList());

        // 各商品ごとに重複する数
        Map<BigDecimal, Integer> productFrequency = new HashMap<BigDecimal, Integer>();

        for (BigDecimal c : CListWithoutDuplication) {
            int frequency = Collections.frequency(CList, c);
            productFrequency.put(c, frequency);
        }

        BigDecimal two = new BigDecimal("2");

        BigDecimal duplication= BigDecimal.ONE;

        for(BigDecimal product : productFrequency.keySet()) {
            duplication= duplication.multiply(calFactorial(productFrequency.get(product))).remainder(new BigDecimal("100003"));
        }

        System.out.println(two.pow(CListWithoutDuplication.size() - 1).multiply(duplication).remainder(new BigDecimal("100003")));

    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

        // 階乗を計算する
    private static BigDecimal calFactorial(int number) {

        if(number == 1 || number == 0) {
            return factorial[1] = BigDecimal.ONE;
        } else {
            return factorial[number] = new BigDecimal(number).multiply(calFactorial(number - 1).remainder(new BigDecimal("100003")));
        }    
    }
}
