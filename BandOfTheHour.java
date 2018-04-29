import java.util.Scanner;
//=================================================================================
public class BandOfTheHour {
//---------------------------------------------------------------------------------
private static Scanner keyboard = new Scanner (System.in);
private static final int MAX_NUMBER_OF_ROWS = 10;
private static final int MAX_NUMBER_OF_POSITIONS = 8;
private static final int MAX_WEIGHT_PER_POSITION = 100;
private static final double MIN_MUSICIAN_WEIGHT = 45.0;
private static final double MAX_MUSICIAN_WEIGHT = 200.0;
//--------------------------------------------------------------------------------
public static void main (String [] args) {

	int numberOfRows, numberOfPositions;
	double [][] rowMusicians;
	double[] rowWeight;
	char choice;

System.out.println("Welcome to the Band of the Hour");
System.out.println("-------------------------------");

//----Get row information to organize seats
System.out.print("Please enter number of rows               : ");
	numberOfRows = keyboard.nextInt();
		while (numberOfRows< 0 || numberOfRows >MAX_NUMBER_OF_ROWS) {
System.out.print("ERROR: Out of range, try again            : ");
	numberOfRows = keyboard.nextInt();
}

// Gathering array data
rowMusicians = new double [numberOfRows][];
rowWeight = new double[numberOfRows];


		for(int i=0; i<numberOfRows; i++) {
System.out.print("Please enter number of positions in row " + (char)(i+'A') + " : ");
	numberOfPositions = keyboard.nextInt();
		while (numberOfPositions<0 || numberOfPositions>MAX_NUMBER_OF_POSITIONS) {
System.out.print("ERROR: Out of range, try again            : ");
	numberOfPositions = keyboard.nextInt();
		}
rowMusicians[i] = new double [numberOfPositions];
	}
System.out.println();

do {	
	System.out.print("(A)dd, (R)emove, (P)rint,          e(X)it : ");
	choice = Character.toUpperCase(keyboard.next().charAt(0));

switch (choice) {
		case 'A' :
 	 	addMusician(numberOfRows,rowMusicians, rowWeight);
		break;
		case 'R' :
		removeMusician(numberOfRows, rowMusicians, rowWeight);
		break;

		case 'P' :
		printRowMusicians(numberOfRows,rowMusicians, rowWeight);
		break;

		case 'X' :
		break;

		default :
		System.out.print("ERROR: Invalid option, try again          : ");
		choice = Character.toUpperCase(keyboard.next().charAt(0));
		break;
			}
		} while (choice !='X');
	}
//--------------------------------------------------------------------------------
 	public static void addMusician(int numberOfRows,double[][]rowMusicians, double[] rowWeight) {
 		
 		char rowLetter;
 		int positionNum;
 		double musicianWeight;
 		int rowPosition;

// Gathering information to place musician in correct postion
System.out.print("Please enter row letter                   : ");
	rowLetter = Character.toUpperCase(keyboard.next().charAt(0));
		while (rowLetter>=((int)('A')+numberOfRows)) {
System.out.print("ERROR: Out of range, try again            : ");
	rowLetter = Character.toUpperCase(keyboard.next().charAt(0));
			}

// Converting row letter into integer for array 
	rowPosition = rowLetter - 'A';

System.out.print("Please enter position number (1 to 4)     : ");
	positionNum = keyboard.nextInt();
		while (positionNum < 0 || positionNum >rowMusicians[rowPosition].length) {
System.out.print("ERROR: Out of range, try again            : ");
	positionNum = keyboard.nextInt();
	}

// Checking row weight to guarantee absent seat
	if (rowMusicians[rowPosition][positionNum-1]<MIN_MUSICIAN_WEIGHT)  {
System.out.print("Please enter weight (45.0 to 200.0)       : ");
		musicianWeight = keyboard.nextDouble();
	while (musicianWeight < MIN_MUSICIAN_WEIGHT || musicianWeight >MAX_MUSICIAN_WEIGHT) {
System.out.print("ERROR: Out of range, try again            : ");
		musicianWeight = keyboard.nextDouble();
			}

// Checking absent position to prevent overloading entire row
	 if ((rowWeight[rowPosition]+musicianWeight)/rowMusicians[rowPosition].length<MAX_WEIGHT_PER_POSITION) {

// Processing information
			rowMusicians[rowPosition][positionNum-1] += musicianWeight;
			rowWeight[rowPosition] +=musicianWeight;
System.out.println("****** Musician added.\n");	
		}
	else {
System.out.println("ERROR: That would exceed the average weight limit.\n");
			}
		}
	else  {
System.out.println("ERROR: There is already a musician there.\n");
	}
}

//----------------------------------------------------------------------------------
	public static void removeMusician(int numberOfRows,double [][] rowMusicians, double[] rowWeight) {

		char rowLetter;
 		int positionNum;
 		int rowPosition;

// Gather information to find musician to remove
System.out.print("Please enter row letter                   : ");
	rowLetter = Character.toUpperCase(keyboard.next().charAt(0));
		while (rowLetter>=((int)('A')+numberOfRows)) {
System.out.print("ERROR: Out of range, try again            : ");
	rowLetter = Character.toUpperCase(keyboard.next().charAt(0));
		}

// Converting row letter into integer for array 
	rowPosition = rowLetter - 'A';

System.out.print("Please enter position number (1 to 4)     : ");
	positionNum = keyboard.nextInt();
		while (positionNum< 0 || positionNum >rowMusicians[rowPosition].length) {
System.out.print("ERROR: Out of range, try again            : ");
	positionNum = keyboard.nextInt();
		}

// minus position Number by 1 because array starts from zero
	if (rowMusicians[rowPosition][positionNum-1] < MIN_MUSICIAN_WEIGHT) {
System.out.println("ERROR: That position is vacant.\n");
	}
	
// Erasing the designated user weight by resetting it to zero
	else {
 	rowWeight[rowPosition] -= rowMusicians[rowPosition][positionNum-1];
 	rowMusicians[rowPosition][positionNum-1] = 0.0;
System.out.println("****** Musician removed.\n");
		}
}
//--------------------------------------------------------------------------------
	public static void printRowMusicians(int numberOfRows, double [][]rowMusicians, double[] rowWeight) {
		char rowLetter = 'A';

		for (int j=0; j<numberOfRows;j++) {
// Labelling the rows Alphabetically
		System.out.print(rowLetter++ + " : ");
// Loop body to access information stored in rowMusician[j][k];
		for (int k=0;k<rowMusicians[j].length;k++) { 
		System.out.print(rowMusicians[j][k] + " ");
			}

	System.out.print("\t[" + rowWeight[j] + ",\t " + rowWeight[j]/rowMusicians[j].length + "]" );
	System.out.println();
		}
	}
//---------------------------------------------------------------------------------
}
//=================================================================================