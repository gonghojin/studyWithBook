import React, {Component} from 'react';

class AsyncSplitMe extends Component {
    state = {
        SplitMe: null,
    }

    loadSplitMe = () => {
        /*
            청크를 생성할 컴포넌트 자체는 특별히 다르지 않고, 해당 컴포넌트를 불러올 때 다르다.
            비동기적으로 파일을 불려오려면 import를 코드 맨 위쪽에서 하는 것이 아니라,
            특정 함수 내부에서 작성하거나(아래), LifeCycle 메서드 안에 넣을 수도 있고, 따로 이벤트를 설정하여 불러오도록 할 수도 있다.
         */

        // 비동기적으로 코드를 불러온다. 함수는 Promise를 결과로 반환
        // import()는 모듈의 전체 네임스페이스를 불러오므로, default를 직접 지정해야 한다.
        import('./SplitMe').then(({default: SplitMe}) => {
            this.setState({
                SplitMe
            });
        });
    };
    render() {
        const { SplitMe } = this.state;

        // SplitMe가 있으면 이를 렌더링하고, 없으면 버튼을 렌더링
        // 버튼을 누르면 SplitMe를 import
        return SplitMe ? <SplitMe/> : <button onClick={this.loadSplitMe}>SplitMe 로딩</button>
    }
}

export default AsyncSplitMe;