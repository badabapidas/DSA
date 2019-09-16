package com.bada.dsa.practice.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;

import com.bada.dsa.practice.node.GraphNode;

public class BFSByLinkedList {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public BFSByLinkedList(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirectedEdge(int i, int j) {
		i--;
		j--;
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);

		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}

	void bfs() {
		// if a node is unvisited then run bfs on it
		for (GraphNode node : nodeList) {
			if (!node.isVisited())
				bfsVisit(node);
		}
	}

	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		// add source node to queue
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode presentNode = queue.remove();
			presentNode.setVisited(true);
			System.out.print(presentNode.getName() + " ");
			for (GraphNode neighbor : presentNode.getNeighbors()) {
				if (!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}
}
