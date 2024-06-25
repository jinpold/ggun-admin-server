package com.james.api.post.application.port.in;

import com.james.api.post.adapter.in.web.response.CommentWithRepliesResponse;
import com.james.api.post.application.port.in.command.CommentQuery;

public interface CommentLoadUseCase {
    CommentWithRepliesResponse getCommentListByParentId(CommentQuery commentQuery);
}
