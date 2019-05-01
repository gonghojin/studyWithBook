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

## 16.6 라우트로 사용된 컴포넌트가 전달받는 props
### 16.6.1 location
location은 현재 페이지의 주소 상태를 알려준다.  
~~~
// Post 페이지 컴포넌트에서 location을 조회
{
    "pathname": "/posts/3",
    "search": "",
    "hash": "",
    "key": "xmsczi",
} 
~~~
이 location 값은 어떤 라우트 컴포넌트에서 조회하든 같다. 주로 search 값에서 `URL Query 읽거나, 주소가 바뀐 것을 감지하는 데` 사용한다.  
주소가 바뀐 것을 감지하려면 다음과 같이 컴포넌트 라이프사이클 메서드에서 location을 비교한다.  
~~~
componentDidUpdate(prevProps, prevState) {
    if (prevPros.location !== this.props.location) {
        // 주소가 바뀜
    }
}
~~~
### 16.6.2 match
match는 <Route> 컴포넌트에서 설정한 path와 관련된 데이터들을 조회할 떄 사용.  
match 객체는 주로 `params를 조회하거나 서브 라우트를 만들 떄 현재 path를 참조하는 데` 사용.
### 16.6.3 history
histroy는 현재 라우터를 조작할 떄 사용한다.   
예를 들어 뒤쪽 페이지로 넘어가거나, 다시 앞쪽 페이지로 가거나, 새로운 주소로 이동해야 할 때 이 객체가 지닌 함수들을 호출

# 17. 코드 스플리팅
싱글 페이지 애플리케이션의 단점은 페이지 로딩 속도가 지연될 수 있다는 것이다. 자바스크립트 번들 파일에 모든 애플리케이션의 로직을 불러오므로 규모가 커지면 용량도 커지기 떄문이다.  
이 문제를 개선하는 방법이 `코드 스플리팅(code splitting)`이다.  
webpack에서 프로젝트를 번들링할 때 파일 하나가 아닌, 파일 여러개로 분리시켜 결과물을 만들거나, 페이지를 로딩할 때 한꺼번에 불러오는 것이 아닌 필요한 시점에 불러올 수 있다.  
## 17.1 코드 스플리팅의 기본  
### 17.1.1 webpack 설정 밖으로 꺼내기  
create-react-app로 만든 프로젝트는 node_modules에 webpack 관련 설정파일을 내장한다.  
코드 스플리팅을 구현하려면 webpack 설정 파일을 커스터마이징해야 하기 떄문에 다음 명령어로 프로젝트의 환경설정을 밖으로 꺼낸다.  
~~~
$ yarn eject
~~~