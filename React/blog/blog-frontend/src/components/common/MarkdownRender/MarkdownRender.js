import React, { Component } from 'react';

import classNames from 'classnames/bind';

import marked from 'marked';
import Prism from 'prismjs';
import styles from './MarkdownRender.scss';

// Prisim 관련 코드: 코드 블록에 색상 입히기
import 'prismjs/themes/prism-okaidia.css';
// 지원할 코드 형식들을 불러옵니다
// http://prismjs.com/#languages-list 참조
import 'prismjs/components/prism-bash.min';
import 'prismjs/components/prism-javascript.min';
import 'prismjs/components/prism-jsx.min';
import 'prismjs/components/prism-css.min';

const cx = classNames.bind(styles);

class MarkdownRender extends Component {
    state = {
      html: '',
    };

    constructor(props) {
      super(props);
      const { markdown } = props;

      // 서버 사이드 렌더링에서도 마크다운 처리가 되도록 constructor 쪽에서도 구현
      this.state = {
        html: markdown ? marked(props.markdown, { breaks: true, sanitize: true }) : '',
      };
    }

    // post같이 첫 랜더링에 적용이 필요할 떄
    componentDidMount() {
      Prism.highlightAll();
    }

    // editor같이 랜더링 후 값이 변경되었을 떄
    componentDidUpdate(prevProps, prevState) {
      // markdown값이 변경되면 renderMarkdown을 호출
      if (prevProps.markdown !== this.props.markdown) {
        this.renderMarkdown();
      }

      // state가 변경되면 코드 하이라이팅
      if (prevState.html !== this.props.html) {
        Prism.highlightAll();
      }
    }

    renderMarkdown = () => {
      const { markdown } = this.props;
      // 마크다운이 존재하지 않는다면 공백 처리
      if (!markdown) {
        this.setState({ html: '' });
        return;
      }

      this.setState({
        html: marked(markdown, {
          breaks: true, // 일반 엔터로 세 줄 입력
          sanitize: true, // 마크다운 내부 html 무시
        }),
      });
    };

    render() {
      const { html } = this.state;

      // React에서 html을 렌더링하려면, 객체를 만들어 내부에 __html 값을 설정해야 함
      const markup = {
        __html: html,
      };
      return (
        <div className={cx('markdown-render')} dangerouslySetInnerHTML={markup} />
      );
    }
}

export default MarkdownRender;
