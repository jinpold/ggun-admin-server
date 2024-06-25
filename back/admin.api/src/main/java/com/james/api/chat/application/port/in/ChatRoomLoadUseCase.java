package com.james.api.chat.application.port.in;


import com.james.api.chat.adapter.in.web.dto.ChatRoomListReadResponse;
import com.james.api.chat.adapter.in.web.dto.ChatRoomResponse;
import com.james.api.chat.application.port.in.query.ChatRoomListQuery;
import com.james.api.chat.application.port.in.query.ChatRoomQuery;

import java.util.List;

public interface ChatRoomLoadUseCase {
    ChatRoomResponse getChatRoomById(ChatRoomQuery chatRoomQuery);
    ChatRoomListReadResponse getChatRoomList(ChatRoomListQuery query);
}
