import React from 'react';
import className from 'classnames/bind';

import HeaderContainer from 'containers/common/HeaderContainer';
import FooterContainer from 'containers/common/FooterContainer';

import styles from './PageTemplate.scss';

const cx = className.bind(styles);
const PageTemplate = ({ children }) => (
  <div className={cx('page-template')}>
    <HeaderContainer />
    <main>
      {children}
    </main>
    <FooterContainer />
  </div>
);

export default PageTemplate;
