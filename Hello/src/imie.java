import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class imie{
  public static void main(String[] args) throws FileNotFoundException{
      File file = new File("ala.txt");
      Scanner in = new Scanner(file);
 
      String zdanie = in.nextLine();
      System.out.println(zdanie);
      PrintWriter zapis = new PrintWriter("ala.txt");
      zapis.println("bo nie wzieła leków");
      zapis.close();
      
  }
}