package com.noriteo.delinori.board.mapper;

import com.noriteo.delinori.board.config.BoardRootConfig;
import com.noriteo.delinori.board.domain.Board;
import com.noriteo.delinori.common.config.RootConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {BoardRootConfig.class, RootConfig.class})

public class TimeMapperTests {


    @Autowired
    TimeMapper timeMapper;


    @Test
    public void getTime() {
        log.info("-------------------");
        log.info("-------------------");
        log.info(timeMapper);
        log.info(timeMapper.getTime());
        log.info("-------------------");
        log.info("-------------------");
    }
}
