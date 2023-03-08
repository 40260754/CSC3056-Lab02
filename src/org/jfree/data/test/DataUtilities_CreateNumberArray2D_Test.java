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

public class DataUtilities_CreateNumberArray2D_Test extends TestCase {

	private double[][] doubleValues;
	private double[][] emptyValues;
	
	@Before
	public void setUp() {
		doubleValues = new double[][] { {-0.1d, -0.2d, -0.3d, -0.4d, -0.5d}, {0.1d, 0.2d, 0.3d, 0.4d, 0.5d} };
		emptyValues = new double[][] {};
	}
	
	@After
	public void tearDown() {
		doubleValues = null;
	}
	
	@Test
	public void testValidData() {
		
		if (!(DataUtilities.createNumberArray2D(doubleValues) instanceof Number[][])) {
			fail("Incorrect returned object type");
		}
		
		Number[][] numberValues = DataUtilities.createNumberArray2D(doubleValues);
		
		for (Number[] row : numberValues) {
			for (Number column : row) {
				try {
					column.doubleValue();
				} catch (Exception e) {
					fail("Null value encountered in converted data");
				}
			}
		}
		
		if (numberValues.length != doubleValues.length) {
			fail("Incorrect number of rows converted");
		}
		
		for (int i = 0; i < doubleValues.length; i++) {
			if (doubleValues[i].length == numberValues[i].length) {
				fail("Incorrect number of columns converted");
			}
		}
		
		for (int i = 0; i < doubleValues.length; i++) {
			for (int j = 0; j < doubleValues[i].length; j++) {
				assertEquals("Data inaccurately converted", doubleValues[i][j], numberValues[i][j].doubleValue());
			}
		}
	} 
	
	public void testEmptyArrayData() {
		
		if (!(DataUtilities.createNumberArray2D(emptyValues) instanceof Number[][])) {
			fail("Incorrect returned object type");
		}
		
		Number[][] numberValues = DataUtilities.createNumberArray2D(emptyValues);
		
		for (Number[] row : numberValues) {
			for (Number column : row) {
				try {
					column.doubleValue();
				} catch (Exception e) {
					fail("Null value encountered in converted data");
				}
			}
		}
		
		if (numberValues.length != emptyValues.length) {
			fail("Incorrect number of rows converted");
		}
		
		for (int i = 0; i < emptyValues.length; i++) {
			if (doubleValues[i].length == numberValues[i].length) {
				fail("Incorrect number of columns converted");
			}
		}
		
		for (int i = 0; i < emptyValues.length; i++) {
			for (int j = 0; j < emptyValues[i].length; j++) {
				assertEquals("Data inaccurately converted", emptyValues[i][j], numberValues[i][j].doubleValue());
			}
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