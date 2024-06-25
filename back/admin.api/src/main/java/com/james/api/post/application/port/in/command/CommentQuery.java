package com.james.api.post.application.port.in.command;

import lombok.Builder;

@Builder
public record CommentQuery(Long postId, Long commentId, String content) {
}
