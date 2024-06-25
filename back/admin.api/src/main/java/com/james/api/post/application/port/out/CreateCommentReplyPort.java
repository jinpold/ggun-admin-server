package com.james.api.post.application.port.out;

import com.james.api.post.domain.Comment;

public interface CreateCommentReplyPort {
    boolean createCommentReply(Comment comment);
}
