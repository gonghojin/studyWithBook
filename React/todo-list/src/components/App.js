import React, {Component} from 'react';
import PageTemplate from './PageTemplate';
import TodoInput from "./TodoInput";
import TodoList from "./TodoList/TodoList";

class App extends Component {
    state = {
        input: '',
        //일정 데이터 초깃값
        todos: [
            {id: 0, text: '리액트 공부하기', done: true},
            {id: 1, text: '컴포넌트 스타일링 해보기', done: false}
        ],
    }

    // 일정 데이터 안에 들어가는 id 값
    id = 1;
    getId = () => {
        return ++this.id; // 현재 값에서 1을 더한 값을 반환
    }

    handleChange = (e) => {
        const {value} = e.target;

        this.setState({
            input: value
        });
    }

    // 새 데이터 추가
    handleInsert = () => {
        const {input, todos} = this.state;

        // 새 데이터 객체 만들기
        const newTodo = {
            id: this.getId(),
            text: input,
            done: false
        };

        this.setState({
            todos: [...todos, newTodo],
        });
    }

    // to do 아이템 토글하기
    handleToggle = (id) => {
        const {todos} = this.state;
        const index = todos.findIndex((todo) => (todo.id === id));

        // 찾을 데이터의 done 값을 반전
        const toggled = {
            ...todos[index],
            done: !todos[index].done
        };

        this.setState({
            todos: [
                ...todos.slice(0, index),
                toggled,
                ...todos.slice(index + 1, todos.length)
            ]
        });
    };

    handleRemove = (id) => {
        const {todos} = this.state;
        const index = todos.findIndex(todo => todo.id === id);

        this.setState({
            todos: [
                ...todos.slice(0, index),
                ...todos.slice(index + 1, todos.length),
            ]
        });
    }

    render() {
        const {input, todos} = this.state;
        const {handleChange, handleInsert, handleToggle, handleRemove} = this;

        return (
            <PageTemplate>
                <TodoInput onChange={handleChange} value={input} onInsert={handleInsert}/>
                <TodoList todos={todos} onToggle={handleToggle} onRemove={handleRemove}/>
            </PageTemplate>
        );
    }
}

export default App;