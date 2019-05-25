import React, {Component, createContext} from 'react';

const Context = createContext(); // Context 생성
/*
 * Context 안에는 Provider와 Consumer가 존재한다.
 * 이 둘은 Context를 사용하기 위해 필요한 컴포넌트
 */
// Consumer는 나중에 내보내줄 때 편하도록 SampleConsumer라고 호칭
const { Provider, Consumer: SampleConsumer } = Context;

class SampleProvider extends Component {
    state = {
        value: '기본값입니다',
    };

    /*
        여기서 action 객체는 임의로 설정하는 객체
        변화를 일으키는 함수들을 전달해줄 때, 함수 하나하나 일일이 전달하는 것이 아니라,
        객체 하나로 한꺼번에 전달하기 위함
     */
    actions = {
        setValue: (value) => {
            this.setState({ value });
        }
    };

    render() {
        const { state, actions } = this;
        /*
            Provier 내에서 사용할 값을 'value'라고 부른다.
            현재 컴포넌트의 state와 actions 객체를 넣은 객체를 만들어서,
            Provider의 value 값으로 사용
         */
        const value = {
            state,
            actions,
        };

        return (
            <Provider value={ value } >
                { this.props.children }
            </Provider>
        );
    }
}

// Context는 여러 개 만들 수 있기 때문에, prefix를 설정해주므로써 구분을 준다.
export {
    SampleProvider,
    SampleConsumer,
}