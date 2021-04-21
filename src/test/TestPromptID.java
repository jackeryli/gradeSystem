package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.NoSuchIDException;
import gradeSystem.UI;

/*
 * Unit test
 * TestPromptID
 * 
 * case1: enter valid ID 985002509 and Exit the program normally
 * case2: enter Q to leave the program
 * case3: enter ID 106062209 which not inside the program
 * case4: enter invalid ID a1234
 */
public class TestPromptID {

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
	public void testPromptID_validID() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nE\nQ".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "Welcome 蔡宗衛\n";
		expect += "1) G 顯⽰成績 (Grade)\n";
		expect += "2) R 顯⽰排名 (Rank)\n";
		expect += "3) A 顯⽰平均 (Average)\n";
		expect += "4) W 更新配分 (Weight)\n";
		expect += "5) E 離開選單 (Exit)\n";
		expect += "輸入ID或Q\n";
		expect += "結束了\n";
		
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	@Test
	public void testPromptID_Q() throws Exception{
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "結束了\n";
		assertEquals(expect, outCome.toString());
	}
	@Test(expected=NoSuchIDException.class)
	public void testPromptID_notFound_ID() throws Exception{
		System.setIn(new ByteArrayInputStream("106062209\n".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "結束了\n";
		assertEquals(expect, outCome.toString());
	}
	@Test(expected=NoSuchIDException.class)
	public void testPromptID_invalidID() throws Exception{
		System.setIn(new ByteArrayInputStream("a12345\n".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "結束了\n";
		assertEquals(expect, outCome.toString());
	}
	

}
