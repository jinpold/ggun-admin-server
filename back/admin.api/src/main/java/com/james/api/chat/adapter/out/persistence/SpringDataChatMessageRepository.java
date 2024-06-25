package com.james.api.chat.adapter.out.persistence;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface SpringDataChatMessageRepository extends JpaRepository<ChatMessageJpaEntity, Long> {
    Optional<ChatRoomJpaEntity> findByChatRoomChatRoomId(Long id);
    Slice<ChatMessageJpaEntity> findAllByChatRoom(ChatRoomJpaEntity chatRoomJpaEntity, PageRequest pageRequest);
}
