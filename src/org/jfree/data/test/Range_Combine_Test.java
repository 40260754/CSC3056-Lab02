package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Range_Combine_Test extends TestCase {
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

	

	
	

}
