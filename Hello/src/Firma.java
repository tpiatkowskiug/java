
public class Firma {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pracownik pracownik = new Pracownik();
		pracownik.imie="Tomasz";
		pracownik.wiek=25;
		pracownik.wyswietl();
		Pracownik pracownik1 = new Pracownik ("Jacek","Piona",25);
		pracownik1.wyswietl();
		
        Pracownik[] pracownicy = new Pracownik[3];
        pracownicy[0] = new Pracownik();
        pracownicy[1] = new Pracownik("Staszek", "Kowalski", 34);
        pracownicy[2] = new Pracownik(pracownicy[1]);
 
        for(Pracownik p: pracownicy)
            System.out.println("prac3: "+p.imie+" "+p.nazwisko+" "+p.wiek);
	}

}
