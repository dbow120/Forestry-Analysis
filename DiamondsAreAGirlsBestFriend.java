import java.util.Scanner;

public class DiamondsAreAGirlsBestFriend {

private static Scanner keyboard = new Scanner (System.in);

public static void main (String [] args) {

//----------- Variables to hold
	String name;
	Girl myGirl;
	Diamond myDiamond;
	int caratSize, dimaondValue;

//----Create object
	System.out.print("Enter the name of the girl : ");
	name = keyboard.next();
	myGirl = new Girl(name);

	do {
//----------- Print Girl information
	System.out.println(myGirl);


//------------- get information to assign worth to myDiamond
	System.out.print("Enter carats and value     : ");
	caratSize = keyboard.nextInt();
	dimaondValue = keyboard.nextInt();

//----------- Assign diamond worth from girl class to myDiamond by using accessor method
	myDiamond = myGirl.getDiamondValue(caratSize,dimaondValue);

		} while (caratSize != 0 && dimaondValue != 0);

	}
}