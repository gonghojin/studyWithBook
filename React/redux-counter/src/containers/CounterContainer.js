import Counter from '../components/Counter';
import * as actions from '../actions';
import { connect } from 'react-redux';

// 13 가지 색상 중 랜덤으로 선택하는 함수
export const getRandomColor = () => {
    const colors = [
        '#495057',
        '#f03e3e',
        '#d6336c',
        '#ae3ec9',
        '#7048e8',
        '#4263eb',
        '#1c7cd6',
        '#1098ad',
        '#0ca678',
        '#37b24d',
        '#74b816',
        '#f59f00',
        '#f76707',
    ];

    // 0 ~ 12 랜덤
    const random = Math.floor(Math.random() * 13);

    return colors[random];
}

// store 안의 state 값을 props로 연결
const mapStateToProps = (state) => ({
/*
    단일 리듀서
    color: state.color,
    number: state.number,

*/
    color: state.colorData.color,
    number: state.numberData.number,
});

/*
    액션 생성 함수를 사용하여 액션을 생성하고,
    해당 액션을 dispatch하는 함수를 만든 후 이를 props로 연결
 */
const mapDispatchToProps  = (dispatch) => ({
    onIncrement : () => dispatch(actions.increment()),
    onDecrement : () => dispatch(actions.decrement()),
    onSetColor : () => {
        const color = getRandomColor();
        dispatch(actions.setColor(color));
    },

});

// Counter 컴포넌트의 Container 컴포넌트
// Counter 컴포넌트를 애플리케이션의 데이터 레이어와 묶는 역할
/**
 * 이렇게 하면 mapStateToProps, mapDispatchToProps의 리턴값이 Counter 컴포넌트의  props로 input
 * 이렇게 리덕스와 연동된 컴포넌트를 CounterContainer 안에 담아 이를 내보낸 후, App 컴포넌트에서 Counter 대신 CounterContainer 컴포넌트를 불러와 렌더링한다.
 */
const CounterContainer = connect(
    mapStateToProps,
    mapDispatchToProps,
)(Counter);

export default CounterContainer;