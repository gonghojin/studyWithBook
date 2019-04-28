import { createStore, applyMiddleware } from 'redux';
import modules from './modules'

/*
    yarn add redux-logger
 */
import { createLogger } from 'redux-logger'

/*
    yarn add redux-thunk
 */
import ReduxThunk from "redux-thunk";

/*
    로그 미들웨어 설정 커스터마이징
    https://github.com/LogRocket/redux-logger#options
 */
const logger = createLogger();

const store = createStore(modules, applyMiddleware(logger, ReduxThunk));

export default store;