import React from 'react';
import classNames from 'classnames/bind';
import styles from './ListWrapper.scss';

const cx = classNames.bind(styles);
/*
    내부 내용을 페이지 한가운데에 정렬,
    웹 브라우저 크기에 따라 화면 크기 조
 */
const ListWrapper = ({ children }) => (
  <div className={cx('list-wrapper')}>
    {children}
  </div>
);

export default ListWrapper;
