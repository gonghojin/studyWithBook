import React from 'react';
import {Route} from "react-router-dom";

import {Home, About} from "pages";
import Menu from "./components/Menu";

const App = () => {
    return (
        <div>
            <Menu/>
            {
                /*
                    exact는 정확한 경로 주소가 들어왔을 때만 보이도록 해준다
                    만약 exact가 없으면 /about 주소에도 '/'가 존재하기 떄문에 Home component도 출력하게 된다.

                 */
            }
            <Route exact path="/" component={Home}/>
            {/*
                Url의 params를 지정할 때 - :key
                 ex) /about/react

                주소 겹침 방지
                <Route exact path="/about" component={About}/>
                또는
                ?로 붙여줌으로써 선택적으로 받을 수 있음
            */}
            <Route path="/about/:name?" component={About}/>

        </div>
    );
};
export default App;
