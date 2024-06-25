package com.james.api.chat.application.port.out;

import com.james.api.chat.domain.ChatMessage;

public interface CreateChatMessagePort {
    Long createChatMessage(ChatMessage chatMessage);
}
