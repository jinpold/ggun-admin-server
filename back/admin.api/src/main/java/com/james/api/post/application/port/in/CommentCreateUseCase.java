package com.james.api.post.application.port.in;

import com.james.api.post.application.port.in.command.CommentReplyCreateCommand;
import com.james.api.post.application.port.in.command.CommentCreateCommand;

public interface CommentCreateUseCase {
    boolean createComment(CommentCreateCommand commentCreateCommand);
    boolean createCommentReply(CommentReplyCreateCommand commentCreateCommand);
}
