package model;



public class Klient {

	private Integer id_klienta; 
	private String imie;
	private String nazwisko;
	private String miasto;
	private String rokUrodzenia;
	
	public Klient(Integer id, String imie, String nazwisko, String miasto, String rokUrodzenia) {
		this(imie, nazwisko, miasto, rokUrodzenia);
		this.id_klienta = id;
	}

	public Klient(String imie, String nazwisko, String miasto, String rokUrodzenia) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miasto = miasto;
		this.rokUrodzenia = rokUrodzenia;
	}

	public Integer getId() {
		return id_klienta;
	}
	
	public String getImie() {
		return imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public String getMiasto() {
		return miasto;
	}
	
	public String getRokUrodzenia() {
		return rokUrodzenia;
	}
	public void setImie(String string) {
		// TODO Auto-generated method stub
		
	}
//	public String getDateTime() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(
//                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        Date date = new Date(rokUrodzenia);
//        return dateFormat.format(date);
//    }
}