/*
    action 객체를 만드는 액션 생성함수들을 선언
    여기에서 () => ({}) 은 function () {return {}}와 동일
 */

import * as types from './ActionTypes';

// Tag - action
export const increment = () => ({
    type: types.INCREEMNT,
});
export const decrement = () => ({
    type: types.DECREMENT,
});
// 파라미터를 가지고 있는 액션
export const increment = (color) => ({
    type: types.SET_COLOR,
    color,
});

// End - action

// Tag - 리듀서 생성
const initialState = {
  color: 'black',
  number: 0,
};
/*
    state, action 파라미터를 받는 리듀서 함수를 정의
    state가 undefined일 때(스토어가 생성될 때) state 기본 값을 initialState로 사용

    주의)
        state를 직접 수정하면 안 되고, 기존 상태 값에 원하는 값을 덮어쓴 새로운 객체를 만들어서 반환해야 한다.
 */
const counter = (state = initialState, action) => {
    switch (action.type) {
        case types.INCREEMNT:
            return {
                ...state,
                number: state.number + 1,
            };
        case types.DECREMENT:
            return {
                ...state,
                number: state.number - 1,
            };
        case types.SET_COLOR:
            return {
                ...state,
                color: action.color,
            };
        default:
            return state;
    }
};
// End - 리듀서 생성

export default counter;