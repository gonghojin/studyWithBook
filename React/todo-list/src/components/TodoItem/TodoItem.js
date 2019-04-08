import React, {Component} from 'react';
import styles from './TodoItem.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);

class TodoItem extends Component {
    /*
        체크박스 변화는 todos 배열을 실제로 업데이트하는 상황이라 TodoList에서 shouldComponentUpdate가 도움이 되지않음.
        따라서 TodoItem에서 최적화를 진행해줘야 함
    */
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.done !== nextProps.done;
    }

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