package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
 * Unit test
 * TestShowGrade
 * case1: ID 985002509
 * case2: ID 962001051
 * case3: ID 985002510 but update weight to [10,10,10,10,60] 
 */
public class TestShowGrade {
	
	/**
	 * @uml.property  name="outCome"
	 */
	private ByteArrayOutputStream outCome = null;
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
	public void testShowGrade_985002509() {
		GradeSystem testGradeSystem = new GradeSystem();
		
		testGradeSystem.showGrade("985002509");
		String expect = "";
		expect += "蔡宗衛成績:\n";
		expect += "  lab1: 84\n";
		expect += "  lab2: 92\n";
		expect += "  lab3: 98\n";
		expect += "  mid-term: 94\n";
		expect += "  final: 99\n";
		expect += "  total: 95.2\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	@Test
	public void testShowGrade_985002510() {
		GradeSystem testGradeSystem = new GradeSystem();
		
		testGradeSystem.showGrade("962001051");
		String expect = "";
		expect += "李威廷成績:\n";
		expect += "  lab1: 81\n";
		expect += "  lab2: 32*\n";
		expect += "  lab3: 50*\n";
		expect += "  mid-term: 90\n";
		expect += "  final: 93\n";
		expect += "  total: 80.5\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	@Test
	public void testShowGrade_985002510_changeWeight() {
		GradeSystem testGradeSystem = new GradeSystem();
		int [] test = {10,10,10,10,60};
		testGradeSystem.setCurrentWeights(test);
		testGradeSystem.showGrade("962001051");
		String expect = "";
		expect += "李威廷成績:\n";
		expect += "  lab1: 81\n";
		expect += "  lab2: 32*\n";
		expect += "  lab3: 50*\n";
		expect += "  mid-term: 90\n";
		expect += "  final: 93\n";
		expect += "  total: 81.1\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}

}
