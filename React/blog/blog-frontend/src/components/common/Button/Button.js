import React from 'react';
import classNames from 'classnames/bind';
import { Link } from 'react-router-dom';
import styles from './Button.scss';

const cx = classNames.bind(styles);

// 전달받은 className, onClick 등 값들이 rest 안에 들어 있음
// JSX에서 ...을 사용하면 내부에 있는 값들을 props로 넣어
const Div = ({ children, ...rest }) => <div {...rest}>{children}</div>;
const Button = ({
  children, to, onClick, disabled, theme = 'default',
}) => {
  const Element = (to && !disabled) ? Link : Div;

  // disable === true 시 className에 disabled를 추가( 비활성화 시 onClick 실행 불가 )
  return (
    <Element
      to={to}
      className={cx('button', theme, { disabled })}
      onClick={disabled ? () => null : onClick}
    >
      {children}
    </Element>
  );
};

export default Button;
