import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { withRouter } from 'react-router-dom';

import * as baseAction from 'store/modules/base';
import * as postAction from 'store/modules/post';
import AskRemoveModal from 'components/modal/AskRemoveModal';

class AskRemoveModalCotainer extends Component {
  handleCancel = () => {
    const { BaseActions } = this.props;
    BaseActions.hideModal('remove');
  };

  handleConfirm = async () => {
    const {
      BaseActions, PostActions, history, match,
    } = this.props;
    const { id } = match.params;

    try { // 포스트 삭제 후, 모달 닫고 웹사이트로 이동
      await PostActions.deletePost(id);
      BaseActions.hideModal('remove');
      history.push('/');
    } catch (e) {
      console.log(e);
    }
  };

  render() {
    const { visible } = this.props;
    const { handleCancel, handleConfirm } = this;

    return (
      <AskRemoveModal
        visible={visible}
        onCancel={handleCancel}
        onConfirm={handleConfirm}
      />
    );
  }
}

export default connect(
  state => ({
    visible: state.base.getIn(['modal', 'remove']),
  }),
  dispatch => ({
    BaseActions: bindActionCreators(baseAction, dispatch),
    PostActions: bindActionCreators(postAction, dispatch),
  }),
)(withRouter(AskRemoveModalCotainer));
