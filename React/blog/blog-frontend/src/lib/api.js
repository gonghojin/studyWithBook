import axios from 'axios';
import * as queryString from 'query-string';

export const writePost = ({ title, body, tags }) => axios.post('/api/posts', { title, body, tags });

export const getPost = id => axios.get(`/api/posts/${id}`);

// queryString.stringify : 쿼리 문자열로 변환
export const getList = ({ tag, page }) => axios.get(`/api/posts/?${queryString.stringify({ tag, page })}`);

export const editPost = ({
  id, title, body, tags,
}) => axios.patch(`/api/posts/${id}`, { title, body, tags });

export const deletePost = id => axios.delete(`/api/posts/${id}`);

// Tag - 로그인
export const login = password => axios.post('/api/auth/login', { password });
export const checkLogin = () => axios.get('/api/auth/check');
export const logout = () => axios.post('/api/auth/logout');
// End
