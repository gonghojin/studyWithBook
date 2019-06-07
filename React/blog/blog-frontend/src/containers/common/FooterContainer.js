import React, { Component } from 'react';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import * as baseActions from 'store/modules/base';
import Footer from 'components/common/Footer/Footer';

class FooterContainer extends Component {
    handleLoginClick = async () => {
      const { BaseActions } = this.props;
      BaseActions.showModal('login');
    };

    render() {
      const { handleLoginClick } = this;

      return (
        <Footer onLoginClick={handleLoginClick} />
      );
    }
}

export default connect(
  state => ({}),
  dispatch => ({
    BaseActions: bindActionCreators(baseActions, dispatch),
  }),
)(FooterContainer);
