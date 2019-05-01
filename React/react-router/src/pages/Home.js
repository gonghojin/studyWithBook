import React from 'react';

const Home = ({history}) => {
    return (
      <div>
          <h2>홈</h2>
          <button onClick={() => {
              // 링크 클릭에의한 단순한 경우가 아니라, 자바스크립트에서 페이지의 이동이 필요할 때
              // ex) login 성공시 특정 페이지 이동
              history.push('/about/javascript');
          }}>자바스크립트를 사용하여 이동</button>
      </div>
    );
};

export default Home;