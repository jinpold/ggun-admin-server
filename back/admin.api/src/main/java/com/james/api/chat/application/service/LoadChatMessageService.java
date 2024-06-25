package com.james.api.chat.application.service;

import com.james.api.chat.adapter.in.web.dto.ChatMessageResponse;
import com.james.api.chat.application.port.in.ChatMessageLoadUseCase;
import com.james.api.chat.application.port.in.command.ChatMessageCreateCommand;
import com.james.api.chat.application.port.in.query.ChatMessageListQuery;
import com.james.api.chat.application.port.out.LoadChatMessagePort;

import com.james.api.chatcommon.annotation.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
class LoadChatMessageService implements ChatMessageLoadUseCase {
    private final LoadChatMessagePort loadChatMessagePort;
    @Override
    public List<ChatMessageResponse> getChatMessageList(ChatMessageListQuery query) {
        PageRequest pageRequest = PageRequest.of(query.page(), query.size(), Sort.by("chatMessageId").descending());
        return loadChatMessagePort.loadChatMessegeList(query.roomId(), pageRequest)
                .stream().map((chatMessage)->
                        ChatMessageResponse.builder()
                                .id(chatMessage.getChatId().value())
                                .content(chatMessage.getContent())
                                .writer(chatMessage.getWriter())
                                .build())
                .collect(Collectors.toList());
    }
}
