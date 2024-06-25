package com.james.api.chat.adapter.in.web.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ChatRoomListReadResponse(List<ChatRoomItemResponse> messageList, boolean hasNext) {
}
