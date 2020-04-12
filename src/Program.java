
/**
 * Author: Viet Long Ta
 * Class : CPSC 319
 * Assignment 3
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	/**
	 * UserScanner is used to get user input
	 */
	private Scanner userScanner;
	/**
	 * fileScanner is used to read the content from the file
	 */
	private Scanner fileScanner;
	/**
	 * The name of the file user wishes to read
	 */
	private String nameOfFile;
	/**
	 * treeList is a tree data structure that is created using words from the txt
	 * file.
	 */
	private TreeList treeList;

	/**
	 * Default Constructor that initializing userScanner and treeList object.
	 */
	public Program() {
		userScanner = new Scanner(System.in);
		treeList = new TreeList();
	}

	/**
	 * This function ask for the input of the file user wishes to read.
	 * 
	 * @return The name of the file user wishes to read.
	 */
	private String askInputFileName() {
		System.out.println("Enter the input file name:");
		nameOfFile = userScanner.nextLine();
		return nameOfFile;
	}

	/**
	 * Receiving the name of the file user wishes to read. If the name of the file
	 * is invalid, user has to reenter name of the file again until it's valid.
	 */
	public void searchFile() {
		try {
			String nameFile = this.askInputFileName();
			File file = new File(nameFile);
			this.nameOfFile = nameOfFile.substring(0, nameOfFile.lastIndexOf('.')); // remove file name extension.
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please reenter the name of the file.");
			this.searchFile();
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Your input is not a type of file. Please reenter your input.");
			this.searchFile();
		}
	}

	/**
	 * Converting data content on the file to a tree data structure.
	 */
	public void readFileToTree() {
		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine().trim();

			if (!line.trim().isEmpty()) { // Detect empty line, if it is empty, it is not going to be added to the list.
				String[] words = line.replaceAll("[^0-9a-zA-Z ]", " ").toLowerCase().split("\\s+"); // This line was
																									// taken from
																									// Professor Hudson.
				for (int i = 0; i < words.length; i++) { // Iterate through words in a line
					if (!words[i].isBlank()) { // Detect any invisible character
						treeList.addNode(words[i]);
					}
				}
			}
		}
	}

	/**
	 * Print total number of word in the text file.
	 */
	private void printNumberOfWord() {
		System.out.println(
				"Total number of words in " + nameOfFile + " = " + treeList.getNumberOfWord(treeList.getRoot()) + "\n");
	}

	/**
	 * Print total number of UNIQUE word in the text file.
	 */
	private void printNumberOfUniqueWord() {
		System.out.println("Number of unique words in " + nameOfFile + " = "
				+ treeList.getNumberOfUniqueWord(treeList.getRoot()) + "\n");
	}

	/**
	 * Print the word that has the largest frequency in the text file.
	 */
	private void printLargestFrequencyWord() {
		int largestFrequency = treeList.getLargestFrequency(treeList.getRoot());
		System.out.println("The word(s) which occur(s) most often and the number of time that it/they occur(s) =");
		treeList.printFrequencyWord(treeList.getRoot(), largestFrequency);
		System.out.println();
	}

	/**
	 * Print the tree data structure content in preorder traversal
	 */
	private void printPreOrderTraversal() {
		treeList.printPreOrderTraversal(treeList.getRoot());
	}

	/**
	 * Print the tree data structure content in inorder traversal
	 */
	private void printInOrderTraversal() {
		treeList.printInOrderTraversal(treeList.getRoot());
	}

	/**
	 * Print the tree data structure content in postorder traversal
	 */
	private void printPostOrderTraversal() {
		treeList.printPostOrderTraversal(treeList.getRoot());
	}

	/**
	 * Print the maximum height of the tree.
	 */
	private void printMaxHeightTree() {
		System.out.println("The maximum height of the tree = " + treeList.maxDepth(treeList.getRoot()));
	}

	/**
	 * Search for word in the tree.
	 * 
	 * @param word is the word that needs to be searched in the tree.
	 */
	private void searchWord(String word) {
		int exist = treeList.searchWord(word, treeList.getRoot());
		if (exist > 0)
			System.out.println("Found!It appears " + exist + " times in the input text file");
		else
			System.out.println("Word not found!");
	}

	/**
	 * Ask for user's request depending on the option.
	 */
	public void menu() {
		try {
			int option = userScanner.nextInt();
			switch (option) {
			case 1:
				this.printNumberOfWord();
				System.out.println("Enter your next option:");
				this.menu();
				break;
			case 2:
				this.printNumberOfUniqueWord();
				System.out.println("Enter your next option:");
				this.menu();
				break;
			case 3:
				this.printLargestFrequencyWord();
				System.out.println("Enter your next option:");
				this.menu();
				break;
			case 4:
				this.printMaxHeightTree();
				System.out.println("Enter your next option:");
				this.menu();
				break;
			case 5:
				System.out.println("Enter the word you are looking for in " + this.nameOfFile);
				userScanner.nextLine();
				String word = userScanner.nextLine();
				this.searchWord(word);
				System.out.println("Enter your next option:");
				this.menu();
				break;
			case 6:
				System.out.print("IN-ORDER output: ");
				this.printInOrderTraversal();
				System.out.println("\nEnter your next option:");
				this.menu();
				break;
			case 7:
				System.out.print("PRE-ORDER output: ");
				this.printPreOrderTraversal();
				System.out.println("\nEnter your next option:");
				this.menu();
				break;
			case 8:
				System.out.print("POST-ORDER output: ");
				this.printPostOrderTraversal();
				System.out.println("\nEnter your next option:");
				this.menu();
				break;
			case 9:
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("Illegal Input. Input should be a number from 1 to 9.");
				userScanner.nextLine();
				this.menu();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Illegal input. Input must be a number. Please reenter your input");
			userScanner.nextLine();
			this.menu();
		}
	}

	/**
	 * Display the option for the user.
	 */
	public void displayOptions() {
		System.out.println("Here are your options:");
		System.out.println("1. Print number of word" + "\n2. Print number of unique word"
				+ "\n3. Print the word with the largest frequency" + "\n4. Print the maximum height of the tree"
				+ "\n5. Search a word" + "\n6. Print in order traversal" + "\n7. Print pre order traversal"
				+ "\n8. Print post order traversal" + "\n9. Exit the program");
	}

	public static void main(String[] args) {
		Program start = new Program();
		start.searchFile();
		start.readFileToTree();

		start.printNumberOfWord();
		start.printNumberOfUniqueWord();
		start.printLargestFrequencyWord();
		start.printMaxHeightTree();

		start.displayOptions();
		start.menu();
	}
}
