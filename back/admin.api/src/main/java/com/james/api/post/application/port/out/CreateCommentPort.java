package com.james.api.post.application.port.out;

import com.james.api.post.domain.Comment;

public interface CreateCommentPort {
    boolean createComment(Comment comment);
}
