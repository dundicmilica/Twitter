/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Korisnik
 *
 */
public class TwitterTest {
	
	TwitterPoruka twit;
	Twitter twitter;
	LinkedList<TwitterPoruka> pomocnaLista;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twit = new TwitterPoruka();
		twitter = new Twitter();
		pomocnaLista = new LinkedList<TwitterPoruka>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twit = null;
		twitter = null;
		for (int i = 0; i < pomocnaLista.size(); i++) {
			pomocnaLista.remove(i);
			
		}
	}

	/**
	 * Test proverava da li metoda vraca praznu listu kad u njoj 
	 * jos uvek ne ostoji objekat klase TwitterPoruka
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke_PraznaLista(){
		//pomocna lista je trenutno prazna
		assertEquals(pomocnaLista, twitter.vratiSvePoruke());
	}
	
	/**
	 * Test proverava da li metoda vraca listu objekata klase TwitterPoruka
	 * kada se u listi nalazi samo jedan element
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke_JednaPoruka() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");
		
		//u pomocnu listu ubacujemo jedan element
		pomocnaLista.add(twit);
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		
		assertEquals(true, twitter.uporediListe(pomocnaLista));
	}
	
	
	/**
	 * Test proverava da li metoda vraca listu objekada klase TwitterPoruka
	 * kada se u njoj nalazi vise elemenata
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke_VisePoruka() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");
		
		pomocnaLista.addLast(twit); //u pomocnu listu ubacujemo prvi element
		
		TwitterPoruka twit2 = new TwitterPoruka();
		twit2.setKorisnik("Marko");
		twit2.setPoruka("Jel znas nesto da napravis? Da, haos od zivota");
		
		pomocnaLista.addLast(twit2); //u pomocnu listu ubacujeo drugi element
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka() );
		twitter.unesi(twit2.getKorisnik(), twit2.getPoruka());
		
		assertEquals(true, twitter.uporediListe(pomocnaLista));
		
	}
	
	/**
	 * Test proverava da li metoda postavlja objekada klase TwitterPoruka
	 * na poslednje mesto u nizu
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testUnesi_PoslednjeMesto() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");
		
		pomocnaLista.addLast(twit);
		
		TwitterPoruka twit2 = new TwitterPoruka();
		twit2.setKorisnik("Marko");
		twit2.setPoruka("Jel znas nesto da napravis? Da, haos od zivota");
		
		pomocnaLista.addLast(twit2);
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka() );
		twitter.unesi(twit2.getKorisnik(), twit2.getPoruka());
		
		assertEquals(true, twitter.vratiPoslednji().equals(pomocnaLista.getLast()));
	} 

	/**
	 * Test proverava da li metoda pravilno unosi korisnika
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi_Korisnik() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		
		assertEquals("Milica", twitter.vratiKorisnika(0));
	}
	
	/**
	 * Test proverava da li metoda pravilno unosi poruku
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi_Poruka() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		
		assertEquals("Baterija mi traje krace od zivota plavuse u horor filmu", twitter.vratiPoruku(0));
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		fail("Not yet implemented");
	}

}
