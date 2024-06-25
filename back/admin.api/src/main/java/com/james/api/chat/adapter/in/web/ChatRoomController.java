package com.james.api.chat.adapter.in.web;

import com.james.api.chat.adapter.in.web.dto.ChatRoomResponse;
import com.james.api.chat.application.port.in.ChatRoomCreateUseCase;
import com.james.api.chat.application.port.in.ChatRoomLoadUseCase;
import com.james.api.chat.application.port.in.command.ChatRoomCreateCommand;
import com.james.api.chat.application.port.in.query.ChatRoomListQuery;
import com.james.api.chat.application.port.in.query.ChatRoomQuery;
import com.james.api.chatcommon.response.SuccessApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
class ChatRoomController {
    private final ChatRoomCreateUseCase chatRoomCreateUseCase;
    private final ChatRoomLoadUseCase chatRoomLoadUseCase;

    @PostMapping
    public SuccessApiResponse<?> createChatRoom(){
        ChatRoomCreateCommand chatRoomCreateCommand = ChatRoomCreateCommand.builder()
                .build();
        chatRoomCreateUseCase.createChatRoom(chatRoomCreateCommand);
        return SuccessApiResponse.of();
    }
    @GetMapping("/{roomId}")
    public SuccessApiResponse<?> getChatRoom(@PathVariable Long roomId,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size){
        ChatRoomQuery chatRoomQuery = ChatRoomQuery.builder()
                .id(roomId)
                .page(page)
                .size(size)
                .build();
        ChatRoomResponse chatRoomResponse = chatRoomLoadUseCase.getChatRoomById(chatRoomQuery);
        return SuccessApiResponse.of(chatRoomResponse);
    }
    @GetMapping
    public SuccessApiResponse<?> getChatRoomList( @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size){
        ChatRoomListQuery chatRoomListQuery = ChatRoomListQuery.builder()
                .page(page)
                .size(size)
                .build();
        return SuccessApiResponse.of(chatRoomLoadUseCase.getChatRoomList(chatRoomListQuery));
    }
}
