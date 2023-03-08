package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilities_GetCumulativePercentages_Test extends TestCase {

	private DefaultKeyedValues testValues;
	private DefaultKeyedValues testZeroValues2d;
	
	@Before
	public void setUp() {
		
		testZeroValues2d = new DefaultKeyedValues();
		
		// Values
		// 0
		// ... 
		
		testValues = new DefaultKeyedValues(); 
		testValues.addValue((Comparable) 1, 1);
		testValues.addValue((Comparable) 2, 2);
		testValues.addValue((Comparable) 3, 3);
		testValues.addValue((Comparable) 4, 4);
		testValues.addValue((Comparable) 5, 5);
		
		// Values
		// 1
		// 2
		// 3
		// 4
		// 5
	}
	
	@After
	public void tearDown() {
		testZeroValues2d = null;
		testValues = null;
	}
	
	@Test
	public void testValidData() {
		
		KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(testValues);
		
		assertEquals("Not all values returned", testValues.getItemCount(), cumulativePercentages.getItemCount());
		
		double total = 0;	
		for (int i = 0; i < testValues.getItemCount(); i++) {
			total += testValues.getIndex(i);
		}
		
		for (int i = 0; i < testValues.getItemCount(); i++) {
			double totalsBelowIndex = 0;
			for (int j = 0; j <= i; j++) {
				totalsBelowIndex += testValues.getIndex(j);
			}
			assertEquals("Incorrect output expected", cumulativePercentages.getIndex(i), (totalsBelowIndex/total));
		}
	}
	
	public void testEmptyData() {
		
		KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(testZeroValues2d);
		
		assertEquals("Not all values returned", testZeroValues2d.getItemCount(), cumulativePercentages.getItemCount());
		
		double total = 0;	
		for (int i = 0; i < testZeroValues2d.getItemCount(); i++) {
			total += testZeroValues2d.getIndex(i);
		}
		
		for (int i = 0; i < testZeroValues2d.getItemCount(); i++) {
			double totalsBelowIndex = 0;
			for (int j = 0; j <= i; j++) {
				totalsBelowIndex += testZeroValues2d.getIndex(j);
			}
			assertEquals("Incorrect output expected", cumulativePercentages.getIndex(i), (totalsBelowIndex/total));
		}
	}
	
	public void testNullData() {
		try
		{
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}	
	} 

}