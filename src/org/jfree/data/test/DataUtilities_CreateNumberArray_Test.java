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

public class DataUtilities_CreateNumberArray_Test extends TestCase {

	private double[] doubleValues;
	private double[] emptyValues;
	
	@Before
	public void setUp() {
		doubleValues = new double[] {0.1d, 0.2d, -0.3d, -0.4d, 0.5d};
		emptyValues = new double[] {};
	}
	
	@After
	public void tearDown() {
		doubleValues = null;
	}
	
	@Test
	public void testValidData() {
		
		if (!(DataUtilities.createNumberArray(doubleValues) instanceof Number[])) {
			fail("Incorrect returned object type");
		}
		
		Number[] numberValues = DataUtilities.createNumberArray(doubleValues);
		
		for (Number number : numberValues) {
			try {
				number.doubleValue();
			} catch (Exception e) {
				fail("Null value encountered in converted data");
			}
		}
		
		if (numberValues.length == doubleValues.length) {
			for (int i = 0; i < doubleValues.length; i++) {
				assertEquals("Data inaccurately converted", doubleValues[i], numberValues[i].doubleValue());
			}
		}
		else {
			fail("Incorrect number of values converted");
		}
	} 
	
	public void testEmptyArrayData() {
		
		if (!(DataUtilities.createNumberArray(emptyValues) instanceof Number[])) {
			fail("Incorrect returned object type");
		}
		
		Number[] numberValues = DataUtilities.createNumberArray(emptyValues);
		
		for (Number number : numberValues) {
			try {
				number.doubleValue();
			} catch (Exception e) {
				fail("Null value encountered in converted data");
			}
		}
		
		if (numberValues.length == emptyValues.length) {
			for (int i = 0; i < emptyValues.length; i++) {
				assertEquals("Data inaccurately converted", emptyValues[i], numberValues[i].doubleValue());
			}
		}
		else {
			fail("Incorrect number of values converted");
		}
	} 
	
	public void testNullData() {
		try
		{
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}	
	} 
}