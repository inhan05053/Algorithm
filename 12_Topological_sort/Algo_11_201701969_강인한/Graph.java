package Algo_11_201701969_강인한;

import java.util.ArrayList;

public class Graph {
	private ArrayList<ArrayList<Integer>> listGraph;
	int size;

	// 그래프 초기화
	public Graph(int initSize) {
		this.listGraph = new ArrayList<ArrayList<Integer>>(); // 그래프 생성
		size = initSize;
		for (int i = 0; i < initSize; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
	}

	public void put(int x, int y) { // 무향 그래프의 일방적인 추가
		listGraph.get(x).add(y);
	}

	public ArrayList<ArrayList<Integer>> getGraph() { // 완성된 arraylist를 전달하기 위해 사용
		return this.listGraph;
	}

}
