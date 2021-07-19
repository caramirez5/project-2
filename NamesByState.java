/**
 * 
 */

/**
 * @author 15715
 *
 */
import java.util.Properties;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class NamesByState {
	
	//instance variables
	protected ArrayList<String> stateNames;
	protected ArrayList<Names> female;
	protected ArrayList<Names> male;
	protected ArrayList<Integer> ages = new ArrayList<Integer>();
	public final int CURRENTYEAR = 2021;

	//NamesByState object
	public NamesByState() {
	}

	public ArrayList<String> statesInFile(String file) throws IOException, IndexOutOfBoundsException, NullPointerException {
		stateNames = new ArrayList<String>();
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);

		try {
			prop.load(input);
		} catch (IOException i) {
			throw i;
		}

		File dir = new File(prop.getProperty("Directory"));
		File[] stateFiles = dir.listFiles();

		if (stateFiles == null) 
			System.out.println("State files is a null list");

		try {
			for (int f = 0; f < stateFiles.length; f++) {
				stateNames.add(stateFiles[f].getName().substring(0, 2));

			}
		} catch (IndexOutOfBoundsException in) {
			System.out.println("Index out of bounds.");
		} catch (NullPointerException n) {
			System.out.println("Null directory.");
		}

		return stateNames;
	}


	/*
		storeData() takes in 3 parameters: String file (name), String stateCode, String gen
		Function uses Properties class to load and access directory containing state files
	*/
	public void storeData(String file, String stateCode, char gen) throws IOException, FileNotFoundException {

		female = new ArrayList<Names>();
		male = new ArrayList<Names>();
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
			
		// An IOException is thrown if Properties is unsuccessful loading input content	
		try {
			prop.load(input);
		} catch (IOException i) {
			throw i;
		} 

		// File package is used to convert state files into file objects
		// File is chosen based on stateCode input
		File dir = new File(prop.getProperty("Directory"));
		File[] stateFiles = dir.listFiles();
		File stateFile = null;

		for (File f : stateFiles) {
			if (f.getName().substring(0,2).equals(stateCode)) {
				stateFile = f;
			}
		}

		BufferedReader br = new BufferedReader(new FileReader(stateFile));
		
		// read through file, separate males and females into lists - if [_], add new Name object with name year and count
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] lines = line.split(",");
			for (int l = 0; l < lines.length; l+=5) {
				if (lines[1].equals("F")) {
					Names na = new Names(lines[3], Integer.parseInt(lines[4]), Integer.parseInt(lines[2]));
					female.add(na);
				}
				else if (lines[1].equals("M")) {
					Names na = new Names(lines[3], Integer.parseInt(lines[4]), Integer.parseInt(lines[2]));
					male.add(na);
				}
			}
		}

	}

	/*
		whatsMyAge() takes in 2 parameters: String n (name) & String g (gender)
		Based on input g, the function will iterate through the male list of female list
		It will search for a Names object with data String name equal to String n input
			if it exists, it is added to a nameps arraylist
		the function searches through names arraylist and determines the names object with the highest occurence 
		using getCount (defined in Names class)
		if there is more than one occurence of the same count, both are kept.
		iterates through previous list and returns ages based on each year
	*/
	public ArrayList<Integer> whatsMyAge(String n, char g) {
		ArrayList<Names> names = new ArrayList<Names>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ages = new ArrayList<Integer>();
		int max = 0;
		int targetYear = 0;

		switch (g) {
			case 'F':
				for (int a = 0; a < female.size(); a++) {
					//iterate though, add all with target name to list. \
					try {						//System.out.println("TEST " + female.get(a).getName());
						if (female.get(a).getName().equals(n)) {
							names.add(female.get(a));
						}
					} catch (Exception e) {
						System.out.println("List index out of bounds.");
					}
				}
				break;

			case 'M':
				for (int b = 0; b < male.size(); b++) {
					//iterate though, add all with target name to list. \
					try {						//System.out.println("TEST " + male.get(b).getName());
						if (male.get(b).getName().equals(n)) {
							names.add(male.get(b));
						}
					} catch (Exception e) {
						System.out.println("List index out of bounds.");
					}
				}
				break;
		}
		
		
		/*based on string g, choose female or male list.
		iterate through list until the list of String n names is found.*/

		/*iterate through name list

		search for highest count, add to list
		if next int is greater, replace everything in list.
		if next in is equal, add to list years.*/
		
		try {
			for (int x = 0; x < names.size(); x++) {
				if (names.get(x).getCount() > max) {
					max = names.get(x).getCount();
					//years.clear();
					years = new ArrayList<Integer>();
					years.add(names.get(x).getYear());
					//System.out.println("TEST greater than max");
				}
				else if (names.get(x).getCount() == max) {
					years.add(names.get(x).getYear());
					//System.out.println("TEST equal to max");
				}
				
			}
		} catch (Exception e) {
			System.out.println("Index out of bounds.");
		}

		int difference;

		for (int i = 0; i < years.size; i++) {
			try {
				difference = CURRENTYEAR - years.get(i);
				ages.add(difference);
			} catch (Exception e) {
				System.out.println("Index out of bounds.");
			}

		}

		return ages;
	}


	public ArrayList<Integer> getAges() {
		return ages;
	}

	public ArrayList<String> getStateNames() {
		return stateNames;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {

		Scanner scan = new Scanner(System.in);
		String na = "";
		char gender;
		String state = "";
		ArrayList<Integer> whatsMyAge;
		int leastAge;
		int greatestAge;

		NamesByState nbs = new NamesByState();

		// property/config file to be used
		System.out.println("Enter property/configuration file");
		String file = scan.nextLine();

		//repeats prompt until user inputs EXIT for name
		do {
			whatsMyAge = new ArrayList<Integer>();
			leastAge = 2021;
			greatestAge = 0;
			state = "";
			na = "";

			System.out.println("Name of the person (or EXIT to quit): ");
			na = scan.next();
			if (na.equals("EXIT")) {
				break;
			}

			System.out.println("Gender (M/F): ");
			gender = scan.next().charAt(0);
			while (gender != 'M' && gender != 'F') {
				System.out.println("Invalid input. Please enter 'M' or 'F'");
				gender = scan.next().charAt(0);
			}
			
			try {
				nbs.statesInFile(file);
				
				boolean contains = false;
				
				do {
					
					System.out.println("State of Birth (two-letter): ");
					state = scan.next();
				 	
					while(state.length() > 2) {
						System.out.println("Invalid input. Please enter 2 character state code.");
						state = scan.next();
					}
					
					for (int c = 0; c < nbs.getStateNames().size; c++) {
						try {
							if (nbs.getStateNames().get(c).substring(0,2).equals(state)) {
								contains = true;
							}
						} catch (Exception e) {
							System.out.println("Index out of bounds.");
						}
					 }
					 
					 if (contains == false) {
						 System.out.print("Invalid input. ");
					 }
				} while (contains == false);
				

			} catch (FileNotFoundException e) {
				System.out.println("File not found. Program quit.");
				break;
			} 

			//throws file not found exception if file has any interruptions
			try {
				nbs.storeData(file, state, gender);
			} catch (FileNotFoundException e) {
				throw e;
			} catch (Exception ex) {
				throw ex;
			}

			nbs.whatsMyAge(na, gender);
			whatsMyAge = nbs.getAges();
			try {
				if (whatsMyAge.size == 0) {
					System.out.println("No age hypothesis.");
				}

				else if (whatsMyAge.size == 1) {
					System.out.println(na + ", born in " + state + ", is most likely around " + whatsMyAge.get(0) + " years old.");
				}

				else {

					for (int age = 0; age < whatsMyAge.size(); age++) {
						if (whatsMyAge.get(age) < leastAge) {
							leastAge = whatsMyAge.get(age);
						}

						if (whatsMyAge.get(age) > greatestAge) {
							greatestAge = whatsMyAge.get(age);
						}
					}

					System.out.println(na + ", born in " + state + ", is most likely around " + leastAge + " to " + greatestAge + " years old.");
				}
			} catch (Exception e) {
				System.out.println("Index out of bounds.");
			}
			System.out.println();
			
		} while (!na.equals("EXIT"));
	}
}

