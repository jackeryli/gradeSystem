package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;

/*
 * Unit test
 * TestPromptCommand
 * 
 * case1: ID 106062209
 * case2: ID 985002509
 */
public class TestContainsID {

	private GradeSystem testGradeSystem = null;
	@Before
	public void setUp() throws Exception {
		testGradeSystem = new GradeSystem();
	}

	@After
	public void tearDown() throws Exception {
		testGradeSystem = null;
	}

	@Test
	public void testContainsID_invalid() {
		assertFalse("",testGradeSystem.containsID("106062209"));
	}
	@Test
	public void testContainsID_valid() {
		assertTrue("",testGradeSystem.containsID("985002509"));
	}
}
