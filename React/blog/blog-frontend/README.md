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

#### 20.1.5.1 루트 컴포넌트 설정
.env 파일 만들어서 절대 경로 src 잡아주기

#### 20.1.5.2 리덕스 설정
리덕스 모듈 설명
+ base: 로그인 상태, 삭제 및 로그인할 떄 보이는 모달 상태
+ editor: 마크다운 에디터 상태
+ list: 포스트 목록 상태
+ post: 단일 포스트 상태

#### 자체 설정: eslint 적용
[intellij 플러그인 연결](https://jojoldu.tistory.com/230)  
[eslint 설정](https://velog.io/@velopert/eslint-and-prettier-in-react)

### 20.2.2 글로벌 스타일 및 스타일 유틸 설정
~~~
// open-color: 색상을 쉽게 선택할 수 있음
// include-media: 반응형 디자인을 쉽게 적용할 수 있음
// materia-shadow 믹스인: 그림자를 간편하게 설정할 수 있음

$ yarn add open-color include-media
~~~

## 20.6  마크다운 에디터 구현
~~~
$ yarn add codemirror marked prismjs
~~~

## 21.1 프록시
webpack의 프록시(proxy) 기능을 사용하면 개발서버(webpack[port:3000])로 들오온 요청을 백엔드 서버에 전달하고, 응답을 그대로 반환할 수 있다.  

## 21.3 포스트 목록 보여주기
### 21.3.1 query-string 라이브러리
문자열 형태의 URL 쿼리를 객체 형태로 변환하거나, 반대로 객체 형태를 문자열 형태로 변환  
~~~
// v6이상은 구형 웹 브라우저에서 호환되지 않기 떄문에 설치할 떄는 뒤에 @5를 붙여 v5를 설치
$ yarn add query-string@5
~~~