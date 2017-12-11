/**
 * 
 */
package searchingPopularWords;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
	
	public static void main(String[] args) {
		
		getPopularWords();

	    
	}

	static void findMostPopular(){
		File file = new File("popular_words.txt");
		StringBuilder reading = new StringBuilder();
		try{
			Scanner scan = new Scanner(file);
	    	while (scan.hasNextLine()) {
	    		reading.append(scan.nextLine()).append(" ");
	    	}
	    	scan.close();
		} catch (Exception e){
			System.out.println(e);
		}
		StringTokenizer strTok = new StringTokenizer(reading.toString()," ");
		int count = strTok.countTokens();
		String[] arr = new String[count];
		int i = 0;
		while (strTok.hasMoreTokens()){
			String str = strTok.nextToken();
			if (str.length() > 3){
				arr[i] = str;
				i++;
			}
		}
		Arrays.sort(arr);
		
		for (int j = 0; j < arr.length; j++) {
			if (arr[j].equals(null)){
				break;
			
		}
		
	}
	
	
	static void getPopularWords(){
		Connection connect = Jsoup.connect("https://www.onet.pl/");

        try {

            Document document = connect.get();
            Elements links = document.select("span.title");
            
            FileWriter file = new FileWriter("popular_words.txt", true);
            
            for (Element elem : links) {
                String[] strings = elem.text().split("[-.,\\s:\"!\\/?]");
                for (int i = 0; i < strings.length; i++) {
                	file.append(strings[i]).append(" ");
				}  
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

}
