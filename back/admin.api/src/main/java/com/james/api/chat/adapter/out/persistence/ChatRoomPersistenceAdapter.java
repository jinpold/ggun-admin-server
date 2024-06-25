package com.james.api.chat.adapter.out.persistence;

import com.james.api.chat.application.port.in.ChatRoomCreateUseCase;
import com.james.api.chat.application.port.in.command.ChatRoomCreateCommand;
import com.james.api.chat.application.port.out.CreateChatMessagePort;
import com.james.api.chat.application.port.out.CreateChatRoomPort;
import com.james.api.chat.domain.ChatMessage;
import com.james.api.chat.domain.ChatRoom;

import com.james.api.chatcommon.annotation.PersistenceAdapter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
class ChatRoomPersistenceAdapter implements CreateChatRoomPort{
    private final SpringDataChatRoomRepository springDataChatRoomRepository;

    @Transactional
    @Override
    public boolean createChatRoom(ChatRoom chatRoom) {
        ChatRoomJpaEntity chatRoomJpaEntity = ChatRoomJpaEntity.builder()
                .build();
        springDataChatRoomRepository.save(chatRoomJpaEntity);
        return true;
    }
}
