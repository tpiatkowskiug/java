
public class Firma1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pracownik prac1 = new Pracownik();
		prac1.setPracownik("tomek", "ppp", 22222);
		
		Pracownik[]	pracownicy = new Pracownik[3];
		String []imie = {"włodek", "jacek", "jacek"};
		String []nazwisko = {"olecki", "jabłońsk", "igorski"};
		int []wiek={22,33,44};
		
		for(int i=0; i<pracownicy.length; i++){
			pracownicy[i]=new Pracownik();
			pracownicy[i].imie=imie[i];
			pracownicy[i].nazwisko=nazwisko[i];
		}
		for(int i=0; i< pracownicy.length; i++)
            System.out.println(pracownicy[i].imie+" "+pracownicy[i].nazwisko);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Pracownik pracownicy[] = new Pracownik[3];
//		//int pracownik[]=new int[3];
//		
//		String imie[] = {"Włódek", "jacek", "zenek"};
//		String nazwisko[] = {"jankowski", "szczepkowski", "janosik"};
//		double pencja[] = {2222, 3333, 4444};
//		for(int i=0; i<pracownicy.length; i++){
//			
//			pracownicy[i] = new Pracownik();
//			pracownicy[i].imie=imie[i];
//			pracownicy[i].nazwisko=nazwisko[i];
//			pracownicy[i].pensja=pencja[i];
//		}
//		System.out.println("Pracownicy firmy to:");
//		for(int i=0; i<pracownicy.length; i++){
//			
//			System.out.println(pracownicy[i].getPracownik());
//		}
	}

}