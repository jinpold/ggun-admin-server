package com.james.api.chat.application.service;

import com.james.api.chat.application.port.in.ChatRoomCreateUseCase;
import com.james.api.chat.application.port.in.command.ChatRoomCreateCommand;
import com.james.api.chat.application.port.out.CreateChatRoomPort;
import com.james.api.chat.domain.ChatRoom;

import com.james.api.chatcommon.annotation.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
class CreateChatRoomService implements ChatRoomCreateUseCase {
    private final CreateChatRoomPort createChatRoomPort;
    @Override
    public boolean createChatRoom(ChatRoomCreateCommand command) {
        ChatRoom chatRoom = ChatRoom.builder()
                .build();
        return createChatRoomPort.createChatRoom(chatRoom);
    }

}
