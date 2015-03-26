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
		//ukoliko vrati true znaci da je twitter lisa jednaka nasoj pomocnoj listi
		//na taj nacin znamo da je metoda vratila listu sa svim elementima koji se u
		//njoj nalaze
		
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
	 * Test proverava da li metoda pravilno vraca korisnika na osnovu
	 * odgovarajuceg unetog parametra koji predstavlja indeks u listi
	 * Test method for {@link com.twitter.Twitter#vratiKorisnika(int i)}.
	 */
	@Test
	public void testVratiKorisnika() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Neka poruka");
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		
		TwitterPoruka twit2 = new TwitterPoruka();
		twit2.setKorisnik("Marko");
		twit2.setPoruka("Neka poruka");
		
		twitter.unesi(twit2.getKorisnik(), twit2.getPoruka());
		
		assertEquals("Marko", twitter.vratiKorisnika(1));
	}

	/**
	 * Test proverava da li metoda pravilno vraca poruku na osnovu
	 * odgovarajuceg unetog parametra koji predstavlja indeks u listi
	 * Test method for {@link com.twitter.Twitter#vratiKorisnika(int i)}.
	 */
	@Test
	public void testVratiPoruku() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Neka poruka");
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		
		TwitterPoruka twit2 = new TwitterPoruka();
		twit2.setKorisnik("Marko");
		twit2.setPoruka("Druga poruka");
		
		twitter.unesi(twit2.getKorisnik(), twit2.getPoruka());
		
		assertEquals("Druga poruka", twitter.vratiPoruku(1));
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		twitter.vratiPoruke(50, null);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagEmptyString() {
		twitter.vratiPoruke(50, "");
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke_index0() {
		TwitterPoruka twit2 = new TwitterPoruka();
		TwitterPoruka twit3 = new TwitterPoruka();
		
		twit.setKorisnik("Milica");
		twit.setPoruka("danas je divan dan");
		
		twit2.setKorisnik("Marko");
		twit2.setPoruka("Neka poruka");
		
		twit3.setKorisnik("Zeljko");
		twit3.setPoruka("idem na bazen danas");
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		twitter.unesi(twit2.getKorisnik(), twit2.getPoruka());
		twitter.unesi(twit3.getKorisnik(), twit3.getPoruka());
		
		TwitterPoruka[] pomocniNiz = new TwitterPoruka[2];
		pomocniNiz[0] = twit;
		pomocniNiz[1] = twit3;
		
		TwitterPoruka [] resrenje = twitter.vratiPoruke(5, "danas");
		
		assertEquals(pomocniNiz[0].getPoruka(), resrenje[0].getPoruka());
	} //uhvacen bug prijavljen NullPointerException
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke_index1() {
		TwitterPoruka twit2 = new TwitterPoruka();
		TwitterPoruka twit3 = new TwitterPoruka();
		
		twit.setKorisnik("Milica");
		twit.setPoruka("danas je divan dan");
		
		twit2.setKorisnik("Marko");
		twit2.setPoruka("Neka poruka");
		
		twit3.setKorisnik("Zeljko");
		twit3.setPoruka("idem na bazen danas");
		
		twitter.unesi(twit.getKorisnik(), twit.getPoruka());
		twitter.unesi(twit2.getKorisnik(), twit2.getPoruka());
		twitter.unesi(twit3.getKorisnik(), twit3.getPoruka());
		
		TwitterPoruka[] pomocniNiz = new TwitterPoruka[2];
		pomocniNiz[0] = twit;
		pomocniNiz[1] = twit3;
		
		TwitterPoruka [] resrenje = twitter.vratiPoruke(5, "danas");
		
		assertEquals(pomocniNiz[1].getPoruka(), resrenje[1].getPoruka());
	}
	

}
