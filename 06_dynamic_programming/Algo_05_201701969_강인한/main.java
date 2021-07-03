package Algo_05_201701969_������;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\user\\Desktop\\hw5_test_case.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line1, line2;
			String[] str_arr1, str_arr2;
			line1 = br.readLine();
			str_arr1 = line1.split(","); // ���ڸ� �迭�� ����

			// int �� �迭�� ��ȯ
			int[] int_arr1 = Arrays.stream(str_arr1).mapToInt(Integer::parseInt).toArray();
			int[] value = new int[int_arr1[0] + 1], weight = new int[int_arr1[0] + 1];
			for (int i = 0; i < int_arr1[0]; i++) { // item�� ������ŭ �ݺ�
				line2 = br.readLine();
				str_arr2 = line2.split(",");
				int[] int_arr2 = Arrays.stream(str_arr2).mapToInt(Integer::parseInt).toArray();
				value[i + 1] = int_arr2[0]; // value�� weight�� �����ؼ� ����
				weight[i + 1] = int_arr2[1];
			}
			large_value(value, weight, int_arr1[0], int_arr1[1]);
			// value �迭, ���� �迭, item�� ����, ������ �ִ��ѵ�
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void large_value(int[] value, int[] weight, int size, int sum_weight) {
		int[][] table = new int[size + 1][sum_weight + 1]; // ���� ��� ������ table
		int[] item = new int[size + 1]; // � item�� ������ �����ϴ� �迭
		int item_index = item.length - 1;
		int i_ = size, j_ = sum_weight;
		for (int i = 1; i <= size; i++) { // item�� ������ŭ �ݺ�
			for (int j = 1; j <= sum_weight; j++) { // �ѹ��� ��ŭ �ݺ�
				if (weight[i] > j) { // i��° item�� ���԰� ��ū ���
					table[i][j] = table[i - 1][j]; // ���̺��� �ٷ����� ���� �״�� ���
				} else { // �� �� �ִ� ��쿡�� ������ ���� ��������� value�� ���� ���
					if (table[i - 1][j] < table[i - 1][j - weight[i]] + value[i]) {
						table[i][j] = table[i - 1][j - weight[i]] + value[i];
					} else {
						table[i][j] = table[i - 1][j];
					}
				}
			}
		}
		// � item�� ���Եƴ��� ã�� �ݺ��� �ð����⵵�� size���̹Ƿ� ��ü�� �ð����⵵�� ���� x
		while (table[i_][j_] != 0) { // table�� 0�̵ɶ����� == index�� 0,0�϶�����
			if (table[i_][j_] != table[i_ - 1][j_]) { // ���̺��� �ٷ����� ���� �ٸ����
				item[item_index--] = i_; // �� ���� ���ٴ� ���̹Ƿ� item�迭�� �߰�
				j_ = j_ - weight[i_]; // j_�߿� weight��ŭ ���������Ƿ� ���ش�.
				i_ = i_ - 1; // i�� �ϳ� ���ش�.
			} else
				i_ = i_ - 1; // i�� 1��ŭ ���ش�.
		}

		System.out.println("max value : " + table[size][sum_weight]);
		System.out.print("item : ");
		for (int i = 0; i < item.length; i++) {
			if (item[i] != 0)
				System.out.print(item[i] + " ");
		}
	}
}