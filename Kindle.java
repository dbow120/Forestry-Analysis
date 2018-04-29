public class Kindle {
	private int currentPage;
	private int totalPages;

public Kindle () {
	currentPage = 1;
	totalPages = 0;
	}

public Kindle (int totalPages) {
	this.totalPages = totalPages;
	currentPage = 1;
	}

public String toString () {
	return "Page " + currentPage + " of " + totalPages;
	}

public void turnPages (int pagesToTurn) {
	currentPage +=pagesToTurn;
	if ((currentPage)>totalPages) {
	System.out.println("You were on \t\tPage : " + (currentPage-pagesToTurn) + " of " + totalPages);
	System.out.println("Turning " + pagesToTurn + " pages would take you past the last page");
	currentPage = totalPages;
	System.out.println("You are now on \t\tPage : " + currentPage + " of " + totalPages);
		}

	}

public void turnPages () {
	currentPage++;
	if ((currentPage)>totalPages) {
	System.out.println("You were on \t\tPage : " + (currentPage - 1) + " of " + totalPages);
	System.out.println("Turning one page would take you past the last page.");
	currentPage = totalPages;
	System.out.println("You are now on \t\tPage : " + currentPage + " of " + totalPages);
		}
	}
}