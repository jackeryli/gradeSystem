# GradeSystem 介紹

本成績系統讀入全班成績有： lab1、lab2、 lab3、mid-term、 final exam 等成績，內建各成績的配分為 10%, 10%, 10%, 30%, 40%，依配分算出總成績建檔後，供使⽤者輸入指令查詢成績及排名，並可更新配分重算總成績，系統可處理兩種異常： (1) 輸入錯誤 ID (2) 輸入不正確指令

[使用者情境介紹](user-scenarios.md)
系統主要畫面如下

螢幕顯示：輸入 ID 或 Q 使用者輸入 ID 如蔡宗衛的 ID 985002509

螢幕顯示：

```
輸入ID或Q
985002509
Welcome 蔡宗衛
1) G 顯示成績 (Grade)
2) R 顯示排名 (Rank)
3) A 顯示平均 (Average)
4) W 更新配分 (Weight)
5) E 離開選單 (Exit)
```

如輸入指令 G 螢幕顯示：

```
G
蔡宗衛成績:
    lab1: 84
    lab2: 92
    lab3: 98
    mid-term: 94
    final: 99
    total: 95.2
```

如輸入指令 R 螢幕顯示：

```
R
蔡宗衛的排名是: 第1名
```

如輸入指令 A 螢幕顯示：

```
A
95.2
```

如輸入指令 W 螢幕顯示： 使用者輸入新配分: `10 10 10 10 60`

```
W
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
    
```

接著會確認是否確定要更改配分，如果確定無誤，輸入 Y ，並顯示

```
以上正確嗎? Y(Yes) or N(No)
Y
更新後的配分 10 10 10 10 60
```


如果有錯誤，則輸入 N 取消這次輸入，並顯示

```
以上正確嗎? Y(Yes) or N(No)
N
回到選單
```

使用者接著不斷輸入上述指令，直到輸入 E（離開選單），螢幕再度顯示：

```
1) G 顯示成績 (Grade)
2) R 顯示排名 (Rank)
3) A 顯示平均 (Average)
4) W 更新配分 (Weight)
5) E 離開選單 (Exit)
E
輸入ID或Q
```

使用者輸入 Q 系統就結束了，此時螢幕顯示：

```
Q
結束了
```
