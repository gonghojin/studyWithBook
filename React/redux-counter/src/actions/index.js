/*
    action 객체를 만드는 액션 생성함수들을 선언
    여기에서 () => ({}) 은 function () {return {}}와 동일
 */

import * as types from './ActionTypes';

// Tag - action
export const increment = (index) => ({
    type: types.INCREEMNT,
    index,
});
export const decrement = () => ({
    type: types.DECREMENT,
    index,
});
// 파라미터를 가지고 있는 액션
export const setColor = (color) => ({
    type: types.SET_COLOR,
    index,
    color,
});

export const create = (color) => ({
    type: types.CREATE,
    color,
});

export const remove = () => ({
    type: types.REMOVE
});
// End - action
