package com.james.api.post.application.port.in.command;

import lombok.Builder;

@Builder
public record PostCreateCommand(String title, String content) {
}
