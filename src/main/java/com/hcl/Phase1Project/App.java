package com.hcl.Phase1Project;


import java.util.*;

public class App {

	final static String FOLDER = "/Users/EdwardDSalazar/Desktop/first";

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Menu menuObj = new Menu();
		menuObj.showWelcomeScreen();
		menuObj.showMainMenu();

	}
	
}
