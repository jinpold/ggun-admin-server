package com.james.api.post.application.service;


import com.james.api.chatcommon.annotation.UseCase;
import com.james.api.post.application.port.in.command.CommentReplyCreateCommand;
import com.james.api.post.application.port.out.CreateCommentReplyPort;
import com.james.api.post.domain.Post;
import com.james.api.post.application.port.in.CommentCreateUseCase;
import com.james.api.post.application.port.in.command.CommentCreateCommand;
import com.james.api.post.application.port.out.CreateCommentPort;
import com.james.api.post.domain.Comment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
class CreateCommentService implements CommentCreateUseCase {
    private final CreateCommentPort createCommentPort;
    private final CreateCommentReplyPort createCommentReply;
    @Override
    public boolean createComment(CommentCreateCommand commentCreateCommand) {
        Comment comment = Comment.builder()
                .content(commentCreateCommand.content())
                .postId(new Post.PostId(commentCreateCommand.postId()))
                .build();
        createCommentPort.createComment(comment);
        return true;
    }

    @Override
    public boolean createCommentReply(CommentReplyCreateCommand commentCreateCommand) {
        Comment comment = Comment.builder()
                .content(commentCreateCommand.content())
                .postId(new Post.PostId(commentCreateCommand.postId()))
                .parentId(new Comment.CommentId(commentCreateCommand.parentId()))
                .build();
        createCommentReply.createCommentReply(comment);
        return true;
    }
}
