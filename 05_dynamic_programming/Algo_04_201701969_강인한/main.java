package Algo_04_201701969_강인한;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\user\\Desktop\\hw4_test_case2.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			line = br.readLine();
			String[] price = line.split(",");
			int[] difference = new int[price.length - 1];
			for (int i = 0; i < price.length - 1; i++) {
				difference[i] = Integer.parseInt(price[i + 1]) - Integer.parseInt(price[i]);
			}
			Find_Maximum(difference, difference.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void Find_Maximum(int[] difference, int ksize) {
		int sum_max = 0; //i마다 큰 이익 값이 들어갈 변수
		int profit = 0; // 가장큰 이익이 들어갈 변수
		int purchase_date = 0; //구매일
		int sell_date = 0;  //판매일
		for (int i = 0; i < ksize - 1; i++) {  //ksize만큼 반복
			if (difference[i] >= difference[i] + sum_max) {  // i번째 difference가 더해질게 큰지 작은지 비교
				sum_max = difference[i];  // i번째 index 자체가 크다면  값 저장
				purchase_date = i;  // 구매일 저장
			} else {
				sum_max = sum_max + difference[i];  //기존의 것에 i번째 index를 더한값이 크다면 저장
			}
			if (sum_max >= profit) {  //기존의 sum_max값과 최신회된 값 저장
				profit = sum_max;
				sell_date = i;  // 기존의 값보다 최신화된 값이 크다면 그날은 판매일이 됨
			}
		}
		System.out.println("RESULT");
		System.out.println("purchase date: " + purchase_date);
		System.out.println("sell date: " + (sell_date + 1));
		System.out.println("profit : " + profit);

	}

}
