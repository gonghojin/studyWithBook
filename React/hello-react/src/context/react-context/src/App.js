import React from 'react';
import LeftPane from "./components/LeftPane";
import RightPane from "./components/RightPane";
import {SampleProvider} from "./contexts/sample";
import {AnotherProvider} from "./contexts/another";
import Counter from "./components/Counter";

/*
    Context의 개수가 많아지면?

    return (
     <SampleProvider>
        <AnotherProvider>
            ....
        </AnotherProvider>
      </SampleProvider>
    )

    따라서 아래의 방법은 위의 문제점을 해결해준다.
    - reduce는 배열 내장 함수

    React.createElement의 이해
    - https://reactgo.com/react-createelement-example/
 */
const AppProvider = ({contexts, children}) => (contexts.reduce(
    (prev, context) => React.createElement(context, {
        children: prev,
    }), children)
);

function App() {
    return (
        <AppProvider
            contexts={[SampleProvider, AnotherProvider]}
        >
            <div className="panes">
                <LeftPane/>
                <RightPane/>
            </div>
            <Counter/>
        </AppProvider>
    );
}

export default App;
