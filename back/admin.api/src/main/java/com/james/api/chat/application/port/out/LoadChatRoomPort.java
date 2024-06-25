package com.james.api.chat.application.port.out;

import com.james.api.chat.domain.ChatRoom;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface LoadChatRoomPort {
    ChatRoom loadById(Long roomId, PageRequest pageRequest);
    List<ChatRoom> search(PageRequest pageRequest);
}
