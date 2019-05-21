import React from 'react';
import PageTemplate from 'components/common/PageTemplate';
import ListWrapper from 'components/list/ListWrapper/ListWrapper';
import ListContainer from 'containers/list/ListContainer';

const ListPage = ({ match }) => {
  // page의 기본 값을 1로 설정
  const { page = 0, tag } = match.params;
  return (
    <div>
      <PageTemplate>
        <ListWrapper>
          <ListContainer
            page={parseInt(page, 10)}
            tag={tag}
          />
        </ListWrapper>
      </PageTemplate>
    </div>
  );
};

export default ListPage;
