import React, { Component } from 'react';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import * as listActions from 'store/modules/list';
import PostList from 'components/list/PostList/PostList';
import Pagination from 'components/list/Pagination/Pagination';


class ListContainer extends Component {
  componentDidMount() {
    this.getPostList();
  }


  componentDidUpdate(prevProps, prevState) {
    // 페이지 / 태크가 바뀔 때 리스트를 다시 불러온다.
    if (prevProps.page !== this.props.page || prevProps.tag !== this.props.tag) {
      this.getPostList();
    }

    // 스크롤바를 맨 위로
    document.documentElement.scrollTop = 0;
  }


    getPostList = () => {
      const { tag, page, ListActions } = this.props;
      ListActions.getPostList({
        tag,
        page,
      });
    }

    render() {
      const {
        loading, posts, page, lastPage, tag,
      } = this.props;
      if (!loading) return null; // 로딩 중에는 아무것도 보여주지 않음

      return (
        <div>
          <PostList posts={posts} />
          <Pagination page={page} lastPage={lastPage} tag={tag} />
        </div>
      );
    }
}

export default connect(
  state => ({
    posts: state.list.get('posts'),
    lastPage: state.list.get('lastPage'),
    loading: state.pender.pending['list/GET_POST_LIST'],
  }),
  dispatch => ({
    ListActions: bindActionCreators(listActions, dispatch),
  }),
)(ListContainer);
