import CounterList from '../components/CounterList';
import * as actions from '../actions';
import {connect} from 'react-redux';
import getRandomColor from '../lib/getRandomColor';


// store 안의 state 값을 props로 연결
const mapStateToProps = (state) => ({counters: state.counters});

/*
 액션 생성자를 사용하여 액션을 만들고, 해당 액션을 dispatch하는 함수를 만든 후 이를 props로 연결
 */
const mapDispatchToProps = (dispath) => ({
    onIncrement: (index) => dispath(actions.increment(index)),
    onDecrement: (index) => dispath(actions.decrement(index)),
    onSetColor: (index) => {
        const color = getRandomColor();
        dispath(actions.setColor({index, color}));
    },
});

// 데이터와 함수들이 props로 붙은 컴포넌트 생성
const CounterListContainer = connect(mapStateToProps, mapDispatchToProps)(CounterList);

export default CounterListContainer;