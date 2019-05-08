import React from 'react';
import PageTemplate from 'components/common/PageTemplate';
import ListWrapper from 'components/list/ListWrapper/ListWrapper';
import PostList from 'components/list/PostList/PostList';
import Pagination from '../components/list/Pagination/Pagination';

const ListPage = () => (
  <div>
    <PageTemplate>
      <ListWrapper>
        <PostList />
        <Pagination />
      </ListWrapper>
    </PageTemplate>
  </div>
);

export default ListPage;
