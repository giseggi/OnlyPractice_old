package com.giseggi.snake;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class SnakeGame extends JFrame {

	JLabel[][] jlArray = new JLabel[31][31];
	JPanel panel = new JPanel();
	Snake snake = new Snake();
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
		
		snake.setLength(10);
		List<Cell> firstBody = new ArrayList<Cell>();
		for(int i = 0; i < snake.getLength(); i++) {
			Cell cell = new Cell();
			cell.setX(15 - i);
			cell.setY(15);
			firstBody.add(cell);
		}
		snake.setDirection(Direction.NONE);
		snake.setBody(firstBody);
		displaySnake(snake);
								
		setSize(700, 700);
		setVisible(true);	
		
		panel.setFocusable(true);
		
									
	}
	
	class SnakeKeyListener implements KeyListener{
		@Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	int keyCode =e.getKeyCode();
            
            switch(keyCode){
                case KeyEvent.VK_UP:
                	if(snake.getDirection() != Direction.DOWN) {
                		moveSnake(Direction.UP, snake);
                	}                	
                    break;
                case KeyEvent.VK_DOWN:
                	if(snake.getDirection() != Direction.UP) {
                		moveSnake(Direction.DOWN, snake);
                	}                	
                    break;
                case KeyEvent.VK_RIGHT:
                	if(snake.getDirection() != Direction.LEFT) {
                		moveSnake(Direction.RIGHT, snake); 
                	}                	
                    break;
                case KeyEvent.VK_LEFT:
                	if(snake.getDirection() != Direction.RIGHT) {
                		moveSnake(Direction.LEFT, snake);
                	}              	
                    break;
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
	
	public void moveSnake(Direction direction, Snake snake) {
		List<Cell> body = snake.getBody();
		
		int newHeadX = snake.getBody().get(0).getX();
        int newHeadY = snake.getBody().get(0).getY();
        
        switch(direction) {
        	case UP:
        		if(isBody(newHeadX - 1, newHeadY)) {
                	return;
                }
        		break;
        		
        	case DOWN:
        		if(isBody(newHeadX + 1, newHeadY)) {
        			return;
                }
        		break;
        		
        	case LEFT:
        		if(isBody(newHeadX, newHeadY - 1)) {
        			return;
                }
        		break;
        		
        	case RIGHT:
        		if(isBody(newHeadX, newHeadY + 1)) {
        			return;
                }
        		break;
        }
		jlArray[snake.getBody().get(snake.getBody().size() - 1).getX()][snake.getBody().get(snake.getBody().size() - 1).getY()].setBackground(Color.BLACK);
		for(int i = body.size() - 1; i > 0; i--) {
			body.get(i).setX(body.get(i - 1).getX());
			body.get(i).setY(body.get(i - 1).getY());
		}
		switch(direction) {
			case UP:
				body.get(0).setX(body.get(0).getX() - 1);
				body.get(0).setY(body.get(0).getY());
				break;
			
			case DOWN:
				body.get(0).setX(body.get(0).getX() + 1);
				body.get(0).setY(body.get(0).getY());
				break;
			
			case LEFT:
				body.get(0).setX(body.get(0).getX());
				body.get(0).setY(body.get(0).getY() - 1);
				break;
			
			case RIGHT:
				body.get(0).setX(body.get(0).getX());
				body.get(0).setY(body.get(0).getY() + 1);
				break;	
				
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
	
	public static void main(String[] args) {
		
		new SnakeGame();

	}

}
