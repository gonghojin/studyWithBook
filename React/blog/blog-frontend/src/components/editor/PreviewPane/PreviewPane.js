import React from 'react';
import classNames from 'classnames/bind';
import styles from './PreviewPane.scss';

const cx = classNames.bind(styles);

const PreviewPane = ({ mardown, title }) => (
  <div className={cx('preview-pane')}>
    <h1 className={cx('title')}>
          제목
    </h1>
    <div>
          내용
    </div>
  </div>
);

export default PreviewPane;
