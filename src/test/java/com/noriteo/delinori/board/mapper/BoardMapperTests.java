package com.noriteo.delinori.board.mapper;

import com.noriteo.delinori.board.config.BoardRootConfig;
import com.noriteo.delinori.board.domain.Board;
import com.noriteo.delinori.board.dto.BoardDTO;
import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BoardRootConfig.class, RootConfig.class})
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void testDummies() {
        IntStream.rangeClosed(1,15).forEach(i ->{
            Board board = Board.builder()
                    .title("title"+i)
                    .content("contnet"+i)
                    .writer("user" + (i%10))
                    .build();

            boardMapper.insert(board);
        });
    }


    @Test
    public void testList() {
        Board board = Board.builder()
                .bno(1L)
                .title("title")
                .content("내용")
                .writer("최한빛")
                .build();
    }

    @Test
    public void testSelect() {
        Board board = boardMapper.select(1L);

        log.info(board);
        log.info("*******************************************************");
    }
//    @Test
//    public void testSelect() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page(2)
//                .build();
//
//        log.info(pageRequestDTO);
//
//        List<BoardDTO> boardDTOList = boardMapper.getList(pageRequestDTO).stream().map(board -> board.getDTO()).collect(Collectors.toList());
//
//        int count = boardMapper.getCount(pageRequestDTO);
//
//    }

    @Test
    public void testUpdateDel() {
        long bno = 79L;

        log.info("delete Del..................");
        log.info(boardMapper.updateShow(bno));

        log.info(boardMapper.getTime());

    }

    @Test
    public void testUpdate() {
        Board board = Board.builder()
                .bno(2L)
                .title("modify title")
                .content("modify contnet")
                .build();

        log.info(boardMapper.update(board));
    }
}
