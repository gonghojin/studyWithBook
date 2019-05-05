import React from 'react';
import classNames from 'classnames/bind';
import { Link } from 'react-router-dom';
import styles from './Header.scss';

const cx = classNames.bind(styles);
const Header = () => (
  <header className={cx('header')}>
    <div className={cx('header-content')}>
      <div className={cx('brand')}>
        <Link to="/">reactBlog</Link>
      </div>
      <div className={cx('right')}>
        {/* 조건에 따라 버튼 렌더링 */}
                오른쪽
      </div>
    </div>
  </header>
);

export default Header;
