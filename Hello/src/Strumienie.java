import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
 
public class Strumienie {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner podajimie = new Scanner(System.in);
		System.out.println("Podaj Swoje imie w celu zapisania do pliku imie.txt");
		String imie = podajimie.nextLine();
	
		
		PrintWriter zapis = new PrintWriter("imie.txt");
		zapis.print(imie);
		zapis.close();
		
		Scanner wyswietl = new Scanner(new File("imie.txt"));
		System.out.println("Wynik zapisania w pliku imie.txt to "+wyswietl.nextLine());
		
	}
	

}