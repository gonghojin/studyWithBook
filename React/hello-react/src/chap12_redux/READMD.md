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



