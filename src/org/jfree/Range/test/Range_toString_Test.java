package org.jfree.Range.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Range_toString_Test extends TestCase {
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
