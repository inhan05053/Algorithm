package Algo_06_201701969_������;

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

			line1 = br.readLine(); // ������ ���� �� �� �ִ� �ִ� �Ÿ�
			line2 = br.readLine(); // �ι�° �迭

			int m = Integer.valueOf(line1); //int�� ������ ��ȯ
			String[] str_arr2 = line2.split(","); //","�� �����ϰ� string �迭 ����
			int[] int_arr2 = Arrays.stream(str_arr2).mapToInt(Integer::parseInt).toArray();
			int i = 0;
			int sum = 0;  //�����ִ� �Ÿ��� ���� ����Ǵ� ����
			int count = 0;  //stop�ϴ� ��ġ�� ����
			String spot= "";
			while (i < int_arr2.length) { //index�� �迭�� ������ Ž���� ��ĥ������ �ݺ�
				while ( i < int_arr2.length &&m >= sum+int_arr2[i]) {  //m�� sum+i��° ������ ũ�ų� ���� ���
					sum += int_arr2[i]; //m�� �ɶ����� ���س����� greedy algorithm
					i += 1; //index�� 1�߰�
				} 
				sum = 0; //���� 1�� �ʱ�ȭ
				count++; //������ while���� �������Ƿ� stop����� ���� 1�߰�
				spot= spot+"a"+i+" ";  //stop��ġ �߰�
			}
			System.out.println("stop count : "+count);
			System.out.println("stop spot : "+spot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
