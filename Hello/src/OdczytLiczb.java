import java.util.Scanner;
public class OdczytLiczb {
	public static void main(String[] args) {
		double liczba1;
		double liczba2; 
		Scanner liczby = new Scanner(System.in);
		liczba1 = liczby.nextInt();
		liczba2 = liczby.nextInt();
		
		 System.out.println("Razem "+(liczba1+liczba2));
		 System.out.println("Razem "+(liczba1/liczba2));

	}

}
