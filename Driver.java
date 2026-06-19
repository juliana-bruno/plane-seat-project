/*
 * Name: Juliana Bruno
 * Project: 2
 * Title: Driver.java
 * Summary: plane seat menu that uses user input and a 2d array to print out information using static methods
 * Date: 3/23/25
 */

import java.util.Scanner;
public class Driver {

     public static void main(String[] args) {

          Scanner k = new Scanner(System.in);

        /**
         * Declaring 12 seats that will be added to the 2D array
         */
        Seat oneA = new Seat("Kathryn Janeway", false, "STANDARD");
        Seat oneB= new Seat();
        Seat oneC= new Seat("Arthur Dent", false, "STANDARD");
        Seat twoA= new Seat();
        Seat twoB= new Seat("Han Solo", false, "STANDARD");
        Seat twoC= new Seat();
        Seat threeA= new Seat("James Kirk", false, "EXtRA_LEGROOM");
        Seat threeB= new Seat();
        Seat threeC= new Seat();
        Seat fourA= new Seat("Jean-Luc Picard", false,"STANDARD");
        Seat fourB= new Seat();
        Seat fourC= new Seat();

        /**
         * planeSeats is our 2D array, the plane has four rows and three seats in each row
         */
        Seat [][] planeSeats= {{oneA, oneB, oneC},
                               {twoA, twoB, twoC},
                               {threeA, threeB, threeC},
                               {fourA, fourB, fourC}};

	/*
	*Add additional code for main method here.
	*/
        System.out.println("Hello! Welcome to the plane seat selection program.");
        
        int choice = 0;
        
        do {
        	System.out.println("Main Menu: \n1 - View current seat status\n2 - Display current passenger list\n3 - Reserve a seat\n4 - Search Passenger\n5 - Exit");
        	choice = k.nextInt();
        	
        	if (choice == 1) {
        		System.out.println("View current seat status selected");
        		printCurrentSeatStatus(planeSeats);
        	} else if (choice == 2) {
        		System.out.println("View print passenger list selected");
        		printPassengerList(planeSeats);
        	} else if (choice == 3) {
        		int row;
        		String seat;
        		String name;
        		System.out.println("Reserve a seat selected");
        		int column;
        		
        		do {
        			k.nextLine();
            		System.out.println("Please enter your name: ");
            		name = k.nextLine();       		
            		
            		System.out.println("Please enter your preferred row: (1, 2, 3, or 4)");
            		row = k.nextInt();
            		
            		System.out.println("Please enter your preferred seat: (A, B, or C)");
            		seat = k.next();
            		
            		if (seat.equalsIgnoreCase("A")) {
            			column = 0;
            		} else if (seat.equalsIgnoreCase("B")) {
            			column = 1;
            		} else{
            			column = 2;
            		}
            		
        		} while (selectSeat(row, seat, name, planeSeats) == false);
        			
        	} else if (choice == 4) {
        		k.nextLine();
        		System.out.println("Search passenger selected");
        		System.out.println("Please enter the name of the passenger you are searching for: ");
        		String searchName = k.nextLine();
        		searchPassengerName(searchName, planeSeats);
        	} else if (choice == 5) {
                System.out.println("Thank you for using the plane seat selection program. Goodbye!");
        	} else {
        		System.out.println("Please enter a valid number.");
        	}
        	
        } while (choice != 5);
        
        
        
        
        
    }//end main


//Static Methods -------

    /**
     * This method iterates through all seats in the 2D array and checks whether they are available using
     * the .getAvailable method. If they are availlble, the method prints out the seat identifier (1A, 3B, etc)
     * and the letter "A". If the set is not available, the method prints out the seat identifier with the letter "X"
     *
     * NOTE that the seat identifier is based on the position of the seat in the 2D array.
     * Seat 1A would be in the array at index [0][0], seat 3B would be in the array at index [2][1]
     *
     * @param x - the 2D array of plane seats
     */
    public static void printCurrentSeatStatus(Seat [][] x){
        for (int row = 0; row < x.length; row++) {
        	for (int column = 0; column < x[row].length; column++) {
        		if (column == 0) {
        			if (x[row][column].getAvailable() == true) {
            			System.out.print((row+1) + "A: A\t");
        			} else {
            			System.out.print((row+1) + "A: X\t");
        			}
        		} else if (column == 1) {
        			if (x[row][column].getAvailable() == true) {
            			System.out.print((row+1) + "B: A\t");
        			} else {
            			System.out.print((row+1) + "B: X\t");
        			}
        		} else {
        			if (x[row][column].getAvailable() == true) {
            			System.out.print((row+1) + "C: A\t");
        			} else {
            			System.out.print((row+1) + "C: X\t");
        			}
        		}
        	}//inner for loop
        	System.out.println();
        }//outer for loop

    }//end printCurrentSeatStatus method






    /**
     * This mehtod iterates through all seats the 2D array and checks whether the seat is avaialble (getAvaialble method
     * returns true) or is unavailable (getAvailable method returns false). If the seat is unavailable, the method
     * prints out the seat identifier (1A, 3B, etc) followed by the seat's information using the toString of the
     * Seat Class.
     *
     * @param x - the 2D array of plane seats
     */
    public static void printPassengerList(Seat [][] x){
    	for (int row = 0; row < x.length; row++) {
    		for (int column = 0; column < x[row].length; column++) {
    			if (column == 0) {
    				if (x[row][column].getAvailable() == false) {
    					System.out.println((row+1) + "A: \n" + x[row][column].toString());
    				}
    			} else if (column == 1) {
    				if (x[row][column].getAvailable() == false) {
    					System.out.println((row+1) + "B: \n" + x[row][column].toString());
    				}
    			} else {
    				if (x[row][column].getAvailable() == false) {
    					System.out.println((row+1) + "C: \n" + x[row][column].toString());
    				}
    			}
    		}//inner for loop
    		System.out.println();
    	}//outer for loop
       
    }//end printPassengerList method






    /**
     * The selectSeat method is used to assign a passenger to a seat. The seat is determined based on the row and
     * letter provided. Example, if 2 and "B" are the provided falues, the passenger to should be assigned to the
     * seat in the 2D array at index [1][1]. Remember. the rows start counting at 1 but they are stored in the
     * 2D array beginning at index 0!
     *
     * @param row - int value, what row the seat is in (1,2,3, or 4)
     * @param letter - String value, should be A, B, C, or D)
     * @param passengerName - Name of passanger who is reserving the seat
     * @param x - the 2D array of plane seats
     * @return - returns a boolean value, true if the seat was successfully reserved, false if the passenger selected a seat that was already taken
     */
    public static boolean selectSeat (int row, String letter, String passengerName, Seat [][] x){
    	int column;
    	if (letter.equalsIgnoreCase("A")) {
    		column = 0;
    		if (x[row-1][column].getAvailable() == true) {
    			x[row-1][column].setPassengerName(passengerName);
    			x[row-1][column].setAvailable(false);
    			System.out.println("Seat reserved successfully.");
    			return true;
        	} else {
    			System.out.println("Error. Seat reserved unsuccessfully.");
        		return false;
        	}
    	} else if (letter.equalsIgnoreCase("B")) {
    		column = 1;
    		if (x[row-1][column].getAvailable() == true) {
    			x[row-1][column].setPassengerName(passengerName);
    			x[row-1][column].setAvailable(false);
    			System.out.println("Seat reserved successfully.");
    			return true;
        	} else {
    			System.out.println("Error. Seat reserved unsuccessfully.");
        		return false;
        	}
    	} else {
    		column = 2;
    		if (x[row-1][column].getAvailable() == true) {
    			x[row-1][column].setPassengerName(passengerName);
    			x[row-1][column].setAvailable(false);
    			System.out.println("Seat reserved successfully.");
    			return true;
        	} else {
    			System.out.println("Error. Seat reserved unsuccessfully.");
        		return false;
        	}
    	}
    	
    }//end selectSeat method


    //extra credit
    public static boolean searchPassengerName(String name, Seat [][] x) {
    	boolean result = false;
    	for (int row = 0; row < x.length; row++) {
    		for (int column = 0; column < x[row].length; column++) {
    			if (column == 0) {
    				if (x[row][column].getPassengerName().equals(name)) {
    					System.out.println(name + " is located in seat " + (row+1) + "A.");
    					result = true;
    				}
    			} else if (column == 1) {
    				if (x[row][column].getPassengerName().equals(name)) {
    					System.out.println(name + " is located in seat " + (row+1) + "B.");
    					result = true;
    				}
    			} else {
    				if (x[row][column].getPassengerName().equals(name)) {
    					System.out.println(name + " is located in seat " + (row+1) + "C.");
    					result = true;
    				}
    			}
    			
    		}//inner for loop
    	}//outer for loop

		if (result == false) {
			System.out.println(name + " is not a passenger.");
			return false;
		} else {
			return true;
		}
    }//end of searchPassengerName method
    
    
/* Output:
 * 
 * 
 * 
Hello! Welcome to the plane seat selection program.
Main Menu: 
1 - View current seat status
2 - Display current passenger list
3 - Reserve a seat
4 - Search Passenger
5 - Exit
8
Please enter a valid number.
Main Menu: 
1 - View current seat status
2 - Display current passenger list
3 - Reserve a seat
4 - Search Passenger
5 - Exit
1
View current seat status selected
1A: X	1B: A	1C: X	
2A: A	2B: X	2C: A	
3A: X	3B: A	3C: A	
4A: X	4B: A	4C: A	
Main Menu: 
1 - View current seat status
2 - Display current passenger list
3 - Reserve a seat
4 - Search Passenger
5 - Exit
2
View print passenger list selected
1A: 
Passenger Name: Kathryn Janeway
Seat Type: STANDARD
1C: 
Passenger Name: Arthur Dent
Seat Type: STANDARD

2B: 
Passenger Name: Han Solo
Seat Type: STANDARD

3A: 
Passenger Name: James Kirk
Seat Type: EXtRA_LEGROOM

4A: 
Passenger Name: Jean-Luc Picard
Seat Type: STANDARD

Main Menu: 
1 - View current seat status
2 - Display current passenger list
3 - Reserve a seat
4 - Search Passenger
5 - Exit
3
Reserve a seat selected
Please enter your name: 
Juliana Bruno
Please enter your preferred row: (1, 2, 3, or 4)
2
Please enter your preferred seat: (A, B, or C)
B
Error. Seat reserved unsuccessfully.
Please enter your name: 
Juliana Bruno
Please enter your preferred row: (1, 2, 3, or 4)
4
Please enter your preferred seat: (A, B, or C)
C
Seat reserved successfully.
Main Menu: 
1 - View current seat status
2 - Display current passenger list
3 - Reserve a seat
4 - Search Passenger
5 - Exit
4
Search passenger selected
Please enter the name of the passenger you are searching for: 
Arthur Dent
Arthur Dent is located in seat 1C.
Main Menu: 
1 - View current seat status
2 - Display current passenger list
3 - Reserve a seat
4 - Search Passenger
5 - Exit
5
Thank you for using the plane seat selection program. Goodbye! 
 * 
 * 
 * 
 */

}// end class