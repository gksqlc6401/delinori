package com.noriteo.delinori.board.domain;

import com.noriteo.delinori.board.dto.BoardDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private int replyCnt;
    private Long bno;
    private String title,writer,content;
    private LocalDateTime regDate,modDate;

    public BoardDTO getDTO(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .modDate(modDate)
                .build();


        return boardDTO;
    }

    public void setBno(Long bno){
        this.bno = bno;
    }
}
