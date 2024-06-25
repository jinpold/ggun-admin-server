package com.james.api.chat.application.port.in.query;

import lombok.Builder;

@Builder
public record ChatMessageListQuery(Long roomId, int page, int size) {
}
