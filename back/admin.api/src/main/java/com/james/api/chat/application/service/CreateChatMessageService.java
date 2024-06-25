package com.james.api.chat.application.service;

import com.james.api.chat.application.port.in.ChatMessageCreateUseCase;
import com.james.api.chat.application.port.in.command.ChatMessageCreateCommand;
import com.james.api.chat.application.port.out.CreateChatMessagePort;
import com.james.api.chat.domain.ChatMessage;
import com.james.api.chat.domain.ChatRoom;

import com.james.api.chatcommon.annotation.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
class CreateChatMessageService implements ChatMessageCreateUseCase {
    private final CreateChatMessagePort createChatMessagePort;

    @Override
    public Long createChatMessage(ChatMessageCreateCommand command) {
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoomId(new ChatRoom.RoomId(command.roomId()))
                .content(command.content())
                .writer(command.from())
                .build();
        return createChatMessagePort.createChatMessage(chatMessage);
    }
}
