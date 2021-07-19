/**
 * 
 */

/**
 * @author 15715
 *
 */
public class Names {

	private String name;
	private int count;
	private int year;
	
	public Names(String n, int c, int y) {
		name = n;
		count = c;
		year = y;
	}

	//setter and getter methods
	public void setName(String n) {
		name = n;
	}

	public void setCount(int c) {
		count = c;
	}

	public void setYear(int y) {
		year = y;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public int getYear() {
		return year;
	}

}