# BWS_IronMan_Practice_ChattingRoom
城市鐵男─程式鐵男 ~


總審文案已上傳至Google共用區。
APP Server- **EC2 runs the Java TriMago Servlet** followed by 專研筆電 Server. Loading balance with **Azure VM**.


Note:

2016/
December - 

  -學習合作機制 - **Github**
  -開始**功能發散** 
    -使用便條紙寫下所有可行功能 
    -湊齊所有功能形成一個主題
    -投票將主題進行篩選 

January -  

  - Github合作漸漸流暢 
  - 持續功能發散 思考主題
  - 為訓練合作性而決定先撰寫一個簡單的聊天室專案 **城市鐵男** 
    - (曾) 負責ER相關資料庫設計訓練
    - (黃) 負責伺服器相關 -> 筆電借不到 
    - (林) 負責網頁以及設計圖 
    - (水) 著手帶隊開發網頁前後端以及專研時程規劃 
  
Feburary -

  - 持續功能發散 思考主題
    - 思考發散經過的主題 (舉行投票)
      - (曾) 多功能鬧鐘
      - (林) 健康水壺
      - (黃) 運動計分系統
      - (水) 情侶情緒處理平台  ->  投票結果
    - 情侶情緒處理平台命名 -> **InterLove**
  - 著手進行InterLove的功能發散 (發散點更集中)    
  -  (水) 進行時程分析 Gantt Chart, WBS 分析

March-

  - (水) 帶領功能發散進行匯集 -> 總共多達70項功能
  - InterLove 可行性持續受到審查
  - 因為 Github效率之差而開發引發另一個專研主題想法 -> **團隊合作平台**
  - 城市鐵男開發及訓練結束 (尚未完成，不過卻得到了許多寶貴的合作機制)
  - 借了一台專研筆電，但是幾天內就炸了。

April-

  - **團隊合作平台**功能慢慢齊全，認為可以取代**InterLove** (再見...)。
  - (水) 正式報告 團隊合作平台的提案
  - (水) 給予正式投票命名 -> 結果 **TeamPathy** 面世
  - 開發時程開始 (WBS -> Gantt chart)
    - (曾) 負責 ER圖 資料後設計
    - (林) 負責 APP介面設計發想 色碼攝取協調設計 以及助手
    - (黃) 負責 後端伺服器設置, EC2 了解 (又借了一台新筆電，貌似還活著)
    - (水) 負責 APP 前後端主要開發以及帶隊

May-
  - (黃) 持續尋找後端伺服器的資源 並架設專研筆電在專研辦公室 負責遠端知識
    -  專研筆電架設成功 
  - (曾) 持續設計ER圖 每次報告持續完善
  - (水) Android 主要介面開發迅速
    - 套用單機模組
    - 風格固定
  - (林) 以友情價替專研 取得較低價格的 **TeamPathy**的主要Logo !!
    - 介面設計已經提供完善 管線化支援前端開發
    - 學習 Javascript -> 已提供 Google Chart API 知識 -> For WBS & Gantt API 
    - 學習 Android 基本 Layout

June-
  - (黃/水) 使用EC2作為備案伺服器 -> 目前 [TriMago](teampathy.tk:8080/TriMago) 持續運行在EC2上 
  - (曾) ER圖漸漸審核完畢
    - 並開始設計存放WBS資料的XML結構
    - XML Stub data
  - (林) 完成 Gantt Chart API 以及 WBS Chart API 之相關知識提供
    - 開始協助(水)開發介面
  - (水) 持續學習後端開發 **ASP.NET MVC** 
    - Android APP開發暫緩
  - **期末考**進度不彰

July-
  - (水) 開始實習
    - Android 最大改變 引入 **RxAndroid & Dagger IOC/DI Framework**
    - 學到了 **Clean Architecture** 架構，決定**重構** TeamPathy
  - (水/林) 迅速重構以及開發新的TeamPathy，合力撰寫超過50個類別。
    - 成功引入XML-XSL系統作為 Gantt, WBS 繪圖技術底層
    - Repository層進行模組單元測試  
  - (黃) 進行遠端SQL Server及IIS 設置
    - 遇到 EC2 權限問題 無法安裝SQL Server
  - (曾) 轉職 行銷組長，為專研發揮呈現面及規劃出路
    - 拒絕參與了一項額外比賽 => 主題不符TeamPathy
    - PPT專案著手進行
August-

September-

October-
