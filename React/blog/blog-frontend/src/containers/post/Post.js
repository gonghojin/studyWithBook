import React, { Component } from 'react';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as postActions from 'store/modules/post';
import PostInfo from 'components/post/PostInfo/PostInfo';
import PostBody from 'components/post/PostBody/PostBody';

class Post extends Component {
  componentDidMount() {
    this.initialize();
  }

    initialize = async () => {
      const { PostActions, id } = this.props;
      try {
        await PostActions.getPost(id);
      } catch (e) {
        console.log(e);
      }
    }

    render() {
      const { loading, post } = this.props;

      if (loading) return null; // 로딩 중일 떄는 아무것도 보여주지 않음
      const {
        title, body, publishedDate, tags,
      } = post.toJS();

      return (
        <div>
          <PostInfo title={title} publishedDate={publishedDate} tags={tags} />
          <PostBody body={body} />
        </div>
      );
    }
}

export default connect(
  state => ({
    post: state.post.get('post'),
    loading: state.pender.pending['post/GET_POST'],

  }),
  dispatch => ({
    PostActions: bindActionCreators(postActions, dispatch),
  }),
)(Post);
