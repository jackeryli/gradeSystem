package gradeSystem;

import java.util.ArrayList;
import java.util.Scanner;

import gradeSystem.NoSuchCommandException;

import java.io.*;
import java.text.DecimalFormat;
public class GradeSystem {
	
	/**
	 * 用來建構GradeSystem
	 * 
	 * pseudo code
	 *   1. 先將weights設定為initial_weights 
	 *   2. 使用bufferedReader跟FileReader讀取input.txt檔
	 *   3. 如果 (line=gradeList.readLine())!=null 則至4.執行loop，反之則至8.
	 *   4. 如果line的開始是utf8的start header，則去除之    //用以解決第一筆資料的問題
	 *   5. 將line用" "做切割，依序把資料丟入p中    				//p是aList的單元子
	 *   6. 再將p加入aList中
	 *   7. 回到3.
	 *   8. 將bufferedReader關起來
	 *   9. 完成建構GradeSystem
	 *
	*/
	public GradeSystem () {
		try{
    		this.weights = this.initial_weights;
    		//System.out.print(System.getProperty("user.dir"));
    		BufferedReader gradeList = new BufferedReader(new FileReader("input.txt"));
    		String line;
    		aList = new ArrayList<Person>();
    		while((line=gradeList.readLine())!=null){
    			if (line.startsWith("\uFEFF")) {
    		        line = line.substring(1);
    		    }
    			String [] parts = line.split(" ");
    			Person p = new Person();
    			p.ID = parts[0];
    			p.name = parts[1];
    			p.grade = new int[5];
    			for(int i=0; i<5; i++) p.grade[i] = Integer.valueOf(parts[i+2]);
    			aList.add(p);
    		}
    		gradeList.close();
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
	/**
	 * 回傳 GradeSystem 裡的 aList
	 * @return GradeSystem 裡的 aList
	 * 
	 * Pseudo code:
	 * 	因為這個變數是private, 需要給予一個 get function
	 */
	
	public ArrayList<Person> getaList(){
		return aList;
	}
   /**
	 * 用來查詢 GradeSystem 中是否包含ID
	 * @param ID 學生的ID
	 * @return 一個布林值，若 GradeSystem 中包含ID，則 return true，反之則 return false
	 *
	 * Pseudo code:
	 *   1. 透過loop找尋是否有此ID的資料
	 *   2. 若包含此ID，則先輸出歡迎訊息再 return true
	 *   3. 若沒有包含此ID，則 return false
	 *
	 * Time estimate: O(n)
	 * Example: 
	 *   containsID(962001051); 傳回結果為true
	 *   containsID(106062209); 傳回結果為false
	 */
    public boolean containsID(String ID){
    		//看aGradeSystem有否含此ID
    		int i=0, j=aList.size();
    		Person p;
    		while(i<j){
    			p = aList.get(i);
    			if((p.ID).equals(ID)) {
    				System.out.print("Welcome " + p.name + "\n");
    				return true;
    			}
    			else i++;
    		}
    		return false;
    }
    /*
     * 用來顯示某個人的成績
     * @param ID 用來查詢的ID
     * 
     * Pseudo code:
     *     1. 透過Loop找尋aList中相符的ID
     *     2. 找到之後，會先將五次的成績都輸出
     *     3. 呼叫 calAverageGrade(ID, weights)
     *     4. 將 calAverageGrade 回傳的值做四捨五入至小數點後第一位再輸出
     *     5. 如果不及格
     *     
     * Time estimate: O(n)
     * Example: 
     *		showGrade(962001051)
     * Output
     *	    李威廷成績: 
	 *			lab1: 81
	 *			lab2: 32*
	 *			lab3: 50*
	 *			mid-term: 90
	 *			final exam: 93
	 *			total grade: 80.5
     */
    public void showGrade(String ID){
    	//顯示各科成績、總成績
    	int i=0, j=aList.size();
		Person p;
		while(i<j){
			p = aList.get(i);
			if((p.ID).equals(ID)){
	    		DecimalFormat df = new DecimalFormat("##.0");
				System.out.print(p.name + "成績:\n");
				System.out.print("  lab1: " + p.grade[0] + showUnder60(p.grade[0]) + "\n");
				System.out.print("  lab2: " + p.grade[1] + showUnder60(p.grade[1]) + "\n");
				System.out.print("  lab3: " + p.grade[2] + showUnder60(p.grade[2]) + "\n");
				System.out.print("  mid-term: " + p.grade[3] + showUnder60(p.grade[3]) + "\n");
				System.out.print("  final: " + p.grade[4] + showUnder60(p.grade[4]) + "\n");
				double total_grade = Double.parseDouble(df.format(this.calAverageGrade(ID,this.weights)));
				System.out.print("  total: " + total_grade  + showUnder60(total_grade) + "\n");
				break;
			}
			else i++;
		}
    }
    /*
     * 用來顯示某個人的排名
     * 
     * @param ID 用來查詢的ID
     *
     * Pseudo code:
     *      1. 透過Loop找尋aList中相符的ID
     *      2. 呼叫 calAverageGrade(grade, weights)計算此ID的總成績（無四捨五入）
     * 		3. 先設rank=1，再以一次loop完整visit過aList，若有人加權後的成績比該生高，則rank+1
     *  	4. 輸出rank 
     *   
     * Time estimate: O(n^2)
     *   
     * Example: 
     *    showRank(962001051)
     * output: 
     *    李威廷的排名是：  第63名
     */
    public void showRank(String ID){
    	//顯示排名
		int i=0, j=aList.size(), rank = 1;
		double g = this.calAverageGrade(ID, this.weights);
		String name = new String();
		while(i<j){
			Person p = aList.get(i);
			if(this.calAverageGrade(p.ID, this.weights) > g) rank++;
			else if((p.ID).equals(ID)) name = p.name;
			i++;
		}
		System.out.print(name + "的排名是:  第" + rank + "名\n");
    }
    /**
	* 用來更新各項成績的權重
	* 
	* @throws NoSuchCommandException --
	* 若使⽤者輸入的權重加起來不等於100或輸入的不是數字, throws an object of NoSuchCommandExceptions
	* 
	* Pseudo code:
	*    1. 輸出舊的權重
	*    2. 輸入新的權重
	*    3. 計算權重的總和是否等於100
	*    4. 若不是，則 throws an object of NoSuchCommandExceptions
	*    5. 輸出新的權重並等待使用者確認
	*    6. 使用者輸入Y(Yes) or N(No)
	*    7. 若輸入為Y，則將該權重存入 aGradeSystem
	*    8. 若輸入為N，則 return
	*    9. 若輸入非Y且非N， 則 throws an object of NoSuchCommandExceptions
	* 
	* Time estimate: O(1)
	*    
	* Example: 
	*     updateWeights()
	* output:
	*     舊配分
	*         lab1 10%
	*          lab2 10%
	*          lab3 10%
	*          mid-term 30%
	*          final exam 40%
	*     輸入新配分
	*          lab1 20
	*          lab2 20
	*          lab3 20
	*          mid-term 20
	*          final exam 20
	*     請確認新配分
	*          lab1 20%
	*          lab2 20%
	*          lab3 20%
	*          mid-term 20% 
	*          final exam 20%
	*      以上正確嗎? Y (Yes) 或 N (No)
	*/      
    public void updateWeights() throws NoSuchCommandException{
	    	//更改權重
	    	this.displayOldWeights();
	    	this.fetchNewWeights();
	    	this.postNewWeights(this.initial_weights);
    }
    /*
    *  用來顯示某個人的成績
    *  
    *  @param ID 用來查詢的ID
    *  @param weights 用來表示各個成績的權重
    *
    *  @return double 回傳 data type 為double的平均成績
    *
    *  Pseudo code
    *    1. 先透過一次loop找尋該ID的資料
    *    2. 找到該ID後，將其每一科成績乘上該科成績的權重，再相加（最高應是10000分）
    *    3. 最後再將總分數除以100，算出最終的成績
    *    4. return 平均成績
    *
    *  Time estimate: O(n)
    *
    *  Example: 
    *     calculateWeights(962001051, [10, 10, 10, 30, 40])
    *     
    *  收到的return值: 
    *     80.5
    */
    public double calAverageGrade(String ID, int [] weights){
    	//計算平均成績  
		int i=0, j=aList.size();
		double g=0.0;
		Person p;
		while(i<j){
			p = aList.get(i);
			if((p.ID).equals(ID)){
				for(int k=0; k<5; k++) g = g + p.grade[k]*weights[k];
				break;
			}
			else i++;
		}
		g = g/100.0;
		return g;
    }
    /*
    * 用來取得現在各科成績的權重
    *
    * @return int [] 回傳現在各科成績的權重
    *
    * pseudo code:
    *   1. 因為weights是 private 的，所以透過這個function return weights的值
    *
    *  Time complexity : O(1)
    *  
    *  Example:
    *       getCurrentWeights();
    *  Return:
    *       [10, 10, 10, 30, 40]   
    */
    public int [] getCurrentWeights(){
    	return this.weights;
    }
    /**
     * 用來設定各科成績的權重
     *
     * @param new_weights
     *
     * pseudo code:
     *   1. 因為weights是 private 的，所以透過這個function 設定 weights的值
     *
     *  Time complexity : O(1)
     *  
     *  Example:
     *       setCurrentWeights([10,10,10,30,40]);
     */
    public void setCurrentWeights(int [] new_weights){
    	this.weights = new_weights;
    }
    private class Person{
		public String ID;
		public String name;
		public int[] grade;
	}
    /**
	 * @uml.property  name="aList"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="this$0:GradeSystem.GradeSystem$Person"
	 */
    
    /* aList用來記錄每一位學生的成績、姓名、ID，是個double linked list */
    private ArrayList<Person> aList;
    
    /**
	 * @uml.property  name="weights" multiplicity="(0 -1)" dimension="1"
	 */
    
    /* weights是個用來記錄現在各科成績的權重的array */
    private  int[] weights;
    
    /**
	 * 用來檢查分數是否低於60分
	 *
	 * @return String 如果低於60分則回傳*，否則就回傳個空個string
	 *
	 * pseudo code
	 *   1. 如果分數低於60分，則回傳"*"
	 *   2. 反之則回傳空的string回去
	 *
	 * time complexity : O(1)
	 *
	 * Example: showUnder60(59.9)  return "*"
	 * 					showUnder60(60.0)  return " "
	*/
    private String showUnder60(double grade){
    	if(grade < 60) return "*";
    	else	return "";
    }
    /**
	 * @uml.property  name="initial_weights" multiplicity="(0 -1)" dimension="1"
	 */
    
    /* initial_weights是初始的權重，單位是百分之一 */
    private int[] initial_weights={10,10,10,30,40};
    
    /**
	 * @uml.property  name="scan"
	 */
    
    /* 用來scan input */
    private Scanner scan = new Scanner(System.in);
    
    /**
	 * 用來顯示各科成績的權重
	 *
	 * @param int [] weights 依序代表lab1、lab2、lab3、mid-term、final exam的權重，單位是百分之一
	 *
	 * pseudo code
	 *   1. 輸出lab1所占的權重
	 *   2. 輸出lab2所占的權重
	 *   3. 輸出lab3所占的權重
	 *   4. 輸出mid-term所占的權重
	 *   5. 輸出final exam所占的權重
	 *
	 * time complexity : O(1)
	 *
	 * Example: displayWeights({10, 10, 10, 30, 40});
	 * 
	 * output:
	 *   lab1 10%
	 *   lab2 10%
	 *   lab3 10%
	 *   mid-term 30%
	 *   final exam 40%
	*/
    private void displayWeights(int [] weights){
    	System.out.print("  lab1 "+weights[0]+"%\n");
    	System.out.print("  lab2 "+weights[1]+"%\n");
    	System.out.print("  lab3 "+weights[2]+"%\n");
    	System.out.print("  mid-term "+weights[3]+"%\n");
    	System.out.print("  final exam "+weights[4]+"%\n");
    }
    /**
	 * 用來顯示舊的各科成績的權重
	 *
	 * pseudo code
	 *   1. 輸出"舊配分"
	 *   2. 呼叫displayWeights(this.weights)
	 *
	 * time complexity : O(1)
	 *
	 * Example: displayOldWeights();  //如果this.weights = {10, 10, 10 ,30, 40}
	 * 
	 * output:
	 * 舊配分
	 *   lab1 10%
	 *   lab2 10%
	 *   lab3 10%
	 *   mid-term 30%
	 *   final exam 40%
	*/
    private void displayOldWeights(){
    	System.out.print("舊配分\n");
    	this.displayWeights(this.weights);
    	
    }
    /**
	 * 用來顯示舊的各科成績的權重
	 *
	 * pseudo code
	 *   1. 輸出"新配分"
	 *   2. 輸出各科的名稱，再等待使用輸入新的配分，並檢查輸入的是否是integer
	 *   3. 如果輸入的不是integer則 throws NoSuchCommandException
	 *   4. 再重複2.四次 
	 *
	 * time complexity : O(1)
	 *
	 * Example1: fetchNewWeights()
	 * 
	 * output:
	 * 輸入配分
	 *   lab1 40%  //40%為使用者輸入
	 *   lab2 30%  //30%為使用者輸入
	 *   lab3 10%	 //10%為使用者輸入
	 *   mid-term 10%  //10%為使用者輸入
	 *   final exam 10%  //10%為使用者輸入
	 *
	 * Example2: fetchNewWeights()
	 * 
	 * output:
	 * 輸入配分
	 *   lab1 40%  //40%為使用者輸入
	 *   lab2 QQ  //QQ為使用者輸入
	 *   throws NoSuchCommandException
	*/
    private void fetchNewWeights() throws NoSuchCommandException{
    	try {
	    	int input[] = new int[5];
	    	System.out.print("輸入新配分\n");
	    	System.out.print("  lab1 ");
	    	input[0] = Integer.parseInt(this.scan.nextLine());
	    	System.out.print("  lab2 ");
	    	input[1] = Integer.parseInt(this.scan.nextLine());
	    	System.out.print("  lab3 ");
	    	input[2] = Integer.parseInt(this.scan.nextLine());
	    	System.out.print("  mid-term ");
	    	input[3] = Integer.parseInt(this.scan.nextLine());
	    	System.out.print("  final exam ");
	    	input[4] = Integer.parseInt(this.scan.nextLine());
	    	this.initial_weights = input;  	
    	}
    	catch(Exception e){
    		throw new NoSuchCommandException("");
    	}
    }
    /**
	 * @param arr
	 * @throws NoSuchCommandException
	 * @uml.property  name="weights"
	 */
    
    /**
	 * 用來確認輸入的新配分
	 *
	 * pseudo code
	 *   1. 如果輸入的五項權重加起來不等於100，則 throws NoSuchCommandException
	 *   2. 輸出"請確認新配分"
	 *   3. 呼叫displayWeights(new_weights)來輸出配分
	 *   4. 等待使用者輸入指令
	 *   5. 如果輸入的是"Y"則成功更新配分並回到選單
	 *   6. 如果輸入的是"N"則直接回到選單
	 *   7. 若非"Y"也非"N"則 throws NoSuchCommandException
	 *
	 * time complexity : O(1)
	 *
	 * Example1: postNewWeights({20, 20, 20, 20, 20})
	 * 
	 * output:
	 * 請確認新配分
	 *   lab1 20%
	 *   lab2 20%
	 *   lab3 20%
	 *   mid-term 20%
	 *   final exam 20%
	 * 以上正確嗎？ Y(Yes) or N(NO)
	 *
	 * input: Y
	 *
	 * output:
	 *
	 *   更新後的配分 20 20 20 20 20
	 *
	 * Example2: postNewWeights({20, 20, 20, 20, 20})
	 * 
	 * output:
	 * 請確認新配分
	 *   lab1 20%
	 *   lab2 20%
	 *   lab3 20%
	 *   mid-term 20%
	 *   final exam 20%
	 * 以上正確嗎？ Y(Yes) or N(NO)
	 *
	 * input: N
	 *
	 * output: 回到選單
	 *
	 * Example3: postNewWeights({10, 20, 20, 20, 20})
	 * 
	 * output: throws NoSuchCommandException
	 * 
	 *
	*/
    private void postNewWeights(int[] new_weights) throws NoSuchCommandException{
    		if(new_weights[0]+new_weights[1]+new_weights[2]+new_weights[3]+new_weights[4]!=100) 	throw new NoSuchCommandException("");
			System.out.print("請確認新配分\n");
			this.displayWeights(new_weights);
			System.out.print("  以上正確嗎？ Y(Yes) or N(NO)\n");
			String ch = "";
			if(scan.hasNextLine()) 	ch = this.scan.nextLine();
			if(ch.equals("Y")){
				this.weights = new_weights;
				System.out.print("  更新後的配分 "+this.weights[0]+" "+this.weights[1]+" "+this.weights[2]+" "+this.weights[3]+" "+this.weights[4]  + "\n");
			}
			else if(ch.equals("N")) System.out.print("回到選單\n");
			else throw new NoSuchCommandException("");
    }
}

