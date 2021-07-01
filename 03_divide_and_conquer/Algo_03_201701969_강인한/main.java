package Algo_03_201701969_강인한;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {
	
	static int num = 0; //inversion의 개수

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\user\\Desktop\\hw3_test_case2.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			line = br.readLine();
			String[] str_ = line.split(",");
			int[] int_ = new int[str_.length];
			int[] int_1 = new int[str_.length];

			for (int i = 0; i < str_.length; i++) {
				int_[i] = Integer.parseInt(str_[i]);
				int_1[i] = Integer.parseInt(str_[i]);

			}

			Merge_Sort(int_, 0, str_.length - 1);
			System.out.println("RESULT");
			System.out.println(num);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// mid를 정하고 두개로 나눠 recursive되도록 한다.
	public static void Merge_Sort(int[] a, int low, int high) { // mid를 정하고 두개로 나눠
		if (high == low) { // base case
			return;
		}
		int mid = (high + low) / 2;
		Merge_Sort(a, low, mid);
		Merge_Sort(a, mid + 1, high);
		Merge_Combine(a, low, mid, high); // 두부분을 combine하는 메소드
	}

	public static void Merge_Combine(int[] arr, int low, int mid, int high) {
		int[] int_sorted = new int[arr.length]; // sort 될 새로운 배열 생성
		int i = low;
		int left_start = low;
		int right_start = mid + 1;
		while (left_start <= mid && right_start <= high) {
			if (arr[left_start] <= arr[right_start]) { // 오른쪽이 큰 경우
				int_sorted[i++] = arr[left_start++];
			} else { // 왼쪽이 큰 경우
				int_sorted[i++] = arr[right_start++];
				num += (mid - left_start + 1); // 남아있는 왼쪽 배열의 개수 만큼 더함 =inversion
			}
		}
		while (left_start <= mid) // sort안된 나머지 index 복사
			int_sorted[i++] = arr[left_start++];
		while (right_start <= high)
			int_sorted[i++] = arr[right_start++];
		for (int j = low; j < i; j++) { // sort된 배열을 arr배열에 저장
			arr[j] = int_sorted[j];
		}

	}
}
