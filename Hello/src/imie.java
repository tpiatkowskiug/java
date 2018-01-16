import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class imie{
  public static void main(String[] args) throws FileNotFoundException{
	   File in = new File("ala.txt");
	   Scanner out = new Scanner(in);
	   String wyswietl = out.nextLine();
	   System.out.println(wyswietl);
	   PrintWriter plikala = new PrintWriter("ala.txt");
	   plikala.write(wyswietl);
	   plikala.close();
}}