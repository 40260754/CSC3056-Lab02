package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Range_Equals_Test extends TestCase {
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

	public void testEqualsNullReturnsFalse() {
		Range r6 = new Range(3, 5);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(null));
		
	}
	
	public void testEqualsPositiveReturnsTrue() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(3, 5);
		assertEquals("Equals: Did not return the expected output", true, r6.equals(r6b));
		
	}
	public void testEqualsNegativeReturnsTrue() {
		Range r7 = new Range(-5, -3);
		Range r7b = new Range(-5, -3);
		assertEquals("Equals: Did not return the expected output", true, r7.equals(r7b));
		
	}
	
	public void testNotEqualsPositiveUpperLesserDoesNotMatchReturnsFalse() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(3, 4);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsPositiveLowerLesserDoesNotMatchReturnsFalse() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(2, 5);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsNegativeUpperLesserDoesNotMatchReturnsFalse() {
		Range r6 = new Range(-5, -3);
		Range r6b = new Range(-5, -4);
		
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsNegativeLowerLesserDoesNotMatchReturnsFalse() {
		Range r6 = new Range(-5, -3);
		Range r6b = new Range(-6, -3);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	
	public void testNotEqualsPositiveUpperGreaterDoesNotMatchReturnsFalse() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(3, 6);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsPositiveLowerGreaterDoesNotMatchReturnsFalse() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(4, 5);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsNegativeUpperGreaterDoesNotMatchReturnsFalse() {
		Range r6 = new Range(-5, -3);
		Range r6b = new Range(-5, -2);
		
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsNegativeLowerGreaterDoesNotMatchReturnsFalse() {
		Range r6 = new Range(-5, -3);
		Range r6b = new Range(-4, -3);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsNegativeBothLess() {
		Range r6 = new Range(-5, -3);
		Range r6b = new Range(-6, -4);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsNegativeBothGreater() {
		Range r6 = new Range(-5, -3);
		Range r6b = new Range(-4, -2);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsPositiveBothLess() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(2, 4);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	
	public void testNotEqualsPositiveBothGreater() {
		Range r6 = new Range(3, 5);
		Range r6b = new Range(4, 6);
		assertEquals("Equals: Did not return the expected output", false, r6.equals(r6b));
		
	}
	/*public void testContainsFirstValue() {
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
