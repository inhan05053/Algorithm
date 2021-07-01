package Algo_10_201701969_������;

import java.util.ArrayList;

class Graph {

	private ArrayList<ArrayList<Integer>> listGraph;
	int size;
	// �׷��� �ʱ�ȭ
	public Graph(int initSize) {
		this.listGraph = new ArrayList<ArrayList<Integer>>(); // �׷��� ����
		size=initSize;
		for (int i = 0; i < initSize + 1; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
	}
    public void put(int x, int y) { //������̹Ƿ� ���� arraylist �߰�
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }
    public ArrayList<ArrayList<Integer>> getGraph() {  //�ϼ��� arraylist�� �����ϱ� ���� ���
        return this.listGraph;
    }
}