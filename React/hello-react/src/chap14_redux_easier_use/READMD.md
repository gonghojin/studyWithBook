## 14. 리덕스 더 편리하게 사용하기
리덕스를 사용하여 만든 멀티 카운터에는 몇 가지 불편한 점이 있다.   
예를들어 액션을 만들 때마다 세 가지 파일(액션 타입, 액션 생성 함수, 리듀서)을 수정해야 한다는 점, 전개 연산자(...)와 slice 함수로 배열 냅우의 원소를 수정하는 데 가독성이 낮다는 점이 있다.  
이러한 불편한 점은 다음으로 인해 보완할 수 있다.  
+ Immutable.js - 상태 업데이트
+ Ducks 파일구조
+ redux-action - 편리한 액션 생성 함수 만들기

### 14.1 Immutable.js
Immutable.js는 자바스크립트에서 `불변성 데이터`를 다룰 수 있도록 도와준다. 
#### 14.1.1 객체 불변성
다음 코드를 보자
````javascript
let a = 7;
let b = 7;

let object1 = { a: 1, b: 2};
let object2 = { a: 1, b: 2};

object1 === object2; // false - 서로 다른 객체

let object3 = object1;
object1 === object3; // true -같은 객체를 가리킴

object3.c = 3;
object1 === object3 // ture
object1 // Object { a:1, b:2, c: 3} // object1에도 c값이 생성됨

let array1 = [0, 1, 2, 3, 4];
let array2 = array1;
array2.push(5);
array1 === array2 // true
````
React는 여기에서 문제가 발생한다.  
>Why?  
> 리액트 컴포넌트는 state 또는 상위 컴포넌트에서 전달받은 props 값이 변할 때 리렌더링되는데,  
> 배열이나 객체를 직접 수정한다면 내부 값을 수정했을지라도 레퍼런스가 가리키는 곳은 같기 때문에 똑같은 값으로 인식!!
> 따라서 기존 값을 가진 새 객체 또는 배열을 만들었던 것(전개연산자[...] 사용)

하지만 이러한 특징은 코드의 복잡성을 불러옴
~~~
let object1 = {
    a: 1,
    b: 2,
    c: 3,
    d: {
        e: 4,
        f: {
            g: 5,
            h: 6,
        },
    },
};

// h 값을 10으로 업데이트한다면?
let object2 = {
    ...object1,
    d: {
        ...object1.d,
        f: {
            ...object1.d.f,
            h: 10,
        },
    },
},
~~~
대략난감.... 따라서 이러한 작업들을 간소화하려고 만든 라이브러리가 바로 `Immutable.js`  
위의 코드는 아래 코드로 대체
~~~
let object1 = Map({
    a: 1,
    b: 2,
    c: 3,
    d: Map({
        e: 4,
        f: Map({
            g: 5,
            h: 6,
        }),
    }),       
});

let object2 = object1.setIn(['d', 'f', 'h'], 10);
~~~
### 14.1.2 Map
Immutable의 Map은 객체 대신 사용하는 데이터 구조
#### 14.1.2.2 사용
~~~
const {Map} = Immutable;
const data = Map({
  a: 1,
  b: 2,
});
~~~
Map을 사용할 때는 Map 함수 안에 객체를 넣어서 호출한다.  
여러 층으로 구성된 객체를 Map으로 표현
~~~
const data = Map({
    a: 1,
    b: 2,
    c: Map({
        d: 3,
        e: 4,
        f: 5,
    }),
});
~~~
이처럼 객체 내부에 또 다른 객체들이 있아면, 내부 객체들도 Map으로 감싸 주어야 편리하다.(내부 객체들도 Map을 필수로 써야 하는 것은 아니지만, 내부에서 Map을 사용하지 않으면 추후 setIn, getIn을 활용할 수 없다.)  

만약 객체 내용을 네트워크에서 받아오거나 `전달받는 객체가 너무 복잡한 상태라면` 일일이 내부까지 Map으로 만들기 힘들 수 있다. 따라서 이떄는 fromJS를 사용하자!  
~~~
const { Map, fromJS } = Immutable;
const data = fromJS({
    a: 1,
    b: 2,
    c: {
        d: 3,
        e: 4,
        f: 5
    },
});
~~~
fromJS를 사용하면 이 코드처럼 내부에 있는 객체들은 Map을 쓰지 않아도 된다.

##### 자주 사용하는 Immutable 객체의 내장 함수
+ 자바스크립트 객체로 변환  
> Immutable 객체를 일반 객체 형태로 변형하는 방법  
> const deserialized = data.toJS(); // { a: 1, b: 2, c: { d: 3, e: 4} }  

+ 특정 키의 값 불러오기 - get()
> data.get('a'); // 1
+ 깊숙이 위치하는 값 불러오기 - getIn()
> Map 내부에 Map이 존재하고, 그 Map 안에 있는 키 값을 불러올 때  
> data.getIn(['c', 'd']); // 3

+ 값 설정 - set()
> const newData = data.set('a', 4);  
> set을 한다고 해서 데이터가 실제로 변하는 것은 아니다. 즉 새 Map을 만든다.  
> newData === data; // false

+ 깊숙이 위치하는 값 수정 - setIn()  
> const newData = data.setIn(['c', 'd'], 10);

+ 여러 값 동시에 설정 - mergeIn()  
> 예를들어 c 객체 안의 d와 e의 값을 동시에 바꿔야 할 때  
> const newData = data.mergeIn(['c'], { d: 10, e: 10});  
> 이렇게 mergeIn을 사용하면 c 안에 들어있는 f값은 그대로 유지하면서 d, e 값만 변경한다.

또는 다음과 같이 입력할 수 있다.
> const newData = data.setIn(['c', 'd'], 10).setIn(['c','d'], 10);  

만약 최상위에서 merge를 해야한다면?
> const newData = data.mergeIn({ a: 10, b: 10 });  

set을 여러 번 할지 vs merge를 할지  
> 그때끄때 상황에 맞추면 되지만, 성능상으로는 set을 여러 번 하는 것이 더 빠르다. (애초에 오래 걸리는 작업이 아니므로, 매우 미미함) 