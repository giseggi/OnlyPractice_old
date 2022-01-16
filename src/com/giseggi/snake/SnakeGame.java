package com.giseggi.snake;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class SnakeGame extends JFrame {

	private JLabel[][] jlArray = new JLabel[30][30];
	private JPanel panel = new JPanel();
	private Snake snake = new Snake();
	private Cell food = new Cell();
	boolean gameOver;

	public SnakeGame() {		
		
		setTitle("SnakeGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLocation(500, 200);
		
		gameOver = false;
		
		panel.setLayout(new GridLayout(30, 30, 1, 1));	
		panel.addKeyListener(new SnakeKeyListener());	
		
		for(int i = 0; i < 30; i ++) {
			for(int j = 0; j < 30; j++) {
				jlArray[i][j] = new JLabel();
				jlArray[i][j].setOpaque(true);
				jlArray[i][j].setBackground(Color.BLACK);
				panel.add(jlArray[i][j]);
			}
		}
		
		snake.setLength(1);
		List<Cell> firstBody = new ArrayList<Cell>();
		Cell cell = new Cell();
		cell.setX(15);
		cell.setY(15);
		firstBody.add(cell);

		snake.setDirection(Direction.NONE);
		snake.setBody(firstBody);
		displaySnake(snake);
		createFood();					
		
		setSize(800, 800);
		setVisible(true);	
		
		panel.setFocusable(true);
		
									
	}
	
	class SnakeKeyListener implements KeyListener{
		@Override
        public void keyTyped(KeyEvent e) {
        }

		@Override
		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();

			switch (keyCode) {
				case KeyEvent.VK_UP:
					if(snake.getBody().get(0).getX() == 0) {
						gameOver = true;
					}
					
					if(snake.getBody().size() == 1) {
						moveSnake(Direction.UP, snake);
					} else {
						if (snake.getDirection() != Direction.DOWN) {
							moveSnake(Direction.UP, snake);
						}
					}					
					break;
					
				case KeyEvent.VK_DOWN:
					if(snake.getBody().get(0).getX() == 29) {
						gameOver = true;
					}
					
					if(snake.getBody().size() == 1) {
						moveSnake(Direction.DOWN, snake);
					} else {
						if (snake.getDirection() != Direction.UP) {
							moveSnake(Direction.DOWN, snake);
						}
					}					
					break;
					
				case KeyEvent.VK_RIGHT:
					if(snake.getBody().get(0).getY() == 29) {
						gameOver = true;
					}
					if(snake.getBody().size() == 1) {
						moveSnake(Direction.RIGHT, snake);
					} else {
						if (snake.getDirection() != Direction.LEFT) {
							moveSnake(Direction.RIGHT, snake);
						}
					}									
					break;
					
				case KeyEvent.VK_LEFT:
					if(snake.getBody().get(0).getY() == 0) {
						gameOver = true;
					}
					
					if(snake.getBody().size() == 1) {
						moveSnake(Direction.LEFT, snake);
					} else {
						if (snake.getDirection() != Direction.RIGHT) {
							moveSnake(Direction.LEFT, snake);
						}
					}					
					break;
			}
			
			if(gameOver) {
				JOptionPane.showMessageDialog(null, "Game Over!");
				panel.setFocusable(false);
				return;
			}
			
			displaySnake(snake);
						
		}

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
	}
	
	public void displaySnake(Snake snake) {
		List<Cell> body = snake.getBody();
		
		for(Cell cell : body) {
			jlArray[cell.getX()][cell.getY()].setBackground(Color.RED);
		}	
	}
	
	public void moveSnake(Direction direction, Snake snake) throws ArrayIndexOutOfBoundsException {
		List<Cell> body = snake.getBody();
		
		int newHeadX = 0;
		int newHeadY = 0;
		int headX = snake.getBody().get(0).getX();
        int headY = snake.getBody().get(0).getY();
        
		switch(direction) {
			case UP:
				newHeadX = headX - 1;
				newHeadY = headY;			
				break;
		
			case DOWN:
				newHeadX = headX + 1;
				newHeadY = headY;
				break;
		
			case LEFT:
				newHeadX = headX;
				newHeadY = headY - 1;
				break;
		
			case RIGHT:
				newHeadX = headX;
				newHeadY = headY + 1;
				break;				
		}
		if(isBody(newHeadX, newHeadY)) {
        	gameOver = true;
			return;
        }
		
		if(newHeadX == food.getX() && newHeadY == food.getY()) {
			Cell cell = new Cell();	
			cell.setX(newHeadX);
			cell.setY(newHeadY);
			snake.getBody().add(0, cell);
			
			createFood();
						
		} else {
			if(!gameOver) {
				jlArray[snake.getBody().get(snake.getBody().size() - 1).getX()][snake.getBody().get(snake.getBody().size() - 1).getY()].setBackground(Color.BLACK);
			}
			
			for(int i = body.size() - 1; i > 0; i--) {
				body.get(i).setX(body.get(i - 1).getX());
				body.get(i).setY(body.get(i - 1).getY());
			}
			body.get(0).setX(newHeadX);
			body.get(0).setY(newHeadY);
		}
		       
		snake.setDirection(direction);
	}
	
	boolean isBody(int x, int y) {
		int index = 0;
		for(Cell cell : snake.getBody()) {
			if(index == 0) {
				index++;
				continue;
			} 
			if(cell.getX() == x && cell.getY() == y) {
				return true;
			}
			index++;
		}
		
		return false;
		
	}
	
	public void createFood() {
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		int foodX = random.nextInt(30);
		int foodY = random.nextInt(30);
		
		int headX = snake.getBody().get(0).getX();
		int headY = snake.getBody().get(0).getY();
		
		while(isBody(foodX, foodY) || (foodX == headX && foodY == headY)) {
			foodX = random.nextInt(30);
			foodY = random.nextInt(30);
		}
		
		food.setX(foodX);
		food.setY(foodY);
		
		jlArray[food.getX()][food.getY()].setBackground(Color.GREEN);
		
	}
	
	public static void main(String[] args) {
		
		new SnakeGame();

	}

}
