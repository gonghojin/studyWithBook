import React, {Component} from 'react';
import './ValidationSample.css';


class ValidationRefSample extends Component {

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
        /**
         * 리액트 컴포넌트 안에서는 id를 사용하지 않는 것을 권장한다.
         * HTML에서 DOM의 id는 유일해야 하는데, 컴포넌트를 여러 번 사용할 경우 중복 id를 가진 DOM이 여러 개 생기기 때문이다
         * ex)
         * <input id="selfName" ~/>
         * document.getElementById('selfName').focus() 비권장
         * 따라서 ref를 생성하여, 밑의 방법으로 접근
         */
        this.selfName.focus();
    }

    render() {
        return (
            <div>
                <input
                    type="password"
                    ref={(ref) => this.selfName=ref}
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

export default ValidationRefSample;