import input from './input';
import todos from './todos';
import {combineReducers} from 'redux';

// 리듀서를 합쳐서 생성
export default combineReducers({input, todos});