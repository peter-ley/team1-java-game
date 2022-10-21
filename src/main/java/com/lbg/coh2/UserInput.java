package com.lbg.coh2;

import java.util.Scanner;

public class UserInput {
	
	private Scanner sc;
	
	// constructor
	public UserInput()
	{
		this.sc = new Scanner(System.in);
	}
	
	// destructor - close scanner
	public void close()
	{
		this.sc.close();
	}
	
	// method for reading in a string
	public String readString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	// method for getting the direction
	public Coordinate getDirection()
	{
		String direction = readString();
		Coordinate cord = new Coordinate(0, 0);
		
		if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("Up") || direction.equalsIgnoreCase("u") || direction.equalsIgnoreCase("n"))
		{
			cord.setY(1);
		}
		else if (direction.equalsIgnoreCase("South") || direction.equalsIgnoreCase("Down") || direction.equalsIgnoreCase("s") || direction.equalsIgnoreCase("d"))
		{
			cord.setY(-1);
		}
		else if (direction.equalsIgnoreCase("West") || direction.equalsIgnoreCase("Left") || direction.equalsIgnoreCase("w") || direction.equalsIgnoreCase("l"))
		{
			cord.setX(-1);
		}
		else if (direction.equalsIgnoreCase("East") || direction.equalsIgnoreCase("Right") || direction.equalsIgnoreCase("e") || direction.equalsIgnoreCase("r"))
		{
			cord.setX(1);
		}
		else System.out.println("\n--- Please enter a valid direction. ---");
		
		return cord;
	}
	
}
