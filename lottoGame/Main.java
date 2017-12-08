/**
 * 
 */
package lottoGame;

import java.util.Arrays;
import java.util.Collections;
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
		lottoGame();

	}

	static void lottoGame() {

		System.out.println("Witamy w grze LOTTO!");
		System.out.println("Podaj sześć liczb z zakresu 1-49.");
		//Pobranie szesciu liczb
		int[] getSix = getSixNumbers();
		//Wylosowanie sześciu liczb
		Integer[] drawSix = drawSixNumbers();
		
		System.out.println("Twoje liczby to:");
		System.out.println(Arrays.toString(getSix));
		System.out.println("Liczby wylosowane w LOTTO to:");
		System.out.println(Arrays.toString(drawSix));
		
		int count = 0;
		
		for (int i = 0; i < getSix.length; i++) {
			for (int j = 0; j < drawSix.length; j++) {
				if (getSix[i]==drawSix[j]){
					count++;
				}
			}
		}
		if (count==6) {
			System.out.println("GRATULACJE! Trafiłeś szóstkę!");
		} else if (count==5) {
			System.out.println("GRATULACJE! Trafiłeś piątkę!");
		} else if (count==4) {
			System.out.println("GRATULACJE! Trafiłeś czwórkę!");
		} else if (count==3) {
			System.out.println("GRATULACJE! Trafiłeś trójkę!");
		} else {
			System.out.println(":( Spróbuj jeszcze raz!");
		}

	}
	/**Pobieranie 6 prawidlowych liczb z konsoli
	 * 
	 * @return int[]
	 */
	static int[] getSixNumbers() {
		// otwarcie skanera
		Scanner scan = new Scanner(System.in);
		int[] givenNumbers = { 0, 0, 0, 0, 0, 0 };
		
		// pobieranie po kolei kazdego elementu tablicy givenNumbers
		for (int i = 0; i < givenNumbers.length; i++) {
			boolean keepGoing = true;
			//zmienna boolean sprawdza czy wylosowany element spelnia wymagania
			while (keepGoing) {
				System.out.println("Podaj liczbę:");
				// pobieraj dopoki nie jest to prawidlowa liczba
				while (!scan.hasNextInt()) {
					System.out.println("To nie jest liczba!");
					scan.next();
				}
				// pobranie liczby
				givenNumbers[i] = scan.nextInt();
				keepGoing = false;
				//sprawdzenie czy liczba jest ze wskazanego przedzialu
				if ((givenNumbers[i] > 49) || (givenNumbers[i] < 1)) {
					System.out.println("Liczba musi być z przedziału 1-49");
					keepGoing = true;
				}
				//sprawdzenie czy liczba nie zostala juz podana
				for (int j = 0; j < givenNumbers.length; j++) {
					if ((!(j == i)) && (givenNumbers[i] == givenNumbers[j])) {
						System.out.println("Podałeś już tą liczbę!");
						keepGoing = true;
					}
				}
			}

		}
		scan.close();
		Arrays.sort(givenNumbers);
		return givenNumbers;
	}
	/**Losowanie sześciu liczb z zakresu 1-49
	 * 
	 * @return Integer[]
	 */
	static Integer[] drawSixNumbers(){
		//tworzenie tablicy 1-49
		Integer[] arr = new Integer[49];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		Collections.shuffle(Arrays.asList(arr));
		//kopia pierwszych 6 liczb z tablicy
		Integer[] arrSix = Arrays.copyOfRange(arr, 0, 6);
		return arrSix;
	}

}
