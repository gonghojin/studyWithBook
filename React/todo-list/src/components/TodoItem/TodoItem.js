import React, {Component} from 'react';
import styles from './TodoItem.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);

class TodoItem extends Component {
    render() {
        const {done, children, onToggle, onRemove} = this.props;
        return (
            <div className={cx('todo-item')} onClick={onToggle}>
                <input className={cx('tick')} type="checkbox" checked={done} readOnly/>
                <div className={cx('text', {done})}>{children}</div>
                <div className={cx('delete')} onClick={(e) => {
                    onRemove();
                    /**
                     * 부모요소와 자식요소 모두 onClick 이벤트가 설정되어 있으면, 자식 -> 부모 순으로 메서드를 실행하게 된다. 이를 'propagation'이라고 한다.
                     * 이를 막기 위해 밑으 함수를 호출
                     */
                    e.stopPropagation();
                }}>[지우기]
                </div>
            </div>
        );
    }
}

export default TodoItem;