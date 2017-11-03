import java.util.Scanner;
public class warunki {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a;
		double b;
		Scanner wynik = new Scanner(System.in);
		a = wynik.nextDouble();
		b = wynik.nextDouble();
		if(a>b){
		System.out.println("liczba" +a+ "jest większa od liczby"+b);}
		else{
			System.out.println("Liczba a jest mniejsza od liczby b");}
		int zmienna;
		Scanner liczba = new Scanner(System.in);
		zmienna = liczba.nextInt();
		
		switch(zmienna){
		case 1:
			System.out.println("to liczba 1");
			break;
		case 2:
			System.out.println("Liczba 2");
			break;
		default:
			System.out.println("żaden");
		}
		
		
	}

}
