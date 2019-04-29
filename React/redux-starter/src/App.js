import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as counterActions from './modules/counter';
import * as postActions from './modules/post';

class App extends Component {

    cancelRequest = null;
    /*
        ES6 - Promise
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
    */

    /*
         ES7 - async/await
         await를 쓸 함수의 앞부분에 async 키워드를 붙여주고, 기다려야 할 Promise 앞에 await 키워드를 붙여준다.

         그리고 await를 사용할 떄는 꼭 try ~ catch 문으로 오류를 처리해야 한다.
         오류를 처리하지 않는다면, 오류가 발생했 을 때 해당 함수는 오류 위치에서 작업을 중지하고 더 이상 진행하지 않는다.
    */
    loadData = async () => {
        const {PostActions, number} = this.props;
        try {
            const p = PostActions.getPost(number);
            // Promise 내장 함수
            this.cancelRequest = p.cancel;
            const response = await p;
            console.log(response);
        } catch (e) {
            console.log(e);
        }
    };

    handleCancel = () => {
        if (this.cancelRequest) {
            this.cancelRequest();
            this.cancelRequest = null;
        }
    }

    componentDidMount() {
        this.loadData();
        console.info('componentDidMount() working')

        // Esc 누르면 요청을 취소
        window.addEventListener('keyup', (e) => {
            if (e.key === 'Escape') {
                this.handleCancel();
            }
        });
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
        /* 비동기 1, 2
        loading: state.post.pending,
        error: state.post.error,
        */

        //redux-pending
        loading: state.pender.pending['GET_POST'],
        error: state.pender.failure['GET_POST'],
    }),
    (dispatch) => ({
        CounterActions: bindActionCreators(counterActions, dispatch),
        PostActions: bindActionCreators(postActions, dispatch),
    }),
)(App);
