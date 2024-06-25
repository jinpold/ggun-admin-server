package com.james.api.post.application.port.in.command;

import lombok.Builder;

@Builder
public record CommentReplyCreateCommand(String content, Long postId, Long parentId) {
}
