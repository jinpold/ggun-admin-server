package com.james.api.post.application.port.in.command;

import lombok.Builder;

@Builder
public record CommentCreateCommand(Long postId, String content) {
}
