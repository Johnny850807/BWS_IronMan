# BWS_IronMan_Practice_ChattingRoom
城市鐵男─程式鐵男 ~


總審文案已上傳至Google共用區。
APP Server- **EC2 runs the Java TriMago Servlet** followed by 專研筆電 Server. Loading balance with **Azure VM**.


Note:

>2016/

December - **TeamPathy Start from here !**

  - (水)引入並奠定未來一年的合作機制 - **Github** 以提升效率
  - 開始**功能發散** 思考專研主題
    - 使用便條紙寫下所有可行功能 
    - 湊齊並篩選所有功能形成一個主題
    - 歷經兩個主題 
      - 自動作曲 APP 
      - 翻轉教室 - 21救星 

>2017/

January -  

  - Github合作漸漸流暢 
  - 持續功能發散 思考主題
  - 審查先前主題可行性
    -  自動作曲 APP -> 只有(水)有相關的音樂Know how, 合作困難 -> 不可行
    -  翻轉教室 - 21救星 -> 主題發揮性質不高 -> 保留
  - 為訓練合作習慣而決定先撰寫一個簡單的線上聊天室專案 **城市鐵男** 
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
    - 情侶情緒處理平台命名 -> **InterLove** -> Interaction with Love
  - 著手進行InterLove的功能發散 (發散點更集中)    
  - (水) 徒手撰寫了九千字，將近五十頁的初審文案。
  - (水) 進行時程分析 Gantt Chart, WBS 分析 並彙整報告

March-

  - (水) 帶領功能發散進行匯集 -> 總共多達70項功能
  - **InterLove 可行性持續受到審查**
  - 因為 專研合作時使用Github遇到一些問題而引發另一個專研主題想法 -> **行動化團隊合作平台**
  - 城市鐵男開發及訓練結束 (尚未完成，不過卻奠定了許多寶貴的合作機制)
  - 借了一台專研筆電，但是幾天內就炸了。(87)

April-

  - **團隊合作平台**功能發想慢慢齊全，認為可以取代**InterLove** (再見...)。
  - (水) 正式報告 團隊合作平台的提案 Proposal
  - (水) 給予正式投票命名 -> 結果 **TeamPathy** 面世 -> Teamwork with Empathy (卓學恩教得很好)
  - 開發時程開始 (WBS -> Gantt chart分析)
    - (曾) 負責 ER圖 資料後設計
    - (林) 負責 APP介面設計發想 色碼協調設計 以及擔任APP助手
    - (黃) 負責 後端伺服器設置, EC2 了解 (又借了一台新筆電，貌似還活著)
    - (水) 負責 APP 前後端主要開發以及帶隊

May-
  - (黃) 持續尋找後端伺服器的資源 並架設專研筆電在專研辦公室 負責遠端知識
    -  專研筆電架設成功 (這台不錯)
  - (曾) 持續設計ER圖 每次報告時持續完善及更正
  - (水) Android 主要介面開發迅速
    - 系統設計文案皆上傳
    - 目前套用單機模組
    - APP主題風格已經固定
  - (林) 以友情價請到設計師替專研 設計 **TeamPathy**的主要Logo !!
    - 介面設計已經提供完善 管線化支援(水)前端開發 -> 效率直接翻倍 -> 雖然一直被我罵
    - 學習 Javascript -> 著手 Study Google Chart API 知識 -> For WBS & Gantt API 
    - 學習 Android 基本 Layout 

June-
  - (黃/水) 使用**EC2**作為備案伺服器 -> 目前 [TriMago](teampathy.tk:8080/TriMago) 持續運行在EC2上 
  - (曾) ER圖漸漸審核完畢 
    - 並開始設計存放WBS資料的XML結構
    - 撰寫XML Stub data
  - (林) 完成 Gantt Chart API 以及 WBS Chart API 之相關知識提供
    - 開始協助(水)開發介面
  - (水) 持續學習後端開發 **ASP.NET MVC** 
    - Android APP開發暫緩 (而且APP架構耦合度高 -> 寫得有點疲倦 -> 重新系統設計)
  - **期末考**進度不彰

July-  **暑假開始**
  - 暑修的暑修，上班的上班，(水) 開始實習
  - (水) 對 TeamPathy的願景重新定義 -> We should refactor it into another model design.
    - Android 最大改變 引入 **RxAndroid & Dagger IOC/DI Framework**
    - 學到了 **Clean Architecture** 架構，發布專案正式決定**完整重構** TeamPathy
  - (水/林) 迅速重構以及開發新的TeamPathy，合力撰寫超過50個類別。
    - 重構完成後提升APP效率及UX
    - 成功引入XML-XSL系統作為 Gantt, WBS 繪圖技術底層
    - Repository層進行模組單元測試  
  - (黃) 進行遠端SQL Server及IIS 設置
    - 遇到 EC2 權限問題 無法安裝SQL Server
    - 筆電伺服器環境尚未設置完全
  - (曾) 轉職 行銷組長，為專研發揮呈現面及規劃出路
    - 拒絕參與了一項額外比賽 => 主題不符TeamPathy
    - PPT專案著手進行 (但對**參加特優組不用報告這件事很不爽**)
August-
  - 暑假完全不需要開會 (豐緒很放心我們)
  - 得到實習公司資源 -> **Azure VM**  迅速運行伺服器 (舒適)
  - 專研夥伴除了(林)以外都患上了暑假症候群 (有心無力)
  - (水) 遇到問題: 使用SQL Server儲存XML-Based樹時，如何在後端維持資料一致性 ?
    - 請求豐緒 -> 我有空時豐緒沒空豐緒有空時我沒空
    - StackOverFlow -> 得到的答案都是風涼話 -> 用SQL處理XML資料本身是個災難，但是要怎麼存入一棵樹到SQL? 還是得靠XML!
    - 8/9 還是沒有跟豐緒通到電話
  - (水) Android 前後端開發持續提交
    - 學會 API Blueprint 作為 API文件語言提升溝通效率 -> 讓(林)做Repository層時能參考
    - 部屬 ASP.NET WebAPI 至 IIS 開始 Model-First TeamPathy專案
    - 登入系統 ok 8/1 
    - 專案系統 ok 8/3
    - Issue系統 ok 8/10
    - Timeline 系統 
    - 待辦清單系統
    - 工作分析系統(災難) 
    - 推播系統
    - 資安模組 ASP.NET Web API Identity (超難..)
  - (曾/林) 行銷組持續繪製簡報
    - 構思三分鐘介紹影片 (**還是很不懂做出一個產品不進行報告要拍影片的制度**)

September-

October-
