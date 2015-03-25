package com.twitter.poruke;


/**
 * Predstavlja poruku na Twitter-u.
 * 
 * @author Dundic Milica
 *
 */
public class TwitterPoruka {
	
	/**
	 * User name korisnika.
	 */
	private String korisnik;
	
	/**
	 * Twit, tj. poruka koju objavljuje korisnik.
	 */
	private String poruka;
	
	/**
	 * Metoda vraca user name korisnika, tj. atribut korisnik.
	 * @return korisnik (user name korisnika) kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja user name korisnika na unetu vrednost.
	 * @param korisnik novi user name korisnika.
	 * @throws java.lang.RuntimeException ako je uneti user name korisnika
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda vraca sadrzaj poruke (twit-a) koju je obavio korisnik,
	 * tj. vrednost atributa poruka.
	 * @return poruku korisnika kao String
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda postavlja poruku korisnika na unetu vrednost.
	 * @param poruka sadrzaj poruke koju je objavio korisnik.
	 * @throws java.lang.RuntimeException ako je uneta poruka
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	public String toString(){
		return "KORISNIK:"+korisnik+" VREME:"+vreme.getTime()+" PORUKA:"+poruka;
	}

}
