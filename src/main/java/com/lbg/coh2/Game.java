package com.lbg.coh2;

public class Game 
{
	private int boardDimensions;
	private Coordinate player;
	private Coordinate treasure;
	
	public Game ()
	{
		this.boardDimensions = 20;
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
	
	private Coordinate generatePositon (int mode) {
		int x, y, edge, scalar;

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
		
		else if (mode == 1) {
			x = getRandomNumbers(0,getBoardDimensions());
			y = getRandomNumbers(0,getBoardDimensions());
		}

		return new Coordinate(x,y);
	}
	
}
