package com.giseggi.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	// 最大頂点数
	private static final int MAX_VERTEX = 20;
	
	// 頂点配列
	private Vertex vertexArray[];
	
	// 隣接行列
	private int adjacencyMatrix[][]; 
	
	// 現在頂点数
	private int vertexCount;
	
	// DFS用のStack
	private Stack<Integer> stack;
	
	//BFS用のQueue
	private Queue<Integer> queue;
	
	// Graph初期化
	public Graph() {
		vertexArray = new Vertex[MAX_VERTEX];
		adjacencyMatrix = new int[MAX_VERTEX][MAX_VERTEX];
		vertexCount = 0;
		
		for(int i = 0; i < MAX_VERTEX; i++) {
			for(int j = 0; j < MAX_VERTEX; j++) {
				adjacencyMatrix[i][j] = 0;
			}
		}
		
		stack = new Stack<>();
		queue = new LinkedList<>();
		
	}
	
	public void addVertex(String value) {
		vertexArray[vertexCount] = new Vertex(value);
		vertexCount++;
	}
	
	public void addEdge(int from, int to) {
		adjacencyMatrix[from][to] = 1;
		adjacencyMatrix[to][from] = 1;	
	}
	
	public void displayVertexValue(int index) {
		System.out.println(vertexArray[index].getValue());
	}
	
	public void DFS() {
		vertexArray[0].setVisited(true);
		displayVertexValue(0);
		stack.push(0);
		
		while(!stack.isEmpty()) {
			int index = getAdjacentUnvisitedVertex(stack.peek());
			if(index == -1) {
				stack.pop();
			} else {
				vertexArray[index].setVisited(true);
				displayVertexValue(index);
				stack.push(index);
			}	
		}
		
		for(int i = 0; i < vertexCount; i++) {
			vertexArray[i].setVisited(false);
		}
		
	}
	
	public void BFS() {
		// levelが増えたかどうかを判別するフラグ
		boolean levelAddedFlg = true;
		vertexArray[0].setVisited(true);
		System.out.println("level: 0");
		displayVertexValue(0);
		// 訪問したVertexの数
		int displayedCount = 1;
		
		queue.add(0);
		int level = 1;
		while(!queue.isEmpty()) {
			
			// 全てのVertexを訪問した場合はlevelを表示させない
			if(levelAddedFlg && displayedCount != vertexCount) {
				System.out.println("level: " + level);
				levelAddedFlg = false;
			}
			int index = queue.remove();			
			while(getAdjacentUnvisitedVertex(index) != -1) {
				int index2 = getAdjacentUnvisitedVertex(index);
				vertexArray[index2].setVisited(true);
				
				// 隣接Vertexを全て訪問した場合、levelを増す。
				if(getAdjacentUnvisitedVertex(index) == -1) {
					level++;
					levelAddedFlg = true;					
				}
				
				displayVertexValue(index2);
				displayedCount++;
				queue.add(index2);
				
			}
						
		}
		
		for(int i = 0; i < vertexCount; i++) {
			vertexArray[i].setVisited(false);
		}
			
	}
	
	// 訪問してないindexの隣接Vertexを返却、ない場合は-1を返却する。
	public int getAdjacentUnvisitedVertex(int index) {
		for(int i = 0; i < vertexCount; i++) {
			if(adjacencyMatrix[index][i] == 1 && !vertexArray[i].isVisited()) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		// graph初期化
		Graph graph = new Graph();
		
		
		// graph構成は以下
        //		B
        //		│
        //		C─H
        //		│ │
        //		A─G─E
        //		│ │
        //		F D
		
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("A");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("H");
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 7);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 7);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		
		// DFS
		// B-C-A-F-G-D-E-H
		graph.DFS();
		
		System.out.println();
		// BFS
		// level: 0
		// B
		// level: 1
		// C
		// level: 2
		// A H
		// level: 3
		// F G
		// level: 4
		// D E
		graph.BFS();
		
	}
	
}

