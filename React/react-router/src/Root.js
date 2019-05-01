import React, {Component} from 'react';
import {BrowserRouter} from "react-router-dom";
import App from './App';

const Root = () => {
    return(
        // html5의 history api를 사용하여 새로고침하지 않고도 페이지 주소를 교체할 수 있도록 해준다.
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    );
}

export default Root;