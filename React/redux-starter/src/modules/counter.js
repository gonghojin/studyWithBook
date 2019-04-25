import {handleActions, createAction} from "redux-actions";

// 모듈 개수가 하나이기 떄문에 액션 이름 부분의 접두사 생략(counter/~)
const INCREMENT = 'INCREMENT';
const DECREMENT = 'DECREMENT';

export const increment = createAction(INCREMENT);
export const decrement = createAction(DECREMENT);

export default handleActions({
    [INCREMENT]: (state, action) => state + 1,
    [DECREMENT]: (state, action) => state - 1,
}, 0);