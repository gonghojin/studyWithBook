import {Map} from 'immutable';
import {handleActions, createAction} from 'redux-actions';

/*
    액션 타입을 정의할 떄는 이처럼 문자열의 앞부분에 리듀서 이름을 적어준다.
    장점 : 이같이 접두사를 설정하면, 서로 다른 리듀서끼리 액션 타입 이름이 중복되어도 상관없다.
 */
const SET_INPUT = 'input/SET_INPUT';

// 액션 생성 함수
export const setInput = createAction(SET_INPUT);

// 초기 상태 정의
const initialState = Map({
    value: '',
});

// 리듀서
export default handleActions({
    [SET_INPUT]: (state, action) => {
        return state.set('value', action.payload);
    },
}, initialState);
