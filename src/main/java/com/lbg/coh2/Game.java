package com.lbg.coh2;

public class Game 
{
	private int boardDimensions;
	private Coordinate player;
	private Coordinate treasure;
	
	public Game (int boardDimensions)
	{
		this.boardDimensions = boardDimensions;
		this.player = generatePosition(0);
		this.treasure = generatePosition(1);
	}

	public int getBoardDimensions() {
		return boardDimensions;
	}

	public void setBoardDimensions(int boardDimensions) {
		this.boardDimensions = boardDimensions;
	}

	public Coordinate getPlayer() {
		return player;
	}

	public void setPlayer(Coordinate player) {
		this.player = player;
	}

	public Coordinate getTreasure() {
		return treasure;
	}

	public void setTreasure(Coordinate treasure) {
		this.treasure = treasure;
	}
	
	private int getRandomNumbers(int min,int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
	
	private Coordinate generatePosition (int mode) {	
		int x = 0;
		int y = 0;
		int edge = 0;
		int scalar = 0;
		
		//Generating player position
		if (mode == 0) {
			scalar = getRandomNumbers(0,getBoardDimensions());
			edge = getRandomNumbers(0,4);
			
			if (edge == 0 || edge == 1) {
				edge = edge*(getBoardDimensions()-1);
				x = scalar;
				y = edge;
			}
			else if (edge == 2 || edge == 3) {
				edge -= 2;
				edge = edge*(getBoardDimensions()-1);
				x = edge;
				y = scalar;
			}
		}
		
		// Generating treasure position
		else {
			x = getRandomNumbers(0,getBoardDimensions());
			y = getRandomNumbers(0,getBoardDimensions());
		}

		return new Coordinate(x,y);
	}
	
	public void userPrompt(double distance) {
		System.out.println("\nYou're approximately " + String.format("%.2f", distance) + " metres from the treasure!");
		System.out.print("Enter the direction in which you'd like to travel: ");
	}
	
	public void updatePlayerPosition(Coordinate moveBy) {
		int x = player.getX() + moveBy.getX();
		int y = player.getY() + moveBy.getY();
		
		if (x > getBoardDimensions() || x < 0 || y > getBoardDimensions() || y < 0) {
			System.out.println("\n--- You are at the edge of the map. Try again. ---");
		}
		else {
			setPlayer(new Coordinate(x,y));
		}
	}

	public double findDistance() {
		int x = player.getX() - treasure.getX();
		int y = player.getY() - treasure.getY();
		return (double)(Math.sqrt((x*x)+(y*y)));
	}
	
	public boolean updateGame(Coordinate moveBy) {
		updatePlayerPosition(moveBy);
		double distance = findDistance();
		if (distance == 0) {
			System.out.println("\n --- Congratulations! You've found the treasure. ---");
			return false;
		}
		else {
			userPrompt(distance);
			return true;
		}
	}
}
