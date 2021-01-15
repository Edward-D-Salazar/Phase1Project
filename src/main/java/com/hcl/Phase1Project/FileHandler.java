package com.hcl.Phase1Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FileHandler {
	
	final static String FOLDER = "/Users/EdwardDSalazar/Desktop/first";
	
	static Scanner scanner = new Scanner(System.in);

	public static void showFilesInAscendingOrder() {
		System.out.println("------------------");
		System.out.println("Showing files in ascending order");
		File[] files = new File(FOLDER).listFiles();
		Set<String> sorted = new TreeSet<>();
		for (File file : files) {
			if (!file.isFile()) {
				continue;
			}
			sorted.add(file.getName());
		}
		sorted.forEach(System.out::println);
		System.out.println("------------------");
	}

	public static void addAFile() throws InvalidPathException {

		System.out.println("Please provide a file path:");
		String filePath = scanner.nextLine();
		Path path = Paths.get(filePath);

		if (!Files.exists(path)) {
			System.out.println("File does not exist");
			return;
		}

		String newFilePath = FOLDER + "/" + path.getFileName();
		int inc = 0;
		while (Files.exists(Paths.get(newFilePath))) {
			inc++;
			newFilePath = FOLDER + "/" + inc + "_" + path.getFileName();
		}
		try {
			Files.copy(path, Paths.get(newFilePath));
		} catch (IOException e) {
			System.out.println("Unable to copy file to " + newFilePath);
		}

	}

	public static void deleteAFile() {

		System.out.println("Please provide the name of the file you want to delete.");
		String nameToDelete = scanner.nextLine();

		String fileToDelete = FOLDER + "/" + nameToDelete;
		Path path = Paths.get(fileToDelete);

		try {
			Files.delete(path);
		} catch (IOException e) {
			System.out.println("FILE WAS NOT ");
		} finally {
			System.out.println("DELETED PROPERLY!");
		}

	}

	public static void searchAFile() {

		System.out.println("Please enter the file name you are searching for.");
		String value = scanner.nextLine();

		File[] files = new File(FOLDER).listFiles();
		ArrayList<String> fileList = new ArrayList<>();
		for (File file : files) {
			if (!file.isFile()) {
				continue;
			}
			fileList.add(file.getName());
		}

		boolean foundResult = false;
		for (String fileName : fileList) {
			if (fileName.equals(value)) {
				foundResult = true;
			}
		}
		if (foundResult) {
			System.out.println("File " + value + " was found.");
		} else {
			System.out.println("Did not find file " + value);
		}

	}

}
