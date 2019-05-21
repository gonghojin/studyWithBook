import React from 'react';
import classNames from 'classnames/bind';
import { Link } from 'react-router-dom';
import moment from 'moment';
import removeMd from 'remove-markdown';
import styles from './PostList.scss';

const cx = classNames.bind(styles);

const PostItem = ({
  title, body, publishedDate, tags, id,
}) => {
  const tagList = tags.map(tag => <Link key={tag} to={`/tag/${tag}`}>#{tag}</Link>);
  return (
    <div className={cx('post-item')}>
      <h2><a>{title}</a></h2>
      <div className={cx('date')}>
        {moment(publishedDate).format('ll')}
      </div>
      {/*
            이 부분에서는 마크다운 html이 변환되지 않으므로 마크다운에서 사용하는 #, **, > 등 특수 문자가 남는다.
            따라서 이를 숨기기 위해 라이브러리를 사용
        */}
      <p>{removeMd(body)}</p>
      <div className={cx('tag)')}>
        {tagList}
      </div>
    </div>
  );
};
const PostList = ({ posts }) => {
  const postList = posts.map(
    (post) => {
      const {
        _idx, title, body, publishedDate, tags,
      } = post.toJS();
      return (
        <PostItem
          id={_idx}
          title={title}
          body={body}
          publishedDate={publishedDate}
          tags={tags}
          key={_idx}
        />
      );
    },
  );
  return (
    <div className={cx('post-list')}>
      {postList}
    </div>
  );
};

export default PostList;
