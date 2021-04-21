# User Scenarios

###### tags: `Software Engineer`

## Normal Scenarios 正常使用

### 1. 螢幕 promptID 或 結束使用

```
使用者要結束使用
螢幕 showFinishMsg
```

### 2. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand:
顯示五種指令 1) 顯示成績 2) 顯示排名 3) 顯示平均 4) 更新配分 5) 離開選單
使用者要離開選單
螢幕 promptID 或 結束使用
使用者要結束使用
螢幕 showFinishMsg
```

### 3. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要顯示成績
螢幕 showGrade(ID)
螢幕 prompCommand 
使用者要離開選單
螢幕 promptID 或 結束使用
使用者要結束使用
螢幕 showFinishMsg
```
    
### 4. 螢幕 prompt ID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要顯示排名
螢幕 showRank(ID)
螢幕 prompCommand
使用者要離開選單
螢幕 promptID 或 結束使用
使用者要結束使用
```
    
### 5. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要 updateWeights (更新配分)
螢幕顯示舊配分
使用者輸入新配分之總和為 100%
使用者輸入 Y 確認新配分
螢幕 promptCommand
使用者要離開選單
螢幕 promptID 或 結束使用
使用者要結束使用
螢幕 showFinishMsg
```
    
### 6. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要 updateWeights (更新配分)
螢幕顯示舊配分
使用者輸入新配分之總和為 100%
使用者輸入 N 代表新配分輸入錯誤
螢幕 promptCommand
使用者要離開選單
螢幕 promptID 或 結束使用
使用者要結束使用
螢幕 showFinishMsg
```
    
## Exceptional scenarios 異常使用情節

### 7. 螢幕 promptID 或 結束使用

```
使用者輸入錯誤的 ID
螢幕顯示錯誤訊息
```

### 8. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者輸入不正確指令
螢幕顯示錯誤訊息
```

### 9. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要 updateWeights (更新配分)
螢幕顯示舊配分
使用者輸入新配分的總和不為 100%
螢幕顯示錯誤訊息
```

### 10. 螢幕 promptID 或 結束使用

```
使用者輸入 ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要 updateWeights (更新配分) 
螢幕顯示舊配分
使用者輸入新配分之總和為 100%
使用者輸入不正確指令
螢幕顯示錯誤訊息
```

## Acceptance Test Cases (紅色表示使用者輸入) 驗收測試案例

### 1. 螢幕顯示：輸入 ID 或 Q (結束使用)︖ Q

```
螢幕顯示：結束了
```

### 2. 螢幕顯示：輸入 ID 或 Q (結束使用)︖ 962001051

```
螢幕顯示：
Welcome 李威廷
1) G 顯示成績 (Grade)
2) R 顯示排名 (Rank)
3) A 顯示平均 (Average)
4) W 更新配分 (Weight)
5) E 離開選單 (Exit)
使用者輸入： E
螢幕顯示：輸入 ID 或 Q (結束使用)︖ Q
螢幕顯示：結束了
```

### 3. 開始至輸入指令如上

```
使用者輸入： G
螢幕顯示：
李威廷成績：
lab1： 81
lab2： 32* 註 低於 60 分需另外標記*
lab3： 50* 註 低於 60 分需另外標記*
mid-term : 90 註 依英文用字 mid 及 term 用 “-“ 連結為一字
final exam：93 註 依英文用字 final 及 exam 為兩字
total grade : 81
輸入指令如上
使用者輸入： E
螢幕顯示：輸入 ID 或 Q (結束使用)︖ Q
螢幕顯示：結束了
```

### 4. 開始至輸入指令如上

```
使用者輸入： R
螢幕顯示：
李威廷排名第 22 (例:李陳張 totalGrade 分別為 86 86 83 則其 rank 為 1 1 3)
輸入指令如上
使用者輸入： E
螢幕顯示：輸入 ID 或 Q (結束使用)︖ Q
螢幕顯示：結束了
```

### 5. 開始至輸入指令如上

```
使用者輸入：W
螢幕顯示
舊配分
lab1 10%
lab2 10%
lab3 10%
mid-term 30%
final exam 40%
輸入新配分
lab1 10
lab2 10
lab3 10
mid-term 10
final exam 60
請確認新配分
lab1 10%
lab2 10%
lab3 10%
mid-term 10%
final exam 60%
以上正確嗎? Y (Yes) 或 N (No)
使用者輸入：Y
螢幕顯示
 更新後的配分 10 10 10 10 60
輸入指令如上
使用者輸入： E
螢幕顯示：輸入 ID 或 Q (結束使用)︖ Q
螢幕顯示：結束了
```

### 6. 開始至輸入指令如上

```
使用者輸入：W
螢幕顯示
舊配分
lab1 10%
lab2 10%
lab3 10%
mid-term 30%
final exam 40%
輸入新配分
lab1 10
lab2 10
lab3 10
mid-term 10
final exam 60
請確認新配分
lab1 10%
lab2 10%
lab3 10%
mid-term 10%
final exam 60%
以上正確嗎? Y (Yes) 或 N (No)
使用者輸入：N
螢幕顯示：
回到選單
輸入指令如上
使用者輸入： E
螢幕顯示：輸入 ID 或 Q (結束使用)︖ Q
螢幕顯示：結束了
```

### 7. 螢幕顯示：輸入 ID 或 Q (結束使用)︖ 123456789

```
螢幕顯示：ID 錯了
```

### 8. 螢幕顯示：輸入 ID 或 Q (結束使用)︖ 962001051

```
輸入指令如上
使用者輸入： K
螢幕顯示：指令錯了
```

### 9. 開始至輸入指令如上

```
使用者輸入：W
螢幕顯示
舊配分
lab1 10%
lab2 10%
lab3 10%
mid-term 30%
final exam 40%
輸入新配分
lab1 10
lab2 10
lab3 10
mid-term 10
final exam 10
螢幕顯示
指令錯了
```

### 10. 開始至輸入指令如上

```
使用者輸入：W
螢幕顯示
舊配分
lab1 10%
lab2 10%
lab3 10%
mid-term 30%
final exam 40%
輸入新配分
lab1 asd
螢幕顯示
指令錯了
```
