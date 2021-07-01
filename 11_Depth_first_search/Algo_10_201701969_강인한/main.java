package Algo_10_201701969_강인한;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\user\\Desktop\\hw10_test_case1.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String vertex = br.readLine(); // vertex
			String edge = br.readLine(); // edge
			int ver = Integer.parseInt(vertex);
			int eg = Integer.parseInt(edge);

			Graph graph = new Graph(ver);

			for (int i = 0; i < eg; i++) {
				String[] node = br.readLine().split(" ");
				int[] int_arr = Arrays.stream(node).mapToInt(Integer::parseInt).toArray();
				graph.put(int_arr[0], int_arr[1]);

			}
			ArrayList<ArrayList<Integer>> arr;
			arr = graph.getGraph();
			Stack<Integer> sck = new Stack<>();

			sck.push(0);
			int idx = 0;
			System.out.println(sck.peek());
			while (true) {
				for (int i = 0; i < ver; i++) {  //stack에 들어간 숫자를 제거해주는 과정
					for (int j = 0; j < arr.get(i).size(); j++) {
						if (idx == arr.get(i).get(j)) {
							arr.get(i).remove(j);
						}
					}
				}
				if (arr.get(idx).isEmpty()) { //arraylist의 idx번째 index가 이미 다 stack에 들어가 더이상 넣을것이 없다면 pop
					sck.pop();
				} else {  //stack에 넣을것이 있다면 push
					sck.push(arr.get(idx).get(0));
					System.out.println(sck.peek());
				}
				
				if (sck.isEmpty()) {  //stack이 다 비워지면 while문 종료
					break;
				}
				idx = sck.peek();  //index를 바꿔주는 과정
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
