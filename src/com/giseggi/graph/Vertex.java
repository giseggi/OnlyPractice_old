package com.giseggi.graph;

public class Vertex {
	
	private String value;
	
	private boolean visited;
	
	// 頂点初期化
	public Vertex(String value) {
		this.value = value;
		visited = false;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
