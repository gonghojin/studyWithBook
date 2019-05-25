import React, {Component} from 'react';

import { SampleConsumer } from '../contexts/sample';
class Sends extends Component {
    state = {
        input: '',
    };

    componentDidMount() {
        this.setState({
            input: this.props.value
        });
    }

    handleChange = (e) => {
        this.setState({ input: e.target.value });
    };

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.setValue(this.state.input);
    };

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input value={this.state.input} onChange={this.handleChange} />
                <button type="submit">설정</button>
            </form>

        );
    }
}

// Consumer를 사용하여 context 값을 전달받기 위한 컨테이너 컴포넌트
const SendsContainer = () => (
    <SampleConsumer>
        {
            ({ state, actions }) => (
                <Sends
                    value={ state.value }
                    setValue={ actions.setValue }
                />
            )
        }
    </SampleConsumer>
);

// Sends 대신에 sendsContainer를 export
export default SendsContainer;