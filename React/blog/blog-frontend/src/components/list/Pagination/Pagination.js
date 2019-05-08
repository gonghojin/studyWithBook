import React from 'react';
import classNames from 'classnames/bind';
import Button from 'components/common/Button';
import styles from './Pagination.scss';

const cx = classNames.bind(styles);

const Pagination = () => (
  <div className={cx('pagination')}>
    {/*
        JSX에서 따로 값을 설정하지 않고 props 이름만 넣어 주면 disabled = { true }
      */}
    <Button disabled>
            이전 페이지
    </Button>
    <div className={cx('number')}>
            페이지 1
    </div>
    <Button>
            다음 페이지
    </Button>
  </div>
);

export default Pagination;
