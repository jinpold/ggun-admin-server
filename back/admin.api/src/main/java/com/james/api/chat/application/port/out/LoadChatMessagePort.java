package com.james.api.chat.application.port.out;

import com.james.api.chat.domain.ChatMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoadChatMessagePort {
    List<ChatMessage> loadChatMessegeList(Long roomId, PageRequest pageRequest);
}
