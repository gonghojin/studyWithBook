import React, { Component } from 'react';
import classNames from 'classnames/bind';

import styles from './ModalWrapper.scss';

const cx = classNames.bind(styles);

class ModalWrapper extends Component {
    state = {
      animate: false,
    };

    componentDidUpdate(prevProps, prevState) {
      if (prevProps.visible !== this.props.visible) {
        this.startAnimation();
      }
    }

    startAnimation = () => {
      this.setState({
        animate: true,
      });

      // 250ms 이후 다시 false로 설정
      setTimeout(() => {
        this.setState({
          animate: false,
        });
      }, 250);
    };

    render() {
      const { children, visible } = this.props;
      const { animate } = this.state;

      // visible과 animate 값이 둘다 false일 때만
      if (!visible && !animate) return null;

      // 상태에 따라 애니메이션 설정
      const animation = animate && (visible ? 'enter' : 'leave');

      return (
        <div>
          <div className={cx('gray-background', animation)} />
          <div className={cx('modal-wrapper', animation)}>
            <div className={cx('modal', animation)}>
              {children}
            </div>
          </div>
        </div>
      );
    }
}

export default ModalWrapper;
