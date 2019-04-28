import { createStore, applyMiddleware } from 'redux';
import modules from './modules'

/*
    yarn add redux-logger
 */
import { createLogger } from 'redux-logger'

/*
    비동기 작업 처리 방법 1 - yarn add redux-thunk
import ReduxThunk from "redux-thunk";
 */

/*
    비동기 작업 처리 방법 2 - yarn add redux-promise-middleware
 */
/**
 * 이 미들웨어는 Promise 객체를 payload로 전달하면(post.js 참조) 요청을 시작 - 성공 - 실패할 때
 * 액션의 뒷부분에 _PENDING, _FUFILED, _REJECTED를 붙어서 반환한다.
 * 따라서 각 액션 타입을 일일이 선언할 필요가 없다.
 * 뒷부분에 붙는 접미사는 커스터마이징할 수도 있다.(아래의  promiseTypeSuffixes: ['PENDING', 'SUCCESS', 'FAILURE'],)
 *
 */
import promiseMiddleware from 'redux-promise-middleware';

/*
    로그 미들웨어 설정 커스터마이징
    https://github.com/LogRocket/redux-logger#options
 */
const logger = createLogger();


const pm = promiseMiddleware({
    promiseTypeSuffixes: ['PENDING', 'SUCCESS', 'FAILURE'],
});

const store = createStore(modules, applyMiddleware(logger, /*ReduxThunk*/ pm));

export default store;