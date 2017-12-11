/**
 * 
 */
package diceGame;

import java.util.Arrays;
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
		
		System.out.println(diceRoll(diceType(getDiceType())));
	}
	/**
	 * 
	 * @return String - typ rzutu w stringu
	 */
	static String getDiceType () {
		
		System.out.println("Podaj kod rzutu");
		Scanner scan = new Scanner(System.in);
		String str = "";
		while (true) {
			str = scan.nextLine();
			//sprawdzanie czy jest podany prawidlowy typ kostki
			if (str.contains("D3")||str.contains("D4")||str.contains("D6")||str.contains("D8")||str.contains("D10")
					||str.contains("D12")||str.contains("D20")||str.contains("D100")){
				break;
			}	
			System.out.println("To nie jest prawidłowy kod");
		}
		scan.close();
		return str;
	}
	
	/**
	 * 
	 * @param str - typ rzutu w Stringu
	 * @return int[] - typ rzutu w tablicy 3 elem. int
	 */
	static int[] diceType (String str) {
		
		boolean minus = str.contains("-");
		String[] textArr = str.split("\\D");
		//poprawki po splicie na prawidlowy schemat
		if (textArr[0].equals("")) {
			textArr[0]="1";
		}
		if (minus){
			textArr[textArr.length-1] = "-"+textArr[textArr.length-1];
		}
		if (textArr.length == 2){
			textArr = Arrays.copyOf(textArr, 3);
			textArr[2] = "0";
		}
		//ze stringa na int
		int[] arr = new int[textArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(textArr[i]);
		}
		return arr;
	}
	/**
	 * 
	 * @param diceType - tablica int
	 * @return int - wynik rzutu daną kostką
	 */
	static int diceRoll (int[] diceType){
		//losowanie
		Random r = new Random();
		return (diceType[0]*(r.nextInt(diceType[1])+1)) +diceType[2];
	}
	

}
