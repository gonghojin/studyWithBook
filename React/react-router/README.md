react-router로 SPA 개발
---
## 16.2 프로젝트 구성
### 16.2.1 프로젝트 생성 및 라이브러리 설치
~~~
$ craete-ract-app react-router
$ yarn add react-router-dom
~~~
### 16.2.2 프로젝트 구조
+ src/components : 컴포넌트들이 위치하는 디렉토리
+ src/pages : 각 라우트들이 위치하는 디렉터리

### 16.2.3 NODE_PATH 설정(절대경로 사용하기)

~~~
 /* 절대 경로 사용하기
     webpack의 resolove 기능과 같음
     create-react-app로 만든 프로젝트는 NODE_PATH로 설정된 경로를 자동으로 resolve해주기 떄문에 별도의 webpack 설정 필요없음
    
    cross-env는 윈도우 환경을 위한 추가 설정
    yarn add cross-env
  */
  "scripts": {
    "start": "cross-env NODE_PATH=src react-scripts start",
    "build": "cross-env NOOE_PATH=src react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject"
  },
~~~