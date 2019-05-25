import React from 'react';
import {useAnother} from "../contexts/another";

const Counter = ({ number, increment, value }) => {
    return (
        <div>
            <h1>{ number }</h1>
            <button onClick={ increment }>더하기</button>
            <h1>{value}</h1>
        </div>
    );
};

export default useAnother(Counter);
