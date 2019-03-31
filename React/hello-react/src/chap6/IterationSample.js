import React, {Component} from 'react';

class IterationSample extends Component {
    state = {
        names: ['눈사람', '얼음', '눈', '바람'],
        name: ''
    };

    handleChange = (e) => {
        this.setState({
            name: e.target.value
        });
    };

    handleInsert = () => {
        this.setState({
            names: this.state.names.concat(this.state.name),
            name: ''
        });
    };

    handleRemove = (index) => {
        const {names} = this.state;

        this.setState({
            /*
                ... [전개연산자]
                ... 뒤에 위치한 배열 값을 그대로 꺼내서 현재 배열에 복사한다.
             */
            names: [
                ...names.slice(0, index),
                ...names.slice(index + 1, names.length)
            ]
        });
    };

    render() {
        const nameList = this.state.names.map(
            (value, index) => (
                <li
                    key={index}
                    onDoubleClick={() => {
                        this.handleRemove(index)
                    }}
                >
                    {value}
                </li>
            )
        );

        return (
            <div>
                <input
                    type="text"
                    value={this.state.name}
                    onChange={this.handleChange}
                />
                <button
                    onClick={this.handleInsert}
                >
                    추가
                </button>
                < ul>
                    {nameList}
                </ul>
            </div>

        );
    }
}

export default IterationSample