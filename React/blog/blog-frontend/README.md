리액트 블로그 만들기
----------------
## 20.1 프로젝트 구조 잡기
### 20.1.2 주요 디렉터리 경로
+ components: 리덕스 상태에 연결되지 않은 프리젠테이셔널 컴포넌트들(스타일 포함)
+ containers: 리덕스 상태와 연결된 컨테이너 컴포넌트들
+ lib: 백엔드 api 함수들과 코드 스플링할 때 사용하는 asyncRoute
+ pages: 라우터에서 사용할 각 페이지 컴포넌트들
+ store: Ducks 구조를 적용시킨 리덕스 모듈들과 스토어 생성 함수
+ styles: 전역적으로 필요한 스타일 관련 코드

### 20.1.4 Sass 및 CSS 모듈 적용
~~~
// 환경설정 꺼내기
$ yarn eject

// Sass 적용 & classnames
$ yarn add node-sass  classnames
~~~
기존 설정법 Create-react-app V2가 릴리즈 되면서 많이 변경되었다. ([참조](https://velog.io/@velopert/create-react-app-v2) )  
따라서 Sass, Css 설정법은 이 방법으로 하기 ([참조](https://velog.io/@velopert/react-component-styling))

### 20.1.5 라우터와 리덕스 적용
~~~
$ yarn add react-router-dom redux redux-actions react-redux redux-pender immutable
~~~

### 20.1.5.1 루트 컴포넌트 설정
.env 파일 만들어서 절대 경로 src 잡아주기