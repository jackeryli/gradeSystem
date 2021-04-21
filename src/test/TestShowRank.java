package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;

/*
 * Unit test
 * TestShowRank
 * 
 * case1: ID 985002509
 * case2: ID 985002510
 * case3: ID 985002510 but change weight to [0,0,0,100,0]
 */
public class TestShowRank {

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
	}

	@Test
	public void testShowRank_985002509() {
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.showRank("985002509");
		String expect = "蔡宗衛的排名是:  第1名\n";
		assertEquals(expect, outCome.toString());
	}
	@Test
	public void testShowRank_985002510() {
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.showRank("985002510");
		String expect = "黃朝偉的排名是:  第36名\n";
		assertEquals(expect, outCome.toString());
	}
	@Test
	public void testShowRank_985002510_changeWeights() {
		GradeSystem testGradeSystem = new GradeSystem();
		int [] test = {0,0,0,100,0};
		testGradeSystem.setCurrentWeights(test);
		testGradeSystem.showRank("985002510");
		String expect = "黃朝偉的排名是:  第4名\n";
		assertEquals(expect, outCome.toString());
	}

}
