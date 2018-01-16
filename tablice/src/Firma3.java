
public class Firma3 {
	public static void main(String[] args) {
		KonstruktrPracownik worker1 = new KonstruktrPracownik("jan", "jankowski", 2017);
		KonstruktrPracownik worker2 = new KonstruktrPracownik();
		worker2.setImie("tomek");
		
		System.out.println(worker2.getPracownik());
		
		KonstruktrPracownik[] tabela= new KonstruktrPracownik[3];
		tabela[0] = new KonstruktrPracownik("olek", "janecki ", 2017);
		tabela[1] = new KonstruktrPracownik();
		tabela[2] = new KonstruktrPracownik(tabela[0]);
		
		for (KonstruktrPracownik p : tabela){
			System.out.println("prac: "+p.imie+" "+p.nazwisko+" "+p.wiek);
		}
		
		KonstruktrPracownik[] tab2 = new KonstruktrPracownik[2];
		String imie[]={"Władek", "janek"};
		String nazwisko[]={"Brożyna", "dytrich"};
		for(int i=0; i<tab2.length; i++){
			tab2[i] = new KonstruktrPracownik();
			tab2[i].imie=imie[i];
			tab2[i].nazwisko=nazwisko[i];
		}
		System.out.println("Pracownicy firmy to:");
		for(int i=0; i<tab2.length; i++){
			System.out.println(tab2[i].getPracownik());
		}
	}

}
