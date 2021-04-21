package gradeSystem;

import java.text.DecimalFormat;
import java.util.Scanner;
import gradeSystem.GradeSystem;
import gradeSystem.NoSuchCommandException;
import gradeSystem.NoSuchIDException;

public class UI {
	/**
	 * 用來建構UI
	 *
	 * pseudo code
	 * 1. 呼叫 GradeSystem() 來建構 aGradeSystem
	 * 2. 如果 promptID==true 執行3. 反之則執行5     //outer loop
	 * 3. 呼叫 showWelcomeMsg()    //inner loop
	 * 3. 如果 promptCommand()==true ，回到3.
	 * 4. 如果 promptCommand()==false ，回到2. //input為E
	 * 5. 結束UI建構子
	 *
	*/
	public UI() throws NoSuchIDException, NoSuchCommandException {
		//建構子
			this.aGradeSystem = new GradeSystem();
			while(this.promptID()) {
				while(true){
					this.showWelcomeMsg();
					if(this.promptCommand() == false)	break;
				}
			} 
	}
   /**
	* 用來根據輸入的指令執行不同的命令
	* @param  string 指令
	* @return 若使用者為E的話，return false 其餘的 return true
	* @throws NoSuchCommandExceptions --
	*  若使⽤者輸入非可用的指令，則throws an object of NoSuchCommandExceptions
	*  
	* Pseudo code:
	*   1. 使用者輸入指令
	*   2. 若為G， 則呼叫 aGradeSystem 裡的 showGrade(ID)
	*   3. 若為R， 則呼叫 aGradeSystem 裡的 showRank(ID)
	*   4. 若為A， 則透過loop找尋該ID在 aList 中的 grade，並傳入calAverageGrade(grade) 做計算，再輸出
	*   5. 若為W， 則呼叫 aGradeSystem 裡的 updateWeights()
	*   6. 若為E， 則呼叫 showMenu()，並 return false
	*   7. 若非上述指令，則 throws an object of NoSuchCommandExceptions
	*   8. return true
	* 
	* Time estimate: O(n)
	* 
	* Example:
	*         input| actions | function
	*	  	  -----|---------|--------------
	*		  G    | 顯示成績  | showGrade(ID)
	*		  R    | 顯示排名  | showRank(ID)
	*		  A    | 顯示平均  | print calAverageGrade(grade)
	*		  W    | 更新配分  | updateWeights()
	*		  E    | 離開選單  | return
	*/ 
	public boolean promptCommand() throws NoSuchCommandException{
		String command = "";
		command = this.scan.nextLine();
		if(command.equals("G"))			aGradeSystem.showGrade(ID);
		else if(command.equals("R"))		aGradeSystem.showRank(ID);
		else if(command.equals("A"))	{
    			DecimalFormat df = new DecimalFormat("##.0");
			System.out.print(Double.parseDouble(df.format(aGradeSystem.calAverageGrade(ID,aGradeSystem.getCurrentWeights()))) + "\n");
		}
		else if(command.equals("W"))		aGradeSystem.updateWeights();
		else if(command.equals("E"))	 return false;
		else throw new NoSuchCommandException("no such command error"); 
		return true;
		
	}
	/**
	* 用來顯示介面 `輸入ID或 Q (結束使⽤) ?` 並接收下一步指令
	* 
	* @return 當使用者輸入的ID是可以被搜尋到的，返回 true, 若否，返回 false
	* @throws NoSuchIDExceptions --
	*  若使⽤者輸入非Q且為無法搜尋到的ID，則throws an object of NoSuchIDException
	*  
	* Pseudo code:
	* 1. 輸出訊息 `輸入ID或 Q (結束使⽤) ?`
	* 2. 使用者輸入ID或Q
	* 3. 若使用者輸入Q，則 showFinishMsg()
	* 4. 若使用者輸入不為Q，則呼叫 checkID(string)
	* 5. 若 checkID(string) 結果為 true，return true
	* 6. 若 checkID(string) 結果為 false ，則 throws an object of NoSuchIDException
	*/
	public boolean promptID() throws NoSuchIDException{
		System.out.print("輸入ID或Q\n");
		String str1 = scan.nextLine();
		// equals 才可, == 不行 （因記憶體位址不同
		if(str1.equals("Q")){
			showFinishMsg();
			return false;
		}
		else{
			if(aGradeSystem.containsID(str1)){
				ID = str1;
				return true;
			}
			else throw new NoSuchIDException("");
		}
	}
	private void showFinishMsg(){
		System.out.print("結束了\n");
	}
	private void showWelcomeMsg(){
		System.out.print("1) G 顯⽰成績 (Grade)\n");
		System.out.print("2) R 顯⽰排名 (Rank)\n");
		System.out.print("3) A 顯⽰平均 (Average)\n");
		System.out.print("4) W 更新配分 (Weight)\n");
		System.out.print("5) E 離開選單 (Exit)\n");
		
	}
    /**
	 * @uml.property  name="aGradeSystem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private GradeSystem aGradeSystem;
    /**
	 * @uml.property  name="iD"
	 */
    private String ID;                 //輸入的指令
    /**
	 * @uml.property  name="scan"
	 */
    private Scanner scan = new Scanner(System.in);
	
}

