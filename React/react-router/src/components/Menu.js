import React from 'react';
// import {Link} from "react-router-dom";
import {NavLink} from "react-router-dom";

const Menu = () => {
    const activeStyle = {
        color: 'green',
        fontSize: '2rem',
    };

    return (
        <div>
            <ul>
                {/*
                    <a> 사용 X - 페이지를 새로고침하면서 로딩하기 떄문
                    <Link> 사용 O - 페이지를 새로고침하여 불러오지 않고, 주소 창 상태를 변경하고 원하는 라우트로 화면을 전환

                <li><Link to="/">홈</Link></li>
                <li><Link to="/about">소개</Link></li>
                <li><Link to="/about/react">React 소개</Link></li>
                */}

                {/*
                    NavLink는 현재 주소와 해당 컴포넌트의 목적지 주소가 일치한다면 특정 스타일 또는 클래스를 지정할 수 있다.
                */}
                <li><NavLink exact to="/" activeStyle={activeStyle}>홈</NavLink></li>
                <li><NavLink exact to="/about" activeStyle={activeStyle}>소개</NavLink></li>
                <li><NavLink to="/about/react" activeStyle={activeStyle}>React 소개</NavLink></li>
            </ul>
        </div>
    );
};

export default Menu;
