package gradeSystem;

import gradeSystem.UI;

import gradeSystem.NoSuchCommandException;
import gradeSystem.NoSuchIDException;

/**
 * ########################################################
本Grade system 讓使用者(學生)取得他的總成績total grade 及排名 rank. 
Total grade 基於配分weights 來算 而 weights可以update.
Rank 表示此 total grade 在全班學生的分數排序
Input file: 全班學生的分數 例如
962001044 凌宗廷 87 86 98 88 87
962001051 李威廷 81 32 50 90 93 

注意 data field names 如下:
     ID name lab1 lab2 lab3 midTerm finalExam

 */

/**
 * public class Main extends Object {
 * 		public static void main (String args[]) 
 *    		try { call UI() 建構 aUI } end try
 * 			catch (NoSuchIDExceptions e1) {print msg1} //ex ID錯了! 
 * 			catch (NoSuchCommandExceptions e2) {print msg2}//ex指令錯了!
 * end class Main
 * @import public class NoSuchIDExceptions extends Exception { } 
 * @import public class NoSuchCommandExceptions extends Exception { }

 */
public class main {
	public static void main(String[] args) {
		try{
			UI ui = new UI();
		}
		catch(NoSuchCommandException e){
			System.out.println("指令錯了");
		}
		catch(NoSuchIDException e){
			System.out.println("ID錯了");
		}
	}
}


