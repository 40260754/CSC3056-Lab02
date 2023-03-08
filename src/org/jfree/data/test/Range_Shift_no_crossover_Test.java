package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Range_Shift_no_crossover_Test extends TestCase {
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

	
	
	public void testShiftDoNotCrossNullThrowsInvalidParameterException() {

		try {
			Range r20 = null;
			Range.shift(r20, 0, false);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			System.out.println(e.getClass());
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}

	}

	public void testShiftDoNotCrossPositiveCross() {

		Range r21 = new Range(-4, 2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(1, 7), Range.shift(r21, 5, false));

	}
	
	public void testShiftDoNotCrossNegativeCross() {

		Range r22 = new Range(-5, 2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(-10, -3), Range.shift(r22, -5, false));

	}
	
	public void testShiftDoNotCrossPositiveNoCross() {

		Range r23 = new Range(-5, 2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(-2, 5), Range.shift(r23, 3, false));

	}
	
	public void testShiftDoNotCrossNegativeNoCross() {

		Range r24 = new Range(-5, 2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(-6, 1), Range.shift(r24, -1, false));

	}
	
	
	public void testShiftDoNotCrossPositiveUpperBoundbecomeZero() {

		Range r25 = new Range(-5, -2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(0, 0), Range.shift(r25, 5, false));

	}
	
	public void testShiftDoNotCrossNegativeUpperBecomeZero() {

		Range r26 = new Range(-5, 2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(-8, 0), Range.shift(r26, -3, false));

	}
	
	public void testShiftDoNotCrossPositiveLowerBoundbecomeZero() {

		Range r27 = new Range(-5, 4);
		//System.out.println(Range.shift(r27, 6, false));
		/*Range test = Range.shift(r27, 7, false);
		System.out.println(test.getLowerBound());
		System.out.println(test.getUpperBound());		
		System.out.println(test);
		 * 
		 */
		assertEquals("Shift do not cross: Did not return the expected output", new Range(0, 10), Range.shift(r27, 6, false));

	}
	
	public void testShiftDoNotCrossNegativeLowerBoundBecomeZero() {

		Range r28 = new Range(5, 8);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(0, 2), Range.shift(r28, -7, false));

	}
	
	
	public void testShiftDoNotCrossZero() {

		Range r29 = new Range(-5, 2);
		assertEquals("Shift do not cross: Did not return the expected output", new Range(-5, 2), Range.shift(r29, 0, false));

	}
	
	


	
	

}
