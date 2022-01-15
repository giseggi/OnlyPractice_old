package com.giseggi.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

	private int length;
	private List<Cell> body;
	private Direction direction;
	
	Snake() {
		body = new ArrayList<Cell>();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public List<Cell> getBody() {
		return body;
	}

	public void setBody(List<Cell> body) {
		this.body = body;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
		
}

enum Direction {
	UP, DOWN, LEFT, RIGHT, NONE
}
