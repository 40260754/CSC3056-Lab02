package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Range_Shift_test extends TestCase {
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
	
	public void testShiftNullThrowsIllegalArgumentExceptionException() {

		try {
			Range r16 = null;
			Range.shift(r16, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			System.out.println(e.getClass());
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}

	}

	public void testShiftPositive() {

		Range r17 = new Range(-5, 2);
		assertEquals("Shift: Did not return the expected output", new Range(0, 7), Range.shift(r17, 5));

	}
	
	public void testShiftNegative() {

		Range r18 = new Range(-5, 2);
		assertEquals("Shift: Did not return the expected output", new Range(-10, -3), Range.shift(r18, -5));

	}
	
	public void testShiftZero() {

		Range r19 = new Range(-5, 2);
		assertEquals("Shift: Did not return the expected output", new Range(-5, 2), Range.shift(r19, 0));

	}
	

	
	

}
