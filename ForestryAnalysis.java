import java.io.*;
import java.util.Scanner;

public class ForestryAnalysis {
	
	private static Scanner keyboard = new Scanner (System.in);

	public static void main (String [] args) {

		char choice;
		String forestName;
		int heightToReap;
		String s2 = ".txt";

//----- Forest class needs to be initialized in the beginning so the program will run
		Forest canadianForest = new Forest();

		do {
			System.out.print("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it :");
			choice = Character.toUpperCase(keyboard.next().charAt(0));

			switch (choice) {

				case 'D' :
				canadianForest.display();
				break;	

				case 'N' :
				System.out.print("What is the forest name : ");
				forestName = keyboard.next();

//--------- This will replace the preceded forest class and the old one will be discarded
				canadianForest = new Forest(forestName);
				break;

				case 'Y' :
				canadianForest.stimulateGrowth();
				break;

				case 'R' :
				System.out.print("What height to reap at  : ");
				try {
					heightToReap = keyboard.nextInt();
					canadianForest.setNewTree(heightToReap);
				} catch (Exception e) {
					System.out.println("ERROR: Invalid height");
					keyboard.nextLine();
					continue;
				}
				break;

				case 'S' :
// writes the file for the forest and stores it to be loaded later
				try {
					Forest.saveForest(canadianForest.getName().concat(s2),canadianForest);
				} catch (IOException e) {
					System.out.println("ERROR loading " + e.getMessage());
					continue;
				}
				break;

				case 'L' :
// Reads the file stored by input class to input back into the program
				System.out.print("What is the forest name : ");
				forestName = keyboard.next();
// Exception handling needed for every filereader program to prevent invalid or interrupted file from crashing the program
				try {
					canadianForest = Forest.loadForest(forestName+".txt" ) ;
				} catch (IOException e) {
					System.out.println("ERROR loading " + e.getMessage());
					continue;
				}
				break;

				case 'X' :
				System.out.println("Goodbye");
				break;

				default :
				System.out.println("ERROR: Invalid option\n");
				break;
			} 
		} while (choice != 'X');

	} 
}