import React from 'react';
import PropTypes from 'prop-types';
import './Counter.css'

const Counter = ({number, color, index, onIncrement, onDecrement, onSetColor}) => {
    return (
        <div
            className='Counter'
            onClick={() => onIncrement(index)}
            // 마우스 오른쪽 버튼을 눌렀을 때 메뉴가 열리는 이벤
            onContextMenu={(e) => {
                e.preventDefault();
                onDecrement(index);
            }}
            onDoubleClick={() => onSetColor(index)}
            style={{
                backgroundColor: color
            }}
        >
            {number}
        </div>
    );
};

Counter.propTypes = {
    index: PropTypes.number,
    number: PropTypes.number,
    color: PropTypes.string,
    onIncrement: PropTypes.func,
    onDecrement: PropTypes.func,
    onSetColor: PropTypes.func,
};

Counter.defaultProps = {
    number: 0,
    color: 'black',
    onIncrement: () => console.warn('onIncrement not defined'),
    onDecrement: () => console.warn('onDecrement not defined'),
    onSetColor: () => console.warn('onSetColor not defined'),
};

export default Counter;
