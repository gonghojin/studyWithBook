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
export const setColor = (color) => ({
    type: types.SET_COLOR,
    color,
});

// End - action
