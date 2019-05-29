import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

import Header from 'components/common/Header/Header';

class HeaderContainer extends Component {
    handleRemove = () => {
      // 임시
    }

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

export default withRouter(HeaderContainer);
