package Algo_11_201701969_������;

import java.util.ArrayList;

public class Graph {
	private ArrayList<ArrayList<Integer>> listGraph;
	int size;

	// �׷��� �ʱ�ȭ
	public Graph(int initSize) {
		this.listGraph = new ArrayList<ArrayList<Integer>>(); // �׷��� ����
		size = initSize;
		for (int i = 0; i < initSize; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
	}

	public void put(int x, int y) { // ���� �׷����� �Ϲ����� �߰�
		listGraph.get(x).add(y);
	}

	public ArrayList<ArrayList<Integer>> getGraph() { // �ϼ��� arraylist�� �����ϱ� ���� ���
		return this.listGraph;
	}

}
