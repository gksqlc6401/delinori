package com.noriteo.delinori.board.mapper;

import com.noriteo.delinori.board.config.BoardRootConfig;
import com.noriteo.delinori.board.domain.Reply;
import com.noriteo.delinori.common.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BoardRootConfig.class, RootConfig.class})
public class ReplyMapperTests {

    @Autowired
    ReplyMapper replyMapper;

    @Test
    public void insertDummies() {

        long[] arr = {1L,2L,3L,4L,5L};//bno

        IntStream.rangeClosed(1,100).forEach(num-> {

            long bno = arr[((int)(Math.random()*arr.length)*1000) % 5];//roof도는것

            Reply reply = Reply.builder()
                    .bno(bno)
                    .reply("댓글..."+num)
                    .replyer("user"+(num % 10))
                    .build();

            replyMapper.insert(reply);
        });

    }

    @Test
    public void testList() {
        Long bno =1L;

        replyMapper.getListWithBoard(bno).forEach(reply -> log.info(reply));//바로 한줄로 끝내버리기~ 이해는 못함
    }

}
