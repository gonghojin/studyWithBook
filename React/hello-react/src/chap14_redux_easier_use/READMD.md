# 14. 리덕스 더 편리하게 사용하기
리덕스를 사용하여 만든 멀티 카운터에는 몇 가지 불편한 점이 있다.   
예를들어 액션을 만들 때마다 세 가지 파일(액션 타입, 액션 생성 함수, 리듀서)을 수정해야 한다는 점, 전개 연산자(...)와 slice 함수로 배열 냅우의 원소를 수정하는 데 가독성이 낮다는 점이 있다.  
이러한 불편한 점은 다음으로 인해 보완할 수 있다.  
+ Immutable.js - 상태 업데이트
+ Ducks 파일구조
+ redux-action - 편리한 액션 생성 함수 만들기

## 14.1 Immutable.js
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
> 그때그때 상황에 맞추면 되지만, 성능상으로는 set을 여러 번 하는 것이 더 빠르다. (애초에 오래 걸리는 작업이 아니므로, 매우 미미함)

### 14.1.3 List  
List는 Immutable 데이터 구조로 `배열` 대신 사용한다. 배열과 동일하게 map, filter, sort, push, pop 함수를 내장하고 있다. 이 내장 함수를 실행하면 List 자체를 변경하는 것이 아니라, `새로운 List를 반환한다`.  
또 리액트 컴포넌트는 List 데이터 구조와 호환되기 때문에 map 함수를 사용하여 데이터가 들어있는 List를 컴포넌트 List로 변환하여 JSX에서 보여 주어도 제대로 렌더링된다. 
#### 14.1.3.1 생성  
~~~
const { List } = Immutable;
const list = List([0, 1, 2, 3, 4]);
~~~
객체들의 List를 만들어야 할 때, 객체들을 Map으로 만들어야 추후 get과 set을 사용가능
~~~
const { List, Map, formJS } = Immutable;

const list = List([
    Map({ value: 1, }),
    Map({ value: 2, }),
]);

// or

const list2 = fromJS([
    { value: 1 },
    { value: 2 },
]);
~~~
fromJS를 사용하면 내부 배열은 List로 만들고, 내부 객체는 Map으로 만듭니다. 
그리고 `Map과 마찬가지로 List도 toJS를 사용하여 일반 배열로 변환`할 수 있다. 이 과정에서 내부에 있는 Map들도 자바스크립트 객체로 변환된다.  
~~~
list.toJS());
~~~ 
#### 14.1.3.2 값 읽어 오기
n번째 원소 값 읽기 - get(n)  
~~~
list.get(0);
~~~
0번째 아이템의 value 값 읽기 
~~~
list.getIn([0, 'value']);
~~~
#### 14.1.3.3 아이템 수정
n번째 아이템을 수정해야 할 때 - set과 setIn / 원소를 통째로 바꾸고 싶을 떄는 다음과 같이 set 사용  
~~~
const newList = list.set(0, Map({value: 10}))
~~~
List의 Map 내부 값을 변경하고 싶을 때 - setIn
~~~
const newList = list.setIn([0, 'value'], 10);
~~~
또 다른 방법 update 사용  
~~~
const newList = list.update(0, item => item.set('value', item.get('value') * 5)) // ~.update(선택할 인덱스 값, 선택한 원소를 업데이트하는 함수)
~~~
값을 업데이트해야 하는데 `기존 값을 참조해야 할 때`는 이처럼 update를 사용하면 편리하다. 업데이트를 사용하지 않았다면?  
~~~
const newlist = list.setIn([0, 'value'], list.getIn([0, 'value'] * 5));
~~~

#### 14.1.3.4 아이템 추가
아이템을 추가할 때는 push를 사용한다. 이 함수를 사용한다고 해서 Array처럼 `기존 List 자체에 아이템을 추가하는 것은 아니다.[새 List를 만들어서 반환한다.]`  
~~~
const newList = list.push(Map({value: 3}))
~~~
리스트 맨 뒤가 아니라 `맨 앞`에 데이터를 추가하고 싶다면 push 대신에 `unshift를` 사용한다.  
~~~
const newList = list.unshift(Map({value: 0}));
~~~

#### 14.1.3.5 아이템 제거  
아이템을 제거할 때는 delete를 사용한다.  
~~~
const newList = list.delete(1); // 인덱스가 1인 아이템을 제
~~~
Array가 가진 내장 함수를 List도 대부분 가지고 있다. 예를들어 마지막 아이템을 제거하고 싶다면 pop을 사용하면 된다.  
~~~
const newList = list.pop();
~~~
하지만 배열크기를 가져올 때는 length를 참조하지만, List에서는 length가 아닌, size를 참조해야 한다.  
~~~
list.size;
list.isEmpty() // 비어 있는지 확인하고 싶다면
~~~
