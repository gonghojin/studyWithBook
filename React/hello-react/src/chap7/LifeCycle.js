import React, {Component} from 'react';

class LifeCycle extends Component {
    state = {
        number: 0,
        color: null,
    };

    myRef = null;

    constructor(props) {
        super(props);
        console.log('constructor');
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.color !== prevState.color) {
            console.info("1. In getDerivedStateFromProps")
            return {color: nextProps.color};
        }

        console.info("2. In getDerivedStateFromProps");
        return null;
    };

    componentDidMount() {
        console.log('componentDidMount');
    };

    shouldComponentUpdate(nextProps, nextState) {
        console.log('shouldComponentUpdate', nextProps, nextState);

        // 숫자의 마지막 자리가 4면 리렌더링하지 않음
        return nextState.number % 10 !== 4;
    };

    componentWillMount() {
        console.log('componentWillMount');
    };

    handleClick = () => {
        this.setState({
            number: this.state.number + 1
        });
    };

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getSnapshotBeforeUpdate');
        if (prevProps.color !== this.props.color) {
            console.info("1. In getSnapshotBeforeUpdate");
            return this.myRef.style.color;
        }
        console.info("2. In getSnapshotBeforeUpdate");
        return null;
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('componentDidUpdate', prevProps, prevState);
        if (snapshot) {
            console.log('업데이트 되기 직전 색상: ', snapshot);
        }
    }

    render() {
        console.info('render');
        const style = {
            color: this.props.color
        };

        return (
            <div>
                <h1 style={style} ref={ref => this.myRef = ref}>
                    {this.state.number}
                </h1>
                <p>color: {this.state.color}</p>
                <button
                    onClick={this.handleClick}
                >
                    더하기
                </button>
            </div>
        );
    }
}

export default LifeCycle;