import React from 'react';
import classNames from 'classnames/bind';
import styles from './PostBody.scss';
import MarkdownRender from '../../common/MarkdownRender/MarkdownRender';

const cx = classNames.bind(styles);

const PostBody = ({ body }) => (
  <div className={cx('post-body')}>
    <div className={cx('paper')}>
      <MarkdownRender markdown={body} />
    </div>
  </div>
);
export default PostBody;
