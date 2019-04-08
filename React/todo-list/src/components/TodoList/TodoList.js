import React, {Component} from 'react';
import TodoItem from '../TodoItem';

class TodoList extends Component {

    /*
        컴포넌트 최적화:
            해당 메소드는 리렌더링을 할지를 선택할 수 있다.
            필요한 이유?
                - TodoInput에서 값을 변경할 경우 App.js의 상태값이 변경된다.
                  부모 컴포넌트가 리렌더링할 경우, 자식 컴포넌트도 리렌덩이 된다.
                  따라서 Input 값의 변경으로 인해, 불필요한 TodoList의 리렌더링으로 이어진다.
                  떄문에 해당 메소드를 사용함으로써, 불필요한 update를 차단할 수 있다.

     */
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.todos !== nextProps.todos;
    }

    render() {
        const {todos, onToggle, onRemove} = this.props;
        const todoList = todos.map(
            todo => (
                <TodoItem
                    key={todo.id}
                    done={todo.done}
                    onToggle={() => onToggle(todo.id)}
                    onRemove={() => onRemove(todo.id)}
                >
                    {todo.text}
                </TodoItem>
            )
        );


        return (
            <div>
                {todoList}
            </div>
        );
    }
}

export default TodoList