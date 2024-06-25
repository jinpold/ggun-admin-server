package com.james.api.chat.adapter.out.persistence;

import com.james.api.chat.application.port.out.CreateChatMessagePort;
import com.james.api.chat.domain.ChatMessage;
import com.james.api.chatcommon.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
class ChatMessagePersistenceAdapter implements CreateChatMessagePort {
    private final SpringDataChatRoomRepository springDataChatRoomRepository;

    @Override
    @Transactional
    public Long createChatMessage(ChatMessage chatMessage) {
        ChatRoomJpaEntity chatRoomJpaEntity = springDataChatRoomRepository.findById(chatMessage.getChatRoomId().value())
                .orElseThrow(RuntimeException::new);
        ChatMessageJpaEntity chatMessageJpaEntity = ChatMessageJpaEntity.builder()
                .chatRoom(chatRoomJpaEntity)
                .content(chatMessage.getContent())
                .writer(chatMessage.getWriter())
                .build();
        chatRoomJpaEntity.createMessage(chatMessageJpaEntity);
        springDataChatRoomRepository.save(chatRoomJpaEntity);
        return chatMessageJpaEntity.getChatMessageId();
    }
}
