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