package com.james.api.board.service;
import com.james.api.board.model.Board;
import com.james.api.board.model.BoardDto;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {




    default Board dtoToEntity(BoardDto dto){

        return Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }

    default BoardDto entityToDto(Board ent){

        return BoardDto.builder()
                .id(ent.getId())
                .title(ent.getTitle())
                .description(ent.getDescription())
                .regDate(ent.getRegDate().toString())
                .modDate(ent.getModDate().toString())
                .build();
    }
}
