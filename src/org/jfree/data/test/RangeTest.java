package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
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
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength());
	}

	public void testGetLengthBothPositiveAndNotEqual() {
		Range r2 = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength());
	}

	public void testGetLengthBothNegativeAndEqual() {
		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength());
	}

	public void testGetLengthBothNegativeAndNotEqual() {
		Range r4 = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength());
	}

	public void testGetLengthOnePositiveOneNegative() {
		Range r5 = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength());

		// TODO Pick 1 other methods in Range and have design tests for them
	}

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

	public void testCombineNullRange() {
		Range r10a = null;
		Range r10b = new Range(-5, 2);
		assertEquals("Combine: Did not return the expected output", new Range(-5, 2), r10a.combine(r10a, r10b));

	}

	public void testCombineRangeNull() {
		Range r11b = null;
		Range r11a = new Range(-5, 2);
		assertEquals("Combine: Did not return the expected output", new Range(-5, 2), r11a.combine(r11a, r11b));

	}

	public void testCombineNullNull() {
		Range r12b = null;
		Range r12a = null;
		assertEquals("Combine: Did not return the expected output", null, r12a.combine(r12a, r12b));

	}

	public void testCombineRangeRange2ndBiggerNoGap() {
		Range r12b = new Range(-5, 2);
		Range r12a = new Range(2, 7);
		assertEquals("Combine: Did not return the expected output", new Range(-5, 7), r12a.combine(r12a, r12b));

	}

	public void testCombineRangeRange2ndBiggerWithGap() {
		Range r13b = new Range(-5, 2);
		Range r13a = new Range(3, 7);
		assertEquals("Combine: Did not return the expected output", new Range(-5, 7), r13a.combine(r13a, r13b));

	}

	public void testCombineRangeRange2ndSmallerNoGap() {
		Range r14a = new Range(-5, 2);
		Range r14b = new Range(-12, -5);
		assertEquals("Combine: Did not return the expected output", new Range(-12, 2), r14a.combine(r14a, r14b));

	}

	public void testCombineRangeRange2ndSmallerWithGap() {
		Range r15a = new Range(-5, 2);
		Range r15b = new Range(-12, -6);
		assertEquals("Combine: Did not return the expected output", new Range(-12, 2), r15a.combine(r15a, r15b));

	}

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
		//System.out.println(Range.shift(r27, 7, false));
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
	
	
	public void testtoStringBothPositive() {
		Range r30 = new Range(2, 5);
		//System.out.println("Pos" + r30.toString());
		assertEquals("To String: Did not return the expected output", "Range[2.0,5.0]", r30.toString());
	}
	
	public void testtoStringBothNegative() {
		Range r31 = new Range(-5, -2);
		//System.out.println("Neg " +r31.toString());
		assertEquals("To String: Did not return the expected output", "Range[-5.0,-2.0]", r31.toString());
	}
	
	public void testtoStringOneNegative () {
		Range r32 = new Range(-5, 7);
		//System.out.println("both " +r32.toString());
		assertEquals("To String: Did not return the expected output", "Range[-5.0,5.0]", r32.toString());
	}

	
	

}
