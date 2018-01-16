
public class Pracownik {

	String imie;
	String nazwisko;
	int wiek;
	public Pracownik(String a, String b, int c){
		imie = a;
		nazwisko=b;
		wiek=c;
	}
	public Pracownik(){
		imie="nie podano";
		nazwisko = "nie_podano";
        wiek = -1;
	}
	  public Pracownik(Pracownik prac){
	        imie = prac.imie;
	        nazwisko = prac.nazwisko;
	        wiek = prac.wiek;
	    }
	  void wyswietl(){
		  System.out.println(" "+imie+" "+nazwisko+" "+wiek);

		  } 
}
