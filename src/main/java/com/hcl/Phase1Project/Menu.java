package com.hcl.Phase1Project;

import java.util.Scanner;

public class Menu {
	
	static Scanner scanner = new Scanner(System.in);

	public void showWelcomeScreen() {
		System.out.println("---------------");
		System.out.println("Hello and Welcome to LockedMe App");
		System.out.println("Developer: Edward Salazar");
		System.out.println("---------------");
	}

	public void showMainMenu() {
		System.out.println("-- MAIN MENU --");
		System.out.println("1.) Show files in ascending order");
		System.out.println("2.) Perform file operations");
		System.out.println("3.) Close the application");
		System.out.println("---------------");
		collectMainMenuOption();
	}

	public void collectMainMenuOption() {

		System.out.println("Please choose 1, 2 or 3:");
		String option = scanner.nextLine();

		switch (option) {
		case "1":
			FileHandler.showFilesInAscendingOrder();
			break;
		case "2":
			showFileOperations();
		case "3":
			System.out.println("Thanks for using the Lockedme App. Closing application...");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input provided, please choose 1, 2 or 3.");
		}
		showMainMenu();
	}

	public void showFileOperations() {

		System.out.println("--------------");
		System.out.println("1.) Add a file");
		System.out.println("2.) Delete a file");
		System.out.println("3.) Search for a file");
		System.out.println("4.) Back to main menu");
		System.out.println("--------------");
		collectFileOperation();
	}
	
	public void collectFileOperation() {
		System.out.println("Please choose 1, 2, 3 or 4:");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			FileHandler.addAFile();
			break;
		case "2":
			FileHandler.deleteAFile();
			break;
		case "3":
			FileHandler.searchAFile();
			break;
		case "4":
			showMainMenu();
			break;
		}
		showFileOperations();
	}

}
