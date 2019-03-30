import React, {Component} from 'react';

/**
 * 이벤트를 사용할 떄 주의사항
 * 1. 이벤트 이름은 camelCase로 작성한다.
 * 2. 이벤트에 실행할 자바스크립트 코드를 전달하는 것이 아니라, 함수 형태의 값을 전달한다
 *  - onClick="alert(~~)" : X , onClick={() => {alert(~~)}}
 * 3. DOM 요소에만 이벤트를 설정할 수 있다.
 */

class EventPractice extends Component {

    state = {
        message : ''
    }

    constructor(props) {
        super(props);
        /**
         * 컴포넌트에 임의 메서드를 만들면 기본적으로 this에 접근할 수 없다.
         * 따라서 컴포넌트의 생성자 메서드인 constructor에서 각 메서드를 this와 바인딩(binding)해 주어야 한다.
         *
         * **/
        this.handleChnage = this.handleChnage.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handleChnage(e) {
        this.setState({
            message: e.target.value
        });
    }

    handleClick() {
        alert(this.state.message);
        this.setState({
            message: ''
        });
    }

    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type="text"
                    name="message"
                    placeholder="아무거나 입력해보세요"
                    value={this.state.message}
                    onChange={
                        /* 밑의 방법과 동일하나, 현재한 방법이 더 가독성이 높다.
                         (e) => {
                             this.setState({
                                 message: e.target.value
                             });
                         }*/
                        this.handleChnage
                    }
                />
                <button
                    onClick={
                        /*
                      () => {
                            alert(this._state.message);
                            this.setState({
                                message: ''
                            });
                        }}*/
                        this.handleClick
                    }
                >
                    버튼
                </button>
            </div>
        );
    }
}

export default EventPractice;