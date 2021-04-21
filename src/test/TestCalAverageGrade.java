package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;

//import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
 * Unit test
 * TestCalAverageGrade
 * 
 * case1: ID 985002509 weights [10,10,10,30,40]
 * case2: ID 985002510 weights [10,10,10,30,40]
 * case3: ID 985002510 weights [10.10,10,10,60]
 */
public class TestCalAverageGrade {

	/**
	 * @uml.property  name="outCome"
	 */
	private ByteArrayOutputStream outCome = null;
	/**
	 * @uml.property  name="test" multiplicity="(0 -1)" dimension="1"
	 */
	int test[] = {10,10,10,30,40};
	/**
	 * @uml.property  name="test2" multiplicity="(0 -1)" dimension="1"
	 */
	int test2[] = {10,10,10,10,60};
	@Before
	public void setUp() throws Exception {
		outCome = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outCome));
	}

	@After
	public void tearDown() throws Exception {
		System.setIn(System.in);
	}

	@Test
	public void testCalAverageGrade_985002509() {
		GradeSystem testGradeSystem = new GradeSystem();
		assertEquals(95.2, testGradeSystem.calAverageGrade("985002509",test),0);
		outCome.reset();
	}
	
	@Test
	public void testCalAverageGrade_985002510() {
		GradeSystem testGradeSystem = new GradeSystem();
		assertEquals(88.8, testGradeSystem.calAverageGrade("985002510",test),0);
		outCome.reset();
	}
	
	@Test
	public void testCalAverageGrade_985002510_changeWeights() {
		GradeSystem testGradeSystem = new GradeSystem();
		assertEquals(85.4, testGradeSystem.calAverageGrade("985002510",test2),0);
		outCome.reset();
	}

}
