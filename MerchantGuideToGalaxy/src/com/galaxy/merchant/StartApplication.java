package com.galaxy.merchant;

import java.util.ArrayList;

/**
 * @author Karan
 * This class is the starting point of the application
 */
public class StartApplication {

	public static void main(String[] args) {
		
		System.out.println("Welcome to GalaxyMerchant. Please provide input below and a blank new line to finish input");
		
		// Initialize a new InputProcessor
		InputProcessor inputProcessor = new InputProcessor();
		
		// Read the input from console, validate and process
		ArrayList<String> output=inputProcessor.read();
		
		for(int i=0;i<output.size();i++)
		{
			System.out.println(output.get(i));
		}
		
		
	}

}
