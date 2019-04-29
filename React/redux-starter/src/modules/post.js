import {handleActions, createAction} from "redux-actions";
import {pender} from "redux-pender";
import axios from 'axios';

function getPostAPI(postId) {
    return axios.get(`https://jsonplaceholder.typicode.com/posts/${postId}`);
}

const GET_POST = 'GET_POST';

/*
    redux-pender의 액션 구조는 Flux standard action(https://github.com/acdlite/flux-standard-action)을 따르기 때문에,
    createAction으로 액션을 만들 수 있으며, 두 번쨰로 들어가는 파라미터는 Promise를 반환하는 함수여야 한다.
 */
export const getPost = createAction(GET_POST, getPostAPI);

const initialState = {
    // 요청이 진행 중인지, 오류가 발생헀는 지 여부는 더 이상 직접 관리할 필요가 없다(~post.js의 비동기 방식1 2와 대조)
    // penderReducer가 담당하기 때문
    data: {
        title: '',
        body: ''
    },
}

export default handleActions({
    ...pender({
        type: GET_POST, // type이 주어지면 이 type에 접미사를 붙인
                        // 액션 핸들러들이 담긴 객체를 만든다.
        /*
            요청 중일 떄와 실패했을 때 추가로 해야할 작업이 있다면
            이렇게 onPending과 onFailure를 추가하면 된다.
            onPending: (state, action) => state,
            onFailure: (state, action) => state,
         */
        onSuccess: (state, action) => {
            // 성공했을 때 해야할 작업이 따로 없으면 이 함수 또한 생략 가능
            const { title, body } = action.payload.data;
            return {
                data: {
                    title,
                    body,
                }
            }
            //함수를 생략했을 떄는 기본 값으로는 (state, action) => state를 설정한다. (state를 그대로 반환한다는 의미)
        },
        // 요청을 취소했을 때 특정 작업
        onCancel: (state, action) => {
            return {
                data: {
                    title: '취소됨',
                    body: '취소됨',
                },
            }
        },
    })
}, initialState);

