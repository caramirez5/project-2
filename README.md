Chloe Ramirez NamesByState

**mostly comments as I encountered issues + omitted code

imported com.opencvs.CVSReader








Author Notes

having issues with cvs & properties, not much experience with reading'manipulating external files

added clear() and contains() functions to arraylist class

implementation searches through a state file out of all files based on state input

store data function places names objects into arraylist by gender

created Names class

import CVS reader ** C:\Users\15715\Documents\cs245\projects\project2\NamesByState.java:9: error: package com.opencsv does not exist

import com.opencsv.CSVReader;

	(You’ll need toinclude the source — ZIP or JAR file? — in your buildpath.) Anexample at TutorialsPointshows how touse CSVReader from OpenCSV.

ABANDONED CSV READER -- COULD NOT ADD THE SOURCE CODE JAR FILE TO BUILDPATH

after different tests, conclusion: dir.listFiles() returns a null list (stateInFiles method)
		dir is not null, but stateFiles is
		System.out.println(dir.listFiles());
		System.out.println(stateFiles);
		Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "<local5>" is null
        at NamesByState.statesInFile(NamesByState.java:171)
        at NamesByState.main(NamesByState.java:357)

/* after different tests, conclusion: dir.listFiles() returns a null list
		dir is not null, but stateFiles is
		System.out.println(dir.listFiles());
		System.out.println(stateFiles);
		Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "<local5>" is null
        at NamesByState.statesInFile(NamesByState.java:171)
        at NamesByState.main(NamesByState.java:357)*/

/* print test to determine if files are being read in
		 * try {
			for (int a = 0; a < stateNames.size(); a++) {
				System.out.println(stateNames.get(a));
			}
		} catch (Exception e) {
			System.out.println("Test. empty.");
		}
		System.out.println(stateNames);*/

/*
		 * test to see if names are added to m/f list - good
		System.out.println("Test. Line 186.");
		for (int c = 0; c < male.size(); c++) {
			try {
				System.out.println(male.get(c).getName());
			} catch (Exception e) {
				System.out.println("List index out of bounds.");
			}
		}*/
		
		/*TEST to determine if content is actually being added to names - good
		 * for (int c = 0; c < names.size(); c++) {
			try {
				System.out.println(names.get(c).getName());
			} catch (Exception e) {
				System.out.println("List index out of bounds.");
			}
		}*/
		/*TEST to determine if content is actually being added to names - good
		*/ /*for (int c = 0; c < names.size(); c++) {
			try {
				System.out.println(names.get(c).getCount());
			} catch (Exception e) {
				System.out.println("List index out of bounds.");
			}
		}

/*System.out.println("Test Line 215. If getCount for a names getCount works.");
		try {
			System.out.println(names.get(1).getCount());
		} catch (Exception e1) {
			System.out.println("getCount issues exist");
		} get count works*/
		
		/*for (Names nam : names) {
			if (nam.getCount() > max) {
				years.clear();
				years.add(nam.getYear());
			}
			else if (nam.getCount() == max) {
				years.add(nam.getYear());
			}
		}*/

/*System.out.println("TEST line 249 Determine if years were added to years");
		try {
			for (int y = 0; y < years.size(); y++) {
				System.out.println(years.get(y));
			}
		} catch (Exception exc) {
			System.out.println("Index out of bounds. TEST check line 194");
		}*/
		//}

/*System.out.println("State of Birth (two-letter): ");
			state = scan.next();
			
			while(state.length() > 2) {
				System.out.println("Invalid input. Please enter 2 character state code.");
				state = scan.next();
			}*/

/*System.out.println("State of Birth (two-letter): ");
				state = scan.next();
				
				while (contains == false) {
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
				}*/
				/*try {
					while (!nbs.getStateNames().contains(state)) {
						System.out.println("Invalid input. Please enter a valid state code.");
						state = scan.nextLine();
					}
				} catch (NullPointerException nul) {
					System.out.println("Invalid input. Please enter a valid state code.");
					state = scan.nextLine();
				}*/