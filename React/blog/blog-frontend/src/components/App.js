import React from 'react';
import { Route, Switch } from 'react-router-dom';
import {
  ListPage, PostPage, EditorPage, NotFoundPage,
} from 'pages';

const App = () => (
  <div>
    {/*
                Switch: 설정된 라우트 중에서 일치하는 라우트 하나만 보여줌
                따라서 Switch로 감쌌기 떄문에, 먼저 매칭된 어떤 라우트도 없으면,
                맨 아래쪽의 path 설정을 하지 않은 NotFoundpage가 렌더링 됨

                ps. switch 문처럼 case에 만족되는 것이 없으니 return을 못하고 마지막까지 가는 듯?

            */}
    <Switch>
      <Route exact path="/" component={ListPage} />
      <Route path="/page/:page" component={ListPage} />
      <Route path="/tag/:tag/:page?" component={ListPage} />
      <Route path="/post/:id" component={PostPage} />
      <Route path="/editor" component={EditorPage} />
      <Route component={NotFoundPage} />
    </Switch>
  </div>
);

export default App;
