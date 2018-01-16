
public class UstawPunkt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld pracownicy[] = new HelloWorld[3];
		
		String[] imiona = {"Jerzy","Jan", "Gabriela"};
		String[] nazwiska = {"Piona", "olecki", "Jabłoński"};
		int[] wiek = {20, 25, 26};
		
		for(int i=0;i<pracownicy.length; i++){
			pracownicy[i]=new HelloWorld();
            pracownicy[i].imie = imiona[i];
            pracownicy[i].nazwisko = nazwiska[i];
            pracownicy[i].wiek = wiek[i];
		}
		System.out.println("pracownicy firmy to");
		for (int i = 0; i<pracownicy.length; i++){
			 System.out.println(pracownicy[i].imie+" "+pracownicy[i].nazwisko+", "+pracownicy[i].wiek+" lat");
		}

	}

}
