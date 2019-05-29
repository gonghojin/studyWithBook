import React from 'react';
import className from 'classnames/bind';
import Footer from 'components/common/Footer';
import styles from './PageTemplate.scss';
import HeaderContainer from 'containers/common/HeaderContainer';

const cx = className.bind(styles);
const PageTemplate = ({ children }) => (
  <div className={cx('page-template')}>
    <HeaderContainer />
    <main>
      {children}
    </main>
    <Footer />
  </div>
);

export default PageTemplate;
