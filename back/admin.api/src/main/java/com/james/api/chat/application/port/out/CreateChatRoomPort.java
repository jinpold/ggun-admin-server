package com.james.api.chat.application.port.out;

import com.james.api.chat.domain.ChatRoom;

public interface CreateChatRoomPort {
    boolean createChatRoom(ChatRoom chatRoom);
}
