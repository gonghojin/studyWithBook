import React from "react";
/*
    HoC를 생성하는 함수 만들기
    - 왜 사용하면 좋은가?
        - Context를 만들 떄마다 HoC를 작성하는 게 귀찮을 수 있다.
        - 같은 Context를 사용할 경우라도, 상황에 따라 다른 props를 전달해줘야 할 경
 */
const createUseConsumer = (Consumer) => (mapContextToProps) => (WrappedComponent) => {
    // mapContextToProps가 없으면 그냥 context를 그대로 props에 전달
     const defaultMapContextToProps = (context) => ({ context });

     function UseConsumer(props) {
         return (
             <Consumer>
                 {
                     context => {
                         // context에서 원하는 값 추출
                         const contextProps = (mapContextToProps || defaultMapContextToProps)(context);

                         return (
                             <WrappedComponent
                                 { ...contextProps }
                                 { ...props }
                             />
                         );
                     }
                 }
             </Consumer>
         );
     }

     // displayName 설정
    const displayName = WrappedComponent.displayName || WrappedComponent.name ||  'component';
    UseConsumer.displayName = `UseConsumer(${displayName})`;

    return UseConsumer;
}

export default createUseConsumer;