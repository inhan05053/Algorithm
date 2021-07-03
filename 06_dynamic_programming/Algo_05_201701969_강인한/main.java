package Algo_05_201701969_강인한;

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
			str_arr1 = line1.split(","); // 숫자만 배열로 저장

			// int 형 배열로 변환
			int[] int_arr1 = Arrays.stream(str_arr1).mapToInt(Integer::parseInt).toArray();
			int[] value = new int[int_arr1[0] + 1], weight = new int[int_arr1[0] + 1];
			for (int i = 0; i < int_arr1[0]; i++) { // item의 개수만큼 반복
				line2 = br.readLine();
				str_arr2 = line2.split(",");
				int[] int_arr2 = Arrays.stream(str_arr2).mapToInt(Integer::parseInt).toArray();
				value[i + 1] = int_arr2[0]; // value와 weight를 구별해서 저장
				weight[i + 1] = int_arr2[1];
			}
			large_value(value, weight, int_arr1[0], int_arr1[1]);
			// value 배열, 무게 배열, item의 개수, 무게의 최대한도
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void large_value(int[] value, int[] weight, int size, int sum_weight) {
		int[][] table = new int[size + 1][sum_weight + 1]; // 값이 담길 이차원 table
		int[] item = new int[size + 1]; // 어떤 item이 들어갔는지 저장하는 배열
		int item_index = item.length - 1;
		int i_ = size, j_ = sum_weight;
		for (int i = 1; i <= size; i++) { // item의 개수만큼 반복
			for (int j = 1; j <= sum_weight; j++) { // 총무게 만큼 반복
				if (weight[i] > j) { // i번째 item의 무게가 더큰 경우
					table[i][j] = table[i - 1][j]; // 테이블에서 바로위의 값을 그대로 사용
				} else { // 들어갈 수 있는 경우에는 들어갈경우와 들어가지 않을경우의 value를 비교해 사용
					if (table[i - 1][j] < table[i - 1][j - weight[i]] + value[i]) {
						table[i][j] = table[i - 1][j - weight[i]] + value[i];
					} else {
						table[i][j] = table[i - 1][j];
					}
				}
			}
		}
		// 어떤 item이 포함됐는지 찾는 반복문 시간복잡도가 size번이므로 전체의 시간복잡도에 영향 x
		while (table[i_][j_] != 0) { // table이 0이될때까지 == index가 0,0일때까지
			if (table[i_][j_] != table[i_ - 1][j_]) { // 테이블에서 바로위의 값과 다를경우
				item[item_index--] = i_; // 그 값이 들어갔다는 뜻이므로 item배열에 추가
				j_ = j_ - weight[i_]; // j_중에 weight만큼 차지했으므로 빼준다.
				i_ = i_ - 1; // i도 하나 빼준다.
			} else
				i_ = i_ - 1; // i를 1만큼 빼준다.
		}

		System.out.println("max value : " + table[size][sum_weight]);
		System.out.print("item : ");
		for (int i = 0; i < item.length; i++) {
			if (item[i] != 0)
				System.out.print(item[i] + " ");
		}
	}
}