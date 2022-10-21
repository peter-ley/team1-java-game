package com.lbg.coh2;

/**
 * Hello world!
 *
 */
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
    		runGame = game.updateGame();
    		moveBy = userInput.getDirection();
    		
    	}

    }
}
