import {createAction, handleActions} from "redux-actions";

// 모듈 개수가 하나이기 떄문에 액션 이름 부분의 접두사 생략(counter/~)
const INCREMENT = 'INCREMENT';
const DECREMENT = 'DECREMENT';

export const increment = createAction(INCREMENT);
export const decrement = createAction(DECREMENT);

export default handleActions({
    [INCREMENT]: (state, action) => state + 1,
    [DECREMENT]: (state, action) => state - 1,
}, 1);

// tag - 카운터를 비동적으로 생성 추가(redux-thunk)
export const incrementAsync = () => dispatch => {
    // 1초 뒤 액션 디스패치
    setTimeout(
        () => {
            dispatch(increment())
        }, 1000);
}

export const decrementAsync = () => dispatch => {
    // 1초 뒤 액션 디스패치
    setTimeout(
        () => {
            dispatch(decrement())
        }, 1000);
}