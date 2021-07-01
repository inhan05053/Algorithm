package Algo_04_201701969_������;

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
		int sum_max = 0; //i���� ū ���� ���� �� ����
		int profit = 0; // ����ū ������ �� ����
		int purchase_date = 0; //������
		int sell_date = 0;  //�Ǹ���
		for (int i = 0; i < ksize - 1; i++) {  //ksize��ŭ �ݺ�
			if (difference[i] >= difference[i] + sum_max) {  // i��° difference�� �������� ū�� ������ ��
				sum_max = difference[i];  // i��° index ��ü�� ũ�ٸ�  �� ����
				purchase_date = i;  // ������ ����
			} else {
				sum_max = sum_max + difference[i];  //������ �Ϳ� i��° index�� ���Ѱ��� ũ�ٸ� ����
			}
			if (sum_max >= profit) {  //������ sum_max���� �ֽ�ȸ�� �� ����
				profit = sum_max;
				sell_date = i;  // ������ ������ �ֽ�ȭ�� ���� ũ�ٸ� �׳��� �Ǹ����� ��
			}
		}
		System.out.println("RESULT");
		System.out.println("purchase date: " + purchase_date);
		System.out.println("sell date: " + (sell_date + 1));
		System.out.println("profit : " + profit);

	}

}
