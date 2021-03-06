Context란?
----------
Context는 전역적으로 데이터가 사용되야 할 때 사용한다.(ex - 사용자 로그인 정보, 애플리케이션 설정 등)  
> 기존의 Context API도 전역적으로 데이터를 관리하는 용도로 사용할 수 있었지만, 사용성이 조금 불편했기 떄문에 사용이 용이하게끔 업데이트 
> redux, react-router 등의 라이브러리도 내부적 Context API를 기반으로 구현

Redux를 대체할 것인가?
------------------
Context API가 글로벌 상태관리를 조금 더 쉽게 해준다. 따라서 Redux를 단순히 깊은 컴포넌트 구조에서 `데이터를 전달하는 용도로만` 사용했다면 리덕스를 대체할 수 있다.
하지만 리덕스는 `단순한 전역적 상태 관리를 넘어 그 이상의 가치가 있다.` [액션 기반 앱 상태 업데이트 로직, 미들웨어, 강력한 개발자 도구 등]
따라서 적절하게 조화를 해서 사용하자.

참조 : https://velopert.com/3606