import React, {Component} from 'react';
import './ValidationSample.css';

/**
 * 현재의 예제는 직접 DOM에 접근하지 않고 state를 사용하였지만, 가끔 state만으로 해결할 수 없는 기능이 있다.
 * 1. 특정 input에 포커스 주기
 * 2. 스크롤 박스 조작하기
 * 3. Canvas 요소에 그림 그리기 등
 *
 * 이때는 어쩔 수 없이 DOM에 직접적으로 접근해야하는데, 바로 ref를 사용한다. [state 사용을 우선순위]
 */
class ValidationSample extends Component {

    state = {
        password: '',
        clicked: false,
        validation: false
    }

    handleChange = (e) => {
        this.setState({
            password: e.target.value
        });
    }

    handleButtonClick = () => {
        this.setState({
            clicked: true,
            validated: this.state.password === '0000'
        });
    }

    render() {
        return (
            <div>
                <input
                    type="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    className={this.state.clicked ? (this.state.validated ? 'success' : 'failure') : ''}
                />
                <button onClick={this.handleButtonClick}>
                    검증하기
                </button>
            </div>
        );
    }

}

export default ValidationSample;