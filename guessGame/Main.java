/**
 * 
 */
package guessGame;

import java.util.Random;
import java.util.Scanner;

/**
 * @author katarzyna
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		guessGame();

	}
	/**
	 * guessing numbers game
	 */
	static void guessGame(){
		
		//choosing random number
		Random r = new Random();
		int luckyNumber = r.nextInt(100)+1;
		int givenNumber;
		//opening scanner
		Scanner scan = new Scanner(System.in);
		//loop for guessing the number
		while (true){
			
			System.out.println("Zgadnij liczbę:");
			//checking if it's an int
			while (!scan.hasNextInt()){
				System.out.println("To nie jest liczba!");
				scan.next();
			}
			//reading the number from console
			givenNumber = scan.nextInt();
			
			if (givenNumber < luckyNumber){
				System.out.println("Za mało!");
			} else if (givenNumber > luckyNumber){
				System.out.println("Za dużo!");
			} else {
				System.out.println("Zgadłeś!");
				//ending the loop
				break;
			}
		}
		//closing scanner
		scan.close();
	}

}
