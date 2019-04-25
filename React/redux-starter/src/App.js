import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as counterActions from './modules/counter';

class App extends Component {
    render() {
        const {number, CounterActions} = this.props;
        return (
            <div>
                <h1>{number}</h1>
                <button onClick={CounterActions.increment}>+</button>
                <button onClick={CounterActions.decrement}>-</button>
            </div>
        );
    }
}

export default connect(
    (state) => ({
        /*
            state의 counter는 어디에서 명칭이 붙었을까?
            바로 modules/index.js에서 combineReducers()의 인자 값으로 들어간 reducer 이름의 상태값으로 잡힘
            즉 state 안에 있는 리듀서 counter의 value 값인 거
            ( modules/counter.js에서 인자 값을 기본값으로 넣어 줬기 떄문에 counter가 key값,
            만약 객체[ex: {obj: 1}]로 넣어줬다면 밑은 state.counter.obj가 되야함
         */
        number: state.counter,
    }),
    (dispatch) => ({
        CounterActions: bindActionCreators(counterActions, dispatch),
    }),
)(App);
