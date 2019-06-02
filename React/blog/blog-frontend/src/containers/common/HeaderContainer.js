import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';


import Header from 'components/common/Header/Header';
import * as baseActions from 'store/modules/base';


class HeaderContainer extends Component {
    handleRemove = () => {
      const { BaseActions } = this.props;
      BaseActions.showModal('remove');
    };

    render() {
      const { match } = this.props;
      const { id } = match.params;

      return (
        <Header
          postId={id}
          onRemove={this.handleRemove}
        />
      );
    }
}

export default connect(
  state => ({}),
  dispatch => ({
    BaseActions: bindActionCreators(baseActions, dispatch),
  }),
)(withRouter(HeaderContainer));
