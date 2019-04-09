import React, {Component} from 'react';
import styles from './TodoInput.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);

// input과 버튼이 함께 있는 컴포넌트

/**
 *
 * @param value: input 값
 * @param onChange: input 변경 이벤트
 * @param onInsert: 추가 버튼 클릭 이벤트
 */
const TodoInput = ({value, onChange, onInsert}) => {

    // Enter키가 눌리면 onInsert를 실행
    const handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            onInsert();
        }
    }

    return (
        <div className={cx('todo-input')}>
            <input onChange={onChange} value={value} onKeyPress={handleKeyPress}/>
            <div className={cx('add-button')} onClick={onInsert}>추가</div>
        </div>
    );
}

export default TodoInput;