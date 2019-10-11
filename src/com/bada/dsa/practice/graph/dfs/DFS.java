package com.bada.dsa.practice.graph.dfs;

import java.util.ArrayList;
import java.util.Stack;

import com.bada.dsa.practice.node.GraphNode;

public class DFS {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public DFS(ArrayList<GraphNode> nodeList) {
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

	void dfs(int caseW) { // 0 for iterative, 1 for recursive
		for (GraphNode node : nodeList) {
			if (!node.isVisited()) {
				if (caseW == 0) {
					dfsVisitIterative(node);
				} else {
					dfsVisitRecurssive(node);
				}
			}
		}
	}

	private void dfsVisitRecurssive(GraphNode node) {
		// mark node as visited
		node.setVisited(true);
		// print the node
		System.out.print(node.getName() + " ");
		// for each neighbor of present node
		for (GraphNode neighbor : node.getNeighbors()) {
			// if neighbor is not visited
			if (!neighbor.isVisited()) {
				// recursive call to dfs function
				dfsVisitRecurssive(neighbor);
			}
		}
	}

	private void dfsVisitIterative(GraphNode node) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNode presentNode = stack.pop();
			presentNode.setVisited(true);

			System.out.print(presentNode.getName() + " ");
			for (GraphNode neighbor : presentNode.getNeighbors()) {
				// if neighbor is not visited then add it to queue
				if (!neighbor.isVisited()) {
					stack.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}
}
