import { combineReducers } from 'redux';
import counter from './counter';
import post from "./~post";
import {penderReducer} from "redux-pender";

export default combineReducers({
    counter,
    post,
    /*
        미들웨어를 적용하고 난 후에는 라이브러리 안에 내장된 리듀서를 루트 리듀서에 넣어 준다.
     */
    pender: penderReducer
});