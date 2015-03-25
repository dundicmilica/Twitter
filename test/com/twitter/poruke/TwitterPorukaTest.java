/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Korisnik
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka twit;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twit = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twit = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		twit.setKorisnik("Milica");
		
		assertEquals("Milica", twit.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		twit.setKorisnik(null);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		twit.setKorisnik("");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");
		
		assertEquals("Baterija mi traje krace od zivota plavuse u horor filmu", twit.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		twit.setPoruka(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaLenght() {
		twit.setPoruka("Gravity (also called gravitation) is a natural phenomenon by"
				+ "which all physical bodies attract each other. On Earth, gravity"
				+ "gives weightto physical objects employing a downward force to keep"
				+ "them grounded. In modern physics, gravity is most accurately described"
				+ "by the general theory of relativity (proposed by Einstein) which describes"
				+ "gravity as a consequence of the curvature of spacetime. For most applications"
				+ "gravity is well approximated by Newton s law of universal gravitation, which"
				+ "postulates that the gravitational force of two bodies of mass is directly proportional"
				+ "to the product of their masses andinversely proportional to the square of the distance"
				+ "between them. In pursuit of a theory of everything, the merging of general relativity"
				+ "and quantum mechanics (or quantum field theory) into a more general theory of quantum"
				+ "gravity has become an area of active research. It is hypothesized that the gravitational"
				+ "force is mediated by a masslessspin-2 particle called the graviton, and that gravity would"
				+ "have separated from the electronuclear force during the grand unification epoch");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		twit.setKorisnik("Milica");
		twit.setPoruka("Baterija mi traje krace od zivota plavuse u horor filmu");	
		
		assertEquals ("KORISNIK:Milica" + " VREME:"+new GregorianCalendar()
			+" PORUKA:Baterija mi traje krace od zivota plavuse u horor filmu",
				"KORISNIK:"+twit.getKorisnik()+ " VREME:"+twit.getVreme()+" PORUKA:"+twit.getPoruka());
	}

}
