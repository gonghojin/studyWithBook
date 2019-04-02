import React, {Component} from 'react';
import styles from './PageTemplate.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);

/*
 페이지 템플릿을 위한 컴포넌트.
 페이지의 틀, 타이틀 /콘텐츠 등 속성이 설정되어 있다.

 PageTemplate 컴포넌트는 유저 인터페이스의 전체적인 틀을 설정한다.
 아래쪽에 children 값으로 그 내부에 들어갈 컴포넌트들을 넣어준다.
 */

const PageTemplate = ({children}) => {
    return (
        <div className={cx('page-template')}>
            <h1>일정관리</h1>
            <div className={cx('content')}>
                {children}
            </div>
        </div>
    );
}

export default PageTemplate;