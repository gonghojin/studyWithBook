import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './containers/App';

// 리덕스 관련 불러오기
import {createStore} from 'redux';
import reducres from './reducers';

// 스토어 생성
const store = createStore(reducres);
ReactDOM.render(<App/>, document.getElementById('root'));
/**
    스토어는 리덕스에서 가장 핵심적인 인스턴스
    이 안에 현재 상태가 내장되어 있고, 상태를 업데이트할 때마다 구독 중인 함수를 호출
    리액트에서 스토어를 생성할 떄는 보통 프로젝트의 엔트리 포인트인 src/index.js 파일에서 만듦
 **/