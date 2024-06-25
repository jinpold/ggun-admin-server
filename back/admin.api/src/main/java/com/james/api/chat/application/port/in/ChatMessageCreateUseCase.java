package com.james.api.chat.application.port.in;

import com.james.api.chat.application.port.in.command.ChatMessageCreateCommand;

public interface ChatMessageCreateUseCase {
    Long createChatMessage(ChatMessageCreateCommand command);
}
