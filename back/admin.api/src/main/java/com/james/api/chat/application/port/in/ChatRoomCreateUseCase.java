package com.james.api.chat.application.port.in;

import com.james.api.chat.application.port.in.command.ChatRoomCreateCommand;

public interface ChatRoomCreateUseCase {
    boolean createChatRoom(ChatRoomCreateCommand command);
}
