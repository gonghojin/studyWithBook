import React from 'react';
import className from 'classnames/bind';
import Header from 'components/common/Header';
import Footer from 'components/common/Footer';
import styles from './PageTemplate.scss';

const cx = className.bind(styles);
const PageTemplate = ({ children }) => (
  <div className={cx('page-template')}>
    <Header />
    <main>
      {children}
    </main>
    <Footer />
  </div>
);

export default PageTemplate;
