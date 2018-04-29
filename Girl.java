public class Girl {
	private String girl;
	private Diamond myDiamond = new Diamond();
	private Diamond newDiamond;

public Girl () {
	girl = "";
	}

public Girl (String name) {
	girl = name;
	}

public String toString () {
	if (myDiamond == null) {
	return girl + " has no friends";	
		}
	else {
	return girl + " has a diamond " + myDiamond;
		}
	}

public Diamond getDiamondValue (int newSize, int newValue) {

	newDiamond = new Diamond (newSize, newValue);

	if (myDiamond.getCaratSize()< newSize && myDiamond.getCaratValue() < newValue ) {
	myDiamond = newDiamond;
	System.out.println("Woohoo, the girl took the diamond");
		}
	else if (newSize == 0 && newValue == 0) {
	myDiamond = myDiamond;
	System.out.println(girl + " has a diamond " + myDiamond);
	}
	else {
	myDiamond = myDiamond;
	System.out.println("Aaargh, the diamond was rejected");
		}
	return myDiamond;
	}
}