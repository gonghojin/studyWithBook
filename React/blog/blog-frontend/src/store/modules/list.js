import { createAction, handleActions } from 'redux-actions';

import { fromJS, List, Map } from 'immutable';
import { pender } from 'redux-pender';

import * as api from 'lib/api';


// action types
const GET_POST_LIST = 'list/GET_POST_LIST';

// action creators
export const getPostList = createAction(GET_POST_LIST, api.getList, meta => meta);

// initial state
const initialState = Map({
  posts: List(),
  lastPage: null,
});

// reducer
export default handleActions({
  ...pender({
    type: GET_POST_LIST,
    onSuccess: (state, action) => {
      const { content: posts } = action.payload;
      console.log(action.payload);
      return state.set('posts', fromJS(posts));
    },
  }),
}, initialState);
