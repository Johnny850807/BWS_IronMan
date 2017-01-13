# BWS_IronMan_Practice_ChattingRoom
城市鐵男─程式鐵男

**簽到區**

- 水球簽到 
- 阿宗師簽到

## Requirements Analyze

需要兩個 Webview
### 等候房間列表

	1. 顯示所有已被建立的房間。
    2. 給予使用者一個欄位輸入他的暱稱，否則他將以匿名參與。
    3. 使用者可以點擊進入房間。
    4. 使用者可以自行建立房間，但要輸入房名跟主題，建立房間後要把他傳入房間頁面。
    
### 房內視窗

	1. 房間主人可以點選按鈕 "Leave" 離開並關閉聊天室。
    2. 使用者可以打字、傳送訊息以及接收聊天訊息。
    3. 每當有使用者離開，要顯示訊息通知大家。





Requests two web views
### waiting for rooms view

	1. present all rooms created by someone.
    2. there should be an input box for the user naming himself , if the user did not name himself , he will be anonymous at the room.
    3. and the user can join every room by clicking it.
    4. the user can also create a room by himself with required both room name and topic , he will join his own room when finished sending the creation request.
    
### inside room view

	1. the room owner can remove the room by clicking the button with a text "Leave".
    2. users can text , send and receive messages for chatting.
    3. users can leave , show a message whenever somebody left.
