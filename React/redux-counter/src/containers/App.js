import React, {Component} from 'react';
import Buttons from '../components/Buttons';
import CounterListContainer from './CounterListContainer';
import getRandomColor from '../lib/getRandomColor';

import {connect} from 'react-redux';
import * as actions from '../actions';

class App extends Component {
    render() {
        const {onCreate, onRemove} = this.props;
        return (
            <div className="App">
                <Buttons
                    onCreate={onCreate}
                    onRemove={onRemove}
                />
                <CounterListContainer/>
            </div>
        );
    }
}

// 액션 생성 함수
const mapToDispatch = (dispatch) => ({
    onCreate: () => dispatch(actions.create(getRandomColor())),
    onRemove: () => dispatch(actions.remove()),
});

// 리덕스에 연결시키고 내보낸다
// 이 컴포넌트에는 store에서 필요한 값이 없으므로, mapStateToProps는 null
/**
 * 만든 컴포넌트를 불러와 이를 리덕스에 연결하는 것이 아니라,
 * 파일 하나에서 컴포넌트를 정의하고 바로 연결해 주었다.
 * 이떄는 AppContainer의 레퍼런스를 따로 만들 필요없이 export 하는 부분에서 connection를 사용하여 리덕스에 연결시키면 된다.
 */
export default connect(null, mapToDispatch)(App);
