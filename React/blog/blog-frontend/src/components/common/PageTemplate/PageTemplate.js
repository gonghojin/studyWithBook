import React from 'react';
import className from 'classnames/bind';
import Footer from 'components/common/Footer';
import HeaderContainer from 'containers/common/HeaderContainer';
import styles from './PageTemplate.scss';

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
