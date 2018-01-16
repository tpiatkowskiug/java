
public class Firma {

	public static void main(String[] args) {
		Pracownik pracownik1 = new Pracownik();
		pracownik1.setPracownik("Tomasz  ", "Piątkowski  ", 5000);
		Pracownik pracownik2=new Pracownik();
		pracownik2.imie="Jacek  ";
		pracownik2.nazwisko="Rębecki  ";
		pracownik2.pensja=4000;
		
		
		
		System.out.println(pracownik1.getPracownik());
		System.out.println(pracownik2.getPracownik());
	}

}
