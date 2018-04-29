
public class Diamond {
	private int caratSize;
	private double caratValue;

public Diamond () {
	caratSize = 0;
	caratValue = 0;
	}

public Diamond (int caratSize, double caratValue) {
	this.caratSize = caratSize;
	this.caratValue = caratValue;
	}

public String toString () {
	return caratSize + " carats, worth $" +caratValue; 
	}

public int getCaratSize () {
	return caratSize;
	}

public double getCaratValue () {
	return caratValue;
	}
}