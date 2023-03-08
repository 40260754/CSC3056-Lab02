package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilities_CalculateRowTotal_Test extends TestCase {

	private Values2D values2D;
	private Values2D zeroValues;
	
	@Before
	public void setUp() {
		
		DefaultKeyedValues2D testZeroValues2d = new DefaultKeyedValues2D();
		zeroValues = testZeroValues2d;
		
		// Values
		// 0 ...
		// ... 
		
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(2, 0, 1);
		testValues.addValue(3, 0, 2);
		testValues.addValue(4, 1, 0);
		testValues.addValue(5, 1, 1);
		testValues.addValue(6, 1, 2);
		testValues.addValue(7, 2, 0);
		testValues.addValue(8, 2, 1);
		testValues.addValue(9, 2, 2);
		
		// Values
		// 1 2 3
		// 4 5 6
		// 7 8 9
	}
	
	@After
	public void tearDown() {
		zeroValues = null;
		values2D = null;
	}
	
	@Test
	public void testValidDataAndFirstRowTotal() {
		assertEquals("Wrong sum returned. It should be 6.0", 6.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	public void testValidDataAndLastRowTotal() {
		assertEquals("Wrong sum returned. It should be 24.0", 24.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
	}
	
	public void testZeroValuesDataAndRowTotal() {
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateRowTotal(zeroValues, 1), 0.0000001d);
	}
	
	public void testNullDataRowTotal() {
		try
		{
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	public void testValidDataAndRowTotalWithInvalidRow() {
		try
		{
			DataUtilities.calculateRowTotal(values2D, 4);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

}