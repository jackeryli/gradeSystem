package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;

/*
 * Unit test
 * TestGradeSystemConstructor
 * 
 * case1: 
 * 		1. Check GradeSystem's aList is not NULL
 * 		2. Check GradeSystem's aList.size == 63
 * 		3. Check GradeSystem's weight is [10,10,10,30,40]
 */
public class TestGradeSystemConstructor {

	GradeSystem testGradeSystem = null;
	@Before
	public void setUp() throws Exception {
		testGradeSystem = new GradeSystem();
	}

	@After
	public void tearDown() throws Exception {
		testGradeSystem = null;
	}

	@Test
	public void test() {
		assertNotNull(testGradeSystem.getaList());
		assertEquals(testGradeSystem.getaList().size(),63,0);
		int [] test = {10,10,10,30,40};
		assertArrayEquals(testGradeSystem.getCurrentWeights(), test);
	}

}
