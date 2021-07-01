package Algo_11_201701969_∞≠¿Œ«—;

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

		File file = new File("C:\\Users\\user\\Desktop\\hw11_test_case2.txt");
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
			Stack<Integer> stk = new Stack<>();
			Stack<Integer> tplogy = new Stack<>();
			int current;
			int k = 0;
			Boolean cycle = false;
			stk.push(0);
			System.out.println("Topology Sort Result");
			while (!stk.isEmpty()) {
				current = stk.pop();
				tplogy.push(current);
				for (int i = 0; i < arr.get(current).size(); i++) {
					stk.push(arr.get(current).get(i));
					if (arr.get(current).get(i) < current) {
						cycle = true;
						break;
					}
				}
				k++;
				int value = tplogy.peek();
				if (k >= ver + 2 && cycle == true) {
					stk.clear();
					System.out.println("cycle");
					for (int i = 0; i < ver; i++) {
						stk.push(tplogy.pop());
						if (value == tplogy.peek())
							break;
					}
					for (int i = stk.size() - 1; i >= 0; i--) {
						System.out.println(stk.elementAt(i));
					}
					break;
				}
			}
			if (cycle != true) {
				print_stack(tplogy);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void print_stack(Stack<Integer> tplogy) {
		Stack<Integer> real_tplogy = new Stack<>();
		int pop;
		int tp_size = tplogy.size();
		for (int i = 0; i < tp_size; i++) {
			pop = tplogy.peek();
			if (!real_tplogy.contains(tplogy.pop())) {
				real_tplogy.push(pop);
			}
		}
		for (int i = real_tplogy.size() - 1; i >= 0; i--) {
			System.out.println(real_tplogy.elementAt(i));
		}

		// TODO Auto-generated method stub
	}

}
