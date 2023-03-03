package org.jfree.Range.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Range_Contains_Test extends TestCase {
	private Range rangeObjectUnderTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	protected void tearDown() throws Exception {
	}

	@Test


	public void testContainsFirstValue() {
		Range r6 = new Range(-5, 3);
		assertEquals("Contains: Did not return the expected output", true, r6.contains(-5));
	}

	public void testContainsLastValue() {
		Range r7 = new Range(-5, 3);
		assertEquals("Contains: Did not return the expected output", true, r7.contains(3));
	}

	public void testContainsDoesNotContainUpper() {
		Range r8 = new Range(-5, 3);
		Range r9 = new Range(-5, 2);
		assertEquals("Contains: Did not return the expected output", false, r8.contains(4));
	}
	
	public void testContainsDoesNotContainLower() {
		Range r9 = new Range(-5, 2);
		assertEquals("Contains: Did not return the expected output", false, r9.contains(-6));
	}
	
	
	/*
	 * public void testContainsEmptyRange() { Range r9 = new Range(-5, -5);
	 * assertEquals("Contains: Did not return the expected output", false,
	 * r9.contains(-5)); }
	 */



	
	

}
