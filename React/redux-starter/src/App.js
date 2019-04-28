import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as counterActions from './modules/counter';
import * as postActions from './modules/post';

class App extends Component {

    loadData = () => {
        const {PostActions, number} = this.props;
        PostActions.getPost(number)
            // getPost의 리턴값은 Promise
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    componentDidMount() {
        this.loadData();
        console.info('componentDidMount() working')
    }

    componentDidUpdate(prevProps, prevState) {
        // 이전 number와 현재 number가 다르면 요청을 시작
        if (this.props.number !== prevProps.number) {
            this.loadData();
        }
        console.info('componentDidUpdate() working')
    }

    render() {
        const {number, CounterActions, post, error, loading} = this.props;
        return (
            <div>
                <h1>{number}</h1>
                {/* 삼항 연산자 표현시
                      {
                        (() => {
                            if (loading) {
                                return (<div>로딩중.....</div>);
                            }
                            if (error) {
                                return (<h2>오류 발생!!</h2>);
                            }
                            return (
                                <div>
                                    <h2>{post.title}</h2>
                                    <p>{post.body}</p>
                                </div>
                            );
                        })()
                 }*/
                }
                {/*       삼항 연산자가 여러 번 겹칠 떄는 아래처럼 아예 함수를 만들어서 if 문을 사용하는 것이 더욱 가독성이 높음*/}
                {
                    (() => {
                        if (loading) {
                            return (<div>로딩중.....</div>);
                        }
                        if (error) {
                            return (<h2>오류 발생!!</h2>);
                        }
                        return (
                            <div>
                                <h2>{post.title}</h2>
                                <p>{post.body}</p>
                            </div>
                        );
                    })()
                }
                <button onClick={CounterActions.increment}>+</button>
                <button onClick={CounterActions.decrement}>-</button>
            </div>
        );
    }
}

export default connect(
    (state) => ({
        /*
            state의 counter는 어디에서 명칭이 붙었을까?
            바로 modules/index.js에서 combineReducers()의 인자 값으로 들어간 reducer 이름의 상태값으로 잡힘
            즉 state 안에 있는 리듀서 counter의 value 값인 거
            ( modules/counter.js에서 인자 값을 기본값으로 넣어 줬기 떄문에 counter가 key값,
            만약 객체[ex: {obj: 1}]로 넣어줬다면 밑은 state.counter.obj가 되야함
         */
        number: state.counter,
        post: state.post.data,
        loading: state.post.pending,
        error: state.post.error,
    }),
    (dispatch) => ({
        CounterActions: bindActionCreators(counterActions, dispatch),
        PostActions: bindActionCreators(postActions, dispatch),
    }),
)(App);
