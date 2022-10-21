package com.lbg.coh2;

public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game(20);
        
    	UserInput userInput = new UserInput();	
    	boolean runGame = true;
    	
    	Coordinate moveBy = new Coordinate(0,0);
    	
    	while(runGame)
    	{
    		runGame = game.updateGame(moveBy);
    		if (runGame == false)
    			break;
    		moveBy = userInput.getDirection();
    	}
    	
    	userInput.close();
    }
}
