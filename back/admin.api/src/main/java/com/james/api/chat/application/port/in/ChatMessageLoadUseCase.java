package com.james.api.chat.application.port.in;


import com.james.api.chat.adapter.in.web.dto.ChatMessageResponse;
import com.james.api.chat.application.port.in.command.ChatMessageCreateCommand;
import com.james.api.chat.application.port.in.query.ChatMessageListQuery;

import java.util.List;


public interface ChatMessageLoadUseCase {
    List<ChatMessageResponse> getChatMessageList(ChatMessageListQuery command);
}
