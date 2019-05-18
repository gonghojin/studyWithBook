import React from 'react';
import classNames from 'classnames/bind';
import Button from 'components/common/Button';
import styles from './EditorHeader.scss';

const cx = classNames.bind(styles);

const EditorHeader = ({ onGoBack, onSubmit }) => (
  <div className="editor-header">
    <div className={cx('back')}>
      <Button onClick={onGoBack} theme="outline">뒤로가기</Button>
    </div>
    <div className={cx('submit')}>
      <Button onClick={onSubmit} theme="outline">작성하기</Button>
    </div>
  </div>
);

export default EditorHeader;