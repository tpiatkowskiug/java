package model;


public class Zamawianie_badan {

	private Integer id_zamówienia; 
	private String rodzaj_badan;
	private Integer ilosc_prob;
	private String kwota;
	private Integer id_klienta;
	
	public Zamawianie_badan(String rodzaj_badan, Integer ilosc_prob,
			String kwota, Integer id_klienta) {
		super();
		this.rodzaj_badan = rodzaj_badan;
		this.ilosc_prob = ilosc_prob;
		this.kwota = kwota;
		this.id_klienta = id_klienta;
	}

	
	public Zamawianie_badan (String rodzaj_badan, Integer ilosc_prob, String kwota) {
		this.rodzaj_badan = rodzaj_badan;
		this.ilosc_prob = ilosc_prob;
		this.kwota = kwota;
	}
	
	public Zamawianie_badan(Integer id_zamówienia, String rodzaj_badan, Integer ilosc_prob, String kwota) {
		this(rodzaj_badan, ilosc_prob, kwota);
		this.id_zamówienia = id_zamówienia;
	}
	
	public Zamawianie_badan(Integer id, String rodzaj_badan,
			Integer ilosc_prob, String kwota, Integer id_klienta) {
		super();
		this.id_zamówienia = id;
		this.rodzaj_badan = rodzaj_badan;
		this.ilosc_prob = ilosc_prob;
		this.kwota = kwota;
		this.id_klienta = id_klienta;
	}

	public Zamawianie_badan(Integer id_klienta) {
		this.id_klienta = id_klienta;
	}

	public Integer getId() {
		return id_zamówienia;
	}

	public void setId(Integer id) {
		this.id_zamówienia = id;
	}

	public String getRodzaj_badan() {
		return rodzaj_badan;
	}

	public void setRodzaj_badan(String rodzaj_badan) {
		this.rodzaj_badan = rodzaj_badan;
	}

	public Integer getIlosc_prob() {
		return ilosc_prob;
	}

	public void setIlosc_prob(Integer ilosc_prob) {
		this.ilosc_prob = ilosc_prob;
	}

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public Integer getKlient_id() {
		return id_klienta;
	}

	public void setKlient_id(Integer id_klienta) {
		this.id_klienta = id_klienta;
	}
	
}
