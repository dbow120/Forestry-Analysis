public class Forest implements Serializable {
	// implement serializable tells the class to read itself and write itself from memory
	private Tree [] forestGrowth = new Tree [10];
	private String forestName;

//--------------- default constructor
public Forest () {
forestName = null;
	}

// ---------------second constructor
public Forest (String forestName) {
	this.forestName = forestName;

//--------------- To initialize varariables in Tree class so it doesn't set to null
	for (int i=0; i<forestGrowth.length; i++) {
	forestGrowth[i] = new Tree();
		}
	}

public void display() {
	if (forestName == null) {
	System.out.println("No forest");
		}
	else{ 
		System.out.println(forestName);
		for (int i=0; i<forestGrowth.length; i++) {
		System.out.print((i+1) + " : " + forestGrowth[i]);
			}
		}
	System.out.println();
	}

//-------------------increase tree height by growth rate to simulate growth rate 
public void stimulateGrowth() {
		for (int i=0; i<forestGrowth.length; i++) {
		forestGrowth[i].incrementTreeHeight();
			}
	}

public void setNewTree(int heightToReap) {

//---- linearSearch algorithm to search for Trees that are in need to be replaced
	for (int i=0; i<forestGrowth.length; i++) {
	if (forestGrowth[i].getTreeHeight()>=(heightToReap)) {

	System.out.print("Cut " + (i+1) + " : " + forestGrowth[i]);

//----------------  initialize tree i to replace tree found in loop
	forestGrowth[i] = new Tree ();

	System.out.print("New " + (i+1) + " : " + forestGrowth[i]);
			} 
		}
	System.out.println();
	}

public String getName () {
return forestName;
	}

public Tree [] getForest () {c
return forestGrowth;
	}

   public static void saveForest(String fileName,
Forest forest) throws IOException {

        ObjectOutputStream toStream;

        toStream = new ObjectOutputStream(new FileOutputStream(fileName));
        toStream.writeObject(forest);
        toStream.close();
    }

    public static Forest loadForest(String fileName) 
throws IOException {

        ObjectInputStream fromStream = null;
        Forest local;

        try {
            fromStream = new ObjectInputStream(new FileInputStream(fileName));
            local = (Forest)fromStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return(null);
        } finally {
            if (fromStream != null) {
                fromStream.close();
            }
        }
        return(local);
    }
}