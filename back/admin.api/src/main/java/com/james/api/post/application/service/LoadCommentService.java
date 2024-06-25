package com.james.api.post.application.service;


import com.james.api.chatcommon.annotation.UseCase;
import com.james.api.post.adapter.in.web.response.CommentWithRepliesResponse;
import com.james.api.post.domain.Comment;
import com.james.api.post.adapter.in.web.response.CommentResponse;
import com.james.api.post.application.port.in.CommentLoadUseCase;
import com.james.api.post.application.port.in.command.CommentQuery;
import com.james.api.post.application.port.out.LoadCommentPort;
import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
class LoadCommentService implements CommentLoadUseCase {
    private final LoadCommentPort loadCommentPort;
    @Override
    public CommentWithRepliesResponse getCommentListByParentId(CommentQuery commentQuery) {
        Comment comment = loadCommentPort.loadById(commentQuery.commentId());
        return CommentWithRepliesResponse.builder()
                .commentId(comment.getId().value())
                .content(comment.getContent())
                .postId(comment.getPostId().value())
                .parentId(comment.getParentId().value())
                .replies(comment.getReplies().stream()
                        .map((domain)-> CommentResponse.builder()
                                .commentId(domain.getId().value())
                                .content(domain.getContent())
                                .postId(domain.getPostId().value())
                                .parentId(domain.getParentId().value())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
