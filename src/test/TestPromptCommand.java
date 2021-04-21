package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.NoSuchCommandException;
import gradeSystem.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
 * Unit test
 * TestPromptCommand
 * 
 * input| actions  | function
 *------|--------- |-------------------
 *    G | 顯示成績  | showGrade(ID)
 *    R | 顯示排名  | showRank(ID)
 *    A | 顯示平均  | print calAverageGrade(grade)
 *    W | 更新配分  | updateWeights()
 *    E | 離開選單  | return
 * 
 * W 因為 Scanner 的問題無法測試
 * 但是我們有單獨設計其他的function來協助我們確認Ｗ的功能是正常的
 * 我們的程式提供 setWeights( int [] new_weights) 給 unit test 使用
 * 讓我們可以更改weights的值來看看學生的grade, rank, average 是否會隨著weights改變而改變
 * 另外updateWeights()我們有單獨做測試，確認過是正常的
 * 
 */
public class TestPromptCommand {

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
	public void testPromptCommand_G() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nG\nE\nQ\n".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "Welcome 蔡宗衛\n";
		expect += "1) G 顯⽰成績 (Grade)\n";
		expect += "2) R 顯⽰排名 (Rank)\n";
		expect += "3) A 顯⽰平均 (Average)\n";
		expect += "4) W 更新配分 (Weight)\n";
		expect += "5) E 離開選單 (Exit)\n";
		
		expect += "蔡宗衛成績:\n";
		expect += "  lab1: 84\n";
		expect += "  lab2: 92\n";
		expect += "  lab3: 98\n";
		expect += "  mid-term: 94\n";
		expect += "  final: 99\n";
		expect += "  total: 95.2\n";
		
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
	public void testPromptCommand_R() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nR\nE\nQ\n".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "Welcome 蔡宗衛\n";
		expect += "1) G 顯⽰成績 (Grade)\n";
		expect += "2) R 顯⽰排名 (Rank)\n";
		expect += "3) A 顯⽰平均 (Average)\n";
		expect += "4) W 更新配分 (Weight)\n";
		expect += "5) E 離開選單 (Exit)\n";
		
		expect += "蔡宗衛的排名是:  第1名\n";
		
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
	public void testPromptCommand_A() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nA\nE\nQ\n".getBytes()));
		UI ui = new UI();
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "Welcome 蔡宗衛\n";
		expect += "1) G 顯⽰成績 (Grade)\n";
		expect += "2) R 顯⽰排名 (Rank)\n";
		expect += "3) A 顯⽰平均 (Average)\n";
		expect += "4) W 更新配分 (Weight)\n";
		expect += "5) E 離開選單 (Exit)\n";
		
		expect += "95.2\n";
		
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
	/*
	@Test
	public void testPromptCommand_W() throws Exception{
		
		UI ui = new UI();
		System.setIn(new ByteArrayInputStream("985002509\nW\n10\n10\n10\n10\n60\n".getBytes()));
		String expect = "";
		expect += "輸入ID或Q\n";
		expect += "Welcome 蔡宗衛\n";
		expect += "1) G 顯⽰成績 (Grade)\n";
		expect += "2) R 顯⽰排名 (Rank)\n";
		expect += "3) A 顯⽰平均 (Average)\n";
		expect += "4) W 更新配分 (Weight)\n";
		expect += "5) E 離開選單 (Exit)\n";
		
		expect += "舊配分\n";
		expect += "  lab1: 10%\n";
		expect += "  lab2: 10%\n";
		expect += "  lab3: 10%\n";
		expect += "  mid-term: 30%\n";
		expect += "  final exam: 40%\n";
    	
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
		
		expect += "輸入ID或Q\n";
		expect += "結束了\n";
		
		
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	*/
	@Test
	public void testPromptCommand_E() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nE\nQ\n".getBytes()));
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
	@Test(expected=NoSuchCommandException.class)
	public void testPromptCommand_invalid() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nK\n".getBytes()));
		UI ui = new UI();
		
	}

}
