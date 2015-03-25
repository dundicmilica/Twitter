package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Predstavlja sve poruke na twitteru
 * @author Dundic Milica
 *
 */
public class Twitter {
	
	/**
	 * Lista svih poruka (twit-ova) na twitteru.
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda vraca listu svih twit-ova
	 * @return poruke kao listu TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
			return poruke;
	}
	
	/**
	 * Metoda unosi novi twit na kraj liste na osnovu
	 * ulaznih parametara
	 * @param korisnik user name korisnika
	 * @param poruka twit koji se objavljuje
	 */
	public void unesi(String korisnik, String poruka) {
		TwitterPoruka twit = new TwitterPoruka();
		
		twit.setKorisnik("korisnik");
		twit.setPoruka(poruka);
		
		poruke.addLast(twit);
	}
	
	/**
	 * Metoda proverava da li u listi TwitterPoruka postoji poruka
	 * sa tag-om. Ako se nadje neka takva i ako nije prekoracen maxBroj
	 * ona se upisuje u niz. Ako je prekoracen maxBroj, pretraga se prekida.
	 * Metoda kao ulazne parametre prima 
	 * @param maxBroj maksimalan broj poruka koje se upisuju u niz
	 * @param tag kljucna rec pomocu koje se vrsi pretrazivanje poruka
	 * @return TwitterPoruka[] niz od maxBroj elemenata, poruka koje sadrze tag
	 * @throws java.lang.RuntimeException ako je uneti tag
	 * <ul>
	 * <li>null</li>
	 * <li>prazanString</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
	
		if (maxBroj<=0)
				maxBroj = 100;
			
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		
		//Niz koji predstavlja rezultat pretrage
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
							
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
						brojac++;
		}
				else break;
		
		return rezultat;
	}
			
}
