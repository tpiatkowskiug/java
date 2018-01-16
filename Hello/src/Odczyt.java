import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Odczyt {


	public static void main(String[] args) {
		int[] tab = {1,2,3,4,5,6};
		BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
		boolean czyPoprawne = false;
		int index = -1;
		System.out.println("Który z elementów tablicy chcesz wyświetlić");
		  while(!czyPoprawne) { //dopóki nie poprawnie
	          try {
	          index = Integer.parseInt(odczyt.readLine());
	          } catch (NumberFormatException n) { System.out.println("Niepoprawne dane! " +
	                "\n Który element tablicy chcesz zobaczyć: ");
	          } catch (IOException e) { System.out.println("Błąd odczytu danych");
	          }
	 
	          czyPoprawne = index == -1? false : true;
	      }
		  try {
	          System.out.println(tab[index-1]);
	      } catch (ArrayIndexOutOfBoundsException e) {
	          System.out.println("Niepoprawny parametr, rozmiar tablicy to: "+tab.length);
	      }
	}

}
