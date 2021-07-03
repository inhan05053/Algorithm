package Algo_06_201701969_강인한;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\user\\Desktop\\hw6_test_case3.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line1, line2;

			line1 = br.readLine(); // 충전된 물로 갈 수 있는 최대 거리
			line2 = br.readLine(); // 두번째 배열

			int m = Integer.valueOf(line1); //int형 변수로 변환
			String[] str_arr2 = line2.split(","); //","를 제거하고 string 배열 생성
			int[] int_arr2 = Arrays.stream(str_arr2).mapToInt(Integer::parseInt).toArray();
			int i = 0;
			int sum = 0;  //갈수있는 거리의 합이 저장되는 변수
			int count = 0;  //stop하는 위치의 개수
			String spot= "";
			while (i < int_arr2.length) { //index가 배열의 끝까지 탐색을 마칠때까지 반복
				while ( i < int_arr2.length &&m >= sum+int_arr2[i]) {  //m이 sum+i번째 값보다 크거나 같을 경우
					sum += int_arr2[i]; //m이 될때까지 더해나간다 greedy algorithm
					i += 1; //index에 1추가
				} 
				sum = 0; //합을 1로 초기화
				count++; //내부의 while문이 멈췄으므로 stop장소의 개수 1추가
				spot= spot+"a"+i+" ";  //stop위치 추가
			}
			System.out.println("stop count : "+count);
			System.out.println("stop spot : "+spot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
