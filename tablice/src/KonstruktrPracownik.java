
public class KonstruktrPracownik {
	String imie;
	String nazwisko;
	int wiek;
	
	void setImie(String imie){
		this.imie=imie;
	}
	void setNazwisko(String nazwisko){
		this.nazwisko=nazwisko;
	}
	void setWiek(int wiek){
		this.wiek=wiek;
	}
	 public KonstruktrPracownik(){
	        this.imie = "nie_podano ";
	        this.nazwisko = "nie_podano  ";
	        this.wiek = -1;
	    }
	public KonstruktrPracownik(String imie, String nazwisko, int wiek){
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.wiek=wiek;
	}
	 public KonstruktrPracownik (KonstruktrPracownik prac){
	        this.imie = prac.imie;
	        this.nazwisko = prac.nazwisko;
	        this.wiek = prac.wiek;
	    }
	String getPracownik(){
			return imie + nazwisko + (int)wiek;
		}
}
