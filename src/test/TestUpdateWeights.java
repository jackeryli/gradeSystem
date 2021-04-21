package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystem;
import gradeSystem.NoSuchCommandException;

/*
 * Unit test
 * TestUpdateWeights
 * 
 * case1: new_weights = [10,10,10,10,60] and update successfully
 * case2: new_weights = [10,10,10,10,60] but back to menu
 * case3: new_weights = [10,10,10,10,60] but enter invalid command
 * case4: new_weights = [10,10,10,10,10] invalid input
 * 
 */
public class TestUpdateWeights {

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
	public void testUpdateWeights_YES() throws Exception{
		System.setIn(new ByteArrayInputStream("10\n10\n10\n10\n60\nY\n".getBytes()));
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.updateWeights();
		String expect = "";
		expect += "舊配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 30%\n";
		expect += "  final exam 40%\n";
    	
		expect += "輸入新配分\n";
		expect += "  lab1 ";
		expect += "  lab2 ";
		expect += "  lab3 ";
		expect += "  mid-term ";
		expect += "  final exam ";
		
		expect += "請確認新配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 10%\n";
		expect += "  final exam 60%\n";
		expect += "  以上正確嗎？ Y(Yes) or N(NO)\n";
		
		expect += "  更新後的配分 10 10 10 10 60\n";
		
		assertEquals(expect, outCome.toString());
		int [] test = {10,10,10,10,60};
		assertArrayEquals(testGradeSystem.getCurrentWeights(),test);
		outCome.reset();
	}
	@Test
	public void testUpdateWeights_NO() throws Exception{
		System.setIn(new ByteArrayInputStream("10\n10\n10\n10\n60\nN\n".getBytes()));
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.updateWeights();
		String expect = "";
		expect += "舊配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 30%\n";
		expect += "  final exam 40%\n";
    	
		expect += "輸入新配分\n";
		expect += "  lab1 ";
		expect += "  lab2 ";
		expect += "  lab3 ";
		expect += "  mid-term ";
		expect += "  final exam ";
		
		expect += "請確認新配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 10%\n";
		expect += "  final exam 60%\n";
		expect += "  以上正確嗎？ Y(Yes) or N(NO)\n";
		
		expect += "回到選單\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	@Test(expected=NoSuchCommandException.class)
	public void testUpdateWeights_invalid_command() throws Exception{
		System.setIn(new ByteArrayInputStream("10\n10\n10\n10\n60\nK\n".getBytes()));
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.updateWeights();
		String expect = "";
		expect += "舊配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 30%\n";
		expect += "  final exam 40%\n";
    	
		expect += "輸入新配分\n";
		expect += "  lab1 ";
		expect += "  lab2 ";
		expect += "  lab3 ";
		expect += "  mid-term ";
		expect += "  final exam ";
		
		expect += "請確認新配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 10%\n";
		expect += "  final exam 60%\n";
		expect += "  以上正確嗎？ Y(Yes) or N(NO)\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	@Test(expected=NoSuchCommandException.class)
	public void testUpdateWeights_invalid_weights() throws Exception{
		System.setIn(new ByteArrayInputStream("10\n10\n10\n10\n10\nK\n".getBytes()));
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.updateWeights();
		String expect = "";
		expect += "舊配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 30%\n";
		expect += "  final exam 40%\n";
    	
		expect += "輸入新配分\n";
		expect += "  lab1 ";
		expect += "  lab2 ";
		expect += "  lab3 ";
		expect += "  mid-term ";
		expect += "  final exam ";
		
		expect += "請確認新配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 10%\n";
		expect += "  final exam 60%\n";
		expect += "  以上正確嗎？ Y(Yes) or N(NO)\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	@Test(expected=NoSuchCommandException.class)
	public void testUpdateWeights_invalid_weights_input() throws Exception{
		System.setIn(new ByteArrayInputStream("asd\n".getBytes()));
		GradeSystem testGradeSystem = new GradeSystem();
		testGradeSystem.updateWeights();
		String expect = "";
		expect += "舊配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 30%\n";
		expect += "  final exam 40%\n";
    	
		expect += "輸入新配分\n";
		expect += "  lab1 ";
		expect += "  lab2 ";
		expect += "  lab3 ";
		expect += "  mid-term ";
		expect += "  final exam ";
		
		expect += "請確認新配分\n";
		expect += "  lab1 10%\n";
		expect += "  lab2 10%\n";
		expect += "  lab3 10%\n";
		expect += "  mid-term 10%\n";
		expect += "  final exam 60%\n";
		expect += "  以上正確嗎？ Y(Yes) or N(NO)\n";
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
}
