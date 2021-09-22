package com.noriteo.delinori.board.mapper;

import com.noriteo.delinori.common.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ApplicationContextTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ArrayList<String> name;

    @Test
    public void test1() {
        log.info("-------------------------");
        log.info("-------------------------");
        log.info("-------------------------");
        log.info(applicationContext);
        log.info(name);
        log.info("-------------------------");
        log.info("-------------------------");
        log.info("-------------------------");
    }
}
