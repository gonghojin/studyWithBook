import React from 'react';
import {useAnother} from "../contexts/another";

const Counter = ({ number, increment }) => {
    return (
        <div>
            <h1>{ number }</h1>
            <button onClick={ increment }>더하기</button>
        </div>
    );
};
/*
Hoc 생성 함수로 대체
export default useAnother(Counter);
*/
export default useAnother(
    ({ state, actions }) => ({
        number: state.number,
        increment: actions.increment,
    })
)(Counter);

