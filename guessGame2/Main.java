/**
 * 
 */
package guessGame2;

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
		
		guessGame2();

	}
	/**
	 * 
	 */
	static void guessGame2(){
		
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach!");
		System.out.println("Odpowiadaj \"za dużo\", \"za mało\", \"zgadłeś\"");
		
		int min = 0;
		int max = 1000;
		int guess = 0;
		
		Scanner scan = new Scanner(System.in);
		String answer = "";
		//pętla nieskończona dopóki nie zgadniemy
		while (true) {
			//strzał w liczbę z połowy przedziału
			guess = ((max-min)/2) + min;
			System.out.println("Zgaduję: "+ guess);
			answer = scan.nextLine();
			//porównanie podanej odpowiedzi
			if (answer.equals("zgadłeś")) {
				System.out.println("Wygrałem!");
				break;
			} else if (answer.equals("za dużo")){
				max = guess;
			} else if (answer.equals("za mało")){
				min = guess;
			} else {
				System.out.println("Nie oszukuj!");
			}
		}
		scan.close();
	}
}
