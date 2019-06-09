/**
    Login modal은 전역적으로 사용하기 떄문에, App.js에서 랜더링이 필요하다.
    소규모에서는  App.js에서 랜더링을 바로 해도 되지만(현재 프로젝트), 규모가 커질 경우 App.js의 소스가 지저분해진다.
    따라서 별도의 js 파일을 만들어서 랜더링을 분리시켜 관리한다.
 */
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as baseActions from 'store/modules/base';

import LoginModalContainer from '../modal/LoginModalContainer';

class Base extends Component {
  render() {
    return (
      <div>
        <LoginModalContainer />
        {/*
            전역적으로 사용하는 컴포넌트 랜더링 위치
          */}
      </div>
    );
  }
}

export default connect(
  null,
  dispatch => ({
    BaseActions: bindActionCreators(baseActions, dispatch),
  }),
)(Base);
