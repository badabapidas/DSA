package com.bada.dsa.practice.graph.bfs;

import java.util.ArrayList;

import com.bada.dsa.practice.node.GraphNode;

public class BFSMain {
	public static void main(String[] args) {
		bfs();
	}

	private static void bfs() {
		ArrayList<GraphNode> nodeList = new ArrayList<>();

		// Create 10 nodes: V1-V10
		for (int i = 1; i < 11; i++) {
			nodeList.add(new GraphNode("V" + i, i - 1));
		}

//		BFSByAdjacencyMatrix graph = new BFSByAdjacencyMatrix(nodeList);
		BFSByLinkedList graph= new BFSByLinkedList(nodeList);
		// Add edges in graph
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 5);
		graph.addUndirectedEdge(3, 6);
		graph.addUndirectedEdge(3, 10);
		graph.addUndirectedEdge(4, 7);
		graph.addUndirectedEdge(5, 8);
		graph.addUndirectedEdge(6, 9);
		graph.addUndirectedEdge(7, 8);
		graph.addUndirectedEdge(8, 9);
		graph.addUndirectedEdge(9, 10);
		graph.bfs();
	}
}
