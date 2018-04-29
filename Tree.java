import java.io.*;

public class Tree implements Serializable {
	private double treeHeight;
	private int growthRate;

public Tree () {
	treeHeight = Math.random()*4+1;
	growthRate = (int)(Math.random()*51+50);
	}

public String toString () {
// this acts as a printf method, since format() and printf cannot be used in toString
 return String.format("%.2f",treeHeight) + " (%" + growthRate +")\n";
	}

public void incrementTreeHeight() {
// the treeHeight is increasing by the growth rate percentage
	treeHeight += treeHeight*(growthRate/100.0);
}
public double getTreeHeight() {
return treeHeight;
	}
}