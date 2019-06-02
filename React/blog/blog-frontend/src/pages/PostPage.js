import React from 'react';

import PageTemplate from 'components/common/PageTemplate/PageTemplate';
import AskRemoveModal from 'components/modal/AskRemoveModal/AskRemoveModal';
import Post from 'containers/post/Post';
import AskRemoveModalCotainer from '../containers/modal/AskRemoveModalCotainer';

const PostPage = ({ match }) => {
  const { id } = match.params;
  return (
    <PageTemplate>
      <Post id={id} />
      <AskRemoveModalCotainer />
    </PageTemplate>
  );
};

export default PostPage;
