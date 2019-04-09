리덕스(redux)
===
리덕스는 `상태 관리의 로직을 컴포넌트 밖에서 처리하는 것이다.` [상태를 상위 컴포넌트에서 가지고 있기에는, 컴포넌트가 많아지면 한계가 있기 때문]  

리덕스의 구성요소
+ 스토어 : 애플리케이션의 상태 값들을 내장하고 있다.
+ 리듀서 : 상태를 변화시키는 로직이 있는 함수  
+ 액션 : 상태 변화를 일으킬 때 참조하는 객체
+ 디스패치 : 액션을 스토어에 전달하는 것을 의미
+ 구독 : 스토어 값이 필요한 컴포넌트는 스토어를 구독한다.  

## 12.2 리덕스 사용
### 12.2.2 액션과 액션 생성 함수
액션 객체 :
~~~
{
    type: "INCREMENT", // type은 필수(대문자와 밑줄을 조합)
}
~~~
액션 생성 함수 :  
~~~
// 액션 생성 함수를 정의하려면 우선 액션 타입을 상수 값으로 정의해 주어야 한다.
const INCREMENT = 'INCREMENT';
const DECREMENT = 'DECREMENT';

// 액션 생성 함수
    // diff: 유동적인 값(선택)
const increment = (diff) => ({type: INCREMENT, diff: diff});
const decrement = (diff) => ({type: DECREMENT, diff: diff});

console.log(increment(1));
console.log(decrement(1));
~~~

### 12.2.3 변화를 일으키는 함수 - 리듀서  
리듀서는 파라미터를 두 개 받는다
+ 첫번째 : 현재 상태
+ 두번쨰 : 액션 객체

~~~
// 리듀서가 초기에 사용할 초기 상태 값부터 먼저 설정해야 리듀서를 만들 수 있음
const initalState = {
    number: 0,
};

// 리듀서 함수
function counter(state = initialState, action) {
    switch(action.type) {
        case INCREMENT:
            return { number: state.number + action.diff };
        case DECREMENT:
            return { number: state.number - action.diff };
        default:
            return state;
    }
}
~~~
지금은 number 값만 설정했지만, 지금처럼 상태에 값이 하나만 있는 경우는 많지 않다.  
만약 number 말고도 다른 값이 있으면 어떻게 해야 할까?
~~~
const initalState = {
    number: 1,
    foo: 'bar',
    baz: 'qux'
};

// 리듀서 함수
function counter(state = initialState, action) {
    switch(action.type) {
        case INCREMENT:
            /*
                리덕스에서 상태를 업데이트할 때는 컴포넌트의 state를 다룰 때처럼 값을 직접 수정하면 안된다.
                새로운 객체를 만든 후 그 안에 상태를 정의해야 한다.
                Object.assing 함수를 싱행하면 파라미터로 전달된 객체들을 순서대로 합쳐 준다.
            */
            return Object.assing({}, state, {
                number: state.number + action.diff,
            });
        case DECREMENT:
            return {
                ...state,
                number: state.number - action.diff,
            };
        default:
            return state;
    }
}

console.log(counter(undefined, increment(1)));

// 결과 :
[object Object] {
    baz: "qux",
    foo: "bar",
    number: 2
}
~~~

### 12.2.4 리덕스 스토어 생성
액션과 리듀서가 준비되면 `리덕스 스토어를` 만들 수 있다. 
~~~
(...)
const { createStore } = Redux;
/*
 나중에 실제로 프로젝트에서 불러올 때는 아래처럼 사용
 import { createStore} from 'redux';
/*

const store = createStore(counter);
~~~
스토어를 생성할 때는 createStore 함수를 사용한다. 파라미터로는 리듀서 함수가 들어가고,  두 번째 파라미터를 설정하면 해당 값을 스토어의 기본 값으로 사용한다.  
이 파라미터를 생략하면 `리듀서 초깃값을 스토어 기본 값`으로 사용한다.  

### 12.2.5 구독
리덕스 스토어를 구독한다는 것은 리덕스 스토어의 상태가 바뀔 떄마다 특정 함수를 실행시킨다는 의미이다.  
리덕스 스토어를 구독하여 상태가 바뀔 때의 상태를 콘솔에서 기록하도록 코드를 입력해보자.  

( 리액트 컴포넌트에서 리덕스 스토어를 `구독(subscribe)`하는 작업은 나중에 react-redux의 content 함수가 대신하여 리덕스의 내장 함수 subscribe를 직접적으로 사용하지는 않는다.  
 여기에서는 리덕스 개념을 이해해보자 )  
 ~~~
 (...)
 const unsubscribe = store.subscribe(() => {
    console.log(store.getState)) // 현재 스토어 상태를 반환
 });
 ~~~   
 스토어를 구독할 때 사용하는 subscribe 함수의 파라미터는 함수 형태의 파라미터를 받는다.  
 함수 향태로 제공된 파라미터는 스토어 상태에 변화가 일어날 때마다 호출된다. 또한 이 subscribe 함수가 호출되면 반환 값으로 구독을 취소하는 unsubscribe 함수를 반환한다.  
 따라서 나중에 구독을 취소해야 할 때는 unsubscribe()를 입력하여 호출한다.  

### 12.2.6 dispatch로 액션 전달  
스토어에 액션을 넣을 때는 store.dispatch 함수를 사용한다.  
~~~
// 이 액션들이 디스패치될 때마다 방금 구독할 떄 등록했던 함수를 실행한다.  
store.dispatch(increment(1));
store.dispatch(decrement(5));
store.dispatch(increment(10));

// 결과 :
[object Object] {
    baz: "qux",
    foo: "bar",
    number: 2
}
[object Object] {
    baz: "qux",
    foo: "bar",
    number: -3
}
[object Object] {
    baz: "qux",
    foo: "bar",
    number: 7
}
~~~

## 12.3 리덕스의 세 가지 규칙
리덕스를 사용할 때 유의해야 할 세 가지 규칙이 있다.  
( 이 사항을 숙지한 상태에서 리덕스 관련 코드를 작성해야 상태를 원활하게 관리할 수 있다. )

### 12.3.1 스토어는 단 한 개
`스토어는 언제나 단 한개이다.` 스토어를 여러 개 생성해서 상태를 관리하면 안되고, 리듀서를 여러 개 만들어서 관리할 수 있다.  

### 12.3.2 state는 읽기 전용  
리덕스의 상태(state 값)은 읽기 전용이다. 이 값은 `절대로 직접 수정하면 안된다.`  
그렇게 하면 리덕스의 구독 함수를 제대로 실행하지 않거나 컴포넌트의 리렌더링이 되지 않을 수 있다.  
상태를 업데이트할 때는 `언제나 새 상태 객체를 만들어서` 넣어 주어야 한다.  
> 메모리 누수가 일어나지는 않을까?   
> Object.assign을 사용한다고 해서 이전에 사용하던 객체들이 메모리에 누적되는 않는다.
> 상태 레퍼런스가 사라지면 자동으로 메모리 관리를 한다.  
> 또 nested된 객체가 있을 때( 여러 괄호로 감싼 ) 그 내부의 깊은 값까지 복사하는 것이 아니라, 객체 내부의 키 레퍼런스만 복사한다.  
> 따라서 객체가 복잡하다고 해서 성능이 악화되지 않는다.  

### 12.3.3 변화는 순수 함수로 구성  
모든 변화는 순수 함수로 구성을 해야 한다. 여기에서 함수란 `리듀서 함수`를 가리킨다.  
순수 함수에서 결과 값을 출력할 때는 파라미터 값에만 의존해야 하며, 같은 파라미터는 언제나 같은 결과를 출력해야 한다.  
> 예를 들어 리듀서 함수 내부에서 외부 네트워크와 데이터베이스에 직접 접근하면 안된다.  
> 요청이 실패할 수도 있고, 외부 서브의 반환 값이 변할수 있기 때문이다.  
> 따라서 현재 날짜를 반환하는 new Date()나 Math.random() 등도 사용하면 안된다. 

---
# 정리
리덕스는 상태 관리를 효율적으로 할 수 있는 라이브러리이다.  
스토어에 상태 정보를 가진 객체를 넣어두고, 액션이 디스패치되었을 떄 리듀서 함수를 이용하여 상태를 변화시키는 것이 주요 역할이다.  
그리고 상태가 변화될 때마다 스토에 구독된 함수를 실행한다.  