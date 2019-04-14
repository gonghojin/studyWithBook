/**
 * 단일 리듀서

 // Tag - 리듀서 생성
 import * as types from "../actions/ActionTypes";

 const initialState = {
    color: 'black',
    number: 0,
};
 // -
 state, action 파라미터를 받는 리듀서 함수를 정의
 state가 undefined일 때(스토어가 생성될 때) state 기본 값을 initialState로 사용

 주의)
 state를 직접 수정하면 안 되고, 기존 상태 값에 원하는 값을 덮어쓴 새로운 객체를 만들어서 반환해야 한다.
 -//
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

 */
import number from './~number';
import color from './~color';

import {combineReducers} from 'redux';
/** 서브 리듀서 **/
/*
    서브 리듀서들을 하나로 합친다.
    combineReducres를 실행하고 나면, 나중에 store 형태를 파라미터로 전달한 객체 모양대로 만든다.
    지금은 다음과 같이 만든다.
    {
        numberData: {
            number: 0,
        },
        colorData: {
            color: 'black',
        },
 */
const reducers = combineReducers({
    numberData: number,
    colorData: color,
});

export default reducers;

