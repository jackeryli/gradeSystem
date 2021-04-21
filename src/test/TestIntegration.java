package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import gradeSystem.UI;

/**
 * Integration test
 * TestIntegration
 * 
 * case1: 輸入學號 >> G(顯示成績） >> R（顯示排名 >> A（顯示平均 >> E（離開選單 >> Q（結束程式
 * case2: 分割測試
 * 
 * Ｗ（更改配分）
 * 
 * W 因為 Scanner 的問題無法測試
 * 但是我們有單獨設計其他的function來協助我們確認Ｗ的功能是正常的
 * 我們的程式提供 setCurrentWeights( int [] new_weights) 給 unit test 使用
 * 也有提供getCurrentWeights() 來獲取當下的 weights 資料
 * 讓我們可以更改weights的值來看看學生的grade, rank, average 是否會隨著weights改變而改變
 * 另外updateWeights()我們有單獨做測試，確認過是正常的
 */
public class TestIntegration {

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
	public void test_integration_1() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nG\nR\nA\nE\nQ\n".getBytes()));
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
		
		expect += "蔡宗衛的排名是:  第1名\n";
		
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
		
		//System.out.println(expect);
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	/*
	@Test
	public void test_integration_2() throws Exception{
		System.setIn(new ByteArrayInputStream("985002509\nW\nasd\n".getBytes()));
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
		
		expect += "蔡宗衛的排名是:  第1名\n";
		
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
		
		//System.out.println(expect);
		assertEquals(expect, outCome.toString());
		outCome.reset();
	}
	*/

}
