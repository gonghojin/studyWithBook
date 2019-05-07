/* eslint-disable no-underscore-dangle */
/*
    스토어를 생성하는 함수
    함수를 따로 만드는 이유는 스토어를 클라이언트에서 생성하지만, 추후 서버사이드 렌더링을 할 떄 서버에서도 호출해야 하기 떄문
 */
import {
  createStore, applyMiddleware, compose, combineReducers,
} from 'redux';
import penderMiddleware from 'redux-pender';
import * as modules from './modules';

// 리덕스 모듈 합치기
const reducres = combineReducers(modules);
const middlewares = [penderMiddleware()];

// 개발 모드일 때만 Redux Devtools 적용
const isDev = process.env.NODE_ENV === 'development';
/*
    리덕스 개발자도구와 미들웨어를 사용하기 위해서 window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ 를 사용.
    (크롬 확장 프로그램에 작성되어있는 자바스크립트 함수입니다.)
     만약에 리덕스 개발자도구가 설치되어있지 않다면 일반 compose 를 사용합니다.
 */
const devtools = isDev && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__;
const composeEnhancers = devtools || compose;

// preloadedState는 추후 서버사이드 렌더링을 했을 떄 전달받는 초기 상태
const configure = preloadedState => createStore(
  reducres, preloadedState, composeEnhancers(applyMiddleware(...middlewares)),
);

export default configure;
