package com.lbg.coh2;

import java.util.Scanner;

public class UserInput {
	
	private Scanner sc = new Scanner(System.in);
	
	// constructor
	public UserInput()
	{
	}
	
	// method for reading in a string
	public String readString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	// method for reading in an integer
	public int readInt()
	{
		int integer = sc.nextInt();
		return integer;
	}
	
	// method for getting the direction
	public Coordinate getDirection()
	{
		String direction = readString();
		Coordinate cord = new Coordinate(0, 0);
		
		if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("Up"))
		{
			cord.setY(1);
		}
		else if (direction.equalsIgnoreCase("South") || direction.equalsIgnoreCase("Down"))
		{
			cord.setY(-1);
		}
		else if (direction.equalsIgnoreCase("West") || direction.equalsIgnoreCase("Left"))
		{
			cord.setX(-1);
		}
		else if (direction.equalsIgnoreCase("East") || direction.equalsIgnoreCase("Right"))
		{
			cord.setX(1);
		}
		else System.out.println("Please enter a valid direction.");
		
		return cord;
	}
	
}
