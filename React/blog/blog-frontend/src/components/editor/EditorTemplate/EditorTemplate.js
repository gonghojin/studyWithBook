/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { Component } from 'react';
import classNames from 'classnames/bind';
import style from './EditorTemplate.scss';

const cx = classNames.bind(style);

/**
 * PageTemplate처럼 children으로 받지 않는 이유
 * - EditorTemplate의 컨포넌트는 두 개 이상이기 때문에 이럴 경우는 props 형태로 전달해서 렌더
 */
class EditorTemplate extends Component {
    state = {
      leftPercentage: 0.5,
    }

    // separtor 클릭 후 마우스를 움직이면 그에 따라 leftPercentage 업데이트
    handleMouseMove = (e) => {
      this.setState({
        leftPercentage: e.clientX / window.innerWidth,
      });
    }

    // 마우스를 떘을 때 등록한 이벤트 제거
    handleMouseUp = (e) => {
      document.body.removeEventListener('mousemove', this.handleMouseMove);
      window.removeEventListener('mouseup', this.handleMouseUp);
    }

    // separator 클릭할 때
    handleSeparatorMouseDown = (e) => {
      document.body.addEventListener('mousemove', this.handleMouseMove);
      window.addEventListener('mouseup', this.handleMouseUp);
    }

    render() {
      const { header, editor, preview } = this.props;
      const { leftPercentage } = this.state;
      const { handleSeparatorMouseDown } = this;

      // 각 영역에 flex 값 적용
      const leftStyle = {
        flex: leftPercentage,
      };
      const rightStyle = {
        flex: 1 - leftPercentage,
      };

      // separator 위치 설정
      const separatorStyle = {
        left: `${leftPercentage * 100}%`,
      };

      return (
        <div className={cx('editor-template')}>
          {header}
          <div className={cx('panes')}>
            <div className={cx('pane', 'editor')} style={leftStyle}>
              {editor}
            </div>
            <div className={cx('pane', 'preview')} style={rightStyle}>
              {preview}
            </div>
            <div
              className={cx('separator')}
              style={separatorStyle}
              onMouseDown={handleSeparatorMouseDown}
            />
          </div>
        </div>

      );
    }
}

export default EditorTemplate;
