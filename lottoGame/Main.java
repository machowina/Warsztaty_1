/**
 * 
 */
package lottoGame;

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
		// TODO Auto-generated method stub
		

	}
	
	static void lottoGame(){
		//opening scanner
		Scanner scan = new Scanner(System.in);
		int[] givenNumbers = {0,0,0,0,0,0};
		
		for (int i = 0; i < givenNumbers.length; i++) {
			
			boolean keepGoing = true;
			while (keepGoing){
				
				System.out.println("Podaj liczbę:");
				//checking if it's an int
				while (!scan.hasNextInt()){
					System.out.println("To nie jest liczba!");
					scan.next();
				}
				//reading the number from console
				givenNumbers[i] = scan.nextInt();
				keepGoing = false;
				for (int j = 0; j < givenNumbers.length; j++) {
					if (givenNumbers[i]==givenNumbers[j]){
						keepGoing = true;
					}
				}
				
				if ((givenNumbers[i]>49)||(givenNumbers[i]<1)){
					keepGoing = true;
				}
			}
			
		}
		scan.close();
		
		
	}
	
	

}
