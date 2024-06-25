package com.james.api.chat.application.service;

import com.james.api.chat.adapter.in.web.dto.ChatMessageResponse;
import com.james.api.chat.adapter.in.web.dto.ChatRoomItemResponse;
import com.james.api.chat.adapter.in.web.dto.ChatRoomListReadResponse;
import com.james.api.chat.adapter.in.web.dto.ChatRoomResponse;
import com.james.api.chat.application.port.in.ChatRoomLoadUseCase;
import com.james.api.chat.application.port.in.query.ChatRoomListQuery;
import com.james.api.chat.application.port.in.query.ChatRoomQuery;
import com.james.api.chat.application.port.out.LoadChatRoomPort;
import com.james.api.chat.domain.ChatRoom;

import com.james.api.chatcommon.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
class LoadChatRoomService implements ChatRoomLoadUseCase {
    private final LoadChatRoomPort loadChatRoomPort;
    @Override
    public ChatRoomResponse getChatRoomById(ChatRoomQuery chatRoomQuery) {
        PageRequest pageRequest = PageRequest.of(chatRoomQuery.page(), chatRoomQuery.size());
        ChatRoom chatRoom = loadChatRoomPort.loadById(chatRoomQuery.id(), pageRequest);

        return ChatRoomResponse.builder()
                .roomId(chatRoom.getRoomId().value())
//                .messageList(chatRoom.getMessageList()
//                    .stream().map((chatMessage ->
//                        ChatMessageResponse.builder()
//                            .id(chatMessage.getChatId().value())
//                            .content(chatMessage.getContent())
//                            .writer(chatMessage.getWriter())
//                            .build()
//                    )).collect(Collectors.toList()))
                .build();
    }

    @Override
    public ChatRoomListReadResponse getChatRoomList(ChatRoomListQuery query) {
        PageRequest pageRequest = PageRequest.of(query.page(), query.size(), Sort.by("chatRoomId").descending());
        List<ChatRoom> chatRoomList = loadChatRoomPort.search(pageRequest);
        ChatRoomListReadResponse response = ChatRoomListReadResponse.builder()
                .messageList(chatRoomList.stream().map(chatRoom -> ChatRoomItemResponse.builder()
                                .roomId(chatRoom.getRoomId().value())
                                .build())
                        .collect(Collectors.toList()))
                .build();
        return response;
    }
}
