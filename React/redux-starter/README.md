## 15.1 미들웨어 이해
### 15.1.1 미들웨어란?
리덕스 미들웨어는 액션을 디스패치했을 때 `리듀세에서 이를 처리하기 전에 사전에 지정된 작업들을 실행한다.` 미들웨어는 `액션과 리듀서 사이의 중간자`라고 볼 수 있다.  
~~~
액션 < - > 미들웨어 < - > 리듀서 --> 스토어
~~~

### 15.1.2 미들웨어 생성
#### 15.1.2.1 준비 작업

