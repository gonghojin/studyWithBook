import React, {Component} from 'react';
import TodoInput from '../components/TodoInput';

import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';

// 액션 생성 함수들을 한꺼번에 불러온다.
import * as inputActions from '../modules/input';
import * as todosActions from '../modules/todos';

class TodoInputContainer extends Component {
    id = 1;
    getId = () => {
        return ++this.id;
    };

    handleChange = (e) => {
        const { value } = e.target;
        const { InputActions } = this.props;
        InputActions.setInput(value);
    };
    handleInsert = () => {
        const { InputActions, TodosActions, value } = this.props;
        const todo = {
            id: this.getId(),
            text: value,
            done: false
        };
        TodosActions.insert(todo);
        InputActions.setInput('');
    };
    render() {
        const { value } = this.props;
        const { handleChange, handleInsert } = this;
        return (
            <TodoInput
            onChange={handleChange}
            onInsert={handleInsert}
            value={value}
            />
        );
    }
}

/*
    이번에는 mapStateToProps와 mapDispatchToPros 함수에 대한 레퍼런스를 따로 만들지 않고,
    그 내부에 바로 정의한다.
 */
export default connect(
    (state) => ({
        value: state.input.get('value')
    }),
    (dispath) => ({
        /*
            bindActionCreators(액션 생성 함수들이 들어있는 객체, dispatch)

            bindActionCreator를 사용하면 자동으로 다음 작업들을 해준다.
                {
                    actionCreator: (...params) => dispatch(actionCreator(...params))
                }
            그래서 이전에 했던 것처럼 일일이 dispatch할 필요가 없다.
            예를들어 InputActions에는 다음 작업이 되어 있다.
            InputActions: {
                setInput: (value) => dispatch(inputActions.setInput(value))
            },
            나중에 이를 호출할 떄는 this.props.InputActions.setInput을 호출하면 된다.
         */
        InputActions: bindActionCreators(inputActions, dispath),
        TodosActions: bindActionCreators(todosActions, dispath),
    }),
)(TodoInputContainer);
